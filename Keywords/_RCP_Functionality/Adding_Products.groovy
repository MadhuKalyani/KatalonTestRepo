package _RCP_Functionality

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*

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
import org.apache.commons.lang3.RandomUtils
import org.junit.Test
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.lang.*;
import internal.GlobalVariable

public class Adding_Products {

	@Keyword

	def Add_Products(HashMap<String, String> TestDataValue){
		print("======================= Product Addition initation ========================");

		WebUI.waitForElementClickable(findTestObject('Object Repository/Navorderpage/Addneworder'), 10)

		WebUI.click(findTestObject('Object Repository/Navorderpage/Addneworder'))


		WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/Servicesearch'), 10)

		WebUI.click(findTestObject('Object Repository/Addingorder/Servicesearch'))

		WebUI.switchToWindowIndex(1)

		WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/Addmicrosoftessential'), 10)

		// PRoduct need to get from Excel sheet
		String product = TestDataValue.get("Product")
		if(product.contains("Microsoft Office365 Business Essentials")){
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/Addingorder/Microsoft Office365 Business Essentials'))
			println ("Microsoft Office365 Business Essentials Selected");
		} else if(product.contains("Microsoft Office365 Business Premium")){
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/Addingorder/Microsoft Office365 Business Premium'))
			println ("Microsoft Office365 Business Premium Selected");
		}else if(product.contains("Dropbox Business Std")){
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/Addingorder/Dropbox Business Std'))
			println ("Dropbox Business Std Selected");
		} else if(product.contains("Dropbox Business Adv")){
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/Addingorder/Dropbox Business Adv'))
			println ("Dropbox Business Adv Selected");
		} else {
			println ("Products Not Found");
		}

		WebUI.switchToDefaultContent()

		WebUI.switchToFrame(findTestObject('Object Repository/Searching/mainframe'), 10)
		WebUI.delay(2)

		WebUI.waitForElementClickable(findTestObject('Addingorder/PeriodSearch'), 10)

		WebUI.click(findTestObject('Addingorder/PeriodSearch'))

		WebUI.switchToWindowIndex(1)
		WebUI.delay(2)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/Addplan'), 10)

		// Logic to get the Service plan
		String period = TestDataValue.get("SubscriptionPeriod");
		if(period.contains("Month")){
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/Addingorder/Month'))
			println ("Subscription Selected as : Month");
		} else if(period.contains("Year")){
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/Addingorder/Year'))
			println ("Subscription Selected as : Year");
		} else {
			println ("Data Not found ");
		}

		WebUI.switchToDefaultContent()

		WebUI.switchToFrame(findTestObject('Object Repository/Searching/mainframe'), 10)

		WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/OrderNext'), 10)
		WebUI.click(findTestObject('Object Repository/Addingorder/OrderNext'))
		println ("Clicked on Next Button");

		if(product.contains("Dropbox")){
			WebUI.delay(2)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/OrderNext'), 10)
			WebUI.click(findTestObject('Object Repository/Addingorder/OrderNext'))
			println ("Clicked on Next Button");
		} else {
			println ("");
		}

		println ("***************** Product Added Successfully *****************************************");



	}

	@Keyword

	def Provide_New_Microsoft_Account(HashMap<String, String> TestDataValue){

		println ("============== Adding new Microsoft Account ===============================")

		WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/Signupbuttton'), 10)
		WebUI.click(findTestObject('Object Repository/Addingorder/Signupbuttton'))

		Random GenerateRandomNume = new Random();
		int RandNum = GenerateRandomNume.nextInt(100000);
		println ("Number is " + RandNum);
		WebUI.delay(3)
		String GenRanNum = Integer.toString(RandNum)

		WebUI.setText(findTestObject('Object Repository/Addingorder/inputsubdomain'), 'CloudB2B'+GenRanNum)
		WebUI.click(findTestObject('Object Repository/Addingorder/checkbtn'))
		WebUI.delay(7)
		WebUI.setText(findTestObject('Object Repository/Addingorder/para_fname'), 'Andrew')
		WebUI.setText(findTestObject('Object Repository/Addingorder/para_lname'), 'Thomas')

		WebUI.setText(findTestObject('Object Repository/Addingorder/para_mail'), "madhusekhar100+"+GenRanNum+"@gmail.com")  // need to check later
		//println ("Enter Email : " +TestDataValue.get("Email"));  // need to check later

		WebUI.click(findTestObject('Object Repository/Addingorder/I-confirmbtn'))
		WebUI.delay(10)
		WebUI.click(findTestObject('Object Repository/Addingorder/OrderNext'))

		println ("============== Microsoft Account Created Successfully ===============================")
	}

