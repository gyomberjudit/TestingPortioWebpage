package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

@Epic("Entry functionalities")
public class RegistrationTest extends BaseTest {

    @DisplayName("Registration")
    @Description("Registration with right credentials")
    @Story("Registration")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("registration")
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
    @Tag("registration")
    @Tag("wrongData")
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
    @Tag("registration")
    @Tag("wrongData")
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
