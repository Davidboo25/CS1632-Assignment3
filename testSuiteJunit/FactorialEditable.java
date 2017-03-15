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
 * I would like to see that the textbox on the factorial page is editable.
 * @author David Anderson
 *
 */
public class FactorialEditable {
	private Selenium selenium;
	
	// Setup the webdriver for the desired website.	
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://cs1632ex.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	// Navigate to the Factorial page.
	// Then verify that the input textbox is editable.
	@Test
	public void testFactorialEditable() throws Exception {
		selenium.open("/");
		// Navigate to the Factorial page.
		selenium.click("link=Factorial");
		selenium.waitForPageToLoad("30000");
		// Verify that the textbox is editable.
		assertTrue(selenium.isEditable("name=value"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
