package com.flipkart.Flipkart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MakemyTrip extends BaseClass {
	static int size;

	@Test
	public void makemytrip() throws Exception {
		/*
		 * List<String> l = new ArrayList<String>(); List<String> l1 = new
		 * ArrayList<String>(); List<String> l2 = new ArrayList<String>(); List<String>
		 * l3 = new ArrayList<String>();
		 * 
		 * String actualasc = null; String actualdec = null;
		 */
		browserLaunch("chrome", "https://www.makemytrip.com/");
		Actions ac = new Actions(driver);
		clickOnElement(driver.findElement(By.xpath("//*[text()='Multi City']")));
		clickOnElement(driver.findElement(By.id("fromAnotherCity0")));
		sendValuesToAelement(driver.findElement(By.xpath("//input[@placeholder='From']")), "chennai,india");
		Thread.sleep(2000);
		ac.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		sendValuesToAelement(driver.findElement(By.xpath("//input[@placeholder='To']")), "mumbai,ind");
		Thread.sleep(3000);
		ac.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='DayPicker-Month'][2]/div[3]"));
		for (WebElement x : findElements) {
			List<WebElement> findElements2 = x.findElements(By.tagName("p"));
			for (WebElement y : findElements2) {
				String text = y.getText();
				if (text.equals("20")) {
					y.click();
					break;
			}
		
			}
		}
		Thread.sleep(1000);
		clickOnElement(driver.findElement(By.id("toAnotherCity1")));
		sendValuesToAelement(driver.findElement(By.xpath("//*[@placeholder='To']")), "chennai,ind");
		Thread.sleep(2000);
		ac.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@aria-label='Next Month']")).click();
		Thread.sleep(1000);
		List<WebElement> findElements2 = driver.findElements(By.xpath("//div[@class='DayPicker-Month'][2]/div[3]//p"));
		int size2 = findElements2.size();
		System.out.println(size2);
		for (WebElement z : findElements2) {
			if (z.getText().equals("12")) {
				z.click();
				break;
			}
		}
		Thread.sleep(2000);
		clickOnElement(driver.findElement(By.xpath("//*[text()='Search']")));
		ac.sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(2000);

		List<WebElement> findElements3 = driver.findElements(By.xpath("//div[@class='splitVw-sctn pull-left']/div/div"));
		for (WebElement x : findElements3) {
			List<WebElement> findElements4 = x.findElements(By.xpath("//span[contains(@class,'actual')]"));
			for (WebElement y : findElements4) {
				System.out.println(y.getText());
				break;
		}	}
		/*
		 * List<WebElement> li =
		 * driver.findElements(By.xpath("//span[@class='actual-price']")); System.out.
		 * println("*************************************price low to high**************************************************"
		 * ); for (WebElement x : li) { actualasc = x.getText(); l.add(actualasc);
		 * 
		 * } System.out.println(l);
		 * 
		 * System.out.println(
		 * "*************************************validation**********************************************************"
		 * ); for (WebElement expasc : li) { String exp2 = expasc.getText();
		 * l1.add(exp2); } Collections.sort(l1); System.out.println(l1);
		 * 
		 * System.out.
		 * println("in ascending order both actual and expected are equal                                "
		 * + l.equals(l1));
		 * 
		 * mouseHoverMoveToAnElement(driver.findElement(By.xpath(
		 * "(//span[text()='Price'])[2]")));
		 * clickOnElement(driver.findElement(By.xpath("(//span[text()='Price'])[2]")));
		 * System.out.
		 * println("****************************price high to low************************************************************"
		 * ); List<WebElement> li1 =
		 * driver.findElements(By.xpath("//span[@class='actual-price']")); for
		 * (WebElement dec : li1) { actualdec = dec.getText(); l2.add(actualdec); }
		 * System.out.println(l2); System.out.
		 * println("********************************descending validation******************************************************"
		 * ); for (WebElement exp3 : li1) { String exp4 = exp3.getText(); l3.add(exp4);
		 * } Collections.sort(l3, Collections.reverseOrder()); System.out.println(l3);
		 * 
		 * System.out.
		 * println("in decending order both actual and expected order are equals                    "
		 * + l2.equals(l3));
		 */
//		  navigationOption("https://www.makemytrip.com/");

		/*
		 * clickOnElement(driver.findElement(By.xpath("//*[text()='Multi City']")));
		 * clickOnElement(driver.findElement(By.id("fromAnotherCity0")));
		 * sendValuesToAelement(driver.findElement(By.xpath(
		 * "//input[@placeholder='From']")), "chennai,ind"); Thread.sleep(2000);
		 * ac.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		 * sendValuesToAelement(driver.findElement(By.xpath("//input[@placeholder='To']"
		 * )), "mumbai,ind"); Thread.sleep(3000);
		 * ac.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		 * clickOnElement(driver.findElement(By.xpath("(//p[text()='14'])[1]")));
		 * clickOnElement(driver.findElement(By.xpath("(//*[@id='toAnotherCity1'])[1]"))
		 * );
		 * sendValuesToAelement(driver.findElement(By.xpath("//*[@placeholder='To']")),
		 * "chennai"); Thread.sleep(2000);
		 * ac.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		 * Thread.sleep(2000);
		 * clickOnElement(driver.findElement(By.xpath("(//p[text()='21'])[1]")));
		 * clickOnElement(driver.findElement(By.xpath("//*[text()='Search']")));
		 * 
		 * 
		 * List<WebElement> findElements =
		 * driver.findElements(By.xpath("//span[@class='actual-price']")); for
		 * (WebElement yy : findElements) { l.add(yy.getText());
		 * //System.out.println(yy.getText()); //System.out.println("After"); size =
		 * l.size();
		 * 
		 * if(size>2) { String lastvalue = l.get(size-1); String substring =
		 * lastvalue.substring(2); String string= substring.replace(",", ""); int value
		 * = Integer.parseInt(string);
		 * 
		 * String beforeLast = l.get(size-2); String substring2 =
		 * beforeLast.substring(2); String string1=substring2.replace(",", ""); int
		 * beforeValue = Integer.parseInt(string1); if(value>=beforeValue) {
		 * System.out.println(l.get(size-1)); }else {
		 * System.out.println("hereAfter price value is decreased"); break; } } else {
		 * System.out.println(l.get(size-1));
		 */
	}

}
