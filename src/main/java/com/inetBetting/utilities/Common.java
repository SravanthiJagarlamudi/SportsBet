package com.inetBetting.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.inetBetting.base.Constants;

public class Common extends Constants {

	/**
	 * This method is used to enter the value in the text box
	 * 
	 * @param element
	 * @param value
	 * @author Shravanthi
	 */
	public static void enterValue(WebElement element, String value) {
		try {
			if (element.isDisplayed()) {
				if (element.isEnabled()) {
					element.sendKeys(value);
					logger.info("Value is entered into the text box as: " + value);
				} else {
					logger.info("Element is not enabled");
				}
			} else {
				logger.info("Element is not displayed");
			}
		} catch (Exception ex) {
			logger.info("Exception occurred while entering text. " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * This method is used to click on the element
	 * 
	 * @param element
	 * 
	 * @author Shravanthi
	 */
	public static void click(WebElement element) {
		try {
			if (element.isDisplayed()) {
				if (element.isEnabled()) {
					element.click();
					logger.info("Element is clicked on ");
				} else {
					logger.info("Element is not enabled");
				}
			} else {
				logger.info("Element is not displayed");
			}
		} catch (Exception ex) {
			logger.info("Exception occurre while clicking on the element. " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * This method is used to retrieve the text of an web element
	 * 
	 * @param element
	 * @return text
	 * @author Shravanthi
	 */
	public static String getText(WebElement element) {
		String text = "";
		try {
			if (element.isDisplayed()) {

				text = element.getText();
				logger.info("Text of the element is:  " + text);

			} else {
				logger.info("Element is not displayed");
			}
		} catch (Exception ex) {
			logger.info("Exception occurre while retrieving the text of an web element. " + ex.getMessage());
			ex.printStackTrace();
		}
		return text;
	}

	public static void pause(long millis) throws InterruptedException {
		Thread.sleep(millis);
	}

	/**
	 * This method is used to scrolling into view to the element
	 * 
	 * @param element
	 */
	public static void scrollIntoView(WebElement element) {
		try {
			if (element.isDisplayed()) {

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", element);

			} else {
				logger.info("Element is not displayed");
			}
		} catch (Exception ex) {
			logger.info("Exception occurre while scrolling into view to the element " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
