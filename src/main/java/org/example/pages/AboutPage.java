package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;

public class AboutPage extends BasePage{
    private final By BUTTON_HIRE_ME = By.xpath("//*[text()=\"Hire me\"]");
    private final By BUTTON_DOWNLOAD_CV = By.xpath("//*[text()=\"Hire me\"]/following-sibling::a");

    public AboutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.LANDING_PAGE.getUrl());
    }


    //Navigate to ContactPage by clicking on Hire Me button
    public void clickOnHireMe() {
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_HIRE_ME)).click();
    }

    //Try download CV by clicking on Download CV button
    public void clickDownloadCV() {
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_DOWNLOAD_CV)).click();
    }

    //Check if downloading CV was successful
    public boolean isFileExist(String filename) {
        String home = System.getProperty("user.home");
        String file_with_location = home + "\\Downloads\\" + filename;
        File file = new File(file_with_location);
        return file.exists();
    }
}
