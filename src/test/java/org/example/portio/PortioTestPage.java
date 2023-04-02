package org.example.portio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class PortioTestPage {
    WebDriver driver;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testRegistration() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.register();
        Assertions.assertEquals("User registered!", registerPage.registeredMessage());
    }
    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        String url = "https://lennertamas.github.io/portio/landing.html";

        String username = "teszteszter";
        String password = "teszt";
        loginPage.navigate();
        loginPage.clickButtonAccept();
        loginPage.enterUsernameLogin(username);
        loginPage.enterPasswordLogin(password);
        loginPage.runJSLogin();
        //loginPage.login();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        Assertions.assertEquals(url, driver.getCurrentUrl());

    }
    public void quitDriver() {
        //driver.quit();
    }
}
