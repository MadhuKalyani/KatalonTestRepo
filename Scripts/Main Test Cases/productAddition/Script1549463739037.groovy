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

print('======================= Product Addition initation ========================')

print("======================= Product Addition initation ========================");

WebUI.waitForElementClickable(findTestObject('Object Repository/Navorderpage/Addneworder'), 10)

WebUI.click(findTestObject('Object Repository/Navorderpage/Addneworder'))


		WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/Servicesearch'), 10)
		
		WebUI.click(findTestObject('Object Repository/Addingorder/Servicesearch'))
		
		WebUI.switchToWindowIndex(1)
		
		WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/Addmicrosoftessential'), 10)
		
		WebUI.click(findTestObject('Object Repository/Addingorder/Addmicrosoftessential'))
		
		WebUI.switchToDefaultContent()
		
		WebUI.switchToFrame(findTestObject('Object Repository/Searching/mainframe'), 10)
		
		WebUI.waitForElementClickable(findTestObject('Addingorder/PeriodSearch'), 10)
		
		WebUI.click(findTestObject('Addingorder/PeriodSearch'))
		
		WebUI.switchToWindowIndex(1)
		
		WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/Addplan'), 10)
		
		WebUI.click(findTestObject('Object Repository/Addingorder/Addplan'))
		
		WebUI.switchToDefaultContent()
		
		WebUI.switchToFrame(findTestObject('Object Repository/Searching/mainframe'), 10)
		
		WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/OrderNext'), 10)
		
		WebUI.click(findTestObject('Object Repository/Addingorder/OrderNext'))
		
		println ("***************** Microsoft Product Added Successfully *****************************************");

println('***************** Microsoft Product Added Successfully *****************************************')