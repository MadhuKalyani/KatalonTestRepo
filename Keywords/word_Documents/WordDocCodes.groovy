package word_Documents

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
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils
import org.apache.poi.*;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.OutputType;
import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.coordinates.*
import ru.yandex.qatools.ashot.cropper.*


import internal.GlobalVariable

public class WordDocCodes{

	@Keyword

	public String getLatestFilefromDir(String path){

		File dir = new File(path);
		File[] files = dir.listFiles();
		Arrays.sort(files, new Comparator<File>() {
					public int compare(File f1, File f2) {
						return Long.valueOf(f2.lastModified()).compareTo(
								f1.lastModified());
					}
				});
		String tempfoldername=files[0].getName();
		return tempfoldername;
	}

	@Keyword
	public void createNewFolder(){
		String UserDir = (System.getProperty('user.dir'))+"/Screenshots/";
		String FilePath = (UserDir);
		println (FilePath);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmmss");
		LocalDateTime now = LocalDateTime.now();
		String Todaydate =  dtf.format(now);
		//println ("Today date " + Todaydate);

		String Foldername = Todaydate.format(Todaydate)
		println ("Folder name is : " +Foldername);
		File file = new File(FilePath+Foldername);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	@Keyword
	public void genericNewWordDocCreate() throws IOException{

		String TestCaseName = GlobalVariable.currentTestCaseId
		println TestCaseName
		String[] Split_TC = TestCaseName.split('/')
		String TCname=Split_TC[2]
		println TCname

		String UserDir = (System.getProperty('user.dir'))+"/Screenshots/";
		String FilePath = (UserDir);
		println (FilePath);

		String newFolderPath=getLatestFilefromDir(FilePath);
		XWPFDocument document = new XWPFDocument();
		FileOutputStream out = new FileOutputStream( new File(FilePath+newFolderPath+"\\"+TCname+".docx"));
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		run.setText("");
		document.write(out);
		out.close();
		//document.close();
	}

	@Keyword

	public void genericWordDocUpdateCommentsandScreenshots() throws IOException, InvalidFormatException{

		String TestCaseName = GlobalVariable.currentTestCaseId
		println TestCaseName
		String[] Split_TC = TestCaseName.split('/')
		String TCname=Split_TC[2]
		println TCname

		String UserDir = (System.getProperty('user.dir'))+"/Screenshots/";
		String FilePath = (UserDir);
		println (FilePath);

		String newFolderPath=getLatestFilefromDir(FilePath);
		WebDriver driver;

		XWPFDocument docx = new XWPFDocument( new FileInputStream(FilePath+newFolderPath+"\\"+TCname+".docx"));
		List<XWPFParagraph>  paragraphs = docx.getParagraphs();
		XWPFParagraph paragraph =  paragraphs.get(paragraphs.size()-1);

		try {
			XWPFRun run = docx.createParagraph().createRun();
			FileOutputStream out = new FileOutputStream(FilePath+newFolderPath+"\\"+TCname+".docx");

			captureScreenShot(docx, run, out);
			TimeUnit.SECONDS.sleep(1);
			run.addBreak(BreakType.PAGE);

			XWPFRun runText = paragraph.createRun();
			runText.setText("Test case name : " +TCname);
			runText.addBreak();
			//runText.setText("Test method : " +method);
			runText.addBreak();

			docx.write(out);
			out.flush();
			out.close();
			//docx.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@Keyword
	public static void captureScreenShot(XWPFDocument docx, XWPFRun run, FileOutputStream out) throws Exception {

		String UserDir2 = (System.getProperty('user.dir'))+"/Images/";
		String imagesfilepath = (UserDir2);
		println (imagesfilepath);

		String screenshot_name = System.currentTimeMillis() + ".png";
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

		File file = new File(imagesfilepath+"temp.png");
		ImageIO.write(image, "png", file);
		InputStream pic = new FileInputStream(file);
		run.addBreak();
		run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, screenshot_name, Units.toEMU(500), Units.toEMU(450));
		run.addBreak();
		pic.close();
		//file.delete();
	}

}
