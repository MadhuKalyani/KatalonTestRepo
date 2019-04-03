import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import javax.servlet.annotation.WebInitParam

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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.support.FindBy as FindBy
import org.openqa.selenium.support.PageFactory as PageFactory

WebUI.openBrowser('')

WebUI.navigateToUrl('https://ap8.lightning.force.com/lightning/page/home')

WebUI.delay(8)

WebUI.maximizeWindow()

WebUI.waitForElementPresent(findTestObject('TestWordDoc/Salesforce_Login'), 5)

WebUI.sendKeys(findTestObject('TestWordDoc/Salesforce_user'), "madhusekhar100@gmail.com")

WebUI.delay(2)

WebUI.sendKeys(findTestObject('TestWordDoc/Salesforce_pswd'), "Madhu@01")

WebUI.delay(2)

WebUI.click(findTestObject('TestWordDoc/Salesforce_Login'))

WebUI.delay(2)

