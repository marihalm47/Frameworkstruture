package utilities;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import io.qameta.allure.Allure;
import page_objects.ClassPageObject;
import webdriver_manager.DriverManager;

public class common_utils {

	public void loadproperties() {

		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		Constants.APP_URL = properties.getProperty("APP_URL");
		Constants.BROWSER = properties.getProperty("BROWSER");
		Constants.USERNAME = properties.getProperty("USERNAME");
		Constants.PASSWORD = properties.getProperty("PASSWORD");
		Constants.REG_URL = properties.getProperty("REG_URL");
		Constants.SIGNIN_URL = properties.getProperty("SIGNIN_URL");
		Constants.HOME_URL = properties.getProperty("HOME_URL");
		Constants.EXCEL_PATH = properties.getProperty("EXCEL_PATH");
		// queue page
		Constants.SIGNIN_URL = properties.getProperty("SIGNIN_URL");
		Constants.HOMEPAGEURL = properties.getProperty("HOMEPAGEURL");
		Constants.EDITORURL = properties.getProperty("EDITORURL");
		Constants.QUEUEPAGEURL = properties.getProperty("QUEUEPAGEURL");
		Constants.QUEUEOPRATIONLINK = properties.getProperty("QUEUEOPRATIONLINK");

		// graph page
		Constants.GRAPHPAGEURL = properties.getProperty("GRAPHPAGEURL");
		Constants.GRAPHEDITORURL = properties.getProperty("GRAPHEDITORURL");
		Constants.GRAPHOPRATIONLINK = properties.getProperty("GRAPHOPRATIONLINK");

		// stack page
		Constants.STACKPAGE_URL = properties.getProperty("STACKPAGE_URL");
		Constants.OPERATIONSINSTACK_URL = properties.getProperty("OPERATIONSINSTACK_URL");
		Constants.IMPLEMENTATION_URL = properties.getProperty("IMPLEMENTATION_URL");
		Constants.APPLICATIONS_URL = properties.getProperty("APPLICATIONS_URL");
		Constants.PRACTICEQUESTIONS_URL = properties.getProperty("PRACTICEQUESTIONS_URL");
		Constants.TRYEDITOR_URL = properties.getProperty("TRYEDITOR_URL");
		Constants.Timecomplexitypage = properties.getProperty("Timecomplexitypage");

	}

	// All the page class has to be initialized in this method
	public void initWebElements() {
		PageFactory.initElements(DriverManager.getDriver(), ClassPageObject.getInstance());
	}

	public ArrayList<ArrayList<String>> readExcelData() {
		ArrayList<ArrayList<String>> arrLL = new ArrayList<ArrayList<String>>();

		File f = new File(this.getClass().getResource("/TestCaseData.xlsx").getFile());
		System.out.println(f.getAbsoluteFile());

		// Inputstream - we have our actual data
		FileInputStream fis;

		// Property created for excel workbook & sheet
		XSSFWorkbook excelWorkbook;
		XSSFSheet excelSheet;
		try {
			fis = new FileInputStream(f);
			excelWorkbook = new XSSFWorkbook(fis);
			excelSheet = excelWorkbook.getSheetAt(0);
			int rows = excelSheet.getPhysicalNumberOfRows();
			int cols = excelSheet.getRow(0).getPhysicalNumberOfCells();
			String data[][] = new String[rows][cols];
			XSSFCell cell;
			for (int i = 0; i < rows; i++) {
				arrLL.add(new ArrayList<String>());
				for (int j = 0; j < cols; j++) {
					cell = excelSheet.getRow(i).getCell(j);
					String cellContents = cell.getStringCellValue();
					data[i][j] = cellContents;
					// System.out.print(" " + data[i][j]);
					arrLL.get(i).add(j, cellContents);
				}
				// System.out.println();
			}
			// System.out.println(arrLL);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrLL;
	}
	
	public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		
		Allure.attachment("Myscreenshot",new ByteArrayInputStream(((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES)));

		}
	
	
}
