import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class SearchTest extends BaseTest {
    HomePage homePage;
    SearchPage searchPage;

    @BeforeClass
    public void setup() {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test ()
    public void searchKeywordTest() {
        homePage.tapOnSearchButton();
        searchPage.enterSearchText("non_exist");
        Assert.assertTrue(searchPage.emptyResultViewIsShown());
    }

    @Test(enabled = false)
    public void searchSuggestionTest() {
        /*
         * TODO
         * Navigate to search component
         * Tap on any letter which will bring suggestion
         * Assert suggestion list
         */
    }

    @Test(enabled = false)
    public void searchExistingKeyword() {
        /*
         * TODO
         * Enter any record with a note
         * Navigate to search component
         * Perform search matching entered note
         * Assert that note is equal with search result
         */
    }

    @Test(enabled = false)
    public void backToHomeButtonTest() {
        /*
         * TODO
         * Navigate to search component
         * Tap on back button
         * Assert that component changed to home bar
         */
    }
}
