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

import internal.GlobalVariable

public class SearchCustomer {
	@Keyword

	def Searchcustomer(){
		println ("================================ Searching Initiated Customer VIA PEVAS ---> RCP Portal ===================================== ");
		WebUI.delay(8)
		String window_title = WebUI.getWindowTitle();
		println ("Current tittle is :" +window_title);

		WebUI.switchToFrame(findTestObject('Object Repository/Searching/BillingFrame'), 20)
		String SwitchedFrameTittle = WebUI.getWindowTitle();
		println ("Current tittle is :" +SwitchedFrameTittle);

		WebUI.waitForElementClickable(findTestObject('Object Repository/Searching/clickonBilling'), 20)
		WebUI.click(findTestObject('Object Repository/Searching/clickonBilling'))
		println ("Billing Link clicked");
		WebUI.delay(7);

		WebUI.switchToWindowTitle(window_title)
		WebUI.switchToFrame(findTestObject('Object Repository/Searching/frame_customers'), 20)

		WebUI.click(findTestObject('Object Repository/Searching/clickoncustomers'))
		WebUI.delay(7)
		WebUI.switchToWindowTitle(window_title)
		WebUI.switchToFrame(findTestObject('Object Repository/Searching/mainframe'), 20)
		WebUI.clearText(findTestObject('Object Repository/Searching/sendcustomerNo'))
		WebUI.click(findTestObject('Object Repository/Searching/Resetsearch'))

		WebUI.click(findTestObject('Object Repository/Searching/sendcustomerNo'))
		WebUI.setText(findTestObject('Object Repository/Searching/sendcustomerNo'), GlobalVariable.Customer_Number );   // Need to change final
		println ("Enter Customer number is :  " + GlobalVariable.Customer_Number);

		WebUI.click(findTestObject('Object Repository/Searching/Entersearch'))

		println ("============================== Searching Process completed, PEVAS user displayed in RCP Portal ==============================");


		println ("============================== Navigating to Account pages ==============================");

		WebUI.delay(20)

		WebUI.click(findTestObject('Object Repository/Searching/Resetsearch'))

		WebUI.click(findTestObject('Object Repository/Searching/sendcustomerNo'))

		// Need to pass Global varaiable data here
		WebUI.setText(findTestObject('Object Repository/Searching/sendcustomerNo'), GlobalVariable.Customer_Number);   // Need to change final
		println ("Enter Customer number is : " + GlobalVariable.Customer_Number);

		WebUI.click(findTestObject('Object Repository/Searching/Resetsearch'))

		WebUI.click(findTestObject('Object Repository/Searching/sendcustomerNo'))

		// Need to pass Global varaiable data here
		WebUI.setText(findTestObject('Object Repository/Searching/sendcustomerNo'), GlobalVariable.Customer_Number);   // Need to change final
		println ("Enter Customer number is : " + GlobalVariable.Customer_Number);

		WebUI.click(findTestObject('Object Repository/Searching/Entersearch'))



		try {
			WebUI.verifyElementPresent(findTestObject('Object Repository/Searching/Enteraccount'), 10)
			WebUI.click(findTestObject('Object Repository/Searching/Enteraccount'))
		} catch (Exception e) {
			e.printStackTrace()
		}

		WebUI.waitForElementClickable(findTestObject('Object Repository/Navorderpage/clickonorders'), 10)
		WebUI.click(findTestObject('Object Repository/Navorderpage/clickonorders'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/Navorderpage/Addneworder'), 10)
		println ("============================== Navigated to Order section page ==============================");
	}
}
