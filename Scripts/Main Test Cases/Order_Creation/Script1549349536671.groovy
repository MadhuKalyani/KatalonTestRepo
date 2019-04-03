import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang3.RandomUtils
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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration



println ("============================== Creation of Customer process is initiated ============================================== " );
WebUI.waitForElementClickable(findTestObject('Object Repository/Order_Creation/Click_NewOrder'), 7)

WebUI.click(findTestObject('Object Repository/Order_Creation/Click_NewOrder'))


// Code To generate RandomNumbers 

Random GenerateRandomNume = new Random();
int custno = GenerateRandomNume.nextInt(100000000);
 println ("Number is " + custno);
 WebUI.delay(3)
 String CustomerNumber = Integer.toString(custno)
 WebUI.click( findTestObject('Object Repository/Order_Creation/cust_num'));
 WebUI.setText( findTestObject('Object Repository/Order_Creation/cust_num'), CustomerNumber)
 WebUI.click( findTestObject('Object Repository/Order_Creation/click_next'))

 // Code to Store Randomly Generated value to be saved in Default Local Object
 GlobalVariable.Customer_Number = CustomerNumber;
 println ("Customer number is : " + CustomerNumber);
 
 WebUI.delay(2)
 WebUI.waitForElementPresent(findTestObject('Object Repository/Order_Creation/cust_name'), 20)
 

WebUI.setText(findTestObject('Object Repository/Order_Creation/cust_name'), "Madhu sekhar")

WebUI.waitForElementClickable(findTestObject('Object Repository/Order_Creation/cust_click_next'),20)

WebUI.click(findTestObject('Object Repository/Order_Creation/cust_click_next'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Order_Creation/cloud_appsore_access_click'),20)

WebUI.click(findTestObject('Object Repository/Order_Creation/cloud_appsore_access_click'))

// Need to develop code to capture service number as per date and year formate

 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
 LocalDateTime now = LocalDateTime.now();
 String Todaydate =  dtf.format(now);
 println ("Today date " + Todaydate);

WebUI.setText(findTestObject('Object Repository/Order_Creation/service_num'), Todaydate)

// Code to Store the passed Servicenumber as per the currentdate formate under Global Variable
GlobalVariable.Service_Number = Todaydate;


WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Order_Creation/Product_select_next'))

WebUI.delay(7)

WebUI.setText(findTestObject('Object Repository/Order_Creation/First_Name'), 'Nandini')

WebUI.setText(findTestObject('Object Repository/Order_Creation/Last_Name'), 'P.S')

// Get the data from Excel sheet
WebUI.setText(findTestObject('Object Repository/Order_Creation/Street_name'),'COWPER CRESCENT,BENGO')

WebUI.setText(findTestObject('Object Repository/Order_Creation/House_num'), '7')

WebUI.setText(findTestObject('Object Repository/Order_Creation/Zipcode'), 'SG143DZ')

WebUI.setText(findTestObject('Object Repository/Order_Creation/city'), 'HERTFORD' )

WebUI.setText(findTestObject('Object Repository/Order_Creation/countrycode'), 'GB' )

WebUI.setText(findTestObject('Object Repository/Order_Creation/state'), 'United Kingdom')

WebUI.setText(findTestObject('Object Repository/Order_Creation/phonecode'), '+44')

WebUI.setText(findTestObject('Object Repository/Order_Creation/phoneAreaCode'), '7013')

WebUI.setText(findTestObject('Object Repository/Order_Creation/phonenum'), '1234567890')

WebUI.setText(findTestObject('Object Repository/Order_Creation/email'), 'nandini.ps@prodapt.com')

WebUI.waitForElementClickable(findTestObject('Object Repository/Order_Creation/saveData'), 7)

WebUI.click(findTestObject('Object Repository/Order_Creation/saveData'))

WebUI.delay(7)

WebUI.click(findTestObject('Object Repository/Order_Creation/saveNext'))

WebUI.scrollToElement(findTestObject('Object Repository/Order_Creation/Finish'), 7)

WebUI.click(findTestObject('Object Repository/Order_Creation/Finish'))

println ("====================================== Customer Successfully Created ================================================== ");