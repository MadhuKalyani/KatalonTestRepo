package cCP_Functionality

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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


import internal.GlobalVariable

public class Microsoft_Users_Validations {

	@Keyword

	def Microsoft_Users_validation(String ExpectedValue){

		WebUI.waitForElementPresent(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Frame_AddUsers'), 20)
		WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Frame_AddUsers'), 20)
		println ("Frame Switched to User Page");

		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Userpage_FilterIcon'), 20)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Userpage_FilterIcon'))
		println ("User's Filter option clicked and table formate is displayed");

		//(new  cCP_Functionality.Adding_UserLicense()).Activate_MicrosoftUserLicense("Not Activated")


		println ("Activating the User under User level");
		WebUI.delay(5)

		WebDriver driver = DriverFactory.getWebDriver()
		//String ExpectedValue = "Not Activated";

		// To get the table and body
		WebElement Table = driver.findElement(By.xpath("//div[@class='table-responsive-vertical']//table[@class='table table-hover']//tbody"))
		// Get the rows of the table
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		int rows_count = rows_table.size()
		println ("Rows Count : " +rows_count);

		Loop:
		for(int row = 0; row<rows_count; row++){

			List<WebElement> Columns_row  = rows_table.get(row).findElements(By.tagName('td'))
			List<WebElement> Columns_Text = Columns_row + "//span[2]";
			int columns_count  = Columns_row.size();
			println((('Number of cells In Row ' + row) + ' are ') + columns_count)

			for(int column = 0; column < columns_count; column++){
				String celltext =  Columns_Text.get(column).getText()
				println((((('Cell Value Of row number ' + row) + ' and column number ') + column) + ' Is ') + celltext)

				if(celltext == ExpectedValue){
					WebUI.waitForElementVisible(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Action_Button'), 10)
					driver.findElement(By.xpath("(//button[@type='button']//ancestor::table[@class='table table-hover']//span[contains(text(),'Actions')])"+[row+1]+""))click();
					WebUI.delay(3)

					// clicking on Activate Button
					WebUI.waitForElementVisible(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Activate'), 10)
					WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Activate'))
					WebUI.delay(5)

					WebUI.switchToDefaultContent();
					println ("Switched to Default window");
					WebUI.delay(5)

					//Navigate to Pswd Generator PSWD
					WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/PSWD_Generater_POPUP'), 20)
					println ("Frame switched to Pop up");

					WebUI.switchToDefaultContent();
					WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Pswd_Activate'), 20)
					WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Pswd_Activate'))
					WebUI.delay(25)
					WebUI.switchToDefaultContent();
					//Need to develop code to check the status

					println ("Activation completed ");
					WebUI.waitForElementPresent(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Frame_AddUsers'), 20)
					WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Frame_AddUsers'), 10)
					println ("Switched to the Users Page");
					WebUI.delay(10)	 // Need to build a code to wait untill the status become Ready
					println ("Value Found");
					break Loop
					println ("Break the Loop");
				}else {
					println ("Value not- Found");

				}
			}
		}
	}

	@Keyword

	def deactivate_User(String ExpectedValue){
		WebUI.waitForElementPresent(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Frame_AddUsers'), 20)
		WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Frame_AddUsers'), 20)
		println ("Frame Switched to User Page");

		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Userpage_FilterIcon'), 20)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Userpage_FilterIcon'))
		println ("User's Filter option clicked and table formate is displayed");

		//(new  cCP_Functionality.Adding_UserLicense()).Activate_MicrosoftUserLicense("Not Activated")


		println ("Activating the User under User level");
		WebUI.delay(5)

		WebDriver driver = DriverFactory.getWebDriver()
		//String ExpectedValue = "Not Activated";

		// To get the table and body
		WebElement Table = driver.findElement(By.xpath("//div[@class='table-responsive-vertical']//table[@class='table table-hover']//tbody"))
		// Get the rows of the table
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		int rows_count = rows_table.size()
		println ("Rows Count : " +rows_count);

		Loop:
		for(int row = 0; row<rows_count; row++){

			List<WebElement> Columns_row  = rows_table.get(row).findElements(By.tagName('td'))
			List<WebElement> Columns_Text = Columns_row + "//span[2]";
			int columns_count  = Columns_row.size();
			println((('Number of cells In Row ' + row) + ' are ') + columns_count)

			for(int column = 0; column < columns_count; column++){
				String celltext =  Columns_Text.get(column).getText()
				println((((('Cell Value Of row number ' + row) + ' and column number ') + column) + ' Is ') + celltext)

				if(celltext == ExpectedValue){
					WebUI.waitForElementVisible(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Action_Button'), 10)
					driver.findElement(By.xpath("(//button[@type='button']//ancestor::table[@class='table table-hover']//span[contains(text(),'Actions')])"+[row+1]+""))click();
					WebUI.delay(3)

					// clicking on Activate Button

					if(ExpectedValue.equalsIgnoreCase("Not Activated")){
						WebUI.waitForElementVisible(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Activate'), 10)
						WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Activate'))
						WebUI.delay(5)

					} else if (ExpectedValue.equalsIgnoreCase("Disable")){
						WebUI.waitForElementVisible(findTestObject('Object Repository/CCP_Portal/DropBox_Validations/Disable'), 10)
						WebUI.click(findTestObject('Object Repository/CCP_Portal/DropBox_Validations/Disable'))
						WebUI.delay(5)
						println ("Disable the user service");

					} else if (ExpectedValue.equalsIgnoreCase("Delete")){
						WebUI.waitForElementVisible(findTestObject('Object Repository/CCP_Portal/DropBox_Validations/Delete_User'), 10)
						WebUI.click(findTestObject('Object Repository/CCP_Portal/DropBox_Validations/Delete_User'))
						WebUI.delay(5)
						println ("Deleted the entire user profile " );
					}
					WebUI.waitForElementVisible(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Activate'), 10)
					WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Activate'))
					WebUI.delay(5)

					WebUI.switchToDefaultContent();
					println ("Switched to Default window");
					WebUI.delay(5)

					//Navigate to Pswd Generator PSWD
					WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/PSWD_Generater_POPUP'), 20)
					println ("Frame switched to Pop up");

					WebUI.switchToDefaultContent();
					WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Pswd_Activate'), 20)
					WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Pswd_Activate'))
					WebUI.delay(25)
					WebUI.switchToDefaultContent();
					//Need to develop code to check the status

					//println ("Activation completed ");
					WebUI.waitForElementPresent(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Frame_AddUsers'), 20)
					WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Frame_AddUsers'), 10)
					println ("Switched to the Users Page");
					WebUI.delay(10)	 // Need to build a code to wait untill the status become Ready
					println ("Value Found");
					break Loop
					println ("Break the Loop");
				}else {
					println ("Value not- Found");

				}
			}
		}
	}


	@Keyword

	def Login_ASUser(){

		// As a admin log-in as user profile

		String GetUserName= WebUI.getText(findTestObject('Object Repository/Validation/CCP/GetUserName'))
		println("User name is : " + GetUserName);

		WebUI.waitForElementPresent(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/UserPage_Action_1'), 20)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/UserPage_Action_1'))
		println ("Selected user row and clicked on Action link");

		WebUI.delay(3)
		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Log_As_User'), 20)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Log_As_User'))
		println ("clicked on Log-As-User ");
		WebUI.delay(2)
		WebUI.switchToWindowIndex(1)
		println ("Switched to new Window");
		WebUI.delay(7)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Validation/CCP/Users_page_Product'), 20)
		WebUI.click(findTestObject('Object Repository/Validation/CCP/Users_page_Product'))

		// Validating the Service
		println ("Validating the Services under the page");
		String product = WebUI.getText(findTestObject('Object Repository/Validation/CCP/Users_page_Product'))
		println ("Product is : " +product);

		if(product.contains("Office 365")){
			println ("Product validation completed");
			println ("Product validation met and Expected product is : " + "Office 365" + " and actual product is : " +product);
		}else if(product.contains("Dropbox")){
			println ("Product validation completed");
			println ("Product validation met and Expected product is : " + "Drop Box" + " and actual product is : " +product);
		} else {
			println ("Product Validation under user profile Failed");
		}

		WebUI.waitForElementClickable(findTestObject('Object Repository/Validation/CCP/Click_Username(newWindow)'), 7)
		String Username= WebUI.getText(findTestObject('Object Repository/Validation/CCP/Click_Username(newWindow)'))
		println("User level Application User name is : " + Username);

		WebUI.click(findTestObject('Object Repository/Validation/CCP/Click_Username(newWindow)'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/Validation/CCP/click_Myprofile'), 7)
		WebUI.click(findTestObject('Object Repository/Validation/CCP/click_Myprofile'))
		WebUI.delay(7)
		WebUI.switchToFrame(findTestObject('Object Repository/Validation/CCP/iframe_newWindow'), 7)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Validation/CCP/Fullname'), 7)
		String Fullname= WebUI.getText(findTestObject('Object Repository/Validation/CCP/Fullname'))
		println("User page level User name is : " + Fullname);

		WebUI.switchToDefaultContent()
		println ("Driver focus switched to user's page ");

		WebUI.click(findTestObject('Object Repository/Validation/CCP/Click_Username(newWindow)'))
		WebUI.click(findTestObject('Object Repository/Validation/CCP/Click_SignOut'))
		WebUI.switchToWindowIndex(0)

		println ("Validating the User profile");
		if(GetUserName==Fullname){
			println ("Checking the name of the user");
			println("Name is Same in both Admin and User Profile portal's");
		}else{
			println("Name's Mismatched");

		}
	}
}
