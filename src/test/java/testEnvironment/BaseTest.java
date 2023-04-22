package testEnvironment;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected RegisterPage registerPage;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected ContactPage contactPage;
    protected ProfilePage profilePage;
    protected AboutPage aboutPage;
    protected ResumePage resumePage;
    protected SkillsPage skillsPage;
    protected BlogLinkPage blogLinkPage;
    protected BlogPage blogPage;
    protected FooterPage footerPage;

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
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        registerPage = new RegisterPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        homePage = new HomePage(driver, wait);
        contactPage = new ContactPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);
        aboutPage = new AboutPage(driver, wait);
        resumePage = new ResumePage(driver, wait);
        skillsPage = new SkillsPage(driver, wait);
        blogLinkPage = new BlogLinkPage(driver, wait);
        blogPage = new BlogPage(driver, wait);
        footerPage = new FooterPage(driver, wait);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void addAttachment(String name) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    @AfterEach
    public void quitDriver() {
        driver.quit();
    }
}
