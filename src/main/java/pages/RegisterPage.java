package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;

public class RegisterPage extends BasePage {
    private final By BUTTON_REGISTER = By.xpath("//*[@id=\"login\"]/button[1]");   // ez a login pagen van!!!!!
    private final By INPUT_USERNAME_REGISTER = By.id("register-username");
    private final By INPUT_PASSWORD_REGISTER = By.id("register-password");
    private final By INPUT_EMAIL_REGISTER = By.id("register-email");
    private final By BUTTON_REGISTER2 = By.xpath("//*[@id=\"register\"]/form//button");
    private final By MESSAGE_USER_REGISTERED = By.xpath("//*[@id=\"register\"]//p");
    private final By BUTTON_LOGIN = By.xpath("//*[@id=\"register\"]/button[2]");

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.LOGIN_PAGE.getUrl());
    }


    //Successful registration with the given right credentials
    public void registration() {
        String username = "teszteszter";
        String password = "teszt";
        String email = "teszteszter5@gmail.com";
        navigate();
        acceptTerms();
        driver.findElement(BUTTON_REGISTER).click();
        driver.findElement(INPUT_USERNAME_REGISTER).sendKeys(username);
        driver.findElement(INPUT_PASSWORD_REGISTER).sendKeys(password);
        driver.findElement(INPUT_EMAIL_REGISTER).sendKeys(email);
        driver.findElement(BUTTON_REGISTER2).click();
    }

    //Method for registration with wrong data
    public void wrongRegistration(String username, String password, String email) {
        navigate();
        acceptTerms();
        driver.findElement(BUTTON_REGISTER).click();
        driver.findElement(INPUT_USERNAME_REGISTER).sendKeys(username);
        driver.findElement(INPUT_PASSWORD_REGISTER).sendKeys(password);
        driver.findElement(INPUT_EMAIL_REGISTER).sendKeys(email);
        driver.findElement(BUTTON_REGISTER2).click();
    }

    //Navigating to LoginPage by clicking on Login button after registration
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
