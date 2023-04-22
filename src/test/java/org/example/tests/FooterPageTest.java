package org.example.tests;

import io.qameta.allure.*;
import org.example.pages.Pages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Navigation")
public class FooterPageTest extends BaseTest {

    @DisplayName("Test Privacy and policy link")
    @Description("Clicking on Privacy and Policy link the user is thrown out of Portio webpage")
    @Story("Navigate with link")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Navigation")
    @Test
    public void testPrivacyAndPolicyLink() throws InterruptedException {
        loginPage.login();
        footerPage.clickLinkPrivacyAndPolicy();
        String expected = Pages.LOGIN_PAGE.getUrl();
        String actual = driver.getCurrentUrl();

        Assertions.assertNotEquals(expected, actual);
        addAttachment("Failed navigation to Privacy and Policy");
    }

    @DisplayName("Test Facebook link")
    @Description("Clicking on Facebook link the user navigates to Facebook webpage")
    @Story("Navigate with link")
    @Severity(SeverityLevel.MINOR)
    @Tag("Window handling")
    @Tag("Navigation")
    @Test
    public void testFacebookLink() throws InterruptedException {
        loginPage.login();
        footerPage.clickIconFacebbok();
        Thread.sleep(3000);
        String expected = Pages.FACEBOOK.getUrl();
        String actual = footerPage.getChildWindowUrl();

        Assertions.assertEquals(expected, actual);
        Thread.sleep(5000);
        addAttachment("Successful navigation to Facebook");
    }
}
