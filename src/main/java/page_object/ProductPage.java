package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ProductPage extends BasePage {
    @FindBys(@FindBy(className = "stock-inStock"))
    private List<WebElement> availableSizeButtons;
    @FindBy(xpath = "//button[@id='addToCartButton']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@id='colorbox']")
    private WebElement addToCartPopup;
    @FindBy(css = ".js-mini-cart-close-button")
    private WebElement continueToShoppingButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAvailableSizeButtons() {
        return availableSizeButtons;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getAddToCartPopup() {
        return addToCartPopup;
    }

    public WebElement getContinueToShoppingButton() {
        return continueToShoppingButton;
    }
}
