package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
public static WebDriver driver; //Declaring instance variable to use anywhere in project.
	
	public void SetUp() { //Opening Browser, Setting Browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Opening Browser");
	}
	
	public void LaunchURL() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		System.out.println("Launching URL");
	}
	
	public void tearDown() { //Closing Browser //Quitting Browser
//		if(driver !=null) {
//			driver.close();
//		}
		driver.close();
		System.out.println("Closing Browser");
	}
}
