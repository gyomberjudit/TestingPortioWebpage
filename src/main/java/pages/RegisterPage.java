package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;

public class RegisterPage extends BasePage {
    private final By BUTTON_REGISTER = By.xpath("//*[@id=\"login\"]/button[1]");
    private final By INPUT_USERNAME_REGISTER = By.id("register-username");
    private final By INPUT_PASSWORD_REGISTER = By.id("register-password");
    private final By INPUT_EMAIL_REGISTER = By.id("register-email");
    private final By BUTTON_REGISTER2 = By.xpath("//*[@id=\"register\"]/form//button");
    private final By MESSAGE_USER_REGISTERED = By.xpath("//*[@id=\"register\"]//p");
    private final By BUTTON_LOGIN = By.xpath("//*[@id=\"register\"]/button[2]");

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.LOGIN_PAGE.getUrl());
    }


    //methods for registration
    @Step("Navigate to RegisterPage")
    public void clickButtonRegister() {
        driver.findElement(BUTTON_REGISTER).click();
    }
    public void inputUsername(String username) {
        driver.findElement(INPUT_USERNAME_REGISTER).sendKeys(username);
    }
    public void inputPassword(String password) {
        driver.findElement(INPUT_PASSWORD_REGISTER).sendKeys(password);
    }
    public void inputEmail(String email) {
        driver.findElement(INPUT_EMAIL_REGISTER).sendKeys(email);
    }
    @Step("Registrate")
    public void clickButtonRegister2() {
        driver.findElement(BUTTON_REGISTER2).click();
    }

    //Navigating to LoginPage by clicking on Login button after registration
    @Step("Navigate to LoginPage")
    public void clickLoginButton() {
        driver.findElement(BUTTON_LOGIN).click();
    }

    //Get the text of successful registration message
    public String registeredMessage() {
        return driver.findElement(MESSAGE_USER_REGISTERED).getText();
    }

    //Checking if message of successful registration visible
    public boolean userRegistered() {
        return driver.findElement(MESSAGE_USER_REGISTERED).isDisplayed();
    }
}