	@ Keyword

	def Additional_Resources(HashMap<String, String> TestDataValue){

		println ("============== Adding Licenses to the Order ===============================")
		WebUI.waitForElementClickable(findTestObject('Object Repository/Confirm_orderpage/OrderAdditional'), 10)
		WebUI.click(findTestObject('Object Repository/Confirm_orderpage/OrderAdditional'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Confirm_orderpage/Choosecategory'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Confirm_orderpage/Modifyresource'))
		WebUI.delay(5)
		WebUI.clearText(findTestObject('Object Repository/Confirm_orderpage/Addunits_licence'))

		WebUI.setText(findTestObject('Object Repository/Confirm_orderpage/Addunits_licence'), TestDataValue.get("Licence"))

		WebUI.click(findTestObject('Object Repository/Confirm_orderpage/Next'))

		println ("============== License has been Successfully added to the order ===============================")
	}


	@ Keyword

	def Price_Validations(HashMap<String, String> TestDataValue){
		WebUI.delay(5)

		//HashMap<String, String> TestDataValue =new HashMap<String,String>()

		println ("============================================= Price Validation Intiatited ======================================================")

		String period =  TestDataValue.get("SubscriptionPeriod")
		println ("Period selected for this order is : " + period);
		float baseprices;
		if(period.contains("Year")){
			String baseprice = TestDataValue.get("Yearly")   // Getting price from external source
			baseprices = Float.parseFloat(baseprice)
			println ("Price for the product based on Year is : " +baseprices);

		} else if (period.contains("Month")){
			String baseprice = TestDataValue.get("Monthly")    // Getting price from external source
			baseprices = Float.parseFloat(baseprice)
			println ("Price for the product based on Year is : " +baseprices)
		} else {
			println ("Values not found")
		}

		// To check the products Wise Calculation

		String product =  TestDataValue.get("Product")
		println ("Period selected for this order is : " + product);

		if(product.contains("Microsoft")){


			String essentialmonthprice= String.format("%.2f", baseprices);
			//println(essentialmonthprice)
			String license =  TestDataValue.get("Licence")   // To get the License
			println ("No.of License added to the product  : " + license);
			float noLic = Float.parseFloat(license)
			float monthlytotallicenceprices= noLic * baseprices ;                                                   //calcualted licencetotal price
			String monthlytotallicenceprice= String.format("%.2f", monthlytotallicenceprices);
			println("No.of License * Base Price = " +monthlytotallicenceprice)

			float totalmonths= monthlytotallicenceprices + baseprices ;                                          //calculated total price DDChec
			String totalmonth= String.format("%.2f", totalmonths);
			println("Total price [(No.of Lic * base price)+product price] = " + totalmonth)

			String pricelicence= WebUI.getText(findTestObject('Object Repository/Addingorder/getpricelicenceaddition'))
			String split = pricelicence.replace('£', '')
			println(split+'-no.of_licence_addedprice')                                                                    //get licencetotal price from order
			if(monthlytotallicenceprice.equals(split)){
				println('Licenceprice validation Success')
			}
			else{
				println('Licenceprice validation failed')
			}

			String pricebase= WebUI.getText(findTestObject('Addingorder/getbaseprice'))
			String split1 = pricebase.replace('£', '')                                                                    //get baseprice from order
			println(split1+'-Baseprice_of_selected product')
			if(essentialmonthprice.equals(split1)){
				println('Original product price from system and external data calculated')
				println('system Generated product Base Price and Expected product pas price matches successful')

				println ("system Generated base price : " + split1 + "   Expected product base price : " + essentialmonthprice)
			}
			else{
				println('Product base price validation failed')
				println ("system Generated base price : " + split1 + "   Expected product base price : " + essentialmonthprice)
			}

			String totalprice= WebUI.getText(findTestObject('Object Repository/Addingorder/totalprice'))
			String split2 = totalprice.replace('£', '')                                                                   //get total price from order
			println(split2+'- System Generated Totalprice of product')
			if(totalmonth.equals(split2)){
				println('Totalprice validation Success')
				println ("System Generated Total Price : " +split2+ "   Mathes formual calulation of total price : " + totalmonth );

			}
			else{
				println('Totalprice validation failed')
				println ("System Generated Total Price : " +split2+ "   Mathes formual calulation of total price : " + totalmonth );
			}
		} else if(product.contains("Dropbox")){

			String essentialmonthprice= String.format("%.2f", baseprices);
			//println(essentialmonthprice)
			String license =  TestDataValue.get("Licence")   // To get the License
			println ("No.of License added to the product  : " + license);
			float noLic = Float.parseFloat(license)
			float monthlytotallicenceprices= noLic * baseprices ;                                                   //calcualted licencetotal price
			String monthlytotallicenceprice= String.format("%.2f", monthlytotallicenceprices);
			println("No.of License * Base Price = " +monthlytotallicenceprice)

			float totalmonths= monthlytotallicenceprices + (baseprices*3) ;                                          //calculated total price DDChec
			String totalmonth= String.format("%.2f", totalmonths);
			println("Total price [(No.of Lic * base price)+product price] = " + totalmonth)

			String pricelicence= WebUI.getText(findTestObject('Object Repository/Addingorder/getpricelicenceaddition'))
			String splitReplace = pricelicence.replace('£', '')
			String split = splitReplace.replace(',', '')
			println(split+'-no.of_licence_addedprice')                                                                    //get licencetotal price from order
			if(monthlytotallicenceprice.equals(split)){
				println('Licenceprice validation Success')
				println ("Licence price Calculated value: " +monthlytotallicenceprice + "Licence price System Generated value : " +split);
			}
			else{
				println('Licenceprice validation failed')
				println ("Licence price Calculated value: " +monthlytotallicenceprice + "Licence price System Generated value : " +split);
			}

			String pricebase= WebUI.getText(findTestObject('Addingorder/getbaseprice'))
			String split1 = pricebase.replace('£', '')                                                                    //get baseprice from order
			println(split1+'-Baseprice_of_selected product')

			float onlyproductprice = baseprices*3;
			String productprice= String.format("%.2f", onlyproductprice);
			if(productprice.equals(split1)){
				println('Original product price from system and external data calculated')
				println('system Generated product Base Price and Expected product pas price matches successful')

				println ("system Generated base price : " + split1 + "   Expected product base price : " + productprice)
			}
			else{
				println('Product base price validation failed')
				println ("system Generated base price : " + split1 + "   Expected product base price : " + totalmonth)
			}

			String totalprice= WebUI.getText(findTestObject('Object Repository/Addingorder/totalprice'))
			String split2before = totalprice.replace('£', '')
			String split2 =  split2before.replace(',', '')                                                         //get total price from order
			println(split2+'- System Generated Totalprice of product')
			float overallprice = totalmonths+monthlytotallicenceprices;
			String finalprice = String.format("%.2f", overallprice);
			if(totalmonth.equals(split2)){
				println('Totalprice validation Success')
				println ("System Generated Total Price : " +split2+ "   Mathes formual calulation of total price : " + totalmonth );

			}
			else{
				println('Totalprice validation failed')
				println ("System Generated Total Price : " +split2+ "   Mathes formual calulation of total price : " + totalmonth );
			}

		}



		//WebUI.click(findTestObject('Object Repository/Addingorder/OrderNext'))

		println ("===================================== Price Validation Successful =========================================================")

	}
}
