package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CalculatorPage;

public class NewSavingRequestTest extends TestBase {

    @Test
    public void itShouldDisplayTotalIncomeInNewRequest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Tom & Jerry corp");
        calculatorPage.enterOneTimeInvestment("1500");
        calculatorPage.enterYears("2");
        calculatorPage.selectEmail("info@furbo.sk");
        //precitat zo stranky total income
        String calculatedIncome = calculatorPage.getTotalIncome();
        //overim ze total income sa zobrazi v requeste
        calculatorPage.submitRequest();

        Assert.assertEquals(
                calculatedIncome,
                calculatorPage.getFirstSavingDetail()
                        .findElement(By.cssSelector("div.amounts > p > span")).getText());

    }




    @Test
    public void itShouldDisplayFundInNewRequest() {
        String fundToSelect = "Tom & Jerry corp";
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund(fundToSelect);
        calculatorPage.enterOneTimeInvestment("1500");
        calculatorPage.enterYears("2");
        calculatorPage.selectEmail("info@furbo.sk");
        //click on apply button
        calculatorPage.submitRequest();
        //overit zobrazeny fond
        //vytiahnem si fond zo stranky a ulozim do premennej
        String displayedFund = calculatorPage.getFirstSavingDetail()
                .findElement(By.cssSelector("p.fund-description")).getText();
        //porovnam zadany fond a ten, ktory som si vytiahol zo stranky
        Assert.assertEquals(fundToSelect, displayedFund);


    }

}
