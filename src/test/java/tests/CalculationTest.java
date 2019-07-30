package tests;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.CalculatorPage;

public class CalculationTest extends TestBase {


    @Test
    public void itShouldCalculateTotalIncome() {
        //1. vybrat fond, zadat sumu, roky, email
        //1.vybrat fond
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Tom & Jerry corp");
        //2.zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        //3.zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("2");
        //4.zadat email
        driver.findElement(By.id("emailInput")).sendKeys("info@furbo.sk");
        Assert.assertFalse(calculatorPage.getTotalIncome().isEmpty());

    }





    @Test
    public void itShouldCalculateInterestIncome() {
        //1. vybrat fond, zadat sumu, roky, email

        //1.vybrat fond
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Tom & Jerry corp");
        //2.zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        //3.zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("2");
        //4.zadat email
        driver.findElement(By.id("emailInput")).sendKeys("info@furbo.sk");
        //2. overit, ze interest income nie je prazdny
        Assert.assertFalse(calculatorPage.getInterestIncome().isEmpty());
    }


    @Test
    public void itShouldCalculateRisk() {
        //1. vybrat fond, zadat sumu, roky, email

        //1.vybrat fond
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Tom & Jerry corp");
        //2.zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        //3.zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("2");
        //4.zadat email
        driver.findElement(By.id("emailInput")).sendKeys("info@furbo.sk");
        //2. overit, ze Risk nie je prazdny
        Assert.assertFalse(calculatorPage.getRisk().isEmpty());

    }


    @Test
    public void itShouldCalculateTotalIncomeForEachFund() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        String[] arrayOfFunds = {"Tom & Jerry corp", "Batman's Cave Development", "McDuck's safe"};
        for (String arrayOfFund : arrayOfFunds) {

            calculatorPage.selectFund("Tom & Jerry corp");
            calculatorPage.enterOneTimeInvestment("1500");
            calculatorPage.enterYears("2");
            calculatorPage.selectEmail("info@furbo.sk");

        }

    }




}
