package org.example.portio;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class PortioTest extends TestEnvironment{
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
    @Epic("Technical functionalities")
    @Story("Login")
    @Test
    public void testLogin() {
        loginPage.login();
        Allure.addAttachment("Successful login", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(homePage.isPortioLogoVisible());
    }
    @Epic("Technical functionalities")
    @Story("Login")
    @Test
    public void testLoginWithMissingUsername() {
        String missingUsername = "";
        String password = "kispal123";
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.login2(missingUsername, password);
        Allure.addAttachment("Failed login with missing username", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(Pages.LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Login")
    @Test
    public void testLoginWithWrongPassword() {
        String username = "lovasia";
        String wrongPassword = "kispal";
        String expectedMessage = "Username or Password\n" + "is not correct!";
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.login2(username, wrongPassword);
        Allure.addAttachment("Failed login with wrong password", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertTrue(loginPage.isAlertMessageDisplayed());
        Assertions.assertEquals(expectedMessage, loginPage.getAlertMessage());
    }
    @Epic("Technical functionalities")
    @Story("Login")
    @Test
    public void testLoginWithEnter() {
        String username = "lovasia";
        String password = "kispal123";
        loginPage.loginWithEnter(username, password);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(homePage.isPortioLogoVisible());
    }
    @Epic("Technical functionalities")
    @Story("Login")
    @Test
    public void testLoginWithoutRegistration() {
        String username = "tesztelek";
        String password = "teszt";
        String expectedMessage = "Username or Password\n" + "is not correct!";
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.login2(username, password);
        Assertions.assertTrue(loginPage.isAlertMessageDisplayed());
        Assertions.assertEquals(expectedMessage, loginPage.getAlertMessage());
    }
    @Epic("Technical functionalities")
    @Story("Logout")
    @Test
    public void testLogout() {
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Assertions.assertTrue(homePage.isPortioLogoVisible());
        homePage.logout();
        Assertions.assertTrue(loginPage.isLoginButtonVisible());
        Assertions.assertEquals(Pages.LOGOUT_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Profile")
    @Test
    public void testSetProfile() {
        String username = "teszteszter";
        String password = "teszt";
        String name ="Teszt Eszti";
        String bio ="female";
        String phone ="06301112233";
        registerPage.registration();
        registerPage.clickLoginButton();
        loginPage.login2(username, password);
        Assertions.assertTrue(homePage.isPortioLogoVisible());
        homePage.clickProfile();
        profilePage.setProfile(name, bio, phone);
        Allure.addAttachment("Set profile successfully", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals("Profile Edited!", profilePage.getProfileMessage());
    }
    @Epic("Technical functionalities")
    @Story("Profile")
    @Test
    public void testProfileUsername() {
        String username = "teszteszter";
        String password = "teszt";
        String name ="Teszt Eszti";
        String bio ="female";
        String phone ="06301112233";
        registerPage.registration();
        registerPage.clickLoginButton();
        loginPage.login2(username, password);
        Assertions.assertTrue(homePage.isPortioLogoVisible());
        homePage.clickProfile();
        profilePage.setProfile(name, bio, phone);
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
        Assertions.assertTrue(homePage.isPortioLogoVisible());
        homePage.clickProfile();
        profilePage.deleteAccount();
        loginPage.login2(username, password);
        Allure.addAttachment("Account deleted, user can't log in", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertTrue(loginPage.isAlertMessageDisplayed());
        Assertions.assertEquals(expectedMessage, loginPage.getAlertMessage());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testNavigateToContactPageWithHireMeButton() {
        loginPage.login();
        Assertions.assertTrue(homePage.isPortioLogoVisible());
        homePage.navigateToContactPageWithHireMeButton();
        Assertions.assertTrue(contactPage.isContactMeTextVisible());
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testNavigateToContactPageWithContactMeButton() {
        loginPage.login();
        Assertions.assertTrue(homePage.isPortioLogoVisible());
        homePage.navigateToContactPageWithContactButton();
        Assertions.assertTrue(contactPage.isContactMeTextVisible());
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Content functionalities")
    @Story("Forms")
    @Test
    public void testContactForm() {
        String name = "Kis Pal";
        String email = "kispal@gmail.com";
        String message = "Let's work together";
        loginPage.login();
        Assertions.assertTrue(homePage.isPortioLogoVisible());
        homePage.navigateToContactPageWithContactButton();
        contactPage.fillContactMeForm(name, email, message);
        contactPage.checkCheckbox();
        contactPage.sendMessage();
        Allure.addAttachment("Sending contact form is unsuccessful", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals("Message was sent successfully", contactPage.getMessageStatusText());
    }
    @Epic("Content functionalities")
    @Story("Forms")
    @Test
    public void testContactFormWithoutCheckingCheckbox() {
        String name = "Kis Pal";
        String email = "kispal@gmail.com";
        String message = "Let's work together";
        String warningMessage = "Kérjük, jelölje be ezt a jelölőnégyzetet, ha tovább kíván haladni.";
        loginPage.login();
        Assertions.assertTrue(homePage.isPortioLogoVisible());
        homePage.navigateToContactPageWithContactButton();
        Assertions.assertTrue(contactPage.isContactMeTextVisible());
        contactPage.fillContactMeForm(name, email, message);
        contactPage.sendMessage();
        Allure.addAttachment("Warning message in case not checking checkbox", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        //Assertions.assertEquals(warningMessage, contactPage.getWarningMessage());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testNavigateFromContactPageBackToHomePage() {
        loginPage.login();
        Assertions.assertTrue(homePage.isPortioLogoVisible());
        homePage.navigateToContactPageWithContactButton();
        Assertions.assertTrue(contactPage.isContactMeTextVisible());
        contactPage.getBackToHomePage();
        Assertions.assertTrue(homePage.isPortioLogoVisible());
    }
}
