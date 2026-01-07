package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass1 {
	
	public static WebDriver driver;
	

	public void SetUp() { //Opening Browser, Setting Browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Opening browser");
	}
	
	public void LaunchURL() { //Launching URL
	driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		System.out.println("Launching URL");
	}
	
	public void tearDown() { //Closing Browser //Quitting Browser
	if(driver != null) {
		System.out.println("Closing Browser");
		driver.close();
	}
}
}
