package cCP_Functionality

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

public class Validations {

	@Keyword

	def HomePage_Validations(){

		WebUI.waitForElementPresent(findTestObject('CCP_Portal/HomePage_Validations/HomePage_frame'), 20)
		println ("Frame has displayed ");
		WebUI.switchToFrame(findTestObject('CCP_Portal/HomePage_Validations/HomePage_frame'), 20)
		println ("Frame Switched to Home page");
		String Title  = WebUI.getWindowTitle();
		println ("Title of the page is : " + Title);

		WebUI.waitForElementPresent(findTestObject('CCP_Portal/HomePage_Validations/HomePage_GetstartedButton'), 20)
		String GetStart_Actual = WebUI.getText(findTestObject('CCP_Portal/HomePage_Validations/HomePage_GetstartedButton'))
		println (GetStart_Actual)
		boolean Button = WebUI.verifyElementPresent(findTestObject('CCP_Portal/HomePage_Validations/HomePage_GetstartedButton'), 20)
		String GetStart_Expected= "Get started";
		//println (Assert.assertEquals(GetStart_Actual, GetStart_Expected))
		if(Button){
			println ("Get Start button is displayed")
		} else {
			println ("Get Start button is Not - displayed")
		}

		println ("===================== TCP21 Validation Completed ===============================================");

		println ("checking the Products visible under the home page");

		WebUI.switchToDefaultContent();
		println ("Switched to Default page");

		// To check the microsoft office product presence

		/*	try{
		 WebUI.verifyElementPresent(findTestObject('Object Repository/CCP_Portal/HomePage_Validations/OfficeO365Product'), 10)
		 boolean OfficeO365 = WebUI.verifyElementPresent(findTestObject('Object Repository/CCP_Portal/HomePage_Validations/OfficeO365Product'), 10)
		 if(OfficeO365){
		 println ("Microsoft OfficeO365 Product is displayed")
		 }else {
		 println ();
		 }
		 } catch (Exception e){
		 println (e)
		 }*/

		//WebUI.switchToDefaultContent();
		println ("Switched to Default page");

		// To check the DropDown product presence
		// need to develop code here


	}
}
