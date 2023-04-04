package org.example.portio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class PortioTestPage {
    WebDriver driver;
    RegisterPage registerPage;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeEach
    public void init() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testRegistration() {
        registerPage.registration();
        Assertions.assertTrue(registerPage.userRegistered());
        Assertions.assertEquals("User registered!", registerPage.registeredMessage());
    }
    @Test
    public void testRegistrationWithMissingPassword() {
        String username = "teszteszter";
        String missingPassword = "";
        String email = "teszteszter5@gmail.com";
        registerPage.wrongRegistration(username, missingPassword, email);
        Assertions.assertFalse(registerPage.userRegistered());
    }
    @Test
    public void testRegistrationWithWrongEmail() {
        String username = "teszteszter";
        String password = "teszt";
        String wrongEmail = "tesztesztergmail";
        registerPage.wrongRegistration(username, password, wrongEmail);
        Assertions.assertFalse(registerPage.userRegistered());
    }
    @Test
    public void testLogin() {
        loginPage.login();
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(loginPage.isPortioLogoVisible());
    }
    @Test
    public void testLoginWithMissingUsername() {
        String missingUsername = "";
        String password = "kispal123";
        loginPage.wrongLogin(missingUsername, password);
        Assertions.assertEquals(Pages.LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Test
    public void testLoginWithWrongPassword() {
        String username = "lovasia";
        String wrongPassword = "kispal";
        String expectedMessage = "Username or Password\n" + "is not correct!";
        loginPage.wrongLogin(username, wrongPassword);
        Assertions.assertTrue(loginPage.isAlertMessageDisplayed());
        Assertions.assertEquals(expectedMessage, loginPage.getAlertMessage());
    }
    @Test
    public void testLoginWithEnter() {
        String username = "lovasia";
        String password = "kispal123";
        loginPage.loginWithEnter(username, password);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(loginPage.isPortioLogoVisible());
    }
    @Test
    public void testLogout() {
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(loginPage.isPortioLogoVisible());
        homePage.logout();
        Assertions.assertEquals(Pages.LOGOUT_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(loginPage.isLoginButtonVisible());
    }
    @Test
    public void testSetProfile() {
        String username = "teszteszter";
        String password = "teszt";
        String name ="Teszt Eszti";
        String bio ="female";
        String phone ="06301112233";
        registerPage.registration();
        loginPage.loginAfterRegistration(username, password);
        homePage.setProfile(name, bio, phone);
        Assertions.assertEquals("Profile Edited!", homePage.getProfileMessage());
    }
    @Test
    public void testDeleteAccount() {
        String username = "teszteszter";
        String password = "teszt";
        String expectedMessage = "Username or Password\n" + "is not correct!";
        registerPage.registration();
        loginPage.loginAfterRegistration(username, password);
        homePage.deleteAccount();
        loginPage.loginAfterDeletingAccount(username, password);
        Assertions.assertTrue(loginPage.isAlertMessageDisplayed());
        Assertions.assertEquals(expectedMessage, loginPage.getAlertMessage());
    }
    @Test
    public void testNavigateToContactPageWithHireMeButton() {
        //HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.navigateToContactPageWithHireMeButton();
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(homePage.isContactMeTextVisible());
    }
    @Test
    public void testNavigateToContactPageWithContactMeButton() {
        //HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.navigateToContactPageWithContactButton();
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(homePage.isContactMeTextVisible());
    }
    @AfterEach
    public void quitDriver() {
        driver.quit();
    }
}
