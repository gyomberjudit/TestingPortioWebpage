package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    //private final By TEXT_TERMS_AND_CONDITION = By.xpath("//*[@class=\"container terms-and-conditions\"]/h1");
    private final By TEXT_TERMS_AND_CONDITION = By.xpath("/html/body/div/h1");


//constructor
    public FooterPage(WebDriver driver) {
        super(driver, Pages.LANDING_PAGE.getUrl());
    }


//methods
    public void clickGetINTouchButton() {
        driver.findElement(BUTTON_GET_IN_TOUCH).click();
    }
    public void clickLinkAboutMe() {
        driver.findElement(LINK_ABOUT_ME).click();
    }
    public void clickLinkFAQ() {
        driver.findElement(LINK_FAQ).click();
    }
    public void clickLinkPrivacyAndPolicy() {
        driver.findElement(LINK_PRIVACY_AND_POLICY).click();
    }
    public void clickLatestArticle() {
        driver.findElement(LINK_LATEST_ARTICLE).click();
    }
    public void clickTermsAndConditions() throws InterruptedException {
        scrollToElement(LINK_TERMS_AND_CONDITIONS);
        driver.findElement(LINK_TERMS_AND_CONDITIONS).click();
    }
    public void clickIconFacebbok() throws InterruptedException {
        scrollToElement(ICON_FACEBOOK);
        driver.findElement(ICON_FACEBOOK).click();
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
    public void clickIconLinkedin() throws InterruptedException {
        scrollToElement(ICON_LINKEDIN);
        driver.findElement(ICON_LINKEDIN).click();
    }
    public void clickIconPinterest() throws InterruptedException {
        scrollToElement(ICON_PINTEREST);
        driver.findElement(ICON_PINTEREST).click();
    }
    public void clickIconTwitter() throws InterruptedException {
        scrollToElement(ICON_TWITTER);
        driver.findElement(ICON_TWITTER).click();
    }


    public boolean isFooterPageTextDisplayed() {
        return driver.findElement(FOOTER_PAGE_TEXT).isDisplayed();
    }
    public boolean isTermsAndConditionsTextDisplayed() {
        return driver.findElement(TEXT_TERMS_AND_CONDITION).isDisplayed();
    }
    public boolean isFileNotFound() {
        return driver.findElement(FILE_NOT_FOUND).isDisplayed();
    }
}
