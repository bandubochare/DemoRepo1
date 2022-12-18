package ai.ds.testbase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ai.ds.pagelayer.DashboardPage;
import ai.ds.pagelayer.ExchangePage;
import ai.ds.pagelayer.LoginPage;
import ai.ds.pagelayer.TransactionsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger;
	public LoginPage login;
	public DashboardPage dash;
	public ExchangePage exchange;
	public TransactionsPage tran;
	
	@BeforeClass
	public void start()
	{
		logger = Logger.getLogger("DalaStreet Automation Framework");
		PropertyConfigurator.configure("Log4j.properties");
		
		logger.info("Framework execution Started");
	}
	
	@AfterClass
	public void end()
	{
		logger.info("Framework execution Completed");
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		String br = "chrome";
		
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please choose correct browswer");
		}
		
		driver.get("https://www.apps.dalalstreet.ai/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Browser launches, maximized, provided wait");
		
		//------ Object Creation -------------
		login = new LoginPage();
		dash = new DashboardPage();
		exchange = new ExchangePage();
		tran = new TransactionsPage();
		logger.info("Object Creation");
		//--- Login Steps ----
		login.enterEmailID("amarwaghmare573@gmail.com");
		login.enterPassword("Test@1234");
		login.clickOnLoginButton();
		Thread.sleep(3000);
		logger.info("Logged in application");
	}
	
	@AfterMethod
	public void tearDown()
	{
//		driver.quit();
		logger.info("Browser closed");
	}
}
