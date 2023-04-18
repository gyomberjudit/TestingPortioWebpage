package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class FooterPage extends  BasePage{

//locate elements for homePage
    private final By LINK_FAQ = By.xpath("//*[@class=\"unstyle-list small\"]/li[2]/a");
    private final By LINK_PRIVACY_AND_POLICY = By.xpath("//*[@class=\"unstyle-list small\"]/li[3]/a");
    private final By ICON_FACEBOOK = By.xpath("//*[@class=\"unstyle-list\"]/li[1]/a");
    private final By ICON_LINKEDIN = By.xpath("//*[@class=\"unstyle-list\"]/li[2]/a");


//constructor
    public FooterPage(WebDriver driver) {
        super(driver, Pages.LANDING_PAGE.getUrl());
    }


//methods
    public void clickLinkFAQ() throws InterruptedException {
        scrollToElement(LINK_FAQ);
        driver.findElement(LINK_FAQ).click();
    }
    public void clickLinkPrivacyAndPolicy() throws InterruptedException {
        scrollToElement(LINK_PRIVACY_AND_POLICY);
        driver.findElement(LINK_PRIVACY_AND_POLICY).click();
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
}
