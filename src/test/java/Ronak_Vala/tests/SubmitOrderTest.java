package Ronak_Vala.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ronak_Vala.TestComponents.BaseTest;
import Ronak_Vala.pageobjects.CartPage;
import Ronak_Vala.pageobjects.CheckoutPage;
import Ronak_Vala.pageobjects.ConfirmationPage;
import Ronak_Vala.pageobjects.LandingPage;
import Ronak_Vala.pageobjects.OrderPage;
import Ronak_Vala.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class SubmitOrderTest extends BaseTest{
		String ProductName = "IPHONE 13 PRO";
		@Test(dataProvider="getData",groups= {"Purchase"})
		public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "D:\\A\\chromedriver.exe");
		ProductCatalogue productCatalogue = landingPage.LoginApp(input.get("email"),input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("ProductName"));	
		CartPage cartPage = productCatalogue.goToCartPage();
	
		Boolean moment = cartPage.VerifyProductDisplay(input.get("ProductName"));
		Assert.assertTrue(moment);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMsg = confirmationPage.getConfirmationMsg();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
		@Test(dependsOnMethods= {"SubmitOrder"})
		public void OrderHistoryTest() {
			ProductCatalogue productCatalogue = landingPage.LoginApp("ronakv@gmail.com", "Wwe@1234");
			OrderPage ordersPage = productCatalogue.goToOrdersPage();
			Assert.assertTrue(ordersPage.VerifyOrderDisplay(ProductName));
		}	
		
		
		@DataProvider
		public Object[][] getData() throws IOException{
			/*HashMap<String,String> map = new HashMap<String,String>();
			map.put("email", "ronakv@gmail.com");
			map.put("password", "Wwe@1234");
			map.put("ProductName", "IPHONE 13 PRO");
			
			HashMap<String,String> map1 = new HashMap<String,String>();
			map1.put("email", "anshika@gmail.com");
			map1.put("password", "Iamking@000");
			map1.put("ProductName", "ZARA COAT 3");*/
			List<HashMap<String,String>> data = getJsonDataToMap("C://Users//ronak//OneDrive//Desktop//Software testing excelr course material, assignments,etc//java practice//SeleniumFramework//src//test//java//Ronak_Vala//data//PurchaseOrder.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
		}
}
