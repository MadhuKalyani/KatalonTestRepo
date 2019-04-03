package excel

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
import internal.GlobalVariable as GlobalVariable
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import internal.GlobalVariable

public class Excel_Reader {

	@Keyword

	def DataReader_Excel(){
		String TestCaseName = GlobalVariable.currentTestCaseId
		println TestCaseName
		String[] Split_TC = TestCaseName.split('/')
		String TCname=Split_TC[2]
		println TCname
		String expectedDataTCName = TCname;

		// TODO Auto-generated method stub

		String UserDir = (System.getProperty('user.dir'))+"/TestData.xlsx";

		String FilePath = (UserDir);

		File srcsan = new File(FilePath);
		FileInputStream fisan = new FileInputStream(srcsan);
		XSSFWorkbook wbsan = new XSSFWorkbook(fisan);
		XSSFSheet sheetsan1 = wbsan.getSheet("TestData")  //get the data based on sheet name
		//XSSFSheet sheetsan1 = wbsan.getSheetAt(0); //index no can also be used
		println ("File found");

		DataFormatter dataFormatter = new DataFormatter();
		int totalRow = sheetsan1.getLastRowNum() + 1;
		println ("Number of Rows in excel sheet : " + totalRow)
		int totalColumn = sheetsan1.getRow(0).getLastCellNum();
		println ("Number of Columns in excel sheet : " + totalColumn)

		def arr = new String[totalColumn][2];
		int m = 0;
		int n = 0;
		for(int i = 0; i< totalRow; i++) {
			m++;
			for(int j =0; j< totalColumn; j++) {
				String cellVal =  sheetsan1.getRow(i).getCell(j).getStringCellValue();
				//arr[i][j] = cellVal;
				arr[j][0] = cellVal;
				println (cellVal);  // to print values of header
			}
			break;
		}

		for(int i =0; i< totalRow; i++) {
			String value = sheetsan1.getRow(i).getCell(0).getStringCellValue();
			if(value.equals(expectedDataTCName)) {
				for(int j = 0; j< totalColumn; j++) {
					String cellVal =  sheetsan1.getRow(i).getCell(j).getStringCellValue();
					//arr[m][j] = cellVal;
					arr[j][1] = cellVal;
					//println (cellVal);
				}
			}
		}

		System.out.println("-----------------------------------------------------------------------------------");

		/*for(String s : dataSheet) {
		 System.out.println(s + "  ");
		 }*/

		HashMap<String, String> TestDataValue =new HashMap<String,String>();
		for (int i=0;i<=totalColumn-1;i++) {
			TestDataValue.put(arr[i][0], arr[i][1]);
		}

		String abcd=TestDataValue.get("Email");
		System.out.println(abcd);
		GlobalVariable.dataReader2=TestDataValue
	}
}
