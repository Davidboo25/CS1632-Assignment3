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
 * I would like to see that there are 5 links at the top of the Factorial page
 * and that they all direct to the correct pages.
 * @author David Anderson
 *
 */

public class FactorialNavLinkTest {
	private Selenium selenium;

	// Setup the webdriver for the desired website.
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://cs1632ex.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	// Navigate to the Factorial page from the index of the website.
	// When I click each link at the top of the page,
	// Confirm that it navigates to the correct destination. 
	@Test
	public void testFactorialNavLink() throws Exception {
		selenium.open("/fact");
		// Click each link and then verify that location is the correct one.
		selenium.click("link=CS1632 D3 Home");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getLocation().matches("^[\\s\\S]*/$"));
		selenium.open("/fact");
		selenium.click("link=Factorial");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getLocation().matches("^[\\s\\S]*/fact$"));
		selenium.open("/fact");
		selenium.click("link=Fibonacci");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getLocation().matches("^[\\s\\S]*/fib$"));
		selenium.open("/fact");
		selenium.click("link=Hello");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getLocation().matches("^[\\s\\S]*/hello$"));
		selenium.open("/fact");
		selenium.click("link=Cathedral Pics");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getLocation().matches("^[\\s\\S]*/cathy$"));
		selenium.open("/fact");
	}

	//End
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
