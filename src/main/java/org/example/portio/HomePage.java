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
    private final By PROFILE = By.xpath("//*[@class=\"nav-link\"]");
    private final By NAME_INPUT = By.id("name");
    private final By BIO_INPUT = By.id("bio");
    private final By PHONE_INPUT = By.id("phone-number");
    private final By SAVE_BUTTON = By.xpath("//*[@class=\"form\"]/div[5]/button");
    private final By PROFILE_MESSAGE = By.id("edit-alert");
    private final By DELETE_BUTTON = By.xpath("//*[@class=\"form\"]/div[6]/button");
    private final By CONFIRM_DELETE_BUTTON = By.xpath("//*[@class=\"form\"]/div[7]/button");
    private final By HIRE_ME_BUTTON = By.xpath("//*[@class=\"navbar-nav\"]/a");
    private final By CONTACT_BUTTON = By.xpath("//*[@class=\"hero_content\"]/a");
    private final By CONTACT_ME_TEXT = By.xpath("//*[@class=\"col-12 text-center\"]/h3");

//constructor
    public HomePage(WebDriver driver) {
        super(driver, Pages.LANDING_PAGE.getUrl());
    }
//methods for homePage
    public void logout() {
        driver.findElement(LINK_LOGOUT).click();
    }
    public void setProfile(String name, String bio, String phone) {
        driver.findElement(PROFILE).click();
        driver.findElement(NAME_INPUT).sendKeys(name);
        driver.findElement(BIO_INPUT).sendKeys(bio);
        driver.findElement(PHONE_INPUT).sendKeys(phone);
        driver.findElement(SAVE_BUTTON).click();
    }
    public void deleteAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(PROFILE));
        profile.click();
        driver.findElement(DELETE_BUTTON).click();
        driver.findElement(CONFIRM_DELETE_BUTTON).click();
    }
    public void navigateToContactPageWithHireMeButton() {
        driver.findElement(HIRE_ME_BUTTON).click();
    }
    public void navigateToContactPageWithContactButton() {
        driver.findElement(CONTACT_BUTTON).click();
    }

//methods for assertions
    public String getProfileMessage() {
        return driver.findElement(PROFILE_MESSAGE).getText();
    }
    public boolean isContactMeTextVisible() {
        return driver.findElement(CONTACT_ME_TEXT).isDisplayed();
    }
}
