package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class FooterPage extends  BasePage{

//locate elements for homePage
    private final By FOOTER_PAGE_TEXT = By.xpath("(//*[contains(@class, \"text-light\")]/h2)[2]");
    private final By BUTTON_GET_IN_TOUCH = By.xpath("//*[@class=\"footer__cta_action\"]/a");
    private final By LINK_ABOUT_ME = By.xpath("//*[@class=\"unstyle-list small\"]/li[1]/a");
    private final By FILE_NOT_FOUND = By.xpath("/html/body/div/h1");
    private final By LINK_FAQ = By.xpath("//*[@class=\"unstyle-list small\"]/li[2]/a");
    private final By LINK_PRIVACY_AND_POLICY = By.xpath("//*[@class=\"unstyle-list small\"]/li[3]/a");
    private final By LINK_LATEST_ARTICLE = By.xpath("//*[@class=\"unstyle-list small\"]/li[4]/a");
    private final By LINK_TERMS_AND_CONDITIONS = By.xpath("//*[@class=\"footer__footer_copy text-light\"]/a");
    private final By ICON_FACEBOOK = By.xpath("//*[@class=\"unstyle-list\"]/li[1]/a");
    private final By ICON_LINKEDIN = By.xpath("//*[@class=\"unstyle-list\"]/li[2]/a");
    private final By ICON_PINTEREST = By.xpath("//*[@class=\"unstyle-list\"]/li[3]/a");
    private final By ICON_TWITTER = By.xpath("//*[@class=\"unstyle-list\"]/li[4]/a");
    private final By TEXT_TERMS_AND_CONDITIONS = By.xpath("/html/body/div/h1");


//constructor
    public FooterPage(WebDriver driver) {
        super(driver, Pages.LANDING_PAGE.getUrl());
    }


//methods
    public void clickGetINTouchButton() {
        moveToElement(BUTTON_GET_IN_TOUCH);
    }
    public void clickLinkAboutMe() {
        moveToElement(LINK_ABOUT_ME);
    }
    public void clickLinkFAQ() {
        moveToElement(LINK_FAQ);
    }
    public void clickLinkPrivacyAndPolicy() {
        moveToElement(LINK_PRIVACY_AND_POLICY);
    }
    public void clickLatestArticle() {
        moveToElement(LINK_LATEST_ARTICLE);
    }
    public void clickTermsAndConditions() {
        moveToElement(LINK_TERMS_AND_CONDITIONS);
    }
    public void clickIconFacebbok() {
       moveToElement(ICON_FACEBOOK);
    }
    public String getChildWindowUrl() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        StringBuilder url = new StringBuilder();
        for (String childWindow : windows) {
            if (!parentWindow.equals(childWindow)) {
                String childUrl = driver.switchTo().window(childWindow).getCurrentUrl();

                url.append(childUrl);
                driver.close();
            }
        }
        Thread.sleep(3000);
        driver.switchTo().window(parentWindow);
        return url.toString();
    }
    public void clickIconLinkedin() {
        moveToElement(ICON_LINKEDIN);
    }
    public void clickIconPinterest() {
        moveToElement(ICON_PINTEREST);
    }
    public void clickIconTwitter() {
        moveToElement(ICON_TWITTER);
    }

//methods for assertion
    public boolean isFooterPageTextDisplayed() {
        return driver.findElement(FOOTER_PAGE_TEXT).isDisplayed();
    }
    public boolean isTermsAndConditionsTextDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement text = wait.until(ExpectedConditions.elementToBeClickable(TEXT_TERMS_AND_CONDITIONS));
        return text.isDisplayed();
    }
    public boolean isFileNotFound() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement text = wait.until(ExpectedConditions.elementToBeClickable(FILE_NOT_FOUND));
        return text.isDisplayed();
    }
}
