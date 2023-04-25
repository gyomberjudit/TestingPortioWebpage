package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;

public class LoginPage extends BasePage {
    private final By TEXT_TERMS_AND_CONDITIONS = By.xpath("//*[@class=\"popup\"]/h1");
    private final By CLOSE_TERMS_ICON = By.xpath("//*[@class=\"CloseIcon\"]");
    private final By INPUT_USERNAME_LOGIN = By.id("email");
    private final By INPUT_PASSWORD_LOGIN = By.id("password");
    private final By BUTTON_LOGIN = By.xpath("//*[@id=\"login\"]/form//button");
    private final By MESSAGE_ALERT = By.id("alert");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.LOGIN_PAGE.getUrl());
    }


    //Checking if text of 'Terms and Conditions' visible
    public boolean isTermsAndConditionsTextDisplayed() {
        return driver.findElement(TEXT_TERMS_AND_CONDITIONS).isDisplayed();
    }

    //Close Accepting Terms by clicking on Close icon without accepting it
    public void clickOnCloseIcon() {
        driver.findElement(CLOSE_TERMS_ICON).click();
    }

    //methods for login
    public void inputUsername(String username) {
        driver.findElement(INPUT_USERNAME_LOGIN).sendKeys(username);
    }
    public void inputPassword(String password) {
        driver.findElement(INPUT_PASSWORD_LOGIN).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(BUTTON_LOGIN).click();
    }

    //Get the text of alert message after wrong login
    public String getAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_ALERT)).getText();
    }

    //Checking if alert message of wrong login is visible
    public boolean isAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_ALERT)).isDisplayed();
    }

    //Checking if Login button visible
    public boolean isLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_LOGIN)).isDisplayed();
    }
}
