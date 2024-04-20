package finalPackage;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLoginShopee {

	public WebDriver driver;
	public UIMap uimap;
	public String workingDir;
	public UIMap datafile;

	@Test(description = "Opens the TestNG Demo Website for login Test", priority = 1)
	public void LaunchWebsite() throws Exception {
		driver.get("https://hoanghamobile.com/Account/login");
		driver.manage().window().maximize();
		
		WebElement login = driver.findElement(By.id("login-modal"));

	}
	
	

	@Test(description = "Fill the Login Details", priority =2 )
	public void FillLoginDetails() throws Exception {
		try {
			// Get the username element
			WebElement username = driver.findElement(uimap.getLocator("Username_field"));
			username.sendKeys(datafile.getData("username"));
			// Get the password element
			WebElement password = driver.findElement(uimap.getLocator("Password_field"));
			password.sendKeys(datafile.getData("password"));
			Thread.sleep(1000);

		} catch (Exception e) {

			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Perform Login", priority = 3)
	public void DoLogin() throws Exception {
		try {
			// Nhấn vào nút login
			WebElement login = driver.findElement(By.className("btn-submit"));

			Actions actions = new Actions(driver).click(login);
			actions.build().perform();
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@SuppressWarnings("deprecation")
	@BeforeClass(alwaysRun = true)
	public void suiteSetup() {

		try {
			// Lấy địa chỉ làm việc hiện tại và tải dữ liệu vào file
			workingDir = System.getProperty("user.dir");
			System.out.println("chay toidau");
			datafile = new UIMap(workingDir + "\\Resources\\datafile.properties");
			System.out.println(datafile);
			uimap = new UIMap(workingDir + "\\Resources\\locator.properties");

			// Cài đặt địa chỉ Edge Driver và chạy Edge
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // No Such Element Exception
		} catch (Exception e) {
			throw new IllegalStateException("Can't start the Chrome web driver", e);
		}

	}

	@AfterClass
	public void close() {
		driver.close();
	}
}
