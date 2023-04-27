package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import utilPages.Pages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

@Epic("Entry functionalities")
public class LogoutTest extends BaseTest {

    @DisplayName("TC26 - Logout")
    @Description("Logging out after logging in")
    @Story("Logout")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("logout")
    @Test
    public void testLogout() {
        String username = "lovasia";
        String password = "kispal123";

        //login
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        addAttachment("User is logged in");
        Assertions.assertTrue(loggedIn);

        //logout
        homePage.clickLogoutButton();
        boolean loginButtonVisible = loginPage.isLoginButtonDisplayed();
        String expected = Pages.LOGOUT_PAGE.getUrl();
        String actual = driver.getCurrentUrl();
        addAttachment("The user is logged out");

        Assertions.assertTrue(loginButtonVisible);
        Assertions.assertEquals(expected, actual);
    }
}
