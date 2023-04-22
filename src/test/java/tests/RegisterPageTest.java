package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

@Epic("Technical functionalities")
public class RegisterPageTest extends BaseTest {

    @DisplayName("Accepting terms")
    @Description("Accept terms by clicking on OK button before Registration")
    @Story("Terms and Conditions")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Accept terms")
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

    @DisplayName("Refusing accepting terms")
    @Description("Close terms - not accepting it - by clicking on Close Icon")
    @Story("Terms and Conditions")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Not accept terms")
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

    @DisplayName("Registration")
    @Description("Registration with right credentials")
    @Story("Registration")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Registration")
    @Tag("Successful")
    @Test
    public void testRegistration() {
        registerPage.registration();
        boolean userRegistered = registerPage.userRegistered();
        String expectedMessage = "User registered!";
        String actualMessage = registerPage.registeredMessage();
        addAttachment("Success message after successful registration");

        Assertions.assertTrue(userRegistered);
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("Registration - Wrong password")
    @Description("Registration using wrong password")
    @Story("Registration")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Registration")
    @Tag("Wrong")
    @Test
    public void testRegistrationWithMissingPassword() {
        String username = "teszteszter";
        String missingPassword = "";
        String email = "teszteszter5@gmail.com";
        registerPage.wrongRegistration(username, missingPassword, email);
        boolean userRegistered = registerPage.userRegistered();
        addAttachment("Successful registration despite of missing password");

        Assertions.assertFalse(userRegistered);
    }

    @DisplayName("Registration - Wrong email")
    @Description("Registration using wrong email")
    @Story("Registration")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Registration")
    @Tag("Wrong")
    @Test
    public void testRegistrationWithWrongEmail() {
        String username = "teszteszter";
        String password = "teszt";
        String wrongEmail = "tesztesztergmail";
        registerPage.wrongRegistration(username, password, wrongEmail);
        boolean userRegistered = registerPage.userRegistered();
        addAttachment("Successful registration despite of wrong email");

        Assertions.assertFalse(userRegistered);
    }
}
