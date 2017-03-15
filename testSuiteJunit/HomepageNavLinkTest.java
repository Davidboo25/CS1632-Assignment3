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


public class HomepageNavLinkTest extends TestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new HtmlUnitDriver();
    baseUrl = "https://cs1632ex.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testHomepageNavLink() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("CS1632 D3 Home")).click();
    assertTrue(driver.getCurrentUrl().matches("^[\\s\\S]*/$"));
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Factorial")).click();
    assertTrue(driver.getCurrentUrl().matches("^[\\s\\S]*/fact$"));
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Fibonacci")).click();
    assertTrue(driver.getCurrentUrl().matches("^[\\s\\S]*/fib$"));
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Hello")).click();
    assertTrue(driver.getCurrentUrl().matches("^[\\s\\S]*/hello$"));
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Cathedral Pics")).click();
    assertTrue(driver.getCurrentUrl().matches("^[\\s\\S]*/cathy$"));
    driver.get(baseUrl + "/");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

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
