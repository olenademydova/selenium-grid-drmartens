package page_object;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@data-qa-automation='header-search-input']")
    private WebElement searchField;
    @FindBy(css = ".mini-cart-link")
    private WebElement cartButton;
    @FindBy(xpath = "//ul[@id='dm-primary-nav']//*[text()='WOMEN']")
    private WebElement womensCategoryButton;
    @FindBy(xpath = "//span[@class='bag-count']")
    private WebElement cartItemsCounter;
    @FindBy(xpath = "//button[@id='country-modal-submit']")
    private WebElement confirmButton;
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookieButton;
    @FindBy(xpath = "//a[@data-qa-automation='header-link-storefinder']")
    private WebElement storeLocatorButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(String searchParameter) {
        searchField.click();
        searchField.sendKeys(searchParameter);
        searchField.sendKeys(Keys.ENTER);
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public WebElement getWomensCategoryButton() {
        return womensCategoryButton;
    }

    public WebElement getCartItemsCounter() {
        return cartItemsCounter;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

    public WebElement getAcceptCookieButton() {
        return acceptCookieButton;
    }

    public WebElement getStoreLocatorButton() {
        return storeLocatorButton;
    }
}
