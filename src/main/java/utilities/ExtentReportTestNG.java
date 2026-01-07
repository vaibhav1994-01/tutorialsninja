package utilities;

//Used to handle file paths in a platform-independent way
import java.nio.file.Path;
import java.nio.file.Paths;

//Used to format date and time for unique report names
import java.text.SimpleDateFormat;
import java.util.Date;

//Core Extent Report classes
import com.aventstack.extentreports.ExtentReports;

//Reporter implementations
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//Used to apply theme (DARK / STANDARD)
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportTestNG {

	    // SparkReporter is the newer, recommended Extent reporter
	    public ExtentSparkReporter sparkReporter;

	    // ExtentReports is the main engine that manages test logging & reporting
	    static ExtentReports extent;

	    /**
	     * This method creates and returns a configured ExtentReports object.
	     * It is called once by the Listener class.
	     */
	    public static ExtentReports getReportObject() {

	        // ------------------------------
	        // 1️⃣ Create unique timestamp
	        // ------------------------------
	        // Ensures every execution generates a new report file
	        String timestamp =
	                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
	                        .format(new Date());

	        String name = "ExtentReport --" + timestamp;

	        // ------------------------------
	        // 2️⃣ Resolve report directory path
	        // ------------------------------
	        // Points to src/test/resources folder
	        Path resourceDirectory =
	                Paths.get("src", "test", "resources");

	        String absolutePath =
	                resourceDirectory.toFile().getAbsolutePath();

	        // Final report path
	        String reportPath =
	                absolutePath + "/reports/" + name + ".html";

	        // ------------------------------
	        // 3️⃣ Initialize HTML Reporter
	        // ------------------------------
	        // ExtentHtmlReporter generates the HTML report file
	        ExtentHtmlReporter reporter =
	                new ExtentHtmlReporter(reportPath);

	        // ------------------------------
	        // 4️⃣ Configure report UI
	        // ------------------------------
	        reporter.config().setReportName(
	                "14 Sep Framework - Regression/Smoke Suite"
	        );

	        reporter.config().setDocumentTitle(
	                "14 Sep Framework Execution Results"
	        );

	        // Set report theme (DARK / STANDARD)
	        reporter.config().setTheme(Theme.DARK);

	        // ------------------------------
	        // 5️⃣ Create ExtentReports instance
	        // ------------------------------
	        extent = new ExtentReports();

	        // Attach the configured reporter
	        extent.attachReporter(reporter);

	        // ------------------------------
	        // 6️⃣ Add system & environment info
	        // ------------------------------
	        // These details appear in the report dashboard
	        extent.setSystemInfo("Name", "Pratik Ubhe");
	        extent.setSystemInfo("Suite Name", "Regression");
	        extent.setSystemInfo("OS", System.getProperty("os.name"));
	        extent.setSystemInfo("OS Version", System.getProperty("os.version"));
	        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
	        extent.setSystemInfo("User Timezone", System.getProperty("user.timezone"));
	        extent.setSystemInfo("Machine Name", System.getenv("COMPUTERNAME"));
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("Browser", "Chrome 112");
	        extent.setSystemInfo("Build Version", "v1.2.3");
	        extent.setSystemInfo("Branch Name", "feature/login-tests");

	        // ------------------------------
	        // 7️⃣ Return ExtentReports object
	        // ------------------------------
	        return extent;
	    }
}
