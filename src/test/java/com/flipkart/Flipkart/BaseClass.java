package com.flipkart.Flipkart;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver browserLaunch(String browserName, String url) throws Exception {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//driver//chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			throw new Exception("Invalid browserName");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return driver;
	}

	public static void explicitVisibilityOfAElement(WebElement element) {
		WebDriverWait wb = new WebDriverWait(driver, 50);
		wb.until(ExpectedConditions.visibilityOf(element));
	}

	public static String getTextOfAElement(WebElement element) {
		explicitVisibilityOfAElement(element);
		String text = element.getText();
		return text;
	}

	public static String getAttributeOfAelement(WebElement element, String value) {
		explicitVisibilityOfAElement(element);
		String attribute = element.getAttribute(value);
		return attribute;

	}

	public static boolean elementisdisplayed(WebElement element) {
		explicitVisibilityOfAElement(element);
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public static boolean elementIsEnabled(WebElement element) {
		explicitVisibilityOfAElement(element);
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public static void clickOnElement(WebElement element) {
		explicitVisibilityOfAElement(element);
		if (elementisdisplayed(element))
			element.click();
	}

	public static void clearValuesInAElement(WebElement element) {
		explicitVisibilityOfAElement(element);
		element.clear();
	}

	public static void sendValuesToAelement(WebElement element, String value) {
		explicitVisibilityOfAElement(element);
		if (elementisdisplayed(element)) {
			if (elementIsEnabled(element)) {
				element.clear();
				element.sendKeys(value);
			}

		}
	}

	public static void selectElementFromDropdown(WebElement element, String option, String value) throws Exception {
		explicitVisibilityOfAElement(element);
		Select se = new Select(element);
		if (option.equalsIgnoreCase("value")) {
			se.selectByValue(value);
		} else if (option.equalsIgnoreCase("visibletext")) {
			se.selectByVisibleText(value);
		} else if (option.equalsIgnoreCase("index")) {
			se.selectByIndex(Integer.parseInt(value));
		} else {
			throw new Exception("ElEMENT IS NOT SELECTABLE");
		}
	}

	public static void navigationOption(String option) throws Exception {
		if (option.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		} else if (option.equalsIgnoreCase("back")) {
			driver.navigate().back();
		} else if (option.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		} else if (option.contains("http")) {
			driver.navigate().to(option);
		} else {
			throw new Exception("Invalid Navigate option");
		}
	}

	public static void mouseHoverMoveToAnElement(WebElement element) {
		explicitVisibilityOfAElement(element);
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
	}

	public static void mouseHoverClickOnElement(WebElement element) {
		explicitVisibilityOfAElement(element);
		Actions ac = new Actions(driver);
		ac.moveToElement(element).click().build().perform();
	}

	public static void mouseHoverdoubleclickOnElement(WebElement element) {
		explicitVisibilityOfAElement(element);
		Actions ac = new Actions(driver);
		ac.moveToElement(element).doubleClick().build().perform();
	}

	public static void mouseHoverContextClick(WebElement element) {
		explicitVisibilityOfAElement(element);
		Actions ac = new Actions(driver);
		ac.moveToElement(element).contextClick().build().perform();
	}

	public static void scrollto(String x, String y) {
		((JavascriptExecutor) driver).executeScript("scroll(" + x + "," + y + ")");
	}

	public static void scrollToTopOrBottom(String option) throws Exception {

		if (option.equalsIgnoreCase("Top")) {
			((JavascriptExecutor) driver).executeScript("scroll(0,document.body.scrollHeight)");
		} else if (option.equalsIgnoreCase("bottom")) {
			((JavascriptExecutor) driver).executeScript("scroll(0,-document.body.scrollHeight)");
		} else {
			throw new Exception("invalid Scroll Option");
		}
	}

	public static void simpleAlerts(String options) throws Exception {

		if (options.equalsIgnoreCase("accept")) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			driver.switchTo().defaultContent();
		} else {
			throw new Exception("INVALID ALERT OPERATION");
		}
	}

	public static void confirmAlerts(String option) {

		if (option.contains("accept")) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			driver.switchTo().defaultContent();
		} else {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			driver.switchTo().defaultContent();
		}
	}

	public static void promptAlerts(String option, String value) {
		if (option.contains("accept")) {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(value);
			alert.accept();
			driver.switchTo().defaultContent();
		} else {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(value);
			alert.dismiss();
			driver.switchTo().defaultContent();
		}
	}

	public static void takeScreenShot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir") + "\\reports\\" + fileName + ".png");
		FileUtils.copyFile(screenshotAs, des);
	}

	public static void quit() {
		driver.quit();
	}

	public static String geturl() {
		 String currentUrl = driver.getCurrentUrl();
		 return currentUrl ;
		
	}
	
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
		
	}
}