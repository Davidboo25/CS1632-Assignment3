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
 * I would like to see that there are 3 images of the Cathedral of Learning
 * on the /Cathy page.
 * @author David Anderson
 *
 */
 
public class Cathy3CathyPictureTest {
	private Selenium selenium;

	// Setup the webdriver for the desired website.
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://cs1632ex.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	// Navigate to the Cathedral page from the index of the website.
	// Test that there are three Cathedral Images.
	@Test
	public void testCathy3CathyPicture() throws Exception {
		selenium.open("/");
		selenium.click("link=Cathedral Pics");
		selenium.waitForPageToLoad("30000");
		// Check that each image exists.
		assertTrue(selenium.isElementPresent("css=img[alt=\"Sunny Cathedral\"]"));
		assertTrue(selenium.isElementPresent("css=img[alt=\"Alpenglow Cathedral\"]"));
		assertTrue(selenium.isElementPresent("css=img[alt=\"Old Cathedral\"]"));
	}

	// End Selenium
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
