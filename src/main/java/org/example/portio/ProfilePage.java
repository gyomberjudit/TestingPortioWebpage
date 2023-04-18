package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage{

//locate elements for profile
private final By NAME_INPUT = By.id("name");
    private final By BIO_INPUT = By.id("bio");
    private final By PHONE_INPUT = By.id("phone-number");
    private final By SAVE_BUTTON = By.xpath("//*[@class=\"form\"]/div[5]/button");
    private final By PROFILE_MESSAGE = By.id("edit-alert");
    private final By DELETE_BUTTON = By.xpath("//*[@class=\"form\"]/div[6]/button");
    private final By CONFIRM_DELETE_BUTTON = By.xpath("//*[@class=\"form\"]/div[7]/button");

//constructor
    public ProfilePage(WebDriver driver) {
        super(driver, Pages.PROFILE_PAGE.getUrl());
    }

//methods for profile
public void setProfile(String name, String bio, String phone) {
    driver.findElement(NAME_INPUT).sendKeys(name);
    driver.findElement(BIO_INPUT).sendKeys(bio);
    driver.findElement(PHONE_INPUT).sendKeys(phone);
    driver.findElement(SAVE_BUTTON).click();
}
    public void deleteAccount() {
        driver.findElement(DELETE_BUTTON).click();
        driver.findElement(CONFIRM_DELETE_BUTTON).click();
    }
    public String getProfileMessage() {
    return driver.findElement(PROFILE_MESSAGE).getText();
}
}
