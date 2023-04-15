package org.example.portio;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class LoginPageTest extends TestEnvironment{
    @Epic("Technical functionalities")
    @Story("Login")
    @Test
    public void testLogin() {
        loginPage.login();
        Allure.addAttachment("Successful login", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(homePage.isPortioLogoDisplayed());
    }
    @Epic("Technical functionalities")
    @Story("Login")
    @Test
    public void testLoginWithMissingUsername() {
        String missingUsername = "";
        String password = "kispal123";
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.login2(missingUsername, password);
        Allure.addAttachment("Failed login with missing username", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(Pages.LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Login")
    @Test
    public void testLoginWithWrongPassword() {
        String username = "lovasia";
        String wrongPassword = "kispal";
        String expectedMessage = "Username or Password\n" + "is not correct!";
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.login2(username, wrongPassword);
        Allure.addAttachment("Failed login with wrong password", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertTrue(loginPage.isAlertMessageDisplayed());
        Assertions.assertEquals(expectedMessage, loginPage.getAlertMessage());
    }
    @Epic("Technical functionalities")
    @Story("Login")
    @Test
    public void testLoginWithEnter() {
        String username = "lovasia";
        String password = "kispal123";
        loginPage.loginWithEnter(username, password);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(homePage.isPortioLogoDisplayed());
    }
    @Epic("Technical functionalities")
    @Story("Login")
    @Test
    public void testLoginWithoutRegistration() {
        String username = "tesztelek";
        String password = "teszt";
        String expectedMessage = "Username or Password\n" + "is not correct!";
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.login2(username, password);
        Assertions.assertTrue(loginPage.isAlertMessageDisplayed());
        Assertions.assertEquals(expectedMessage, loginPage.getAlertMessage());
    }
    @Epic("Technical functionalities")
    @Story("Logout")
    @Test
    public void testLogout() {
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Assertions.assertTrue(homePage.isPortioLogoDisplayed());
        homePage.logout();
        Assertions.assertTrue(loginPage.isLoginButtonDisplayed());
        Assertions.assertEquals(Pages.LOGOUT_PAGE.getUrl(), driver.getCurrentUrl());
    }
}
