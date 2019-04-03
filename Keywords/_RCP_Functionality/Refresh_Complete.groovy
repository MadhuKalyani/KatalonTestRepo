package _RCP_Functionality

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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

public class Refresh_Complete {

	@Keyword

	def RefreshOrder_Provide(){

		WebUI.waitForElementClickable(findTestObject('Object Repository/Confirm_orderpage/Placeorder'), 10)

		WebUI.click(findTestObject('Object Repository/Confirm_orderpage/Placeorder'))
		println ("Performed placing the order");
		WebUI.delay(3)

		WebUI.delay(2)
		// Have to write logic for the status count to get as a loop
		println ("Refreshing the Order")
		WebUI.waitForElementClickable(findTestObject('Object Repository/Productstatus_details/Refresh'), 10)
		WebUI.click(findTestObject('Object Repository/Productstatus_details/Refresh'))

		WebDriver driver = DriverFactory.getWebDriver();

		String status= WebUI.getText(findTestObject('Object Repository/Productstatus_details/Statuscheck'))
		System.out.println(status);
		while(!status.equals('Completed')){
			WebUI.click(findTestObject('Object Repository/Productstatus_details/Refresh'))
			WebUI.delay(10)
			status= WebUI.getText(findTestObject('Object Repository/Productstatus_details/Statuscheck'))
			System.out.println(status);
		}
		System.out.println(status);
		System.out.println("Order has trun to Completed status");


	}

	@Keyword

	def RefreshOrder_MACD(){

		WebUI.waitForElementClickable(findTestObject('Object Repository/Confirm_orderpage/Placeorder'), 10)
		WebUI.click(findTestObject('Object Repository/Confirm_orderpage/Placeorder'))
		println ("Performed placing the order");
		WebUI.delay(3)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Productstatus_details/Macd_Ordersbtn'), 10)
		WebUI.click(findTestObject('Object Repository/Productstatus_details/Macd_Ordersbtn'))
		println ("Order Link is clicked");
		WebUI.delay(2)
		// Have to write logic for the status count to get as a loop
		println ("Refreshing the Order")
		WebUI.waitForElementClickable(findTestObject('Object Repository/Productstatus_details/Refresh'), 10)
		WebUI.click(findTestObject('Object Repository/Productstatus_details/Refresh'))

		WebDriver driver = DriverFactory.getWebDriver();

		String status= WebUI.getText(findTestObject('Object Repository/Productstatus_details/MACD_StatusCheck'))

		System.out.println(status);
		while(!status.equals('Completed')){
			WebUI.click(findTestObject('Object Repository/Productstatus_details/Refresh'))
			WebUI.delay(10)
			status= WebUI.getText(findTestObject('Object Repository/Productstatus_details/MACD_StatusCheck'))
			System.out.println(status);
		}
		System.out.println(status);
		System.out.println("Order has trun to Completed status");

	}
}
