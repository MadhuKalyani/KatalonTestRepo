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

WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/Click_Subscription'), 7)
WebUI.click(findTestObject('Object Repository/Termination/Click_Subscription'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/click_Subscription_name'), 7)
WebUI.click(findTestObject('Object Repository/Termination/click_Subscription_name'))

WebUI.delay(7)

WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/click_cancelSubsc'), 7)
WebUI.click(findTestObject('Object Repository/Termination/click_cancelSubsc'))

WebUI.delay(3)

WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/Enter_comment'), 7)
WebUI.click(findTestObject('Object Repository/Termination/Enter_comment'))

WebUI.setText(findTestObject('Object Repository/Termination/Enter_comment'), 'Zero Charge- refunded')
WebUI.click(findTestObject('Object Repository/Termination/click_next'))

WebUI.delay(7)

WebUI.click(findTestObject('Object Repository/Termination/click_placeorder'))
WebUI.delay(3)

WebUI.waitForElementClickable(findTestObject('Object Repository/Termination/click_refresh'), 7)
WebUI.click(findTestObject('Object Repository/Termination/click_refresh'))

