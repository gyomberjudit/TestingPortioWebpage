package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

//locate elements for homePage
    private final By LINK_LOGOUT = By.xpath("//*[@id=\"logout-link\"]/a");
    private final By PROFILE_LINK = By.xpath("//*[@class=\"nav-link\"]");
    private final By PROFILE_TEXT = By.id("profile-btn");
    private final By HIRE_ME_NOW_BUTTON = By.xpath("//*[@class=\"navbar-nav\"]/a");
    private final By CONTACT_BUTTON = By.xpath("//*[@class=\"hero_content\"]/a");
    private final By PORTIO_LOGO = By.xpath("//*[@class=\"container\"]/a/img");
    private final By LINK_ABOUT = By.xpath("//*[@id=\"navbarCollapse\"]//li[2]/a");
    private final By LINK_SERVICE = By.xpath("//*[@id=\"navbarCollapse\"]//li[3]/a");
    private final By LINK_WORK = By.xpath("//*[text()=\"Work\"]");
    private final By LINK_RESUME = By.xpath("//*[@id=\"navbarCollapse\"]//li[5]/a");
    private final By LINK_SKILLS = By.xpath("//*[@id=\"navbarCollapse\"]//li[6]/a");
    private final By LINK_BLOG = By.xpath("//*[@id=\"navbarCollapse\"]//li[7]/a");
    private final By LINK_CONTACT = By.xpath("//*[@id=\"navbarCollapse\"]//li[8]/a");


//constructor
    public HomePage(WebDriver driver) {
        super(driver, Pages.LANDING_PAGE.getUrl());
    }


//methods for homePage
    public void logout() {
        driver.findElement(LINK_LOGOUT).click();
    }
    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(PROFILE_LINK));
        profile.click();
    }
    public void navigateToContactPageWithHireMeNowButton() {
        driver.findElement(HIRE_ME_NOW_BUTTON).click();
    }
    public void navigateToContactPageWithContactButton() {
        driver.findElement(CONTACT_BUTTON).click();
    }
    public void clickOnLinkAbout() {
        driver.findElement(LINK_ABOUT).click();
    }
    public void clickOnLinkService() {
        driver.findElement(LINK_SERVICE).click();
    }
    public void clickOnLinkWork() {
        driver.findElement(LINK_WORK).click();
    }
    public void clickOnLinkResume() {
        driver.findElement(LINK_RESUME).click();
    }
    public void clickOnLinkSkills() {
        driver.findElement(LINK_SKILLS).click();
    }
    public void clickOnLinkBlog() {
        driver.findElement(LINK_BLOG).click();
    }
    public void clickOnLinkContact() {
        driver.findElement(LINK_CONTACT).click();
    }

//methods for assertions
    public boolean isPortioLogoDisplayed() {
    return driver.findElement(PORTIO_LOGO).isDisplayed();
}
    public boolean isHomePageTextDisplayed() {
    return driver.findElement(PORTIO_LOGO).isDisplayed();
}
    public String getProfileName() {
        return driver.findElement(PROFILE_TEXT).getText();
    }
}
