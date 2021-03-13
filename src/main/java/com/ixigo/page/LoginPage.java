/**
 * 
 */
package com.ixigo.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ixigo.base.Base;

/**
 * @author Subhajit
 *
 */
public class LoginPage extends Base{

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	
	private By website_Logo = By.id("ixiLogoImg");
	private By flight_Tab = By.xpath("//a[text()='flights']");
	private By search_Button = By.xpath("//div[@class='search u-ib u-v-align-bottom']/button");
	private By fromCity_InputBox = By.xpath("//div[@class='input-label' and text()='From']/following-sibling::input");
	private By fromCity_SearchResult = By.xpath("(//div[@class='city'])");
	private By toCity_InputBox = By.xpath("//div[@class='input-label' and text()='To']/following-sibling::input");
	private By departureDate_DatePicker = By.xpath("//div[@class='input-label' and text()='Departure']/following-sibling::input");
	private By returnDate_DatePicker = By.xpath("//div[@class='input-label' and text()='Return']/following-sibling::input");
	private By travellers_DatePicker = By.xpath("//div[@class='input-label' and text()='Travellers | Class']/following-sibling::input");
	private By travellersAdult_Type = By.xpath("//div[contains(text(),'Adult')]");
	private By travellersChild_Type = By.xpath("//div[contains(text(),'Child')]");
	private By travellersInfant_Type = By.xpath("//div[contains(text(),'Infant')]");
	private By book_Button = By.xpath("//button[text()='Book']");
	private By nonStop_CheckBox = By.xpath("//div[text()='Non stop']/../../span[1]/span");
	private By flight_Icon = By.xpath("//i[@class='ixi-icon-plane plane-icon']");
	private By filter = By.xpath("//div[text()='Reset Filters']");
	
	public String getTitle() {
		try {
			String title = driver.getTitle();
			return title;
		} catch (Exception error) {
			error.printStackTrace();
			return null;
		}
	}
	
	public void enteredFromCity(String From_City) {
		try {
			waitForElementToBeClickable(fromCity_InputBox);
			doClick(fromCity_InputBox);
			getElement(fromCity_InputBox).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			doSendKeys(fromCity_InputBox, From_City);
			Thread.sleep(3000);
			List <WebElement> yt = driver.findElements(fromCity_SearchResult);
			for(int i=1;i<yt.size();i++) {
				waitForElementVisible(By.xpath("(//div[@class='city'])["+i+"]"));
				String rt = getElement(By.xpath("(//div[@class='city'])["+i+"]")).getText();
				if(rt.contains(From_City)) {
					doClick(By.xpath("(//div[@class='city'])["+i+"]"));
					break;
				}
			}
		}catch(Exception error) {
			error.printStackTrace();
		}
	}
	
	public void enteredToCity(String To_City) {
		try {
			waitForElementToBeClickable(toCity_InputBox);
			doClick(toCity_InputBox);
			getElement(toCity_InputBox).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			doSendKeys(toCity_InputBox, To_City);
			Thread.sleep(3000);
			List <WebElement> yt = driver.findElements(fromCity_SearchResult);
			for(int i=1;i<yt.size();i++) {
				String rt = getElement(By.xpath("(//div[@class='city'])["+i+"]")).getText();
				if(rt.contains(To_City)) {
					doClick(By.xpath("(//div[@class='city'])["+i+"]"));
					break;
				}
			}
		}catch(Exception error) {
			error.printStackTrace();
		}
	}
	
	public void travellers_Selection(String travellers_Type, int travellers_count) {
		try {
			By travellers = By.xpath("//div[contains(text(),'"+travellers_Type+"')]/../../div[2]/span["+travellers_count+"]");
			waitForElementToBeClickable(travellers);
			doClick(travellers);
		}catch(Exception error) {
			error.printStackTrace();
		}
	}
	
	public void clickOnSearchButton() {
		try {
			doClick(search_Button);
			waitForElementPrasent(flight_Icon);
			waitForElementVisible(flight_Icon);
			waitForElementToBeInVisible(flight_Icon);
		}catch(Exception error) {
			error.printStackTrace();
		}
	}
	
