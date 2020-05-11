package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilClass {
	public static void takeSnapShot(WebDriver driver, String name) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+name+".png";
		File DestFile = new File(screenshotPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	
	public static String randomestring(int number)
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(number);
		return(generatedstring);
	}
	
	public static String randomeNum(int number) {
		String generatedString2 = RandomStringUtils.randomNumeric(number);
		return (generatedString2);
	}
}
