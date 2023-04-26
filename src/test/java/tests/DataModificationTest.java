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
    @DisplayName("TC18 - Test profile name")
    @Description("Test if profile name is visible after setting account")
    @Story("Data modification")
    @Severity(SeverityLevel.MINOR)
    @Tag("dataModification")
    @Tag("profile")
    @Test
    public void testProfileUsername() {
        String username = "teszteszter";
        String password = "teszt";
        String email = "teszteszter5@gmail.com";
        String name ="Teszt Eszti";
        String bio ="female";
        String phone ="06301112233";

        //registration
        registerPage.navigate();
        registerPage.acceptTerms();
        registerPage.clickButtonRegister();
        registerPage.inputUsername(username);
        registerPage.inputPassword(password);
        registerPage.inputEmail(email);
        registerPage.clickButtonRegister2();
        boolean userRegistered = registerPage.userRegistered();
        Assertions.assertTrue(userRegistered);

        //logging in
        registerPage.clickLoginButton();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        Assertions.assertTrue(loggedIn);

        //setting profile
        homePage.clickProfile();
        profilePage.inputName(name);
        profilePage.inputBio(bio);
        profilePage.inputPhone(phone);
        profilePage.clickSaveButton();
        String expectedMessage = "Profile Edited!";
        String actualMessage = profilePage.getProfileMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);

        //checking if profile name has changed
        homePage.navigate();
        String expectedProfileName = "Teszt Eszti";
        String actualProfileName = homePage.getProfileName();
        addAttachment("Username is not displayed after profile edited");

        Assertions.assertEquals(expectedProfileName, actualProfileName);
    }
}
