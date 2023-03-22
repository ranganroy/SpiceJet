package test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.TestingPage;

public class BookingFlight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://spicejet.com");
		driver.manage().window().maximize();
		
		TestingPage testingPage = new TestingPage(driver);
		//String title = new String (driver.getTitle());
		//testPage.getTitle();
		//WebElement title = testPage.getTitle();
		
		testingPage.getURL();
		
		//verifying page title
		String title1 = testingPage.getWeb("title");
					
		String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		if(title1.equals(expectedTitle)) {
			System.out.println("Assertion Passed - Title");				
			} else {
				
				System.out.println("Assertion Failed - Title");
			
		}
		
		//click on departing flight
		testingPage.clickDepartFl();
		//selecting returning flight
		testingPage.returnFlight();
		//selecting departing date
		testingPage.departDateClick();
		//clicking on num of adult 
		testingPage.clickAdultPass();
		testingPage.numOfAdults();
		//validating number of adults selected
		String numAd = testingPage.verifyAdults("Adults");
		
		Assert.assertEquals(numAd, "6 Adults");
		
		

	}

}
