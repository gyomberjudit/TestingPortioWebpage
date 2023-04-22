package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;

public class LoginPage extends BasePage {
    private final By TEXT_TERMS_AND_CONDITIONS = By.xpath("//*[@class=\"popup\"]/h1");
    private final By CLOSE_TERMS_ICON = By.xpath("//*[@class=\"CloseIcon\"]");
    private final By BUTTON_REGISTER = By.xpath("//*[@id=\"login\"]/button[1]");
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

    //Checking if Accepting terms was successful
    public boolean isRegisterButtonDisplayed() {
        return driver.findElement(BUTTON_REGISTER).isDisplayed();
    }

    //logging in without registration (no need for registration with the given credentials, so the user should accept terms before logging in)
    public void login() {
        String username = "lovasia";
        String password = "kispal123";
        navigate();
        acceptTerms();
        driver.findElement(INPUT_USERNAME_LOGIN).sendKeys(username);
        driver.findElement(INPUT_PASSWORD_LOGIN).sendKeys(password);
        driver.findElement(BUTTON_LOGIN).click();
    }

    //logging in, used for tests where the user have to do registration before logging in
    public void login2(String username, String password) {
        driver.findElement(INPUT_USERNAME_LOGIN).sendKeys(username);
        driver.findElement(INPUT_PASSWORD_LOGIN).sendKeys(password);
        driver.findElement(BUTTON_LOGIN).click();
    }

    //Logging in with pressing key Enter (this function doesn't work during exploratory testing)
    public void loginWithEnter(String username, String password) {
        navigate();
        acceptTerms();
        driver.findElement(INPUT_USERNAME_LOGIN).sendKeys(username);
        driver.findElement(INPUT_PASSWORD_LOGIN).sendKeys(password);
        driver.findElement(BUTTON_LOGIN).sendKeys(Keys.ENTER);
    }

    //Get the text of alert message after wrong login
    public String getAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_ALERT)).getText();
    }

    //Checking if alert message of wrong login is visible
    public boolean isAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_ALERT)).isDisplayed();
    }

    //Checking if Login button visible after logging out
    public boolean isLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_LOGIN)).isDisplayed();
    }
}
