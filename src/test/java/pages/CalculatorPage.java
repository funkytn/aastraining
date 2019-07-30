package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage {
    private WebDriver pageDriver;

    public CalculatorPage(WebDriver driver) {
        this.pageDriver = driver;
    }

    public void selectFund(String fundToSelect) {

        new Select(pageDriver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToSelect);
    }

    public void enterOneTimeInvestment(String amountToEnter) {
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).clear();
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(amountToEnter);
    }

    public void enterYears(String yearsToEnter) {
        pageDriver.findElement(By.id("yearsInput")).clear();
        pageDriver.findElement(By.id("yearsInput")).sendKeys(yearsToEnter);
    }

    public void selectEmail(String emailToSelect) {
        pageDriver.findElement(By.id("emailInput")).clear();
        pageDriver.findElement(By.id("emailInput")).sendKeys(emailToSelect);
    }

    public String getTotalIncome(){
        return pageDriver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
    }
    public String getInterestIncome() {
        return pageDriver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
    }
    public String getRisk() {
        return pageDriver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
    }

}
