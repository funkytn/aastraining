package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculationTest {

    WebDriver driver;


    @Test
    public void itShouldCalculateTotalIncome() {

        //1. vybrat fond, zadat sumu, roky, email
        //1.vybrat fond
        selectFund("Tom & Jerry corp");
        //2.zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        //3.zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("2");
        //4.zadat email
        driver.findElement(By.id("emailInput")).sendKeys("info@furbo.sk");
        Assert.assertFalse(getTotalIncome().isEmpty());

    }
    private String getTotalIncome(){
        return driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
        }
    private String getInterestIncome() {
        return driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
    }
    private String getRisk() {
        return driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
    }




    @Test
    public void itShouldCalculateInterestIncome() {

        //1. vybrat fond, zadat sumu, roky, email

        //1.vybrat fond
        selectFund("Tom & Jerry corp");
        //2.zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        //3.zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("2");
        //4.zadat email
        driver.findElement(By.id("emailInput")).sendKeys("info@furbo.sk");
        //2. overit, ze interest income nie je prazdny
        Assert.assertFalse(getInterestIncome().isEmpty());
    }


    @Test
    public void itShouldCalculateRisk() {

        //1. vybrat fond, zadat sumu, roky, email

        //1.vybrat fond
        selectFund("Tom & Jerry corp");
        //2.zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        //3.zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("2");
        //4.zadat email
        driver.findElement(By.id("emailInput")).sendKeys("info@furbo.sk");
        //2. overit, ze Risk nie je prazdny
        Assert.assertFalse(getRisk().isEmpty());

    }


    @Test
    public void itShouldCalculateTotalIncomeForEachFund() {

        String[] arrayOfFunds = {"Tom & Jerry corp", "Batman's Cave Development", "McDuck's safe"};
        for (String arrayOfFund : arrayOfFunds) {
            selectFund(arrayOfFund);
            enterOneTimeInvestment("1500");
            enterYears("2");
            selectEmail("info@furbo.sk");


        }

    }

    private void selectFund(String fundToSelect) {
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToSelect);
    }

    private void enterOneTimeInvestment(String amountToEnter) {
        driver.findElement(By.id("oneTimeInvestmentInput")).clear();
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(amountToEnter);
    }

    private void enterYears(String yearsToEnter) {
        driver.findElement(By.id("yearsInput")).clear();
        driver.findElement(By.id("yearsInput")).sendKeys(yearsToEnter);
    }

    private void selectEmail(String emailToSelect) {
        driver.findElement(By.id("emailInput")).clear();
        driver.findElement(By.id("emailInput")).sendKeys(emailToSelect);
    }



}
