package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	static String dateformat = new SimpleDateFormat("HH:mm:ss").format(new Date());
	static TakesScreenshot ts;

	public static String filePath;

	public static void getScreenshot(WebDriver driver, String name) throws IOException {
		filePath = System.getProperty("user.dir") + "\\screenshots" + dateformat + name + ".png";
		File destination = new File(filePath);
		ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, destination);

	}

}
