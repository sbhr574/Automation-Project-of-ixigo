/**
 * 
 */
package com.ixigo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author Subhajit
 *
 */
public class Base extends Page {
	
	
	public Base(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}


	public void doClick(By locator) {
		driver.findElement(locator).click();
	}
	
	public void doSendKeys(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}
	
	public void doClear(By locator) {
		driver.findElement(locator).clear();
	}

	
	//Below function is wrapper function
	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPrasent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void waitForElementVisible(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void waitForElementToBeClickable(By locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void waitForElementToBeInVisible(By locator) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
