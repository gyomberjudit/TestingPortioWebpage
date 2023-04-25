package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;

public class ProfilePage extends BasePage {
    private final By NAME_INPUT = By.id("name");
    private final By BIO_INPUT = By.id("bio");
    private final By PHONE_INPUT = By.id("phone-number");
    private final By SAVE_BUTTON = By.xpath("//*[@class=\"form\"]/div[5]/button");
    private final By PROFILE_MESSAGE = By.id("edit-alert");
    private final By DELETE_BUTTON = By.xpath("//*[@class=\"form\"]/div[6]/button");
    private final By CONFIRM_DELETE_BUTTON = By.xpath("//*[@class=\"form\"]/div[7]/button");

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.PROFILE_PAGE.getUrl());
    }


    //Setting profile by giving credentials and saving them
    public void inputName(String name) {
        driver.findElement(NAME_INPUT).sendKeys(name);
    }
    public void inputBio(String bio) {
        driver.findElement(BIO_INPUT).sendKeys(bio);
    }
    public void inputPhone(String phone) {
        driver.findElement(PHONE_INPUT).sendKeys(phone);
    }
    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
    }

    //Get the message of successful profile editing
    public String getProfileMessage() {
        return driver.findElement(PROFILE_MESSAGE).getText();
    }

    //Deleting account by clicking on 'Delete Account' button
    public void deleteAccount() {
        driver.findElement(DELETE_BUTTON).click();
    }

    //Confirm deleting account by clicking on confirmation button
    public void confirmDeletingAccount() {
        driver.findElement(CONFIRM_DELETE_BUTTON).click();
    }

    //Checking if confirmation message is visible during deleting
    public boolean isConfirmMessageDisplayed() {
        return driver.findElement(CONFIRM_DELETE_BUTTON).isDisplayed();
    }

}
