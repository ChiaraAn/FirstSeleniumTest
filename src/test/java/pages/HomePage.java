package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
    }

    @FindBy(className = "cdx-text-input__input")
    private WebElement searchInput;
    @FindBy(className = "cdx-search-input__end-button")
    private WebElement searchButton;
    @FindBy(className = "mw-page-title-main")
    private WebElement titleName;
    @FindBy(tagName = "a")
    private List<WebElement> anchorLinks;

    public void clickSearchBar(){
        this.searchInput.click();
    }
    public void setSearchText(String text){
        this.searchInput.sendKeys(text);
    }
    public void clickOnSearchButton(){
        this.searchButton.click();
    }
    public String getTitleName(){
        this.isElementDisplayed(this.titleName);
        return this.titleName.getText();
    }

    public void getAllAnchorLinks(){
        for (WebElement anchor : this.anchorLinks ) {
            String linkText = anchor.getText();
            System.out.println(linkText);
        }
    }




}
