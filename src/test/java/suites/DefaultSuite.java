package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tests.CalculationTest;
import tests.SavingsCalculatorTest;
import tests.NewSavingRequestTest;
import tests.EmailValidationTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({

    CalculationTest.class,
    SavingsCalculatorTest.class,
    NewSavingRequestTest.class,
    EmailValidationTest.class,



})

public class DefaultSuite {
}
