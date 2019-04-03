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
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang3.RandomUtils
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import internal.GlobalVariable

public class Adding_UserLicense {

	@Keyword

	def Adding_MicrosoftUserLicense(){

		println ("=================================   CCP_23_Self Care Admin role can assign services Microsoft office 365 Business Premium to the user ========================================================");

		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/HomePage_Validations/OfficeO365Product'), 10)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/HomePage_Validations/OfficeO365Product'))
		println ("OfficeO365 link is clicked");
		WebUI.delay(4)

		WebUI.waitForElementPresent(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Office365Frame'), 20)
		WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Office365Frame'), 10)
		println ("Switched to the Office365Frame");

		// Adding New User
		WebUI.delay(5)
		WebUI.waitForElementPresent(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/AddNewUser'), 10)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/AddNewUser'))
		println ("Clicked on add new user button");
		println ("Page navigated to Add New Users page");
		WebUI.delay(4)
		println WebUI.getWindowTitle();
		WebUI.switchToDefaultContent();
		println ("Switched to main page")
		WebUI.delay(4)

		Random GenerateRandomNume = new Random();
		int RandNo = GenerateRandomNume.nextInt(10000);
		println ("Number is " + RandNo);
		WebUI.delay(3)

		WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Frame_AddUsers'), 20)
		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/FirstName'), 0)
		WebUI.sendKeys(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/FirstName'), "James"+RandNo)
		WebUI.sendKeys(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/LastName'), "Camaron"+RandNo)

		WebUI.sendKeys(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Email'), "madhusekhar100"+RandNo+"@gmail.com")  // Need to provide random text here
		WebUI.switchToDefaultContent();
		println ("Switched to main page")

		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Next'), 10)
		WebUI.scrollToElement(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Next'), 10)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Next'))

		WebUI.delay(5);
		WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Office365Frame'), 10)
		println ("Frame Switched successfully");

		//adding Licsence to the user
		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/License_Office365'), 10)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/License_Office365'))
		println ("License got selected");
		WebUI.delay(3);

		WebUI.switchToDefaultContent();
		println ("Switched to main page")

		WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Next'))
		WebUI.delay(5);
		println ("successfully New User Added to the Group");

		// To check whether user got added into the group

		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/HomePage_Validations/OfficeO365Product'), 10)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/HomePage_Validations/OfficeO365Product'))
		println ("OfficeO365 link is clicked");
		WebUI.delay(4)

		WebUI.waitForElementPresent(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Office365Frame'), 20)
		WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Office365Frame'), 10)
		println ("Switched to the Office365Frame");
		println ("check the Created User added in the List");
		println ("Created User successfully added into the new List");

		println ("======================================================== CCP 23 Validation completes ==========================================================");


	}

	// To Activate Users under Microsoft Office

	@Keyword

	def Activate_MicrosoftUserLicense(String ExpectedValue){


		println ("Activating the User under Account level");
		WebUI.delay(5)

		WebDriver driver = DriverFactory.getWebDriver()
		//String ExpectedValue = "Not Activated";

		// To get the table and body
		WebElement Table = driver.findElement(By.xpath("//table/tbody"))
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
					driver.findElement(By.xpath("(//button[@type='button']//ancestor::tbody//span[contains(text(),'Actions')])"+[row+1]+""))click();
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
					WebUI.waitForElementClickable( findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Pswd_Generator'), 30)
					WebUI.click( findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Pswd_Generator'))
					WebUI.delay(5)

					WebUI.switchToDefaultContent();
					WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Pswd_Activate'), 20)
					WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Pswd_Activate'))
					WebUI.delay(25)
					WebUI.switchToDefaultContent();
					//Need to develop code to check the status

					println ("Activation completed ");
					WebUI.waitForElementPresent(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Office365Frame'), 20)
					WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Office365Frame'), 10)
					println ("Switched to the Office365Frame");
					WebUI.delay(25)	 // Need to build a code to wait untill the status become Ready
					println ("Value Found");
					break Loop
					println ("Break the Loop");
				}else {
					println ("Value not- Found");
					;
				}
			}
		}

		WebUI.switchToDefaultContent();
		println ("Switched to Default window");
		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Users_btn'), 20)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Users_btn'))

		WebUI.delay(8)
	}



	// ------------------------------------ code to handle the DropBox Scenarios


	@Keyword
	def Adding_DropBoxUserLicense(){

		println ("=================================   CCP_23_Self Care Admin role can assign services of DropBox Premium to the user ========================================================");

		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/HomePage_Validations/DropBoxProduct'), 10)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/HomePage_Validations/DropBoxProduct'))
		println ("DropBox is clicked");
		WebUI.delay(4)

		WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/DropBox_Validations/Dropbox_mainframe'), 10)
		println ("Frame Switched to Dropbox main page ");
		String  WindowTitle = WebUI.getWindowTitle();
		println ("Title of the window is : " +WindowTitle);

		WebUI.waitForElementPresent(findTestObject('Object Repository/CCP_Portal/DropBox_Validations/SpaceQuota'), 10)
		String Terabyte_Storage = WebUI.getText(findTestObject('Object Repository/CCP_Portal/DropBox_Validations/SpaceQuota'));
		println ("provide storage space per subscription is  : " +Terabyte_Storage);

		WebUI.waitForElementPresent(findTestObject('Object Repository/CCP_Portal/DropBox_Validations/License_Assigned_or_unassigned'), 10)
		String OverAll_License_Status = WebUI.getText(findTestObject('Object Repository/CCP_Portal/DropBox_Validations/License_Assigned_or_unassigned'));
		println ("Over all Assigned and un-assigned License are  : " +OverAll_License_Status);

		WebUI.switchToDefaultContent();
		println ("Switched to main page focus");

		WebUI.waitForElementPresent(findTestObject('Object Repository/CCP_Portal/DropBox_Validations/Account_btn'), 10)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/DropBox_Validations/Account_btn'))
		println ("Clicked on Account button");

		WebUI.delay(3)
		WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Frame_AddUsers'), 20)
		println ("FrameSwitched to Account page");
		println ("All User Related details and logs has been displayed");

		WebUI.switchToDefaultContent();
		println ("Switched to main page focus");

		// Navigate to Users page
		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Users_btn'), 20)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Users_btn'))
		println ("Clicked on User link")
		WebUI.delay(3);

		WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Frame_AddUsers'), 20)
		println ("FrameSwitched to User page");

		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Userpage_FilterIcon'), 20)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Userpage_FilterIcon'))
		println ("User's Filter option clicked and table formate is displayed");

		// Adding New User
		WebUI.delay(3)
		WebUI.waitForElementPresent(findTestObject('Object Repository/CCP_Portal/DropBox_Validations/add_new__users'), 10)

		WebUI.click(findTestObject('Object Repository/CCP_Portal/DropBox_Validations/add_new__users'))
		println ("Clicked on add new user button");
		println ("Page navigated to Add New Users page");
		WebUI.delay(4)
		println WebUI.getWindowTitle();
		WebUI.switchToDefaultContent();
		println ("Switched to main page")
		WebUI.delay(4)

		Random GenerateRandomNume = new Random();
		int RandNo = GenerateRandomNume.nextInt(10000);
		println ("Number is " + RandNo);
		WebUI.delay(3)

		WebUI.switchToFrame(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Frame_AddUsers'), 20)
		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/FirstName'), 0)
		WebUI.sendKeys(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/FirstName'), "James"+RandNo)
		WebUI.sendKeys(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/LastName'), "Camaron"+RandNo)

		WebUI.sendKeys(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Email'), "madhusekhar100"+RandNo+"@gmail.com")  // Need to provide random text here
		WebUI.switchToDefaultContent();
		println ("Switched to main page")

		WebUI.waitForElementClickable(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Next'), 10)
		WebUI.scrollToElement(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Next'), 10)
		WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Next'))

		WebUI.delay(3);

		WebUI.switchToDefaultContent();
		println ("Switched to main page")

		WebUI.click(findTestObject('Object Repository/CCP_Portal/MicrosoftO365_Validations/Next'))
		WebUI.delay(5);
		println ("successfully New User Added to the Group");
		WebUI.delay(30)
		println ("Waiting untill user status turns to Not Active");
		WebUI.delay(30)
		// To check whether user got added into the group

		WebUI.delay(3);




		println ("======================================================== CCP 23 Validation completes ==========================================================");


	}
}
