import junit.framework.TestCase;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


/**
 * As a user,
 * I would like to see if the Hello page correctly
 * displays the text, "Hello CS1632, from",
 * and also an input decimal from the navigation bar,
 * "3.14159", on the page to the user.
 */
public class HelloDecimalDisplayTest extends TestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  // Setup the homepage.
  @Before
  public void setUp() throws Exception {
    driver = new HtmlUnitDriver();
    baseUrl = "https://cs1632ex.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  // Test to see if the correct Hello output is displayed to the user. 
  // Also test that if the user inputs a decimal, 3.14159,  to the end of the address, 
  // it is displayed correctly.
  @Test
  public void testHelloDecimalDisplay() throws Exception {
    driver.get(baseUrl + "/hello/3.14159");
    assertTrue(driver.findElement(By.cssSelector("h2")).getText().matches("^[\\s\\S]*Hello CS1632, from[\\s\\S]*$"));
    assertTrue(driver.findElement(By.cssSelector("h2")).getText().matches("^[\\s\\S]*3\\.14159[\\s\\S]*$"));
  }

  // Quit driver.
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  // Check if an element is present on the page.
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  
  // Check if an alert is present on the page.
  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  // Close a specific alert and get it's text.
  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
