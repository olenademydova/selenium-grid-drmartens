package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class FindStorePage extends BasePage {
    @FindBy(id = "storelocator-query")
    private WebElement storeLocatorQuery;
    @FindBys(@FindBy(css = ".entry__address"))
    private List<WebElement> storeAddressList;
    @FindBy(xpath = "//div[@class='info__address']//div[1]")
    private WebElement broadwayAddress;

    public FindStorePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getStoreLocatorQuery() {
        return storeLocatorQuery;
    }

    public List<WebElement> getStoreAddressList() {
        return storeAddressList;
    }

    public WebElement getBroadwayAddress() {
        return broadwayAddress;
    }
}
