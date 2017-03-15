
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import junit.framework.TestCase;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a user,
 * I would like to see if the Fibonacci text box correctly
 * displays the output of a decimal number "1.5".
 * @author David Anderson
 */
public class FibDecimalTest extends TestCase {
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
  
  // Test that using Fibonacci decimal 1.5 produces the correct output of
  // 1.
  // This is due to it being the wrong type.
  
  @Test
  public void testFibDecimal() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Fibonacci")).click();
    driver.findElement(By.id("tb1")).clear();
    driver.findElement(By.id("tb1")).sendKeys("1.5");
    driver.findElement(By.id("sub")).click();
    assertTrue(driver.findElement(By.cssSelector("h2")).getText().matches("^[\\s\\S]*1![\\s\\S]*$"));
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
