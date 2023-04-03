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
        String url = "https://lennertamas.github.io/portio/landing.html";
        registerPage.registration();
        loginPage.login();

        Assertions.assertEquals(url, driver.getCurrentUrl());
        Assertions.assertTrue(loginPage.isPortioLogoVisible());
    }
    @Test
    public void testLoginWithMissingUsername() {
        String missingUsername = "";
        String password = "teszt";
        registerPage.registration();
        loginPage.wrongLogin(missingUsername, password);

        Assertions.assertEquals(loginPage.getURL(), driver.getCurrentUrl());
    }
    @Test
    public void testLoginWithWrongPassword() {
        String username = "teszteszter";
        String wrongPassword = "tesztelek";
        registerPage.registration();
        loginPage.wrongLogin(username, wrongPassword);

        Assertions.assertTrue(loginPage.isAlertMessageDisplayed());
        Assertions.assertEquals("Username or Password\nis not correct!", loginPage.getAlertMessage());
    }
    @AfterEach
    public void quitDriver() {
        driver.quit();
    }
}
