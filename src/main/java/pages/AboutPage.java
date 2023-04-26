package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;

import java.io.File;

public class AboutPage extends BasePage {

    private final By BUTTON_DOWNLOAD_CV = By.xpath("//*[@class=\"about_content-inner\"]//a[2]");

    public AboutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.LANDING_PAGE.getUrl());
    }


    //Try download CV by clicking on Download CV button
    public void scrollToDownloadButton() throws InterruptedException {
        scrollToElement(BUTTON_DOWNLOAD_CV);
    }
    public void clickDownloadCV() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(BUTTON_DOWNLOAD_CV).click();
    }

    //Check if downloading CV was successful
    public boolean isFileExist(String filename) {
        String home = System.getProperty("user.home");
        String file_with_location = home + "\\Downloads\\" + filename;
        File file = new File(file_with_location);
        return file.exists();
    }
}
