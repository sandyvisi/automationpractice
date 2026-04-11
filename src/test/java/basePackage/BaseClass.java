package basePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected static WebDriver driver;
	protected static WebDriverWait webDriverWait;
	protected static Properties properties;
	protected static String propertiesFilePath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\configProperties.properties";
//	src\test\resources\configProperties.properties
	protected static FileInputStream fis;
	protected static Select select;
	protected static JavascriptExecutor js;

	public void init() throws IOException {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("autofill.profile_enabled", false);
		prefs.put("autofill.credit_card_enabled", false);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("profile.default_content_setting_values.popups", 2);
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-popup-blocking");

		options.setExperimentalOption("prefs", prefs);
		fis = new FileInputStream(propertiesFilePath);
		properties = new Properties();
		properties.load(fis);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));

		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver;
		fis.close();

	}

	public void alertClose() {
		try {
			Alert alert = webDriverWait.until(ExpectedConditions.alertIsPresent());
			alert.dismiss();
		} catch (TimeoutException e) {
			System.out.println("No alert present within the given time.");
			e.printStackTrace();
		}
	}

	public void elementVisibleClose(By locator) {
		try {
			WebElement popup = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
			popup.click();

		} catch (TimeoutException e) {
			System.out.println("Element not visible: " + locator);
			throw e;
		} catch (Exception e) {
			System.out.println("Unexpected error while clicking element: " + locator);
			throw e;
		}
	}

	public void scrollDownToElement(By locator) {
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
	}

	public void selectList(By locator, String text) {
		select = new Select(driver.findElement(locator));
		select.selectByVisibleText(text);

	}

	public String webElementWaitGetText(By locator) {

		WebElement headerElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return headerElement.getText();

	}

	public void click(By locator) {

		driver.findElement(locator).click();
	}

	public void sendKeys(String text, By locator) {

		driver.findElement(locator).sendKeys(text);
	}

	public void tearDown() {
		driver.quit();
	}

}
