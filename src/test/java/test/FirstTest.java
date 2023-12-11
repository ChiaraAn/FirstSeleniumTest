package test;

import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FirstTest extends BaseTest {

    @Test
    public void TestWiki() {
        HomePage homepage = getHomePage();

        driver.manage().window().maximize();
        homePage.clickSearchBar();
        homePage.setSearchText("Microsoft");
        homePage.clickOnSearchButton();
        Assert.assertEquals(homePage.getTitleName(),"Microsoft","The webpage title does not match 'Microsoft'.");
        homePage.getAllAnchorLinks();

    }
}
