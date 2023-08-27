package com.generic.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains useful methods of selenium web driver to perform action
 * on web element.
 * 
 * @author Vivek M
 *
 */
public class WebDriverUtility {

	/**
	 * This method will maximize the web page.
	 * 
	 * @param d
	 */
	public void maximizeWebPage(WebDriver d) {
		d.manage().window().maximize();
	}

	/**
	 * This method will minimize the web page.
	 * 
	 * @param d
	 */
	public void minimizeWebPage(WebDriver d) {
		d.manage().window().minimize();
	}

	/**
	 * This method will wait for 30 seconds to load web page to fine web elements.
	 * 
	 * @param d
	 */
	public void waitForPageLoad(WebDriver d) {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	/**
	 * This method will wait for 30 seconds to load web page to fine web elements.
	 * 
	 * @param d
	 */
	public void waitForElementToBeClickable(WebDriver d, WebElement element) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will perform mouse hover action using web element
	 * 
	 * @param d
	 * @param element
	 */
	public void mouseHoverAction(WebDriver d, WebElement element) {
		Actions actions = new Actions(d);
		actions.moveToElement(element).perform();
	}

	/**
	 * This method will perform mouse hover action using web element & xOffset,
	 * yOffset
	 * 
	 * @param d
	 * @param element
	 * @param xOffset
	 * @param yOffset
	 */
	public void mouseHoverAction(WebDriver d, WebElement element, int xOffset, int yOffset) {
		Actions actions = new Actions(d);
		actions.moveToElement(element, xOffset, yOffset);
	}

	/**
	 * This method will perform mouse hover action using xOffset, yOffset
	 * 
	 * @param d
	 * @param xOffset
	 * @param yOffset
	 */
	public void mouseHoverAction(WebDriver d, int xOffset, int yOffset) {
		Actions actions = new Actions(d);
		actions.moveByOffset(xOffset, yOffset);
	}

	/**
	 * This method will capture the screen shot of whole web page
	 * @param d
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver d, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) d;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "\\Screenshot\\" + screenShotName + ".png";
		File dst = new File(path);
		Files.copy(src, dst);
		return dst.getAbsolutePath();
	}

}
