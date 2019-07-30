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

public class SavingsCalculatorTest extends TestBase {

    @Test
    public void itShouldDisplayTitle() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Tom & Jerry corp");
        Assert.assertEquals("Savings Calculator", driver.findElement(By.cssSelector("h1")).getText());
    }

    @Test
    public void itShouldDisableApplyButtonOnPageOpen() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Tom & Jerry corp");
        Assert.assertFalse(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }

    @Test
    public void itShouldEnabeAppplyButton() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Tom & Jerry corp");
        //1.vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Fellowship investment group");
        //2.zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        //3.zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("2");
        //4.zadat email
        driver.findElement(By.id("emailInput")).sendKeys("info@furbo.sk");
        //5.overit button
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }

    @Test
    public void itShouldNotSelectAnyFundOnPageOpen() {
        new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText();
        System.out.println(new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText());
        Assert.assertEquals("Select your fund",
                new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText());
    }

}
