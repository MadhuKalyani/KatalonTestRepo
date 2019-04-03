package _PEVAS_Functionality

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

public class PEVAS_Login {

	@Keyword

	def PevasLogin(){

		WebUI.openBrowser('')
		WebUI.delay(5)
		println ("========================  Performing PEVAS Login Operation =============================");
		WebUI.navigateToUrl(GlobalVariable.PEVAS_URL)
		println ("PEVAS Portal Launched Successfully ");
		WebUI.maximizeWindow()
		WebUI.delay(3)
		WebUI.setText(findTestObject('Object Repository/Login_PEVAS/username'),GlobalVariable.username_pevas)
		WebUI.setText(findTestObject('Object Repository/Login_PEVAS/password'),GlobalVariable.password_pevas)
		WebUI.click(findTestObject('Object Repository/Login_PEVAS/login'))
		println ("========================  User Logged in PEVAS Portal Successfully =============================");
		WebUI.delay(7)
	}
}
