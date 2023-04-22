package org.example.tests;

import io.qameta.allure.*;
import org.example.pages.Pages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Technical functionalities")
public class HomePageTest extends BaseTest {

    @DisplayName("Logout")
    @Description("Logging out after logging in")
    @Story("Logout")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Logout")
    @Test
    public void testLogout() {
        loginPage.login();
        Assertions.assertTrue(homePage.isPortioLogoDisplayed());
        homePage.logout();
        boolean loginButtonVisible = loginPage.isLoginButtonDisplayed();
        String expected = Pages.LOGOUT_PAGE.getUrl();
        String actual = driver.getCurrentUrl();

        Assertions.assertTrue(loginButtonVisible);
        Assertions.assertEquals(expected, actual);
    }
}
