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

public class HelloNavDisplayTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://cs1632ex.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testHelloNavDisplay() throws Exception {
		selenium.open("/hello");
		assertTrue(selenium.isElementPresent("link=CS1632 D3 Home"));
		assertTrue(selenium.isElementPresent("link=Factorial"));
		assertTrue(selenium.isElementPresent("link=Fibonacci"));
		assertTrue(selenium.isElementPresent("link=Hello"));
		assertTrue(selenium.isElementPresent("link=Cathedral Pics"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
