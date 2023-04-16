package org.example.portio;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class ProfilePageTest extends BaseTest{
    @Epic("Technical functionalities")
    @Story("Profile")
    @Test
    public void testProfileUsername() {
        testSetProfile();
        Assertions.assertEquals("Profile Edited!", profilePage.getProfileMessage());
        homePage.navigate();
        Allure.addAttachment("Username is not displayed after profile edited", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals("Teszt Eszti", homePage.getProfileName());
    }
    @Epic("Technical functionalities")
    @Story("Profile")
    @Test
    public void testDeleteAccount() {
        String username = "teszteszter";
        String password = "teszt";
        String expectedMessage = "Username or Password\n" + "is not correct!";
        registerPage.registration();
        registerPage.clickLoginButton();
        loginPage.login2(username, password);
        Assertions.assertTrue(homePage.isPortioLogoDisplayed());
        homePage.clickProfile();
        profilePage.deleteAccount();
        loginPage.login2(username, password);
        Allure.addAttachment("Account deleted, user can't log in", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertTrue(loginPage.isAlertMessageDisplayed());
        Assertions.assertEquals(expectedMessage, loginPage.getAlertMessage());
    }
}
