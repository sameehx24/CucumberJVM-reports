package org.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	 public static WebDriver driver;
   	public static Navigation n;
     public static Select s;

	// 1
	public static void browserLaunch() {
		driver = new ChromeDriver();
	}

	// 2
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// 3
	public static void urlLaunch(String url) {
		driver.get(url);
	}

	// 4
	public static void getTheTitle() {
		System.out.println(driver.getTitle());
	}

	// 5
	public static void pageSource() {
		System.out.print(driver.getPageSource());
	}

	// 6
	public static void getTheCurrentURL() {
		System.out.println(driver.getCurrentUrl());
	}

	// 7
	public static void getWindowID() {
		String parentWindowID = driver.getWindowHandle();
		System.out.println(parentWindowID);
	}

	// 8
	public static void getChildWindowID() {
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
	}

	// 9
	public static void clickHRM() {
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
	}

	// 10
	public static void getTakeScreenShot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File(
				"/Users/sameeh/eclipse/selenium/selenium-maven-base-class/Screenshot/" + fileName + ".png");
		FileUtils.copyFile(temp, perm);

	}

	// 11
	public static void alertOk() {
		driver.switchTo().alert().accept();
	}

	// 12
	public static void alertNotOk() {
		driver.switchTo().alert().dismiss();
	}

	// 13
	public static void alertPrint() {
		String message = driver.switchTo().alert().getText();
		System.out.println(message);
	}

	// 14
	public static void alertSendMessage() {
		String s = "Im not robot";
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(s);
		alert.accept();
	}

	// 15
	public static void closeBrowser() {
		driver.close();
	}

	// 16
	public static void quitBrowser() {
		driver.quit();
	}

	// 17
	public static void isItVisible() {
		WebElement button = driver.findElement(By.id("login"));

		if (button.isDisplayed()) {
			System.out.println("Button is enabled");
		} else {
			System.out.println("Button is disabled");
		}
	}

	// 18
	public static void isItTypeable() {
		WebElement button = driver.findElement(By.id("login"));

		if (button.isEnabled()) {
			System.out.println("Button is enabled");
		} else {
			System.out.println("Button is disabled");
		}
	}

	// 19
	public static void isSelected() {
		WebElement button = driver.findElement(By.id("login"));

		if (button.isSelected()) {
			System.out.println("Button is enabled");
		} else {
			System.out.println("Button is disabled");
		}
	}

	// 20
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	// 21
	public static void navigateForward() {
		driver.navigate().forward();
	}

	// 22
	public static void navigateBack() {
		driver.navigate().back();
	}

	// 23
	public static void refresh() {
		driver.navigate().refresh();
	}

	// 24
	public static void switchToAnotherFrame(String id) {
		driver.switchTo().frame(id);

	}

	// 25
	public static void switchToMainFrame(String id) {
		driver.switchTo().frame(id);

	}

	// 26
	public static void switchToPreviousFrame() {
		driver.switchTo().defaultContent();

	}

	// 27
	public static void selectOptionByVisibleText() {
		s.selectByVisibleText(null);
	}

	// 28

	public static void selectOptionByValue() {
		s.selectByValue(null);
	}

	// 29
	public static void selectOptionByIndex() {
		s.selectByIndex(0);
	}

	// 30
	public static void isTheDropDownMultiple() {
		System.out.print(s.isMultiple());
	}

	// 31
	public static void isTheDropDownNotMultiple() {
		System.out.print(!s.isMultiple());
	}

	// 32
	public static void getAllOptions() {
		List<WebElement> options = s.getOptions();
		System.out.println(options);
	}

	// 33
	public static void getAllSelectedOptions() {
		List<WebElement> options = s.getAllSelectedOptions();
		System.out.println(options);
	}

	// 34
	public static void getFirstSelectedOption() {
		WebElement options = s.getFirstSelectedOption();
		System.out.println(options);
	}

	// 35
	public static void deselectwithIndex() {
		s.deselectByIndex(0);
	}

	// 36
	public static void deselectwithText() {
		s.deselectByVisibleText(null);
	}

	// 37
	public static void deselectwithValue() {
		s.deselectByValue(null);
	}

	// 38

	public static void deselectAll() {
		s.deselectAll();
	}

	// 39

	public static void forcewait(int i) throws InterruptedException {
		Thread.sleep(i);
	}

	// 40
	public static void conditionalWait(int i) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
	}

	public static String getData(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("/Users/sameeh/eclipse/selenium/testNG-demo/Excel/employee_details_10.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fin);
		Sheet sh = book.getSheet(sheetName);
		Row r = sh.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int type = c.getCellType().getCode();

		String name;

		if (type == 1) {
			name = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
			name = sim.format(d);
		} else {
			double da = c.getNumericCellValue();
			long l = (long) da;
			name = String.valueOf(l);

		}
		return name;

	}

	
	
}