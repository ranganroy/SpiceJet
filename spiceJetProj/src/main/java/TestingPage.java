package main.java;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingPage {
	
	WebDriver driver;
	
	public TestingPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")
	WebElement departureFlight;
	
	@FindBy(xpath = "//*[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79']")
	List <WebElement> selectReturnFL;
	
	@FindBy(xpath = "//div[contains(text(),('28'))]")
	WebElement departDate;
	
	@FindBy(xpath = "(//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'] ) [2]")
	WebElement clickAdult;
	
	@FindBy(xpath = "//div[@data-testid=\"Adult-testID-plus-one-cta\"]")
	WebElement selectAdult;
	
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[5]")
	WebElement assertAdults;
	
	public String getWeb (String title) {
		
		title = driver.getTitle();
		//System.out.println("Page title" + driver.getTitle());
	    return title;
	}
	
	public void getURL() {
		//driver.getCurrentUrl();
		System.out.println("Page url " + driver.getCurrentUrl());
	}
	
	public void clickDepartFl() {
		departureFlight.sendKeys("Kol");
	}
	
	public void returnFlight() {
		
		for (WebElement  retFlight : selectReturnFL) {
			if (retFlight.getText().equalsIgnoreCase("Ajmer")) {
				retFlight.click();
				break;
			}
		}
	}
	
	public void departDateClick () {
		
		departDate.click();
	}
	
	public void clickAdultPass() {
		clickAdult.click();
	}
	
	public void numOfAdults() {
		
		for(int i=1; i<6;i++) {
			selectAdult.click();
		}
	}
	
	public String verifyAdults(String Adults) {
		Adults= assertAdults.getText();
		return Adults;
	}
}
