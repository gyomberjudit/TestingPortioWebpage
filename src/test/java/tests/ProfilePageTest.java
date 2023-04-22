package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

@Epic("Data handling")
public class ProfilePageTest extends BaseTest {

    //Setting profile with registration because of incognito mode
    @DisplayName("Set Profile")
    @Description("Set profile by giving credentials")
    @Story("Data input")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataInput")
    @Tag("profile")
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
        boolean loggedIn = homePage.isPortioLogoDisplayed();

        Assertions.assertTrue(loggedIn);

        homePage.clickProfile();
        profilePage.setProfile(name, bio, phone);
        String expectedMessage = "Profile Edited!";
        String actualMessage = profilePage.getProfileMessage();

        addAttachment("Success message visible after setting profile: 'Profile edited'");
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    //Checking if profile name has changed after setting it (with registration because of incognito mode)
    @DisplayName("Test profile name")
    @Description("Test if profile name is visible after setting account")
    @Story("Data modification")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataModification")
    @Tag("profile")
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
        boolean loggedIn = homePage.isPortioLogoDisplayed();

        Assertions.assertTrue(loggedIn);

        homePage.clickProfile();
        profilePage.setProfile(name, bio, phone);
        String expectedMessage = "Profile Edited!";
        String actualMessage = profilePage.getProfileMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);

        homePage.navigate();
        String expectedProfileName = "Teszt Eszti";
        String actualProfileName = homePage.getProfileName();

        addAttachment("Username is not displayed after profile edited");
        Assertions.assertEquals(expectedProfileName, actualProfileName);
    }

    //Delete a registered account
    @DisplayName("Delete Account")
    @Description("Click profile and delete account, then try login again")
    @Story("Data deletion")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("dataDeletion")
    @Tag("profile")
    @Test
    public void testDeleteAccount() {
        String username = "teszteszter";
        String password = "teszt";
        registerPage.registration();
        registerPage.clickLoginButton();
        loginPage.login2(username, password);
        boolean loggedIn = homePage.isPortioLogoDisplayed();

        Assertions.assertTrue(loggedIn);

        homePage.clickProfile();
        profilePage.deleteAccount();
        boolean confirmationMessageVisible = profilePage.isConfirmMessageDisplayed();

        Assertions.assertTrue(confirmationMessageVisible);

        profilePage.confirmDeletingAccount();
        loginPage.login2(username, password);
        boolean  alertMessageVisible = loginPage.isAlertMessageDisplayed();
        String expectedMessage = "Username or Password\n" + "is not correct!";
        String actualMessage = loginPage.getAlertMessage();

        addAttachment("Account deleted, user can't log in, warning message is visible");
        Assertions.assertTrue(alertMessageVisible);
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}
