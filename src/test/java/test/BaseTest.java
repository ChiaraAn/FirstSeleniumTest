package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTest {
    WebDriver driver = null;
    HomePage homePage;
    @BeforeTest
    public void beforeTest(){
        String driverPath = "C:\\Users\\Chiara\\Documents\\Selenium\\PruebaSelenium\\Seleniumtest\\FirstSeleniumTest\\src\\utils\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        homePage = new HomePage(driver, "https://es.wikipedia.org/wiki/Wikipedia:Portada");
    }
    @AfterTest
    public void afterTest(){
        driver.close();
    }

    public HomePage getHomePage(){
        return new HomePage(driver, "https://es.wikipedia.org/wiki/Wikipedia:Portada");
    }
}
