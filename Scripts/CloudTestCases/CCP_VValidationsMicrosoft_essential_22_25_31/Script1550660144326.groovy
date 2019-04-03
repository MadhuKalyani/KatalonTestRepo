import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'cCP_Functionality.CCP_Login.CCPLogin'()

CustomKeywords.'cCP_Functionality.Validations.HomePage_Validations'()

CustomKeywords.'cCP_Functionality.Adding_UserLicense.Adding_MicrosoftUserLicense'()

CustomKeywords.'cCP_Functionality.Adding_UserLicense.Activate_MicrosoftUserLicense'('Not Activated')

CustomKeywords.'cCP_Functionality.Microsoft_Users_Validations.Microsoft_Users_validation'('Not Activated')

CustomKeywords.'cCP_Functionality.Microsoft_Users_Validations.Login_ASUser'()
