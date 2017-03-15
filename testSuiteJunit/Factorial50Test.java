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
 * I would like to see that entering 50 into the factorial textbox displays the correct output.
 * @author David Anderson
 *
 */

public class Factorial50Test {
	private Selenium selenium;

	// Setup the webdriver for the desired website.

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://cs1632ex.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	// Navigate to the Factorial page.
	// Then test that entering "50" displays the correct
	// output of
	// 30414093201713378043612608166064768844377641568960512000000000000
	@Test
	public void testFactorial50() throws Exception {
		selenium.open("/");
		selenium.click("link=Factorial");
		selenium.waitForPageToLoad("30000");
		// Enter 50 into the textbox.
		selenium.type("name=value", "50");
		// Submit it.
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		// Verify that it matches the correct output.
		assertTrue(selenium.getText("css=h2").matches("^[\\s\\S]*30414093201713378043612608166064768844377641568960512000000000000[\\s\\S]*[\\s\\S]*$"));
	}

	// End
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
