package tests;

import org.junit.jupiter.api.Tag;
import io.qameta.allure.*;
import utilPages.Pages;
import org.junit.jupiter.api.*;
import testEnvironment.BaseTest;

@Epic("Entry functionalities")
public class LoginTest extends BaseTest {

    @DisplayName("TC6 - Login")
    @Description("Login with right credentials, accepting terms")
    @Story("Login")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("login")
    @Test
    public void testLogin() {
        String username = "lovasia";
        String password = "kispal123";

        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        String expected = Pages.LANDING_PAGE.getUrl();
        String actual = driver.getCurrentUrl();
        addAttachment("Successful login");

        Assertions.assertTrue(loggedIn);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("TC7 - Wrong login1")
    @Description("Login with missing username")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("login")
    @Tag("wrongData")
    @Test
    public void testLoginWithMissingUsername() {
        String missingUsername = "";
        String password = "kispal123";

        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(missingUsername);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();

        String expected = Pages.LOGIN_PAGE.getUrl();
        String actual = driver.getCurrentUrl();
        addAttachment("Failed login with missing username, warning message is visible");

        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("TC8 - Wrong login2")
    @Description("Login with wrong password")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("login")
    @Tag("wrongData")
    @Test
    public void testLoginWithWrongPassword() {
        String username = "lovasia";
        String wrongPassword = "kispal";

        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(username);
        loginPage.inputPassword(wrongPassword);
        loginPage.clickLoginButton();

        boolean failedLogin = loginPage.isAlertMessageDisplayed();
        String expectedMessage = "Username or Password\n" + "is not correct!";
        String actualMessage = loginPage.getAlertMessage();
        addAttachment("Failed login with wrong password, warning message is visible");

        Assertions.assertTrue(failedLogin);
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}
