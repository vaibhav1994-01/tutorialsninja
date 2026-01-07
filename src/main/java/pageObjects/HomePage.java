package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	 WebDriver driver;

	    /* ---------------- Web Elements ---------------- */

	    @FindBy(xpath = "//span[contains(text(),'My Account')]")
	    private WebElement linkMyAccount;

	    @FindBy(xpath = "//a[contains(text(),'Register')]")
	    private WebElement linkRegister;

	    @FindBy(xpath = "//a[contains(text(),'Login')]")
	    private WebElement linkLogin;

	    @FindBy(tagName = "a")
	    private List<WebElement> allLinks;

	    @FindBy(tagName = "img")
	    private List<WebElement> allImages;

	    @FindBy(linkText = "Desktops")
	    private WebElement desktopsMenu;

	    @FindBy(linkText = "Show AllDesktops")
	    private WebElement showAllDesktopsSubmenu;

	    @FindBy(name = "search")
	    private WebElement searchBox;

	    @FindBy(css = "button.btn.btn-default.btn-lg")
	    private WebElement searchButton;

	    /* ---------------- Constructor ---------------- */

	    public HomePage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    /* ---------------- Actions ---------------- */

	    public void clickMyAccount() {
	        linkMyAccount.click();
	    }

	    public void clickRegister() {
	        linkRegister.click();
	    }

	    public void clickLogin() {
	        linkLogin.click();
	    }

	    public void searchProduct(String productName) {
	        searchBox.clear();
	        searchBox.sendKeys(productName);
	        searchButton.click();
	    }

	    /* ---------------- Utilities ---------------- */

	    public List<WebElement> getAllLinksAndImages() {
	        List<WebElement> elements = new ArrayList<>();
	        elements.addAll(allLinks);
	        elements.addAll(allImages);
	        return elements;
	    }

	    // Filter only valid (active) links
	    public List<WebElement> getActiveLinks(List<WebElement> allElements) {
	        List<WebElement> activeLinks = new ArrayList<>();

	        for (WebElement element : allElements) {
	            try {
	                String href = element.getAttribute("href");
	                if (href != null && !href.trim().isEmpty() && !href.contains("javascript")) {
	                    activeLinks.add(element);
	                }
	            } catch (Exception e) {
	                System.out.println("Error processing element: " + element);
	            }
	        }
	        return activeLinks;
	    }

	    public WebElement getDesktopsMenu() {
	        return desktopsMenu;
	    }

	    public WebElement getShowAllDesktopsSubmenu() {
	        return showAllDesktopsSubmenu;
	    }

}
