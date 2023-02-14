package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.webpageobjects.GoogleSearchResultsPageObject;
import pageobjects.webpageobjects.GoogleStartPageObject;
import setup.BaseTest;

public class WebMobileTests extends BaseTest {

    private static final String URL = "https://www.google.com/";
    private String searchQuery = "EPAM";
    private int minExpectedValidSearchResults = 1;

    @Test(groups = {"web"}, description = "Make sure that relevant values are displayed on Google search page")
    public void googleSearchTest() {

        //open Google page
        getDriver().get(URL);

        //run search query
        GoogleStartPageObject googleStartPage = new GoogleStartPageObject(getDriver());
        googleStartPage.runSearchQuery(searchQuery);

        //Verify that at least one relevant search result is displayed
        GoogleSearchResultsPageObject searchResultsPage = new GoogleSearchResultsPageObject(getDriver());
        int actualSearchResult = searchResultsPage.findValidSearchResult();
        Assert.assertEquals(actualSearchResult, minExpectedValidSearchResults);

    }

}
