package resources;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {

	public static String captureScreenshot(WebDriver driver, WebElement ele) throws IOException {

		String strImageLocation = "";
		try {

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImg = ImageIO.read(screenshot);

			// Get the location of element on the page
			Point point = ele.getLocation();
		
			// Get width and height of the element
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();

			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX() + 1100, point.getY() + 40, eleWidth - 300,
					eleHeight - 440);
			ImageIO.write(eleScreenshot, "png", screenshot);

			// Copy the element screenshot to disk
			File screenshotLocation = new File("./screenshots/" + generateFileName() + ".png");
			FileUtils.copyFile(screenshot, screenshotLocation);
			strImageLocation = screenshotLocation.getAbsolutePath();

		} catch (Exception e) {
			System.out.println("Exception while taking screenshot" + e.getMessage());

		}
		return strImageLocation;
	}

	public static String generateFileName() {
		LocalDateTime currentDateObj = LocalDateTime.now();
		return "calc" + currentDateObj;
	}

}
