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
 * I would like to see that there are 5 items in the display and that they are the correct elements.
 * This is for the Cathy page.
 * @author David Anderson
 *
 */
 
public class CathyNavDisplayTest {
	private Selenium selenium;

	// Setup the webdriver for the desired website.
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://cs1632ex.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	// Navigate to the Cathedral page from the index of the website.
	// Test that the five required links exist on the page.
	// These links are "CS1632 D3 Home", "Factorial", "Fibonacci", "Hello", and "Cathedral Pics".
	@Test
	public void testCathyNavDisplay() throws Exception {
		selenium.open("/cathy");
		// Check that the links exist on the page.
		assertTrue(selenium.isElementPresent("link=CS1632 D3 Home"));
		assertTrue(selenium.isElementPresent("link=Factorial"));
		assertTrue(selenium.isElementPresent("link=Fibonacci"));
		assertTrue(selenium.isElementPresent("link=Hello"));
		assertTrue(selenium.isElementPresent("link=Cathedral Pics"));
	}

	// End Selenium
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
