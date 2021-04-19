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
public class TestCase_02 extends BaseTest{
	
	@Test(priority = 0)
	public void PageValidation() {	
		String title = getBase().getInstance(LoginPage.class).getTitle();
		hardAssert.assertEquals(title, "ixigo - Flights, IRCTC Train Booking, Bus Booking, Air Tickets & Hotels");			
	}
	

}
