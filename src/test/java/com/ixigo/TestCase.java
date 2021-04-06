/**
 * 
 */
package com.ixigo;

import org.testng.annotations.Test;

import com.ixigo.page.LoginPage;

/**
 * @author Subhajit
 *
 */
public class TestCase extends BaseTest{
	
	
	@Test(priority = 0)
	public void PageValidation() {	
		String title = getBase().getInstance(LoginPage.class).getTitle();
		hardAssert.assertEquals(title, "ixigo - Flights, IRCTC Train Booking, Bus Booking, Air Tickets & Hotels");	
		
	}
	
	@Test(priority = 1)
	public void EnteredData() {
		getBase().getInstance(LoginPage.class).enteredFromCity("Pune");
		getBase().getInstance(LoginPage.class).enteredToCity("Hyderabad");
//		getBase().getInstance(LoginPage.class).clickOndepDateInput();
//		getBase().getInstance(LoginPage.class).datePick("17 Sep 2020");
//		getBase().getInstance(LoginPage.class).clickOnReturnDateInput();
//		getBase().getInstance(LoginPage.class).datePick("24 Oct 2020");
//		getBase().getInstance(LoginPage.class).clickOnTravellerType();
//		getBase().getInstance(LoginPage.class).travellers_Selection("Adult",2);
	}
	
//	@Test(priority = 2)
	public void SearchValidation() {
		getBase().getInstance(LoginPage.class).clickOnSearchButton();
		String title = getBase().getInstance(LoginPage.class).getTitle();
		hardAssert.assertEquals(title, "Pune - Hyderabad, Economy Flights, roundtrip, 17 Sep - 24 Oct");		
	}
	
//	@Test(priority = 3)
	public void InputDataValidation() {
		String fromCity = getBase().getInstance(LoginPage.class).getFromCity();
		hardAssert.assertEquals(fromCity.substring(fromCity.indexOf("-")+2), "Pune");
		String toCity = getBase().getInstance(LoginPage.class).getToCity();
		hardAssert.assertEquals(toCity.substring(toCity.indexOf("-")+2), "Hyderabad");
		String depDate = getBase().getInstance(LoginPage.class).getDepDate();
		hardAssert.assertEquals(depDate.substring(0,depDate.indexOf(",")), "17 Sep");
	}
	
//	@Test(priority = 4)
	public void getFlightDetails() {
		getBase().getInstance(LoginPage.class).clickOnNon_Stop_Checkbox();
		getBase().getInstance(LoginPage.class).fareDetails();
	}

}
