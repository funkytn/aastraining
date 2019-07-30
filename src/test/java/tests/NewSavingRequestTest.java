package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CalculatorPage;
import utils.MathUtils;

public class NewSavingRequestTest extends TestBase{

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

    @Test
    public void itShouldDisplayTwentyRequests() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        for (int i = 0; i < 20; i++) {
            calculatorPage.selectFund("Tom & Jerry corp");
            calculatorPage.enterOneTimeInvestment(String.valueOf(MathUtils.getRandomNumberInRange(1000,10000)));
            calculatorPage.enterYears(String.valueOf(MathUtils.getRandomNumberInRange(1,50)));
            calculatorPage.selectEmail("info@furbo.sk");
            //submit
            calculatorPage.submitRequest();

        }
        driver.findElements(By.cssSelector("ul.saving-list > li > div.saving-detail"));
        Assert.assertEquals(20,driver.findElements(By.cssSelector("ul.saving-list > li > div.saving-detail")).size());
    }
}
