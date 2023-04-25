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

    //test if clicking on 'Hire Me Now' button navigates to ContactPage
    @DisplayName("Test 'Hire Me Now' button")
    @Description("Test if 'Hire Me Now' button navigates to Contact page")
    @Story("Navigate with button")
    @Severity(SeverityLevel.NORMAL)
    @Tag("navigation")
    @Test
    public void testButtonHireMe() {
        String username = "lovasia";
        String password = "kispal123";

        //login
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        addAttachment("User logged in");
        Assertions.assertTrue(loggedIn);

        //navigating to ContactPage
        homePage.clickHireMeNowButton();
        String expected = Pages.CONTACT_PAGE.getUrl();
        String actual = driver.getCurrentUrl();
        addAttachment("Successful navigation to ContactPage");

        Assertions.assertEquals(expected, actual);
    }

    //test if clicking on 'Privacy and Policy' link navigates to the document
    @DisplayName("Test Privacy and policy link")
    @Description("Clicking on Privacy and Policy link the user is thrown out of Portio webpage")
    @Story("Navigate with link")
    @Severity(SeverityLevel.NORMAL)
    @Tag("navigation")
    @Test
    public void testPrivacyAndPolicyLink() throws InterruptedException {
        String username = "lovasia";
        String password = "kispal123";

        //login
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        addAttachment("Successful login");
        Assertions.assertTrue(loggedIn);

        //navigating to Privacy and Policy document
        footerPage.scrollToPrivacyAndPolicyLink();
        footerPage.clickPrivacyAndPolicyLink();
        boolean thrownOutFromWebsite = loginPage.isLoginButtonDisplayed();
        addAttachment("Failed navigation to Privacy and Policy");

        Assertions.assertFalse(thrownOutFromWebsite);
    }

    //check if clicking on 'Facebbok' link navigates to Facebook
    @DisplayName("Test Facebook link")
    @Description("Clicking on Facebook link the user navigates to Facebook webpage")
    @Story("Navigate with window handling")
    @Severity(SeverityLevel.MINOR)
    @Tag("navigation")
    @Tag("windowHandling")
    @Test
    public void testFacebookLink() throws InterruptedException {
        String username = "lovasia";
        String password = "kispal123";

        //login
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        Assertions.assertTrue(loggedIn);

        //navigating to Facebbok
        footerPage.scrollToFacebookIcon();
        footerPage.clickFacebokIcon();
        String expected = Pages.FACEBOOK.getUrl();
        String actual = footerPage.getChildWindowUrl();

        Assertions.assertEquals(expected, actual);
    }
}
