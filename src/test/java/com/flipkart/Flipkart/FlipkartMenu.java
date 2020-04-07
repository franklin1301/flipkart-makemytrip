package com.flipkart.Flipkart;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class FlipkartMenu extends BaseClass {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the menu");
		String menu = s.nextLine();
		System.out.println("Enter the submenu");
		String submenu = s.nextLine();
		
		browserLaunch("chrome", "https://www.flipkart.com");
		
		clickOnElement(driver.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")));
		
		List<WebElement> findmenu = driver.findElements(By.tagName("span"));
		for (WebElement x : findmenu) {
			if (x.getText().equalsIgnoreCase(menu)) {
				mouseHoverMoveToAnElement(x);
			}}
		List<WebElement> sub = driver.findElements(By.tagName("a"));
		for (WebElement submenuuu : sub) {
			if (submenuuu.getAttribute("title").equalsIgnoreCase(submenu)) {
				clickOnElement(submenuuu);
			}}
			s.close();
			}}