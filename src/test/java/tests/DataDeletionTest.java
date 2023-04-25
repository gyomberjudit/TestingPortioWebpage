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
