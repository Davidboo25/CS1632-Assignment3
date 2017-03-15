package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

/**
 * As a user,
 * I would like to see that entering a decimal number into the factorial textbox displays the correct output.
 * @author David Anderson
 *
 */

public class FactorialDecimalTest {
	private Selenium selenium;

	// Setup the webdriver for the desired website.	
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://cs1632ex.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	// Navigate to the Factorial page.
	// Then test that entering "1.5" displays the correct
	// output of 1 due to it being an invalid input.
	@Test
	public void testFactorialDecimal() throws Exception {
		selenium.open("/");
		selenium.click("link=Factorial");
		selenium.waitForPageToLoad("30000");
		// Enter the input and then submit it.
		selenium.type("name=value", "1.5");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		// Verify that the output is correct.
		assertTrue(selenium.getText("css=h2").matches("^[\\s\\S]*1![\\s\\S]*$"));
	}

	// End
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
