package utilities;
import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Genericutils {

	    /* ---------------- WAIT UTILITIES ---------------- */

	    public static WebElement waitForElementPresence(
	            WebDriver driver, By locator, int timeout) {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    }

	    public static void waitForVisibility(
	            WebDriver driver, WebElement element, int timeout) {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public static void waitForClickability(
	            WebDriver driver, WebElement element, int timeout) {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    /* ---------------- RANDOM DATA GENERATORS ---------------- */

	    public static String randomString() {
	        return RandomStringUtils.randomAlphabetic(5);
	    }

	    public static String randomNumber() {
	        return RandomStringUtils.randomNumeric(10);
	    }

	    public static String randomAlphaNumeric() {
	        return RandomStringUtils.randomAlphabetic(4)
	                + RandomStringUtils.randomNumeric(3);
	    }

	    /* ---------------- SCREENSHOT ---------------- */

	    public static String captureScreenshot(WebDriver driver, String testName) {

	        TakesScreenshot ts = (TakesScreenshot) driver;
	        String screenshotBase64 = ts.getScreenshotAs(OutputType.BASE64);

	        return "data:image/png;base64," + screenshotBase64;
	    }
}
