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

WebUI.openBrowser('')

WebUI.maximizeWindow()
WebUI.delay(5)
WebUI.navigateToUrl(GlobalVariable.RCP_URL)

WebUI.waitForElementClickable((findTestObject('Object Repository/Rcp-login/Username')), 10)

WebUI.sendKeys(findTestObject('Object Repository/Rcp-login/Username'), GlobalVariable.RCP_Username)
WebUI.delay(5)
WebUI.sendKeys(findTestObject('Object Repository/Rcp-login/Password'), GlobalVariable.RCP_Password)
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Rcp-login/Loginbutton'))
WebUI.delay(5)
window_title= WebUI.getWindowTitle()


WebUI.switchToFrame(findTestObject('Object Repository/Searching/Framebilling'), 10)

WebUI.waitForElementClickable(findTestObject('Object Repository/Searching/clickonBilling'), 10)

WebUI.click(findTestObject('Object Repository/Searching/clickonBilling'))


WebUI.switchToWindowTitle(window_title)
WebUI.switchToFrame(findTestObject('Object Repository/Searching/frame_customers'), 10)

WebUI.click(findTestObject('Object Repository/Searching/clickoncustomers'))
WebUI.delay(10)
WebUI.switchToWindowTitle(window_title)
WebUI.switchToFrame(findTestObject('Object Repository/Searching/mainframe'), 10)
WebUI.clearText(findTestObject('Object Repository/Searching/sendcustomerNo'))
WebUI.delay(10)
WebUI.setText(findTestObject('Object Repository/Searching/sendcustomerNo'),'43182695')

WebUI.click(findTestObject('Object Repository/Searching/Entersearch'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Searching/Enteraccount'), 10)

WebUI.click(findTestObject('Object Repository/Searching/Enteraccount'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/clicksubscrption'), 10)

WebUI.click(findTestObject('Object Repository/Macdchange/clicksubscrption'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/Selectproduct'), 10)

WebUI.click(findTestObject('Object Repository/Macdchange/Selectproduct'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/clickresource'), 10)

WebUI.click(findTestObject('Object Repository/Macdchange/clickresource'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/clickchckboxproduct'), 10)

WebUI.click(findTestObject('Object Repository/Macdchange/clickchckboxproduct'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/clickupgradeplan'), 10)

WebUI.click(findTestObject('Object Repository/Macdchange/clickupgradeplan'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/clickchckboxlicence'), 10)

WebUI.click(findTestObject('Object Repository/Macdchange/clickchckboxlicence'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/Sendno_licence'), 10)

WebUI.setText(findTestObject('Object Repository/Macdchange/Sendno_licence'),'-1')
WebUI.click(findTestObject('Object Repository/Macdchange/nextbtn'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Confirm_orderpage/Placeorder'), 10)

WebUI.click(findTestObject('Object Repository/Confirm_orderpage/Placeorder'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Productstatus_details/Refresh'), 10)

WebUI.click(findTestObject('Object Repository/Productstatus_details/Refresh'))
String chkstatus = WebUI.getText(findTestObject('Object Repository/Macdchange/Statuschck'))
System.out.println(chkstatus);
while(!chkstatus.equalsIgnoreCase('installed')){
WebUI.click(findTestObject('Object Repository/Productstatus_details/Refresh'))
WebUI.delay(10)
chkstatus= WebUI.getText(findTestObject('Object Repository/Macdchange/Statuschck'))
System.out.println(chkstatus);
}
System.out.println("it's installed");
WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/clickorders'), 10)

WebUI.click(findTestObject('Object Repository/Macdchange/clickorders'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Macdchange/confirmstatus'), 10)

String staus= WebUI.getText(findTestObject('Object Repository/Macdchange/confirmstatus'))
System.out.println(staus);