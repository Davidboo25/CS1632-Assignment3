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
 * I would like to see if the factorial text box correctly
 * displays the output of the number "50".
 * @author David Anderson
 */
public class Factorial50Test extends TestCase {
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

  // Test that using factorial 50 produces the correct output of
  // 30414093201713378043612608166064768844377641568960512000000000000.
  @Test
  public void testFactorial50() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Factorial")).click();
    driver.findElement(By.name("value")).clear();
    driver.findElement(By.name("value")).sendKeys("50");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertTrue(driver.findElement(By.cssSelector("h2")).getText().matches("^[\\s\\S]*30414093201713378043612608166064768844377641568960512000000000000[\\s\\S]*[\\s\\S]*$"));
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
