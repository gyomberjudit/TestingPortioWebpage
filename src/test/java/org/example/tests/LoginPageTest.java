package org.example.tests;

import io.qameta.allure.*;
import org.example.pages.Pages;
import org.junit.jupiter.api.*;

@Epic("Technical functionalities")
public class LoginPageTest extends BaseTest {

    @DisplayName("Login")
    @Description("Login with right credentials, accepting terms")
    @Story("Login")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Login")
    @Test
    public void testLogin() {
        loginPage.login();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        String expected = Pages.LANDING_PAGE.getUrl();
        String actual = driver.getCurrentUrl();

        Assertions.assertTrue(loggedIn);
        Assertions.assertEquals(expected, actual);
        addAttachment("Successful login");
    }

    @DisplayName("Wrong login1")
    @Description("Login with missing username")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Login")
    @Test
    public void testLoginWithMissingUsername() {
        String missingUsername = "";
        String password = "kispal123";
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.login2(missingUsername, password);
        String expected = Pages.LOGIN_PAGE.getUrl();
        String actual = driver.getCurrentUrl();

        Assertions.assertEquals(expected, actual);
        addAttachment("Failed login with missing username");
    }

    @DisplayName("Wrong login2")
    @Description("Login with wrong password")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Login")
    @Test
    public void testLoginWithWrongPassword() {
        String username = "lovasia";
        String wrongPassword = "kispal";
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.login2(username, wrongPassword);
        boolean failedLogin = loginPage.isAlertMessageDisplayed();
        String expectedMessage = "Username or Password\n" + "is not correct!";
        String actualMessage = loginPage.getAlertMessage();

        Assertions.assertTrue(failedLogin);
        Assertions.assertEquals(expectedMessage, actualMessage);
        addAttachment("Failed login with wrong password");
    }

    @DisplayName("Login with Enter")
    @Description("Login pressing button Enter")
    @Story("Login")
    @Severity(SeverityLevel.MINOR)
    @Tag("Login")
    @Test
    public void testLoginWithEnter() {
        String username = "lovasia";
        String password = "kispal123";
        loginPage.loginWithEnter(username, password);
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        String expected = Pages.LANDING_PAGE.getUrl();
        String actual = driver.getCurrentUrl();

        Assertions.assertTrue(loggedIn);
        Assertions.assertEquals(expected, actual);
        addAttachment("Successful login with key Enter");
    }

    @DisplayName("Wrong Login3")
    @Description("Login without registration")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Login")
    @Test
    public void testLoginWithoutRegistration() {
        String username = "tesztelek";
        String password = "teszt";
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.login2(username, password);
        boolean failedLogin = loginPage.isAlertMessageDisplayed();
        String expectedMessage = "Username or Password\n" + "is not correct!";
        String actualMessage = loginPage.getAlertMessage();

        Assertions.assertTrue(failedLogin);
        Assertions.assertEquals(expectedMessage, actualMessage);
        addAttachment("Failed login without registration");
    }
}
