package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;

public class HomePage extends BasePage {
    private final By LINK_LOGOUT = By.xpath("//*[@id=\"logout-link\"]/a");
    private final By PROFILE_LINK = By.xpath("//*[@class=\"nav-link\"]");
    private final By PROFILE_TEXT = By.id("profile-btn");
    private final By HIRE_ME_NOW_BUTTON = By.xpath("//*[@class=\"navbar-nav\"]/a");
    private final By CONTACT_ME_BUTTON = By.xpath("//*[@class=\"hero_content\"]/a");
    private final By PORTIO_LOGO = By.xpath("//*[@class=\"container\"]/a/img");
    private final By LINK_ABOUT = By.xpath("//*[@id=\"navbarCollapse\"]//li[2]/a");
    private final By LINK_SKILLS = By.xpath("//*[@id=\"navbarCollapse\"]//li[6]/a");
    private final By LINK_BLOG = By.xpath("//*[@id=\"navbarCollapse\"]//li[7]/a");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.LANDING_PAGE.getUrl());
    }


    //Logging out from the webpage
    @Step("Log out")
    public void clickLogoutButton() {
        driver.findElement(LINK_LOGOUT).click();
    }

    //Navigating to ProfilePage by clicking on Profile link
    @Step("Click Profile")
    public void clickProfile() {
        driver.findElement(PROFILE_LINK);
        wait.until(ExpectedConditions.elementToBeClickable(PROFILE_LINK)).click();
    }

    //Navigating to ContactPage with 'Hire Me Now' button
    @Step("Click 'Hire Me' button")
    public void clickHireMeNowButton() {
        driver.findElement(HIRE_ME_NOW_BUTTON).click();
    }

    //Navigating to ContactPage with 'Contact Me' button
    @Step("Click 'Contact Me' button")
    public void clickContactMeButton() {
        driver.findElement(CONTACT_ME_BUTTON).click();
    }

    //Navigating to AboutPage by clicking on About link
    @Step("Click menu link 'About'")
    public void clickOnLinkAbout() {
        driver.findElement(LINK_ABOUT).click();
    }

    //Navigating to SkillsPage by clicking on Skills link
    @Step("Click menu link 'Skills'")
    public void clickOnLinkSkills() {
        driver.findElement(LINK_SKILLS).click();
    }

    //Navigating to BlogPage by clicking on Blog link
    @Step("Click menu link 'Blog'")
    public void clickOnLinkBlog() {
        driver.findElement(LINK_BLOG).click();
    }

    //scroll to the ResumePage to take screenshot
    public void scrollWindow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-200)", "");
    }

    //Checking if HomePage is visible
    public boolean isPortioLogoDisplayed() {
        WebElement logo = driver.findElement(PORTIO_LOGO);
        try {
            driver.findElement(PORTIO_LOGO);
            wait.until(ExpectedConditions.visibilityOfElementLocated(PORTIO_LOGO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logo.isDisplayed();
    }

    //Checking if Profile name displayed after setting profile
    @Step("Check if profile name has changed")
    public String getProfileName() {
        return driver.findElement(PROFILE_TEXT).getText();
    }
}
