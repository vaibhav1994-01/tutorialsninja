package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;

public class Iphone extends BaseClass {

	
		@FindBy (xpath="//a[text()='iPhone']") private WebElement iphoneLink;
		
		 public Iphone(WebDriver driver) {
		        PageFactory.initElements(driver, this);
		
		
		 }

	 
		 public String validateIphone() {
			return iphoneLink.getText();
		 }
}
