
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ExpensePage;
import pages.HomePage;
import pages.TransactionsPage;

public class ExpenseTest extends BaseTest {
    ExpensePage expensePage;
    HomePage homePage;

    @BeforeClass
    public void setup() {
        expensePage = new ExpensePage(driver);
        homePage = new HomePage(driver);
    }

    @Test()
    public void createExpenseWithCalculatorTest() {
        //data
        String category = "Clothes";
        String note = "Text";

        homePage.tapOnExpenseButton();
        expensePage.multiplyFiveTimesEight();
        String amount = expensePage.getAmount();
        expensePage.enterNote(note);
        expensePage.selectCategory(category);
        Assert.assertEquals(category, homePage.getCategoryNameFromSnackbar());
        Assert.assertEquals(("$" + amount), homePage.getAmountFromSnackbar());
        TransactionsPage transactionsPage = homePage.tapOnBalanceAmount();
        transactionsPage.tapToExpandCategory();
        Assert.assertEquals(note, transactionsPage.getTransactionText());
    }

    @Test()
    public void quickExpenseCategoryNamingTest() {
        String [] categories = {
                "ADD 'FOOD'",
                "ADD 'CAR'",
                "ADD 'TRANSPORT'",
                "ADD 'ENTERTAINMENT'",
                "ADD 'HOUSE'",
                "ADD 'TAXI'",
                "ADD 'EATING OUT'",
                "ADD 'CLOTHES'", "ADD 'TOILETRY'",
                "ADD 'SPORTS'",
                "ADD 'HEALTH'",
                "ADD 'COMMUNICATIONS'"
            };
        Assert.assertEquals(homePage.getArrayFromCategoryNames(), categories);
    }

    @Test(enabled = false)
    public void addExpenseWithQuickCategory() {
        /*
         * TODO
         * Choose a category on home page
         * Enter amount and Note
         * Tap on Add %categoryName%
         * Assert amount is added
         */
    }
}
