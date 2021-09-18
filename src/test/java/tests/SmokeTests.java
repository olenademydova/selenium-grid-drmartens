package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest {
    private final String searchParameter = "1460";
    private final String addToCartSearchParameter = "8065 Smooth Leather Mary Jane Shoes";

    @Test
    public void searchByKeyword() {
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().searchByKeyword(searchParameter);
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitVisibilityOfElement(15, getSearchResultsPage().getSearchTittle());
        assertTrue(getSearchResultsPage().getSearchTittle().getText().contains(format("SEARCH RESULTS FOR '%s'", searchParameter)));
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        Assert.assertTrue(getSearchResultsPage().getSearchResultsList()
                .stream()
                .anyMatch(result -> result.getText().contains(searchParameter))
        );
    }

    @Test
    public void checkStoreLocation() {
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().getStoreLocatorButton().click();
        getFindStorePage().getStoreLocatorQuery().click();
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getFindStorePage().getStoreLocatorQuery().sendKeys("New York");
        getFindStorePage().getStoreLocatorQuery().sendKeys(Keys.ENTER);
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getFindStorePage().getStoreAddressList().get(1).click();
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        assertTrue(getFindStorePage().getBroadwayAddress().getText().contains("868 Broadway"));
    }

    @Test
    public void checkAddToCart() {
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().searchByKeyword(addToCartSearchParameter);
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getSearchResultsPage().getSearchResultsList().get(1).click();
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getProductPage().getAvailableSizeButtons().get(0).click();
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getProductPage().getAddToCartButton().click();
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        assertTrue(getProductPage().getAddToCartPopup().getText().contains("Added to Your Shopping Cart"));
        assertTrue(getProductPage().getAddToCartPopup().getText().contains(addToCartSearchParameter));
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getProductPage().getContinueToShoppingButton().click();
        getHomePage().waitForPageLoadingComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        assertEquals(getHomePage().getCartItemsCounter().getText(), "1");
    }
}
