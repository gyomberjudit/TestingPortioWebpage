package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import utilPages.Pages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

@Epic("Navigation")
public class NavigationTest extends BaseTest {

    @DisplayName("Test Hire me button")
    @Description("Test if Hire me button navigates to Contact page")
    @Story("Navigate with button")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Navigation")
    @Test
    public void testButtonHireMe() {
        loginPage.login();
        addAttachment("User logged in");
        homePage.clickOnLinkAbout();
        aboutPage.clickOnHireMe();
        String expected = Pages.CONTACT_PAGE.getUrl();
        String actual = driver.getCurrentUrl();
        addAttachment("Successful navigation to ContactPage");

        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Test Privacy and policy link")
    @Description("Clicking on Privacy and Policy link the user is thrown out of Portio webpage")
    @Story("Navigate with link")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Navigation")
    @Tag("Failed")
    @Test
    public void testPrivacyAndPolicyLink() throws InterruptedException {
        loginPage.login();
        footerPage.clickLinkPrivacyAndPolicy();
        String expected = Pages.LOGIN_PAGE.getUrl();
        String actual = driver.getCurrentUrl();
        addAttachment("Failed navigation to Privacy and Policy");

        Assertions.assertNotEquals(expected, actual);
    }

    @DisplayName("Test Facebook link")
    @Description("Clicking on Facebook link the user navigates to Facebook webpage")
    @Story("Navigate with window handling")
    @Severity(SeverityLevel.MINOR)
    @Tag("Navigation")
    @Tag("Window handling")
    @Test
    public void testFacebookLink() throws InterruptedException {
        loginPage.login();
        footerPage.clickIconFacebbok();
        Thread.sleep(1000);
        String expected = Pages.FACEBOOK.getUrl();
        String actual = footerPage.getChildWindowUrl();

        Assertions.assertEquals(expected, actual);
    }
}
