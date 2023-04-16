package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class AboutPage extends BasePage{

//locate elements for AboutPage
    private final By ABOUT_PAGE_TEXT = By.id("about-me");
    private final By BUTTON_HIRE_ME = By.xpath("//*[text()=\"Hire me\"]");
    private final By BUTTON_DOWNLOAD_CV = By.xpath("//*[text()=\"Hire me\"]/following-sibling::a");


//constructor
    public AboutPage(WebDriver driver) {
        super(driver, Pages.LANDING_PAGE.getUrl());
    }


//methods for AboutPage
    public void clickOnHireMe() {
        driver.findElement(BUTTON_HIRE_ME).click();
    }
    public void clickDownloadCV() {
        driver.findElement(BUTTON_DOWNLOAD_CV).click();
    }

//methods for assertions
    public boolean isAboutPageTextDisplayed() {
        return driver.findElement(ABOUT_PAGE_TEXT).isDisplayed();
    }
    public boolean isFileExist(String filename) {
        String home = System.getProperty("user.home");
        String file_with_location = home + "\\Downloads\\" + filename;
        File file = new File(file_with_location);
        return file.exists();
    }
}
