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
 * I would like to see that entering 100 into the factorial textbox displays the correct output.
 * @author David Anderson
 *
 */

public class Fact100Test {
	private Selenium selenium;

	// Setup the webdriver for the desired website.

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://cs1632ex.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	// Navigate to the Factorial page.
	// Then test that entering "100" displays the correct
	// output of
	// 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
	@Test
	public void testFact100() throws Exception {
		selenium.open("/");
		selenium.click("link=Factorial");
		selenium.waitForPageToLoad("30000");
		// Enter 100 into the textbox.
		selenium.type("name=value", "100");
		// Submit it.
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		// Assert that the output value is correct.
		assertTrue(selenium.getText("css=h2").matches("^[\\s\\S]*93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000[\\s\\S]*$"));
	}

	// End selenium.
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
