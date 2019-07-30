package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
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
        //vytvorit novy saving request
        driver.findElement(By.cssSelector("button.btn-block")).click();
        //overim ze total income sa zobrazi v requeste

        Assert.assertEquals(
                calculatedIncome,
                driver.findElement(By.xpath("//ul[contains(@class,'saving-list')]/li//div[contains(@class,'amounts')]/p/span")).getText());

    }
}
