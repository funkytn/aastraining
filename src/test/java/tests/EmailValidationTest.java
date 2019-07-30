package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CalculatorPage;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmailValidationTest extends TestBase {

    @Test
    public void itShouldDisplayErrorWhenEmailIsInvalid() throws FileNotFoundException {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        //zadam zly email
        for (String invalidEmail : readInvalidEmails()) {
            calculatorPage.selectEmail(invalidEmail);
            Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='emailInput']]"))
                    .getAttribute("class")
                    .contains("error"));
        }
    }

    private List<String> readInvalidEmails() throws FileNotFoundException {
        FileReader invalidEmailsTxt = new FileReader(new File("src/test/resources/invalid_emails.txt"));
        List<String> invalidEmailList = new ArrayList<>();
        invalidEmailList = new BufferedReader(invalidEmailsTxt).lines().collect(Collectors.toList());
        return invalidEmailList;
    }
}
