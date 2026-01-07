package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {


	    // ThreadLocal for parallel execution safety
	    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    // Getter for driver (used by Listeners & tests)
	    public static WebDriver getDriver() {
	        return driver.get();
	    }

	    @BeforeMethod
	    public void setUp() {

	        WebDriver wd = new ChromeDriver();
	        driver.set(wd);

	        getDriver().manage().window().maximize();
	        getDriver().manage().timeouts()
	                .implicitlyWait(Duration.ofSeconds(10));

	        System.out.println("Opening Browser");

	        getDriver().get(
	            "https://tutorialsninja.com/demo/index.php?route=common/home"
	        );
	        System.out.println("Launching URL");
	    }

	    @AfterMethod
	    public void tearDown() {

	        if (getDriver() != null) {
	            getDriver().quit();
	            driver.remove();
	        }

	        System.out.println("Closing Browser");
	    }
}
