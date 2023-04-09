package org.example.portio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestEnvironment {
    WebDriver driver;
    RegisterPage registerPage;
    LoginPage loginPage;
    HomePage homePage;
    ContactPage contactPage;
    ProfilePage profilePage;
    WorkPage workPage;
    CaseStudyPage caseStudyPage;
    RecipeAppPage recipeAppPage;
    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void init() {
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
        contactPage = new ContactPage(driver);
        profilePage = new ProfilePage(driver);
        workPage = new WorkPage(driver);
        caseStudyPage = new CaseStudyPage(driver);
        recipeAppPage = new RecipeAppPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterEach
    public void quitDriver() {
        driver.quit();
    }
}
