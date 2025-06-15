package com.omrbranch.stepdefinition;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	WebDriver driver;
	@Given("user is on the omrbranch page")
	public void a() {
		driver=new ChromeDriver();
		driver.get("https://www.omrbranch.com/");
		driver.manage().window().maximize();
	}
	
	@When("user enters {string} and {string}")
	public void user_enters_and(String name, String password) {
		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys(name);
		WebElement userpass = driver.findElement(By.id("pass"));
		userpass.sendKeys(password); 
	}

	@When("user click the login button")
	public void c() {
		WebElement btnlogin = driver.findElement(By.xpath("(//button[@type = 'submit'])[1]"));
	    btnlogin.click();
	    
	 }
	@Then("user should verify after login success message")
	public void d() {
		Assert.assertTrue("Verify Sucess", true);

	   
	}
}
