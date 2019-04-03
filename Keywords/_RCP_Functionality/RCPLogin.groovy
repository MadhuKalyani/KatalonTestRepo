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

public class RCPLogin {

	@Keyword
	def RCP_Login(){
		println ("================================= Initiating RCP Portal =================================================");
		WebUI.navigateToUrl(GlobalVariable.RCP_URL)

		WebUI.waitForElementClickable((findTestObject('Object Repository/Rcp-login/Username')), 10)

		WebUI.sendKeys(findTestObject('Object Repository/Rcp-login/Username'), GlobalVariable.RCP_Username)
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('Object Repository/Rcp-login/Password'), GlobalVariable.RCP_Password)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Rcp-login/Loginbutton'))

		println ("================================ User Logged RCP portal successfully ===================================");
	}
}
