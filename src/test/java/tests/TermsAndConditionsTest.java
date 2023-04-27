package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

@Epic("Entry functionalities")
public class TermsAndConditionsTest extends BaseTest {

    @DisplayName("TC1 - Accept terms")
    @Description("Accept terms by clicking on OK button before Registration")
    @Story("Terms and Conditions")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("acceptTerms")
    @Test
    public void testAcceptTerms() {
        loginPage.navigate();
        boolean textOfTermsVisible = loginPage.isTermsAndConditionsTextDisplayed();
        addAttachment("Terms and Conditions text should be accepted before moving on");

        Assertions.assertTrue(textOfTermsVisible);

        loginPage.acceptTerms();
        boolean loginButtonVisible = loginPage.isLoginButtonDisplayed();
        addAttachment("Navigate to LoginPage after accepting terms");

        Assertions.assertTrue(loginButtonVisible);

    }

    @DisplayName("TC2 - Refuse accepting terms")
    @Description("Refuse accepting terms by clicking on Close Icon")
    @Story("Terms and Conditions")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("refuseTerms")
    @Test
    public void testNotAcceptTerms() {
        loginPage.navigate();
        boolean textOfTermsVisible = loginPage.isTermsAndConditionsTextDisplayed();
        addAttachment("Terms and Conditions text should be accepted before moving on");

        Assertions.assertTrue(textOfTermsVisible);

        loginPage.clickOnCloseIcon();
        boolean loginButtonVisible = loginPage.isLoginButtonDisplayed();
        addAttachment("Navigate to LoginPage after NOT accepting terms");

        Assertions.assertFalse(loginButtonVisible);

    }
}
