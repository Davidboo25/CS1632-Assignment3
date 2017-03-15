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
 * I would like to see if the navigation on the Hello page
 * contains all the correct names. These are:
 * "CS1632 D3 Home","Factorial","Fibonacci","Hello","Cathedral Pics"
 * @author David Anderson
 *
 */
public class HelloNavDisplayTest extends TestCase{
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

  // I open the hello page from the homepage.
  // Then, I check to see if each link specified is located somewhere on the webpage.
  @Test
  public void testHelloNavDisplay() throws Exception {
    driver.get(baseUrl + "/hello");
    assertTrue(isElementPresent(By.linkText("CS1632 D3 Home")));
    assertTrue(isElementPresent(By.linkText("Factorial")));
    assertTrue(isElementPresent(By.linkText("Fibonacci")));
    assertTrue(isElementPresent(By.linkText("Hello")));
    assertTrue(isElementPresent(By.linkText("Cathedral Pics")));
  }

  // Quit the driver.
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  // Check if a certain element exists on the page.
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  // Check if there is an alert on the loaded page.
  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  // Close alert and get the text from it 
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
