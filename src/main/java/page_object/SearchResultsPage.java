package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(css = ".active")
    private WebElement searchTittle;
    @FindBys(@FindBy(css = ".product__list__item"))
    private List<WebElement> searchResultsList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchTittle() {
        return searchTittle;
    }

    public List<WebElement> getSearchResultsList() {
        return searchResultsList;
    }
}
