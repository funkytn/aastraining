package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CalculatorPage;

public class EmailValidationTest extends TestBase {

    @Test
    public void itShouldDisplayErrorWhenEmailIsInvalid() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectEmail("asfasfsadf");
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='emailInput']]")).getAttribute("class").contains("error"));

    }
}
