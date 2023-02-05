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
    public void googleSearchTest() throws InterruptedException {
        getDriver().get(URL);

        GoogleStartPageObject googleStartPage = new GoogleStartPageObject(getDriver());
        googleStartPage.runSearchQuery(searchQuery);

        GoogleSearchResultsPageObject searchResultsPage = new GoogleSearchResultsPageObject(getDriver());
        int actualSearchResult = searchResultsPage.findValidSearchResult();
        Assert.assertEquals(actualSearchResult, minExpectedValidSearchResults);
    }

    /*@Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
    public void simpleWebTest() throws InterruptedException {
        getDriver().get("http://iana.org"); // open IANA homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // Check IANA homepage title
        assert ((WebDriver) getDriver())
        .getTitle().equals("Internet Assigned Numbers Authority") : "This is not IANA homepage";

        // Log that test finished
        System.out.println("Site opening done");
    }*/

}
