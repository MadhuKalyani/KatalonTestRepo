package cCP_Functionality

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.print.Printable

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

public class CCP_Login {

	@Keyword

	def CCPLogin(){
		WebUI.openBrowser('')
		WebUI.delay(5)
		println ("================================= Initiating CCP Portal =================================================");
		WebUI.navigateToUrl(GlobalVariable.CCP_URL)
		println ("CCP URL had been launched successfully: " + GlobalVariable.CCP_URL);

		WebUI.maximizeWindow();

		WebUI.waitForElementClickable((findTestObject('Object Repository/Rcp-login/Username')), 10)

		WebUI.sendKeys(findTestObject('Object Repository/Rcp-login/Username'), GlobalVariable.CCP_Username)
		WebUI.delay(2)
		println ("CCP User name passed");
		WebUI.sendKeys(findTestObject('Object Repository/Rcp-login/Password'), GlobalVariable.CCP_Password)
		WebUI.delay(1)
		println ("CCP password passed");
		WebUI.click(findTestObject('Object Repository/Rcp-login/Loginbutton'))
		println ("Logged button clicked");

		println ("================================ User Logged CCP portal successfully ===================================");
	}
}
