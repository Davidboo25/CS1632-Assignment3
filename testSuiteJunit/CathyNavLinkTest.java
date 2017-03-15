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

public class CathyNavLinkTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://cs1632ex.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testCathyNavLink() throws Exception {
		selenium.open("/cathy");
		selenium.click("link=CS1632 D3 Home");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getLocation().matches("^[\\s\\S]*/$"));
		selenium.open("/cathy");
		selenium.click("link=Factorial");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getLocation().matches("^[\\s\\S]*/fact$"));
		selenium.open("/cathy");
		selenium.click("link=Fibonacci");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getLocation().matches("^[\\s\\S]*/fib$"));
		selenium.open("/cathy");
		selenium.click("link=Hello");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getLocation().matches("^[\\s\\S]*/hello$"));
		selenium.open("/cathy");
		selenium.click("link=Cathedral Pics");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getLocation().matches("^[\\s\\S]*/cathy$"));
		selenium.open("/cathy");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
