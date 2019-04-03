package _MACD

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.security.Principal
import java.lang.*;
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

import internal.GlobalVariable

public class Change {

	@Keyword

	def Initiate_Licence_Change (HashMap<String, String> TestDataValue){

		println ("***********************  MACD Initiation starts **********************************");
		WebUI.delay(2);
		println ("checking for the object Subscription")
		WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/clicksubscrption'), 120)
		WebUI.click(findTestObject('Object Repository/Macdchange/clicksubscrption'))
		println ("Subscription link is clicked")

		WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/Selectproduct'), 10)
		WebUI.click(findTestObject('Object Repository/Macdchange/Selectproduct'))
		println ("Product link is clicked");

		WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/clickresource'), 10)
		WebUI.click(findTestObject('Object Repository/Macdchange/clickresource'))
		println ("Resource Link icon is clicked");

		WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/clickchckboxproduct'), 10)
		WebUI.click(findTestObject('Object Repository/Macdchange/clickchckboxproduct'))
		println ("check box of the product enabled");

		WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/clickupgradeplan'), 20)
		WebUI.click(findTestObject('Object Repository/Macdchange/clickupgradeplan'))
		println ("Clicked on upgrade plan link");

		WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/clickchckboxlicence'), 10)
		WebUI.click(findTestObject('Object Repository/Macdchange/clickchckboxlicence'))


		WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/Sendno_licence'), 10)
		WebUI.setText(findTestObject('Object Repository/Macdchange/Sendno_licence'), TestDataValue.get("MACDLicenceQty"))
		println ("MACD Licence Qty passed");

		WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/nextbtn'),10);
		WebUI.click(findTestObject('Object Repository/Macdchange/nextbtn'))


		println ("***********************  MACD Initiation starts **********************************");
	}



	@Keyword

