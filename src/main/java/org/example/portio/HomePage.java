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
    private final By HIRE_ME_BUTTON = By.xpath("//*[@class=\"navbar-nav\"]/a");
    private final By CONTACT_BUTTON = By.xpath("//*[@class=\"hero_content\"]/a");
    private final By PORTIO_LOGO = By.xpath("//*[@class=\"container\"]/a/img");
    private final By LINK_WORK = By.xpath("//*[text()=\"Work\"]");

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
    public void navigateToContactPageWithHireMeButton() {
        driver.findElement(HIRE_ME_BUTTON).click();
    }
    public void navigateToContactPageWithContactButton() {
        driver.findElement(CONTACT_BUTTON).click();
    }
    public void clickOnWorkLink() {
        driver.findElement(LINK_WORK).click();
    }

//methods for assertions
    public boolean isPortioLogoVisible() {
    return driver.findElement(PORTIO_LOGO).isDisplayed();
}
    public String getProfileName() {
        return driver.findElement(PROFILE_TEXT).getText();
    }
}
