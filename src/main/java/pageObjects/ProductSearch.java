package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;

public class ProductSearch extends BaseClass {
	
	
	    @FindBy(xpath = "//input[@type='text']")
	    private WebElement searchBox;

	    @FindBy(xpath = "(//span[@class='input-group-btn'])[1]")
	    private WebElement searchButton;
	    
	    
	    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criteria.')]") private WebElement invalidSearchMessage;
	    
	    public ProductSearch(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }

	    public void searchProduct(String productName) {
	        searchBox.clear();
	        searchBox.sendKeys(productName);
	        searchButton.click();
	    }
	    
	    
	    
	    public String getInvalidSearchMessage() {
			return invalidSearchMessage.getText();
		}
	    
	    
}
