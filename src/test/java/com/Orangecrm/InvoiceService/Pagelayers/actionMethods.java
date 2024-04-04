package com.Orangecrm.InvoiceService.Pagelayers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class actionMethods {

	
	
	public static void EntervaluestoTextBox ( WebElement inputbox,String Mengevalue)
	{
		inputbox.clear();
		inputbox.sendKeys(Mengevalue);
	}
	
	
	 public static WebElement waitmethod(WebDriver driver,String xpath) {
		   WebDriverWait wt = new WebDriverWait(driver,10);
		   WebElement Element = driver.findElement(By.xpath(xpath));
			wt.until(ExpectedConditions.elementToBeClickable (Element));
		   
		return Element;
		   
	   }
	 
	 public static void clicktheobjects(WebDriver driver, String elementxpath) {
			WebDriverWait wt = new WebDriverWait(driver,10);
			WebElement Element = driver.findElement(By.xpath(elementxpath));
			wt.until(ExpectedConditions.elementToBeClickable (Element));
			Element.click();
		}
}
