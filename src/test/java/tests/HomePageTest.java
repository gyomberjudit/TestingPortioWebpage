package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import utilPages.Pages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

@Epic("Entry functionalities")
public class HomePageTest extends BaseTest {

    @DisplayName("Logout")
    @Description("Logging out after logging in")
    @Story("Logout")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("logout")
    @Test
    public void testLogout() {
        loginPage.login();
        addAttachment("The user is logged in");
        Assertions.assertTrue(homePage.isPortioLogoDisplayed());
        homePage.logout();
        boolean loginButtonVisible = loginPage.isLoginButtonDisplayed();
        String expected = Pages.LOGOUT_PAGE.getUrl();
        String actual = driver.getCurrentUrl();
        addAttachment("The user is logged out");

        Assertions.assertTrue(loginButtonVisible);
        Assertions.assertEquals(expected, actual);
    }
}
