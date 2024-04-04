package com.Orangecrm.InvoiceService.Pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class LoginPagePagelayer {
	
public static String title;
WebDriver driver;
public String elementxpath;

public LoginPagePagelayer(Base.Baseclass drivermanager) {

	this.driver = drivermanager.driver;

}



	public static String getthetitle(WebDriver driver) {
		title = driver.getTitle();
		return title;
	}
	public static void Logintoapplication(String id, String pwd,WebDriver driver) {
		By username = By.xpath("//input[@name='username']");
		WebElement user= driver.findElement(username);
		actionMethods.EntervaluestoTextBox(user,id);
		
		By password = By.xpath("//input[@name='password']");
		WebElement passwordelement= driver.findElement(password);
		actionMethods.EntervaluestoTextBox(passwordelement,pwd);
		
		String submit ="//button[@type='submit']";
		//WebElement Submitelement= driver.findElement(submit);
		
		actionMethods.clicktheobjects(driver, submit);
	}
	
	

}
