package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]") public WebElement MyAccount;
	@FindBy(linkText = "Login") public WebElement Login;
	

public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void click_MyAccount() {
	MyAccount.click();
	System.out.println("Clicking on the My Account option on home page ");
}
public void click_Login() {
	Login.click();
	System.out.println("Clicking on Login option under My Account ");
}
}