	def Macd_PriceValidations(HashMap<String, String> TestDataValue){

		println ("**********************************************  MACD Price Validations starts ***************************************************");

		//String setlicence = '-2';
		String Licence =  TestDataValue.get("MACDLicenceQty")
		println ("No of License for MACD order : " + Licence);

		//set licence
		int printlicence = Integer.parseInt(Licence);
		println(printlicence)

		if(printlicence < 0){

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
			// if condition whether  licence is  -ve or +ve.
			// original price (GV)
			String essentialmonthprice= String.format("%.2f", baseprices);
			println(essentialmonthprice+' --> baseprice_of_product')
			float monthlytotallicenceprices= printlicence * baseprices ;                             // totalprice claculated
			String monthlytotallicenceprice= String.format("%.2f", monthlytotallicenceprices);
			println(monthlytotallicenceprice+'  --> (No.of License * Base price) formual Calculatted value')
			String getduration= WebUI.getText(findTestObject('Object Repository/Addingorder/get_macduration')) // Get the duration (months/years) of products
			println("Time period of the product : " + getduration)
			String getlicence = WebUI.getText(findTestObject('Object Repository/Addingorder/getlicence_units'))
			println("No.of License after MACD : " +getlicence)
			String pricebase= WebUI.getText(findTestObject('Addingorder/getbaseprice'))                        // Price from order
			String split1 = pricebase.replace('-£', '')
			println(split1+' --> System Generated total price')
			if(monthlytotallicenceprice.equals(split1)){
				println('Base Price  validation Success')
			}
			else{
				//println('Product Base Price validation failed')
			}
			String totalprice= WebUI.getText(findTestObject('Object Repository/Addingorder/totalprice'))       //totalprice from order
			String split2 = totalprice.replace('£', '')
			println(split2+'- System Generated Totalmacdprice of product')
			if(split2 == '0.00'){
				println('totalprice validation Success')

				println ("system Generated base price : " + split2 + "   Expected product base price : " + split2)
			}
			else{
				println('totalprice validation failed')
			}
		}
		else{

			// Condition to split calculation formula based on product Selection

			String period =  TestDataValue.get("SubscriptionPeriod")
			println ("Period selected for this order is : " + period);
			float baseprices;
			if(period.contains("Year")){
				String baseprice = TestDataValue.get("Yearly")   // Getting price from external source
				baseprices = Float.parseFloat(baseprice)
				println ("Price for the product based on Year is : " +baseprices);

			} else if (period.contains("Month")){
				String baseprice = TestDataValue.get("Monthly")    // Getting price from external source
				baseprices = float.parseFloat(baseprice)
				println ("Price for the product based on Year is : " +baseprices)
			} else {
				println ("Values not found")
			}

			// =====================================================

			String product =  TestDataValue.get("Product")
			println ("Period selected for this order is : " + product);
			if(product.contains("Microsoft")){

				// original price (GV)
				String essentialmonthprice= String.format("%.2f", baseprices);
				println(essentialmonthprice+ ' -->  baseprice_of_product')

				String license =  TestDataValue.get("MACDLicenceQty")   // To get the License
				println ("No.of License added to the product  : " + license);
				float noLic = Float.parseFloat(license)

				float monthlytotallicenceprices= noLic * baseprices ;
				String monthlytotallicenceprice= String.format("%.2f", monthlytotallicenceprices);

				println(monthlytotallicenceprice+  ' Total Price (Product base price * No.of License) Formual Calculatted')
				String getduration= WebUI.getText(findTestObject('Object Repository/Addingorder/get_macduration'))                     // Get the duration (months/years) of products
				println("No of Period Time : " +getduration)
				String getlicence = WebUI.getText(findTestObject('Object Repository/Addingorder/getlicence_units'))
				println("No of License under page :" +getlicence)

				String pricebase= WebUI.getText(findTestObject('Addingorder/getbaseprice'))                                            // Price from order
				String split1 = pricebase.replace('£', '')
				println(split1+'- System Generated MACD product price (No.of Lic * product)')
				if(monthlytotallicenceprice.equals(split1)){
					println('Product Base price validation Success')

					println ("system Generated base price : " + split1 + "   Calculatted Expected product base price (No.of Lic*prod) : " + monthlytotallicenceprice)
				}
				else{
					println('Product Base price validation Failed ')

					println ("system Generated base price : " + split1 + "   Calculatted Expected product base price (No.of Lic*prod) : " + monthlytotallicenceprice)
				}

				String totalprice= WebUI.getText(findTestObject('Object Repository/Addingorder/totalprice'))                        //total price from order
				String split2 = totalprice.replace('£', '')
				println(split2+'- Totalmacdprice of product(No.of Lic * product) under page level')
				if(monthlytotallicenceprice.equals(split2)){
					println('Total price validation Success Across Page Level')
					println ("system Generated base price : " + split2 + "   Calculatted Expected product base price (No.of Lic*prod) : " + monthlytotallicenceprice)
				}
				else{
					println('Total price validation Failed Across Page Level')
					println ("system Generated base price : " + split2 + "   Calculatted Expected product base price (No.of Lic*prod) : " + monthlytotallicenceprice)
				}

			}else if (product.contains("Dropbox")){


				// original price (GV)
				String essentialmonthprice= String.format("%.2f", baseprices);
				println(essentialmonthprice+ ' -->  baseprice_of_product')

				String license =  TestDataValue.get("MACDLicenceQty")   // To get the License
				println ("No.of License added to the product  : " + license);
				float noLic = Float.parseFloat(license)

				float monthlytotallicenceprices= noLic * baseprices ;
				String monthlytotallicenceprice= String.format("%.2f", monthlytotallicenceprices);

				println(monthlytotallicenceprice+  ' Total Price (Product base price * No.of License) Formual Calculatted')
				String getduration= WebUI.getText(findTestObject('Object Repository/Addingorder/get_macduration'))                     // Get the duration (months/years) of products
				println("No of Period Time : " +getduration)
				String getlicence = WebUI.getText(findTestObject('Object Repository/Addingorder/getlicence_units'))
				println("No of License under page :" +getlicence)

				String pricebase= WebUI.getText(findTestObject('Addingorder/getbaseprice'))                                            // Price from order
				String split1 = pricebase.replace('£', '')
				println(split1+'- System Generated MACD product price (No.of Lic * product)')
				if(monthlytotallicenceprice.equals(split1)){
					println('Product Base price validation Success')

					println ("system Generated base price : " + split1 + "   Calculatted Expected product base price (No.of Lic*prod) : " + monthlytotallicenceprice)
				}
				else{
					println('Product Base price validation Failed ')

					println ("system Generated base price : " + split1 + "   Calculatted Expected product base price (No.of Lic*prod) : " + monthlytotallicenceprice)
				}

				String totalprice= WebUI.getText(findTestObject('Object Repository/Addingorder/totalprice'))                        //total price from order
				String split2 = totalprice.replace('£', '')
				println(split2+'- Totalmacdprice of product(No.of Lic * product) under page level')
				if(monthlytotallicenceprice.equals(split2)){
					println('Total price validation Success Across Page Level')
					println ("system Generated base price : " + split2 + "   Calculatted Expected product base price (No.of Lic*prod) : " + monthlytotallicenceprice)
				}
				else{
					println('Total price validation Failed Across Page Level')
					println ("system Generated base price : " + split2 + "   Calculatted Expected product base price (No.of Lic*prod) : " + monthlytotallicenceprice)
				}
			}
		}

		println ("**********************************************  MACD Price Validations Successfully Complets  ***************************************************");

	}
}