	public void clickOndepDateInput() {
		try {
			waitForElementToBeClickable(departureDate_DatePicker);
			doClick(departureDate_DatePicker);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	public void clickOnReturnDateInput() {
		try {
			waitForElementToBeClickable(returnDate_DatePicker);
			doClick(returnDate_DatePicker);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	public void clickOnTravellerType() {
		try {
			waitForElementToBeClickable(travellers_DatePicker);
			doClick(travellers_DatePicker);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}
	
	public void datePick(String Departure_date) {
		try {
			String month_Name = null;
			By locator = By.xpath("//div[@class='rd-month']");
			List<WebElement> elementCount = driver.findElements(locator);
			for (int i = 1; i <= elementCount.size(); i++) {
				By getMonth_Name = By.xpath("(//div[@class='rd-month-label'])[" + i + "]");
				if (getElement(getMonth_Name).isDisplayed()) {
					month_Name = getElement(getMonth_Name).getText();
					if (month_Name.substring(0, 3).equals(Departure_date.substring(3, 6))) {
						String date = Departure_date.substring(0, 2);
						By loc = By.xpath("(//div[@class='rd-month'])[" + i + "]/table/tbody//tr");
						List<WebElement> date_Count = driver.findElements(loc);
						for (int j = 1; j < date_Count.size(); j++) {
							By loc_tr = By.xpath("(//div[@class='rd-month'])[" + i + "]/table/tbody//tr[" + j + "]/td");
							List<WebElement> row = driver.findElements(loc_tr);
							for (int k = 1; k <= row.size(); k++) {
								By loc_td = By.xpath("(//div[@class='rd-month'])[" + i + "]/table/tbody//tr[" + j
										+ "]/td[" + k + "]");
								String val = getElement(loc_td).getAttribute("class");
								if (!val.contains("disabled") || !val.contains("prev-month")) {
									By loc_value = By.xpath("(//div[@class='rd-month'])[" + i + "]/table/tbody//tr[" + j
											+ "]/td[" + k + "]/div[1]");
									// System.out.println(getElement(loc_value).getText());
									if (date.equals(getElement(loc_value).getText())) {
										doClick(loc_value);
										break;
									}

								} else {

								}
							}

						}

					} else {
//						System.out.println("Month not matched");
					}
				} else {
//					System.out.println("not Displayed");
				}

			}
		} catch (Exception error) {
			error.printStackTrace();
		}
	}
	
	
	public void clickingOnNonStop_Checkbox(String PassType, String passenger_count ) {
		try {
			By locator = By.xpath("(//div[contains(text(),'"+PassType+"')]/../following-sibling::div/span)["+passenger_count+"]");
			doClick(locator);
			
		}catch(Exception error) {
			error.printStackTrace();
		}
	}

	public void fareDetails() {
		try {
			List<WebElement> fare_Count = driver
					.findElements(By.xpath("//div[@class='result-wrpr']//div[@class='price-group']//span[2]"));
			String fare = null;
			String getValue_airlinesNumber = null;
			String getValue_depatureTime = null;
			for (int i = 1; i <= fare_Count.size(); i++) {
				By getFare = By.xpath("(//div[@class='result-wrpr']//div[@class='price-group']//span[2])[" + i + "]");
				fare = getElement(getFare).getText();
				if (Integer.parseInt(fare) < 5000) {
					By airlinesNumber = By
							.xpath("(//div[@class='result-wrpr']//div[@class='time-group']/div[4]/div)[" + i + "]");
					getValue_airlinesNumber = getElement(airlinesNumber).getText();
					By depatureTime = By
							.xpath("(//div[@class='result-wrpr']//div[@class='time-group']/div[1])[" + i + "]");
					getValue_depatureTime = getElement(depatureTime).getText();

					System.out.println("Airlines Details ::- " + getValue_airlinesNumber + "; Depature Time ::- "
							+ getValue_depatureTime + "; Flight Fare :: " + fare);

				}
			}
		} catch (Exception error) {
			error.printStackTrace();
		}

	}
	

	public String getFromCity() {
		try {
			String value = getElement(fromCity_InputBox).getAttribute("value");
			return value;
		}catch(Exception error) {
			return null;
		}
	}
	
	public String getToCity() {
		try {
			String value = getElement(toCity_InputBox).getAttribute("value");
			return value;
		}catch(Exception error) {
			return null;
		}
	}
	
	public String getDepDate() {
		try {
			String value = getElement(departureDate_DatePicker).getAttribute("value");
			return value;
		}catch(Exception error) {
			return null;
		}
	}
	
	public void clickOnNon_Stop_Checkbox() {
		try {
			waitForElementToBeClickable(nonStop_CheckBox);
			doClick(nonStop_CheckBox);
			waitForElementPrasent(filter);
			waitForElementVisible(filter);
		}catch(Exception error) {
			
		}
	}
	
	public void keyEnterOperation() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
}
