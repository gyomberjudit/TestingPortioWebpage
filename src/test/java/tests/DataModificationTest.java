package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

@Epic("Data handling")
public class DataModificationTest extends BaseTest {

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
}
