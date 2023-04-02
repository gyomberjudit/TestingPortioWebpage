package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BasePage{

    //private final By BUTTON_ACCEPT_TERMS = By.id("terms-and-conditions-button");
    private final By BUTTON_REGISTER = By.xpath("//*[@id=\"login\"]/button[1]");
    private final By INPUT_USERNAME_REGISTER = By.id("register-username");
    private final By INPUT_PASSWORD_REGISTER = By.id("register-password");
    private final By INPUT_EMAIL_REGISTER = By.id("register-email");
    //private final By INPUT_DESCRIPTION = By.id("register-description");
    private final By BUTTON_REGISTER2 = By.xpath("//*[@id=\"register\"]/form//button");
    private final By MESSAGE_USER_REGISTERED = By.xpath("//*[@id=\"register\"]//p");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

//registration
   /* public void clickButtonAccept() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement acceptButton = wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_ACCEPT_TERMS));
        acceptButton.click();
    }*/
    public void clickButtonRegister() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement registerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_REGISTER));
        registerButton.click();
    }
    public void enterUsername(String username) {
        driver.findElement(INPUT_USERNAME_REGISTER).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(INPUT_PASSWORD_REGISTER).sendKeys(password);
    } public void enterEmail(String email) {
        driver.findElement(INPUT_EMAIL_REGISTER).sendKeys(email);
    }
    public void clickButtonRegister2() {
        driver.findElement(BUTTON_REGISTER2).click();
    }
    public String registeredMessage() {
        return driver.findElement(MESSAGE_USER_REGISTERED).getText();
    }
    public void register() {
        String username = "teszteszter";
        String password = "teszt";
        String email = "teszeszter5@gmail.com";
        navigate();
        clickButtonAccept();
        clickButtonRegister();
        enterUsername(username);
        enterPassword(password);
        enterEmail(email);
        clickButtonRegister2();
    }
}
