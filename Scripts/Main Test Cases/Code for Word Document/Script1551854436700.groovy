import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.RenderingHints.Key as Key
import org.openqa.selenium.Keys as Keys
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

WebUI.comment(">>> currentTestCaseId=$GlobalVariable.currentTestCaseId")

WebUI.openBrowser('')

WebUI.delay(5)

WebUI.navigateToUrl('https://Google.com')

WebUI.maximizeWindow()

WebUI.delay(4)

CustomKeywords.'word_Documents.WordDocCodes.genericWordDocUpdateCommentsandScreenshots'()

WebUI.waitForElementPresent(findTestObject('TestWordDoc/tittle'), 5)

WebUI.sendKeys(findTestObject('TestWordDoc/tittle'), 'Prodapt.com')

WebUI.delay(2)

WebUI.click(findTestObject('TestWordDoc/Submit'))

WebUI.delay(3)

CustomKeywords.'word_Documents.WordDocCodes.genericWordDocUpdateCommentsandScreenshots'()

WebUI.waitForElementClickable(findTestObject('TestWordDoc/ProdaptHomeLink'), 10)

WebUI.click(findTestObject('TestWordDoc/ProdaptHomeLink'))

WebUI.delay(3)

WebUI.waitForPageLoad(20)

CustomKeywords.'word_Documents.WordDocCodes.genericWordDocUpdateCommentsandScreenshots'()

WebUI.waitForElementPresent(findTestObject('TestWordDoc/ContactLink'), 10)

WebUI.click(findTestObject('TestWordDoc/ContactLink'))

WebUI.delay(3)

WebUI.waitForPageLoad(20)

CustomKeywords.'word_Documents.WordDocCodes.genericWordDocUpdateCommentsandScreenshots'()


