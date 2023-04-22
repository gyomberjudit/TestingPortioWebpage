package org.example.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Technical functionalities")
public class RegisterPageTest extends BaseTest {

    @DisplayName("Accepting terms")
    @Description("Accept terms by clicking on OK button before Registration")
    @Story("Accepting terms")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Registration")
    @Test
    public void testAcceptTerms() {
        loginPage.navigate();
        addAttachment("Terms and Conditions text should be accepted before moving on");
        boolean textOfTermsVisible = loginPage.isTermsAndConditionsTextDisplayed();

        Assertions.assertTrue(textOfTermsVisible);

        loginPage.acceptTerms();
        boolean registerButtonVisible = loginPage.isRegisterButtonDisplayed();

        Assertions.assertTrue(registerButtonVisible);
        addAttachment("Navigate to LoginPage after accepting terms");
    }

    @DisplayName("Refusing accepting terms")
    @Description("Close terms - not accepting it - by clicking on Close Icon")
    @Story("Close terms instead of accepting")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Registration")
    @Test
    public void testNotAcceptTerms() {
        loginPage.navigate();
        addAttachment("Terms and Conditions text should be accepted before moving on");
        boolean textOfTermsVisible = loginPage.isTermsAndConditionsTextDisplayed();

        Assertions.assertTrue(textOfTermsVisible);

        loginPage.clickOnCloseIcon();
        boolean registerButtonVisible = loginPage.isRegisterButtonDisplayed();

        Assertions.assertFalse(registerButtonVisible);
        addAttachment("Navigate to LoginPage after NOT accepting terms");
    }

    @DisplayName("Registration")
    @Description("Registration with right credentials")
    @Story("Registration")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Registration")
    @Test
    public void testRegistration() {
        registerPage.registration();
        boolean userRegistered = registerPage.userRegistered();
        String expectedMessage = "User registered!";
        String actualMessage = registerPage.registeredMessage();

        Assertions.assertTrue(userRegistered);
        Assertions.assertEquals(expectedMessage, actualMessage);
        addAttachment("Successful registration");
    }

    @DisplayName("Registration - Wrong password")
    @Description("Registration using wrong password")
    @Story("Registration")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Registration")
    @Test
    public void testRegistrationWithMissingPassword() {
        String username = "teszteszter";
        String missingPassword = "";
        String email = "teszteszter5@gmail.com";
        registerPage.wrongRegistration(username, missingPassword, email);
        boolean userRegistered = registerPage.userRegistered();

        Assertions.assertFalse(userRegistered);
        addAttachment("Successful registration despite of missing password");
    }

    @DisplayName("Registration - Wrong email")
    @Description("Registration using wrong email")
    @Story("Registration")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Registration")
    @Test
    public void testRegistrationWithWrongEmail() {
        String username = "teszteszter";
        String password = "teszt";
        String wrongEmail = "tesztesztergmail";
        registerPage.wrongRegistration(username, password, wrongEmail);
        boolean userRegistered = registerPage.userRegistered();

        Assertions.assertFalse(userRegistered);
        addAttachment("Successful registration despite of wrong email");
    }
}
