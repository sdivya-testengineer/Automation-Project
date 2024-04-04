package com.invoiceservice.Testlayers;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Orangecrm.InvoiceService.Pagelayers.LoginPagePagelayer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginpageTest {
	WebDriver driver;
	String baseURL;
	// define the driver in the Construtor:
	public LoginpageTest(Base.Baseclass drivermanager) {

		this.driver = drivermanager.driver;
	
	}
	
@Given("I am on the Main page")
public void i_am_on_the_Main_page() {
   String title = LoginPagePagelayer.getthetitle(driver);
   System.out.println(title);
   Assert.assertTrue("The title is not matching", title.contains("OrangeHRM"));
}



@When("^I can enter the  (.*) and (.*)$")
public void i_can_enter_the_Admin_and_admin123(String id , String pwd) {
	
	
	LoginPagePagelayer.Logintoapplication(id,pwd,driver);
	
    
}

@Then("I have logged in successfully")
public void i_have_logged_in_successfully() {
   
}
}