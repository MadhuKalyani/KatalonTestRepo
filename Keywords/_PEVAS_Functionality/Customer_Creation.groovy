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
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang3.RandomUtils
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.apache.commons.lang.RandomStringUtils

import internal.GlobalVariable

public class Customer_Creation {

	@Keyword
	def CustomerCreation(HashMap<String, String> TestDataValue){

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

		String random = RandomStringUtils.randomAlphabetic(5);

		WebUI.setText(findTestObject('Object Repository/Order_Creation/cust_name'), "CloudTestB2B"+random)

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
		String random2 = RandomStringUtils.randomAlphabetic(5);
		WebUI.setText(findTestObject('Object Repository/Order_Creation/First_Name'), 'Logistics Formalities'+random2)

		WebUI.setText(findTestObject('Object Repository/Order_Creation/Last_Name'), 'PVT')

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
		WebUI.delay(2)
		println ("Enter Email : " +TestDataValue.get("Email"));
		Random GenerateRandomNume2 = new Random();
		int custno2 = GenerateRandomNume2.nextInt(10000);
		println ("Number is " + custno2);
		WebUI.delay(3)
		String CustomerNumber2 = Integer.toString(custno2)

		WebUI.setText(findTestObject('Object Repository/Order_Creation/email'), TestDataValue.get("Email")+CustomerNumber2+"@gmail.com")
		println ("Enter Email : " +TestDataValue.get("Email"));

		WebUI.waitForElementClickable(findTestObject('Object Repository/Order_Creation/saveData'), 7)

		WebUI.click(findTestObject('Object Repository/Order_Creation/saveData'))

		WebUI.delay(7)

		WebUI.click(findTestObject('Object Repository/Order_Creation/saveNext'))

		WebUI.scrollToElement(findTestObject('Object Repository/Order_Creation/Finish'), 7)

		WebUI.click(findTestObject('Object Repository/Order_Creation/Finish'))

		println ("====================================== Customer Successfully Created ================================================== ");
	}
}
