package org.example.portio;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class RegisterPageTest extends TestEnvironment{
    @Epic("Technical functionalities")
    @Story("Registration")
    @Test
    public void testRegistration() {
        registerPage.registration();
        Allure.addAttachment("Successful registration", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertTrue(registerPage.userRegistered());
        Assertions.assertEquals("User registered!", registerPage.registeredMessage());
    }
    @Epic("Technical functionalities")
    @Story("Registration")
    @Test
    public void testRegistrationWithMissingPassword() {
        String username = "teszteszter";
        String missingPassword = "";
        String email = "teszteszter5@gmail.com";
        registerPage.wrongRegistration(username, missingPassword, email);
        Allure.addAttachment("Successful registration with missing password", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertFalse(registerPage.userRegistered());
    }
    @Epic("Technical functionalities")
    @Story("Registration")
    @Test
    public void testRegistrationWithWrongEmail() {
        String username = "teszteszter";
        String password = "teszt";
        String wrongEmail = "tesztesztergmail";
        registerPage.wrongRegistration(username, password, wrongEmail);
        Allure.addAttachment("Successful regidtration with wrong email", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertFalse(registerPage.userRegistered());
    }
}
