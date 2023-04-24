package tests;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Tag;
import io.qameta.allure.*;
import utilPages.Pages;
import org.junit.jupiter.api.*;
import testEnvironment.BaseTest;
import java.io.IOException;
import java.util.Map;

@Epic("Entry functionalities")
public class LoginPageTest extends BaseTest {

    public LoginPageTest() {
    }

    @DisplayName("Login")
    @Description("Login with right credentials, accepting terms")
    @Story("Login")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("login")
    @Test
    public void testLogin() {
        loginPage.login();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        String expected = Pages.LANDING_PAGE.getUrl();
        String actual = driver.getCurrentUrl();

        addAttachment("Successful login");
        Assertions.assertTrue(loggedIn);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Sequential login")
    @Description("Login repeatedly with valid credentials from file.")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("login")
    @Test
    public void testLoginMultipleUsers() throws IOException, ParseException {
        loginPage.navigate();
        loginPage.acceptTerms();

        String fileName = "users.json";
        String keys = "login";
        String values = "password";
        Map<String, String> map = loginPage.jsonParser(fileName, keys, values);
        for(String key : map.keySet()){
            loginPage.login2(key, map.get(key));
            addAttachment("Logged in with multiple different credentials");
            boolean loggedIn = homePage.isPortioLogoDisplayed();

            Assertions.assertTrue(loggedIn);
            loginPage.navigate();
        }
    }

    @DisplayName("Wrong login1")
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
        loginPage.login2(missingUsername, password);
        String expected = Pages.LOGIN_PAGE.getUrl();
        String actual = driver.getCurrentUrl();

        addAttachment("Failed login with missing username, warning message is visible");
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Wrong login2")
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
        loginPage.login2(username, wrongPassword);
        boolean failedLogin = loginPage.isAlertMessageDisplayed();
        String expectedMessage = "Username or Password\n" + "is not correct!";
        String actualMessage = loginPage.getAlertMessage();

        addAttachment("Failed login with wrong password, warning message is visible");
        Assertions.assertTrue(failedLogin);
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("Login with Enter")
    @Description("Login pressing button Enter")
    @Story("Login")
    @Severity(SeverityLevel.MINOR)
    @Tag("login")
    @Test
    public void testLoginWithEnter() {
        String username = "lovasia";
        String password = "kispal123";
        loginPage.loginWithEnter(username, password);
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        String expected = Pages.LANDING_PAGE.getUrl();
        String actual = driver.getCurrentUrl();

        addAttachment("Successful login with key Enter");
        Assertions.assertTrue(loggedIn);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Wrong login3")
    @Description("Login without registration")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("login")
    @Tag("wrongData")
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

        addAttachment("Failed login without registration, warning message is visible");
        Assertions.assertTrue(failedLogin);
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}
