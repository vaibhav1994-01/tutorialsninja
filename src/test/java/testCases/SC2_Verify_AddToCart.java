package testCases;

import org.testng.annotations.*;

import base.BaseClass1;
import pageObjects.AddToCart;

public class SC2_Verify_AddToCart extends BaseClass1 {
	
	AddToCart add; //Creating object of AddToCart class so that we can access in all test cases
	
	@BeforeMethod 
	public void setup() { 
		SetUp();
		LaunchURL();
		add = new AddToCart(driver);
	}
	
	@Test
	public void TC4_ClickOn_AddToCart() throws InterruptedException{
		add.click_iPhone();
		add.click_AddToCart();
		Thread.sleep(2000);
		}
	@Test
	public void TC5_VerifyProductDisplayed_InShoppingCart() throws InterruptedException{
		add.click_iPhone();
		add.click_AddToCart();
		Thread.sleep(2000);
		add.click_ShoppingCart();
		Thread.sleep(2000);}
	@Test
	public void TC6_EnterValidQuantity() throws InterruptedException{ //in quantity input box
		add.click_iPhone();
		add.clear_QtyInputBox();
		add.input_Quantity();
		add.click_AddToCart();
		Thread.sleep(2000);
		add.click_ShoppingCart();
		Thread.sleep(2000);
	}
	@Test
	public void TC7_EnterInvalidQuantity() throws InterruptedException{ //in quantity input box
		add.click_iPhone();
		add.clear_QtyInputBox();
		add.input_InvalidQuantity();
		add.click_AddToCart();
		Thread.sleep(2000);
		add.click_ShoppingCart();
		Thread.sleep(2000);
		}
	
	@AfterMethod
	public void tearDownMethod() {
		tearDown();
	}
	
	
}
