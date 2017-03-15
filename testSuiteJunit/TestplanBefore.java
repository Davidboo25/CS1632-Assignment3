

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

public class TestplanBefore {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://cs1632ex.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testTestplanBefore() throws Exception {
		selenium.open("/");
		assertTrue(selenium.getText("css=div.row > p.lead").matches("^[\\s\\S]*Used for CS1632 Software Quality Assurance, taught by Bill Laboon[\\s\\S]*$"));
		assertTrue(selenium.getText("css=p.lead").matches("^[\\s\\S]*Welcome, friend,[\\s\\S]*$"));
		assertTrue(selenium.getText("css=p.lead").matches("^[\\s\\S]*to a land of pure calculation\\.[\\s\\S]*$"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
