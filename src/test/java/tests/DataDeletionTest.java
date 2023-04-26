package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

@Epic("Data handling")
public class DataDeletionTest extends BaseTest {

    //Delete a registered account
    @DisplayName("TC19 - Delete Account")
    @Description("Click profile and delete account, then try login again")
    @Story("Data deletion")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("dataDeletion")
    @Tag("profile")
    @Test
    public void testDeleteAccount() {
        String username = "teszteszter";
        String password = "teszt";
        String email = "teszteszter5@gmail.com";

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

        //login
        registerPage.clickLoginButton();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        Assertions.assertTrue(loggedIn);

        //delete account
        homePage.clickProfile();
        profilePage.deleteAccount();
        boolean confirmationMessageVisible = profilePage.isConfirmMessageDisplayed();
        Assertions.assertTrue(confirmationMessageVisible);
        profilePage.confirmDeletingAccount();

        //checking if deletion is successful
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean  alertMessageVisible = loginPage.isAlertMessageDisplayed();
        String expectedMessage = "Username or Password\n" + "is not correct!";
        String actualMessage = loginPage.getAlertMessage();

        addAttachment("Account deleted, user can't log in, warning message is visible");
        Assertions.assertTrue(alertMessageVisible);
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}
