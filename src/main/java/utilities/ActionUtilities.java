package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtilities {

		   WebDriver driver;

		    public ActionUtilities(WebDriver driver) {
		    	
		        this.driver = driver;
		    }
		    
		    //Hover over an element.
		   public void hoverOverElement(WebElement element) {
		        Actions actions = new Actions(driver);
		        actions.moveToElement(element).perform();
		    }

		    
		     //Right-click on an element.
		    public void rightClickOnElement(WebElement element) {
		        Actions actions = new Actions(driver);
		        actions.contextClick(element).perform();
		    }

		    //Double-click on an element.
		    public void doubleClickOnElement(WebElement element) {
		        Actions actions = new Actions(driver);
		        actions.doubleClick(element).perform();
		    }
		    
		    //Drag and drop an element from source to target.
		     public void dragAndDrop(WebElement source, WebElement target) {
		        Actions actions = new Actions(driver);
		        actions.dragAndDrop(source, target).perform();
		    }

		    //Click and hold an element.
		      public void clickAndHold(WebElement element) {
		        Actions actions = new Actions(driver);
		        actions.clickAndHold(element).perform();
		    }

		    //Release a clicked and held element.
		      public void releaseElement(WebElement element) {
		        Actions actions = new Actions(driver);
		        actions.release(element).perform();
		    }
}
