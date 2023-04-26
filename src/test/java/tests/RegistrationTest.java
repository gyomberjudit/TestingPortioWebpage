package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

@Epic("Entry functionalities")
public class RegistrationTest extends BaseTest {

    @DisplayName("TC3 - Registration")
    @Description("Registration with right credentials")
    @Story("Registration")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("registration")
    @Test
    public void testRegistration() {
        String username = "teszteszter";
        String password = "teszt";
        String email = "teszteszter5@gmail.com";
        String expectedMessage = "User registered!";

        registerPage.navigate();
        registerPage.acceptTerms();
        registerPage.clickButtonRegister();
        registerPage.inputUsername(username);
        registerPage.inputPassword(password);
        registerPage.inputEmail(email);
        registerPage.clickButtonRegister2();
        boolean userRegistered = registerPage.userRegistered();
        String actualMessage = registerPage.registeredMessage();
        addAttachment("Success message after successful registration");

        Assertions.assertTrue(userRegistered);
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("TC4 - Registration, Wrong password")
    @Description("Registration using wrong password")
    @Story("Registration")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("registration")
    @Tag("wrongData")
    @Test
    public void testRegistrationWithMissingPassword() {
        String username = "teszteszter";
        String missingPassword = "";
        String email = "teszteszter5@gmail.com";

        registerPage.navigate();
        registerPage.acceptTerms();
        registerPage.clickButtonRegister();
        registerPage.inputUsername(username);
        registerPage.inputPassword(missingPassword);
        registerPage.inputEmail(email);
        registerPage.clickButtonRegister2();
        boolean userRegistered = registerPage.userRegistered();
        addAttachment("Successful registration despite of missing password");

        Assertions.assertFalse(userRegistered);
    }

    @DisplayName("TC5 - Registration, Wrong email")
    @Description("Registration using wrong email")
    @Story("Registration")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("registration")
    @Tag("wrongData")
    @Test
    public void testRegistrationWithWrongEmail() {
        String username = "teszteszter";
        String password = "teszt";
        String wrongEmail = "tesztesztergmail";

        registerPage.navigate();
        registerPage.acceptTerms();
        registerPage.clickButtonRegister();
        registerPage.inputUsername(username);
        registerPage.inputPassword(password);
        registerPage.inputEmail(wrongEmail);
        registerPage.clickButtonRegister2();
        boolean userRegistered = registerPage.userRegistered();
        addAttachment("Successful registration despite of wrong email");

        Assertions.assertFalse(userRegistered);
    }
}
