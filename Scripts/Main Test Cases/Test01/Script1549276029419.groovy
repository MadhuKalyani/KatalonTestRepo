import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import org.apache.commons.lang.RandomStringUtils

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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.lang.*;


//WebUI.comment(">>> currentTestCaseId=$GlobalVariable.currentTestCaseId")

//CustomKeywords.'excel.Excel_Reader.DataReader_Excel'()

//HashMap<String, String> TestDataValue = GlobalVariable.dataReader2
Random GenerateRandomNume = new Random();

int custno = GenerateRandomNume.nextInt(100000000);
 println ("Number is " + custno);
 
 
 Date date = new Date();
 String todayDate = date.format(84+'yymmdd');
 String todayTime = date.format('hhmmss');
 println ("todayDate date : " + todayDate+todayDate);
 
 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
 LocalDateTime now = LocalDateTime.now();
 String date2 =  dtf.format(now);
 println ("Today date " + date2);
 
 String random = RandomStringUtils.randomAlphabetic(5);
  println random
  
  // Excel Call  
   
  
  //CustomKeywords.'excel.Excel_Reader.DataReader_Excel'()   
  
  //HashMap<String, String> TestDataValue = GlobalVariable.dataReader2
  
  String Full_Refund_Value= "The Full Refund: -£356.40"
  
		  String[] parts= Full_Refund_Value.split(": ");
  
		  String part1=parts[0];
  
		  String part2=parts[1];
		  println (part2)
  
		 // float Sysprice = Float.parseFloat(part2)
  
		  println("System Generated full - Refunded price :" + part2);