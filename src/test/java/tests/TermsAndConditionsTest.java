package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

public class TermsAndConditionsTest extends BaseTest {

    @DisplayName("Accept terms")
    @Description("Accept terms by clicking on OK button before Registration")
    @Story("Terms and Conditions")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("acceptTerms")
    @Test
    public void testAcceptTerms() {
        loginPage.navigate();
        addAttachment("Terms and Conditions text should be accepted before moving on");
        boolean textOfTermsVisible = loginPage.isTermsAndConditionsTextDisplayed();

        Assertions.assertTrue(textOfTermsVisible);

        loginPage.acceptTerms();
        boolean registerButtonVisible = loginPage.isRegisterButtonDisplayed();
        addAttachment("Navigate to LoginPage after accepting terms");

        Assertions.assertTrue(registerButtonVisible);

    }

    @DisplayName("Refuse accepting terms")
    @Description("Refuse accepting terms by clicking on Close Icon")
    @Story("Terms and Conditions")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("refuseTerms")
    @Test
    public void testNotAcceptTerms() {
        loginPage.navigate();
        addAttachment("Terms and Conditions text should be accepted before moving on");
        boolean textOfTermsVisible = loginPage.isTermsAndConditionsTextDisplayed();

        Assertions.assertTrue(textOfTermsVisible);

        loginPage.clickOnCloseIcon();
        boolean registerButtonVisible = loginPage.isRegisterButtonDisplayed();
        addAttachment("Navigate to LoginPage after NOT accepting terms");

        Assertions.assertFalse(registerButtonVisible);

    }
}
