package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    private final By LINK_LOGOUT = By.xpath("//*[@id=\"logout-link\"]/a");
    private final By PROFILE_LINK = By.xpath("//*[@class=\"nav-link\"]");
    private final By PROFILE_TEXT = By.id("profile-btn");
    private final By HIRE_ME_NOW_BUTTON = By.xpath("//*[@class=\"navbar-nav\"]/a");
    private final By CONTACT_ME_BUTTON = By.xpath("//*[@class=\"hero_content\"]/a");
    private final By PORTIO_LOGO = By.xpath("//*[@class=\"container\"]/a/img");
    private final By LINK_ABOUT = By.xpath("//*[@id=\"navbarCollapse\"]//li[2]/a");
    private final By LINK_WORK = By.xpath("//*[text()=\"Work\"]");
    private final By LINK_SKILLS = By.xpath("//*[@id=\"navbarCollapse\"]//li[6]/a");
    private final By LINK_BLOG = By.xpath("//*[@id=\"navbarCollapse\"]//li[7]/a");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.LANDING_PAGE.getUrl());
    }


    //Logging out from the webpage
    public void logout() {
        driver.findElement(LINK_LOGOUT).click();
    }

    //Navigating to ProfilePage by clicking on Profile link
    public void clickProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(PROFILE_LINK)).click();
    }

    //Navigating to ContactPage with 'Hire Me Now' button
    public void navigateWithHireMeNowButton() {
        driver.findElement(HIRE_ME_NOW_BUTTON).click();
    }

    //Navigating to ContactPage with 'Contact Me' button
    public void navigateWithContactMeButton() {
        driver.findElement(CONTACT_ME_BUTTON).click();
    }
    public void clickOnLinkAbout() {
        driver.findElement(LINK_ABOUT).click();
    }

    //Navigating to WorkPage by clicking on Work link
    public void clickOnLinkWork() {
        driver.findElement(LINK_WORK).click();
    }

    //Navigating to SkillsPage by clicking on Skills link
    public void clickOnLinkSkills() {
        driver.findElement(LINK_SKILLS).click();
    }

    //Navigating to BlogPage by clicking on Blog link
    public void clickOnLinkBlog() {
        driver.findElement(LINK_BLOG).click();
    }

    //Checking if HomePage is visible
    public boolean isPortioLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PORTIO_LOGO)).isDisplayed();
    }

    //Checking if Profile name displayed after setting profile
    public String getProfileName() {
        return driver.findElement(PROFILE_TEXT).getText();
    }
    }
