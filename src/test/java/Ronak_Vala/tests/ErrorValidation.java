package Ronak_Vala.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Ronak_Vala.TestComponents.BaseTest;
import Ronak_Vala.pageobjects.CartPage;
import Ronak_Vala.pageobjects.CheckoutPage;
import Ronak_Vala.pageobjects.ConfirmationPage;
import Ronak_Vala.pageobjects.LandingPage;
import Ronak_Vala.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class ErrorValidation extends BaseTest{

		@Test(groups= {"ErrorHandling"})
		public void SubmitOrder() throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "D:\\A\\chromedriver.exe");
		String ProductName = "IPHONE 13 PRO";
		landingPage.LoginApp("ronakv@mail.com", "Wwe@1234");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMsg());
	}
}
