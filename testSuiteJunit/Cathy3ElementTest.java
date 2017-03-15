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
 * I would like to see that there are 3 elements in the ordered list
 * on the /Cathy page.
 * @author David Anderson
 *
 */


public class Cathy3ElementTest {
	private Selenium selenium;

	// Setup the webdriver for the desired website.
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://cs1632ex.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	// Navigate to the Cathedral page from the index of the website.
	// Test that there are three elements in the ordered list.
	@Test
	public void testCathy3Element() throws Exception {
		selenium.open("/");
		selenium.click("link=Cathedral Pics");
		selenium.waitForPageToLoad("30000");
		// Check that the 3rd list item is visible. 
		assertTrue(selenium.isVisible("css=ol > li:nth(2)"));
		// Test that the fourth list item doesnt exist.
		// This shows that there are only three items.
		assertFalse(selenium.isElementPresent("css=ol > li:nth(3)"));
	}

	// End Selenium
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
