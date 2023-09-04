package testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelUtilities;
import utilities.ScreenShotCapture;
public class BaseClass {
	WebDriver driver;
	ScreenShotCapture sc;
	public static Properties pro;
	
	public static void testBasic() throws IOException {
		pro = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\config.properties");
		pro.load(fp);
	}
	
	public static String logIndata(int usr) throws IOException, InvalidFormatException {
		ArrayList<String> data = ExcelUtilities.readDataFromExcel("\\src\\main\\resources\\Excel\\Exportkontrol.xls","LogInPage");				
		return data.get(usr);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethode(String browserName) throws IOException {
		if (browserName.equals("chrome")) {
			/*System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();*/
			testBasic();
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			DesiredCapabilities cp=new DesiredCapabilities();
			cp.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(cp);
			driver = new ChromeDriver(options);
		} else if (browserName.equals("fireFox")) {
			
		//	 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
		//	"\\src\\main\\resources\\Driver\\geckodriver.exe");
			testBasic();
		WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 		
		driver.manage().window().maximize();
		//driver.get("http://217.172.173.207/Exportkontrolle/Index.aspx");
		driver.get(pro.getProperty("BaseURL"));		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethode(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
		}
		driver.close();
	}
}
