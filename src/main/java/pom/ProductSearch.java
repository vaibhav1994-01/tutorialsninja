package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSearch {
	@FindBy(xpath = "//input[@type='text']" ) private WebElement searchBox; 
	
	@FindBy(xpath = "(//button[@type='button'])[4]") private WebElement searchButton; 
	
	
}
