import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CalculatorPage;
import pages.HomePage;
import pages.TransferPage;

public class TransferTest extends BaseTest{
    CalculatorPage calculatorPage;
    TransferPage transferPage;
    HomePage homePage;

    @BeforeClass
    public void setup() {
        calculatorPage = new CalculatorPage(driver);
        transferPage = new TransferPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(groups = {"regression"})
    public void transferCashToCardTest() {
        String noteText = "transfer_one";
        homePage.tapOnTransferButton();
        calculatorPage.enterNote(noteText);
        transferPage.choosePaymentCardFromDropDown();
        transferPage.chooseCashFromDropDown();
        transferPage.tapOnCalculatorButton();
        calculatorPage.enterSevenHundred();
        transferPage.tapOnAddTransferButton();
        Assert.assertEquals(homePage.getTextFromSnackbar(), "Transfer was added");
    }

    @Test(groups = {"regression"})
    public void transferFromCardToCashTest() {
        String noteText = "transfer_two";
        homePage.tapOnTransferButton();
        calculatorPage.enterNote(noteText);
        transferPage.tapOnCalculatorButton();
        calculatorPage.multiplyFiveTimesEight();
        transferPage.tapOnAddTransferButton();
        Assert.assertEquals(homePage.getTextFromSnackbar(), "Transfer was added");
    }

    @Test(groups = {"regression"})
    public void chooseDateForTransferTest() {
        int date = 14;
        homePage.tapOnTransferButton();
        transferPage.tapOnDatePicker();
        transferPage.selectDate(date);
        transferPage.tapOnConfirmButton();
        Assert.assertTrue(transferPage.dateContainsSelectedDate(date));
    }
}
