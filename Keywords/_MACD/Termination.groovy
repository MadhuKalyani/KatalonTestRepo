package _MACD

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*

import org.junit.Test

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import internal.GlobalVariable

public class Termination {

	@Keyword

	def Initiate_Termination(HashMap<String, String> TestDataValue){
		WebUI.delay(3)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/Click_Subscription'), 7)
		WebUI.click(findTestObject('Object Repository/Termination/Click_Subscription'))
		println ("Clicked on Subscription button");

		WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/click_Subscription_name'), 7)
		WebUI.click(findTestObject('Object Repository/Termination/click_Subscription_name'))
		println ("clicked on Subscrption name");

		WebUI.delay(7)

		WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/click_cancelSubsc'), 7)
		WebUI.click(findTestObject('Object Repository/Termination/click_cancelSubsc'))
		println ("clicked on Cancel subscription");

		WebUI.delay(4)

		String CancleType = TestDataValue.get("CancellationOption");
		println ("Cancellation Type is : " +CancleType);

		if(CancleType.contains("FullRefund")){
			WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/FullRefund'), 20)
			WebUI.click(findTestObject('Object Repository/Termination/FullRefund'))
			println ("Selected Full Refund Process");


			println ("Full Refund Process calculation intiated");
			Full_Refund_Calculation(TestDataValue);
			println ("Full Refund Process calculation Completed");
		} else if(CancleType.contains("PartialRefund")){

			WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/Partial Cancellation'), 20)
			WebUI.click(findTestObject('Object Repository/Termination/Partial Cancellation'))
			println ("Selected Partial Refund Process");
		} else if (CancleType.contains("NoRefund")) {

			WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/NoRefund'), 20)
			WebUI.click(findTestObject('Object Repository/Termination/NoRefund'))
			println ("Selected No Refund Process");

			println ("Zero Refund Calculation intiated");
			Zero_Refund_calculation();
			println ("Zero Refund Calculation completed");
		} else {

			println ("Non -cancellation process passed in external data ");
		}

		WebUI.click(findTestObject('Object Repository/Termination/click_placeorder'))
		WebUI.delay(3)

		WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/click_refresh'), 7)
		WebUI.click(findTestObject('Object Repository/Termination/click_refresh'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Termination/click_refresh'))

		WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/OrderBtn'), 20)
		WebUI.click(findTestObject('Object Repository/Termination/OrderBtn'))
		println ("clicked on orders link");

		WebUI.delay(3)

		WebDriver driver = DriverFactory.getWebDriver()
		String ExpectedValue = "Completed";
		WebElement Status = driver.findElements(By.xpath("//table[@id='global_list']//tr//td[contains(text(),'Completed')]"))
		String ActualValue = Status.getText();
		if(ExpectedValue.equalsIgnoreCase(ActualValue)){
			println ("Order Successfully completed");
		} else {
			println ("Order failed");
		}
	}

	@Keyword

	def Zero_Refund_calculation(){

		String No_Refund_Value= WebUI.getText(findTestObject('Validation/RCP/MACD_Validation_Termination/NoRefund'))
		String[] parts= No_Refund_Value.split(": ");
		String part1=parts[0];
		String part2=parts[1];
		println(part2);

		WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/Enter_comment'), 7)
		WebUI.click(findTestObject('Object Repository/Termination/Enter_comment'))

		WebUI.setText(findTestObject('Object Repository/Termination/Enter_comment'), 'Zero Charge- refunded')
		WebUI.click(findTestObject('Object Repository/Termination/click_next'))
		println ("Comments enter");


		println ("Zero_Refund Validations intiated");
		String total=WebUI.getText(findTestObject('Object Repository/Validation/RCP/MACD_Validation_Termination/Total_amount'))

		println("System Generated Total Amount of Refunded : "+ total);

		WebUI.delay(3)

		WebUI.click(findTestObject('Object Repository/Termination/click_placeorder'))

		WebUI.delay(3)

		String Renewal_fee=WebUI.getText(findTestObject('Object Repository/Validation/RCP/MACD_Validation_Termination/Renewal_Fee'))

		println(Renewal_fee);

		String Non_Refund_Amount=WebUI.getText(findTestObject('Object Repository/Validation/RCP/MACD_Validation_Termination/NoRefundValue'))

		println( "Over all amount Refunded to the user: " + Non_Refund_Amount);

		if(Renewal_fee==Non_Refund_Amount) {
			println("Zero funded process succesfully done ");
			println ("Expected Refund : " +Renewal_fee + "System Generated Refund : " +Non_Refund_Amount);

			WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/click_refresh'), 7)
			WebUI.click(findTestObject('Object Repository/Termination/click_refresh'))
			WebUI.delay(3)
			WebUI.click(findTestObject('Object Repository/Termination/click_refresh'))
		}
		else {
			println("No-Refund is wrong");
		}

		WebUI.delay(3)

		WebUI.waitForElementClickable(findTestObject('Object Repository/Validation/RCP/MACD_Validation_Termination/Click_Order'), 7)

		WebUI.click(findTestObject('Object Repository/Validation/RCP/MACD_Validation_Termination/Click_Order'))

		WebUI.delay(3)

		WebUI.click(findTestObject('Object Repository/Termination/click_refresh'))

		String totalvalue=WebUI.getText(findTestObject('Object Repository/Validation/RCP/MACD_Validation_Termination/Cancellation'))

		if(Non_Refund_Amount==totalvalue) {
			println("Full amount is Refunded");
		}
		else {
			println("Variation in Refunded amount");
		}
	}


	@Keyword

	def Full_Refund_Calculation(HashMap<String, String> TestDataValue){

		String period = TestDataValue.get("SubscriptionPeriod")
		println ("selected Period is : " +period);

		float baseprice ;
		if(period.contains("Year")){
			String yearprice = TestDataValue.get("Yearly")
			float year = Float.parseFloat(yearprice)
			baseprice = year;
		}	else if(period.contains("Month")) {
			String monthprice = TestDataValue.get("Monthly")
			float month = Float.parseFloat(monthprice)
			baseprice = month;
		}

		String Full_Refund_Value= WebUI.getText(findTestObject('Object Repository/Validation/RCP/MACD_Validation_Termination/Full_Refund'))

		String[] parts= Full_Refund_Value.split(": ");

		String part1=parts[0];

		String Sysprice=parts[1];
		//String Sysprice = pricelist.replace("-", "")
		println (Sysprice);

		//float Sysprice = Float.parseFloat(part2)

		println("System Generated full - Refunded price :" + Sysprice);
		String essentialmonthprice= String.format("%.2f", baseprice*3);

		// Calulation validation

		if(Sysprice.equals(essentialmonthprice)){
			println ("Price Validation successful");
			println ("User receiving expected amount");
			println ("System Generated Refund amount : " +Sysprice + "Expected Refund amount : " + essentialmonthprice);
		} else {
			println ("Price Validation Failed");
			println ("System Generated Refund amount : " +Sysprice + "Expected Refund amount : " + essentialmonthprice);
		}


		WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/Enter_comment'), 7)

		WebUI.click(findTestObject('Object Repository/Termination/Enter_comment'))

		WebUI.setText(findTestObject('Object Repository/Termination/Enter_comment'), 'Full- refunded')

		WebUI.click(findTestObject('Object Repository/Termination/click_next'))

		WebUI.delay(7)

		String total=WebUI.getText(findTestObject('Object Repository/Validation/RCP/MACD_Validation_Termination/Total_amount'))
		String split1 = total.replace('£', '')
		String TotalPrice = split1;
		println("Over All Price : " +TotalPrice);

		if(TotalPrice.equals(Sysprice))
		{
			println("Full Refund price mathes in both pages ");
			println ("Expected Full Refund price : " +Sysprice + "Actual Full Refund price : " +TotalPrice);
			println ("Price Validation successful");
		}
		else
		{
			println("Full Refund price Mismatch in both pages ");
			println ("Expected Full Refund price : " +Sysprice + "Actual Full Refund price : " +TotalPrice);
			println ("Price Validation Failed");
		}

		WebUI.delay(3)




	}
}
