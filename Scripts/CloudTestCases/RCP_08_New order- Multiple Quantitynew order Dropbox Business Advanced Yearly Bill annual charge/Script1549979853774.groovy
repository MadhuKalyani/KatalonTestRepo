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

WebUI.comment(">>> currentTestCaseId=$GlobalVariable.currentTestCaseId")

CustomKeywords.'word_Documents.WordDocCodes.createNewFolder'()

CustomKeywords.'word_Documents.WordDocCodes.genericNewWordDocCreate'()

CustomKeywords.'excel.Excel_Reader.DataReader_Excel'()

HashMap<String, String> TestDataValue = GlobalVariable.dataReader2

CustomKeywords.'_PEVAS_Functionality.PEVAS_Login.PevasLogin'()

CustomKeywords.'word_Documents.WordDocCodes.genericWordDocUpdateCommentsandScreenshots'()

CustomKeywords.'_PEVAS_Functionality.Customer_Creation.CustomerCreation'(TestDataValue)

CustomKeywords.'word_Documents.WordDocCodes.genericWordDocUpdateCommentsandScreenshots'()

CustomKeywords.'_RCP_Functionality.RCPLogin.RCP_Login'()

CustomKeywords.'word_Documents.WordDocCodes.genericWordDocUpdateCommentsandScreenshots'()

CustomKeywords.'_RCP_Functionality.SearchCustomer.Searchcustomer'()

CustomKeywords.'word_Documents.WordDocCodes.genericWordDocUpdateCommentsandScreenshots'()

CustomKeywords.'_RCP_Functionality.Adding_Products.Add_Products'(TestDataValue)

CustomKeywords.'word_Documents.WordDocCodes.genericWordDocUpdateCommentsandScreenshots'()

CustomKeywords.'_RCP_Functionality.Adding_Products.Additional_Resources'(TestDataValue)

CustomKeywords.'word_Documents.WordDocCodes.genericWordDocUpdateCommentsandScreenshots'()

CustomKeywords.'_RCP_Functionality.Adding_Products.Price_Validations'(TestDataValue)

CustomKeywords.'word_Documents.WordDocCodes.genericWordDocUpdateCommentsandScreenshots'()

CustomKeywords.'_RCP_Functionality.Refresh_Complete.RefreshOrder_Provide'()

CustomKeywords.'word_Documents.WordDocCodes.genericWordDocUpdateCommentsandScreenshots'()


