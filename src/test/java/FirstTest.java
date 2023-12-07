import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.logging.Logger;
import java.util.List;


public class FirstTest {

    WebDriver driver = null;

    @Test
    public void TestWiki() throws InterruptedException {
        String driverPath = "C:\\Users\\Chiara\\Documents\\QA projects\\PruebaSelenium\\Seleniumtest\\src\\utils\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();

        driver.navigate().to("https://es.wikipedia.org/wiki/Wikipedia:Portada");

       /* WebElement searchInput = driver.findElement(By.cssSelector("#p-search > a > span.vector-icon.mw-ui-icon-search.mw-ui-icon-wikimedia-search"));*/
        WebElement searchInputField = driver.findElement(By.cssSelector("#p-search > a > span.vector-icon.mw-ui-icon-search.mw-ui-icon-wikimedia-search"));
        searchInputField.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait for up to 5 seconds.
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#searchform > div > div > div.cdx-text-input.cdx-text-input--has-start-icon.cdx-text-input--status-default.cdx-search-input__text-input > input")));
        searchInput.sendKeys("Microsoft");

        WebElement searchButton = driver.findElement(By.cssSelector("#searchform > div > button"));
        searchButton.click();

        WebElement titleName = driver.findElement(By.className("mw-page-title-main"));

       Assert.assertEquals(titleName.getText(),"Microsoft","The webpage title does not match 'Microsoft'.");
       System.out.println("The webpage title matches 'Microsoft'.");

        List<WebElement> anchorLinks = driver.findElements(By.tagName("a"));

        for (WebElement anchor : anchorLinks ) {
            String linkText = anchor.getText();
            System.out.println(linkText);
        }

    }

}
