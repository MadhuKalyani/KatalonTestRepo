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



println ("================================= Initiating RCP Portal =================================================");
WebUI.navigateToUrl(GlobalVariable.RCP_URL)

WebUI.waitForElementClickable((findTestObject('Object Repository/Rcp-login/Username')), 10)

WebUI.sendKeys(findTestObject('Object Repository/Rcp-login/Username'), GlobalVariable.RCP_Username)
WebUI.delay(2)
WebUI.sendKeys(findTestObject('Object Repository/Rcp-login/Password'), GlobalVariable.RCP_Password)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Rcp-login/Loginbutton'))

println ("================================ User Logged RCP portal successfully ===================================");

println ("================================ Searching Initiated Customer VIA PEVAS ---> RCP Portal ===================================== ");
WebUI.delay(20)
String Tittle = WebUI.getWindowTitle();
println ("Current tittle is :" +Tittle);

WebUI.switchToFrame(findTestObject('Object Repository/Searching/BillingFrame'), 20)
String SwitchedFrameTittle = WebUI.getWindowTitle();
println ("Current tittle is :" +SwitchedFrameTittle);

WebUI.waitForElementClickable(findTestObject('Object Repository/Searching/clickonBilling'), 10)
WebUI.click(findTestObject('Object Repository/Searching/clickonBilling'))
WebUI.delay(10);

WebUI.switchToDefaultContent();
println ("Driver Siwtch back to Default Frame");

WebUI.switchToFrame(findTestObject('Object Repository/Searching/LeftPannelFrame'), 20)
String SwitchedLeftFrame = WebUI.getWindowTitle();
println ("Current tittle is :" +SwitchedLeftFrame);
WebUI.delay(5)

WebUI.waitForElementClickable(findTestObject('Object Repository/Searching/clickoncustomers'), 50)
WebUI.click(findTestObject('Object Repository/Searching/clickoncustomers'))
WebUI.delay(10)
WebUI.setText(findTestObject('Object Repository/Searching/sendcustomerNo'), GlobalVariable.Customer_Number );

WebUI.click(findTestObject('Object Repository/Searching/Entersearch'))

println ("============================== Searching Process completed, PEVAS user displayed in RCP Portal ==============================");

println ("============================== Navigating to Account pages ==============================");

WebUI.waitForElementClickable(findTestObject('Object Repository/Searching/Enteraccount'), 10)

WebUI.click(findTestObject('Object Repository/Searching/Enteraccount'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Navorderpage/clickonorders'), 10)

WebUI.click(findTestObject('Object Repository/Navorderpage/clickonorders'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Navorderpage/Addneworder'), 10)

println ("============================== Navigated to Order section page ==============================");


WebUI.click(findTestObject('Object Repository/Navorderpage/Addneworder'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/Servicesearch'), 10)

WebUI.click(findTestObject('Object Repository/Addingorder/Servicesearch'))

//////////////////////////// Latest code

WebUI.waitForElementClickable(findTestObject('Object Repository/Navorderpage/Addneworder'), 10)

WebUI.click(findTestObject('Object Repository/Navorderpage/Addneworder'))

//After clicking add new order
WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/Servicesearch'), 10)

WebUI.click(findTestObject('Object Repository/Addingorder/Servicesearch'))

WebUI.switchToWindowIndex(1)

WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/Addmicrosoftessential'), 10)

WebUI.click(findTestObject('Object Repository/Addingorder/Addmicrosoftessential'))

WebUI.switchToWindowTitle(window_title)

WebUI.switchToFrame(findTestObject('Object Repository/Searching/mainframe'), 10)

WebUI.waitForElementClickable(findTestObject('Addingorder/PeriodSearch'), 10)

WebUI.click(findTestObject('Addingorder/PeriodSearch'))

WebUI.switchToWindowIndex(1)

WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/Addplan'), 10)

WebUI.click(findTestObject('Object Repository/Addingorder/Addplan'))

WebUI.switchToWindowTitle(window_title)

WebUI.switchToFrame(findTestObject('Object Repository/Searching/mainframe'), 10)

WebUI.waitForElementClickable(findTestObject('Object Repository/Addingorder/OrderNext'), 10)

WebUI.click(findTestObject('Object Repository/Addingorder/OrderNext'))
//parameters page- adding microsft mail

WebUI.waitForElementClickable(findTestObject('Object Repository/Parameters/Signupbuttton'), 10)

WebUI.click(findTestObject('Object Repository/Parameters/Signupbuttton'))

WebUI.setText(findTestObject('Object Repository/Parameters/inputsubdomain'), 'nandini619')

WebUI.click(findTestObject('Object Repository/Parameters/checkbtn'))
WebUI.delay(20)
WebUI.setText(findTestObject('Object Repository/Parameters/para_fname'), 'nandini')

WebUI.setText(findTestObject('Object Repository/Parameters/para_lname'), 'ps')

WebUI.setText(findTestObject('Object Repository/Parameters/para_mail'), 'nandini.ps+009@prodapt.com')

WebUI.click(findTestObject('Object Repository/Parameters/I-confirmbtn'))
WebUI.delay(10)
WebUI.click(findTestObject('Object Repository/Addingorder/OrderNext'))
//confirm-order page- adding licences

WebUI.waitForElementClickable(findTestObject('Object Repository/Confirm_orderpage/OrderAdditional'), 10)
WebUI.click(findTestObject('Object Repository/Confirm_orderpage/OrderAdditional'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Confirm_orderpage/Choosecategory'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Confirm_orderpage/Modifyresource'))
WebUI.delay(5)
WebUI.clearText(findTestObject('Object Repository/Confirm_orderpage/Addunits_licence'))

WebUI.setText(findTestObject('Object Repository/Confirm_orderpage/Addunits_licence'), '20.0')

WebUI.click(findTestObject('Object Repository/Confirm_orderpage/Next'))

WebUI.click(findTestObject('Object Repository/Addingorder/OrderNext'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Productstatus_details/Refresh'), 10)
WebUI.click(findTestObject('Object Repository/Productstatus_details/Refresh'))

String status= WebUI.getText(findTestObject('Object Repository/Productstatus_details/Statuscheck'))
System.out.println(status);
while(!(status.equals('Completed'))){
WebUI.click(findTestObject('Object Repository/Productstatus_details/Refresh'))
WebUI.delay(10)
//String status= WebUI.getText(findTestObject('Object Repository/Productstatus_details/Statuscheck'))
}
