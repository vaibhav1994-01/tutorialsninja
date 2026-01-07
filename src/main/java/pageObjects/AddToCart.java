package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass1;

public class AddToCart extends BaseClass1 {
	@FindBy(linkText = "iPhone") public WebElement iphonelink;
	@FindBy(xpath = "(//button[@type='button'])[10]") public WebElement AddToCartbutton;
	@FindBy(xpath = "(//span)[6]") public WebElement ShoppingCartIcon;
	@FindBy(id = "input-quantity") public WebElement QtyInput;

	public AddToCart(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public void click_iPhone() {
		iphonelink.click();
		System.out.println("Clicking on the iPhone product on home page");
	}
	public void clear_QtyInputBox() {
		QtyInput.clear();
		System.out.println("Clear Qty input box on iphone page");
	}
	public void input_Quantity() {
		QtyInput.sendKeys("2");
		System.out.println("Entering 2 in Qty input box");
	}
	public void input_InvalidQuantity() {
		QtyInput.sendKeys("sagfef");
		System.out.println("Entering invalid quantity");
	}
	public void click_AddToCart() {
		AddToCartbutton.click();
		System.out.println("Clicking on the Add To Cart button on iPhone page");
	}
	public void click_ShoppingCart() {
		ShoppingCartIcon.click();
		System.out.println("Clicking on the Shopping Cart button on iPhone page");
	}

}
