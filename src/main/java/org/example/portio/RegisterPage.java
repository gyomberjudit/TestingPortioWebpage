package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{

//registration
    private final By BUTTON_REGISTER = By.xpath("//*[@id=\"login\"]/button[1]");
    private final By INPUT_USERNAME_REGISTER = By.id("register-username");
    private final By INPUT_PASSWORD_REGISTER = By.id("register-password");
    private final By INPUT_EMAIL_REGISTER = By.id("register-email");
    private final By BUTTON_REGISTER2 = By.xpath("//*[@id=\"register\"]/form//button");
    private final By MESSAGE_USER_REGISTERED = By.xpath("//*[@id=\"register\"]//p");

    public RegisterPage(WebDriver driver) {
        super(driver, Pages.LOGIN_PAGE.getUrl());
    }

//methods for registration
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
    public void wrongRegistration(String username, String password, String email) {
        navigate();
        acceptTerms();
        driver.findElement(BUTTON_REGISTER).click();
        driver.findElement(INPUT_USERNAME_REGISTER).sendKeys(username);
        driver.findElement(INPUT_PASSWORD_REGISTER).sendKeys(password);
        driver.findElement(INPUT_EMAIL_REGISTER).sendKeys(email);
        driver.findElement(BUTTON_REGISTER2).click();
    }
    public String registeredMessage() {
        return driver.findElement(MESSAGE_USER_REGISTERED).getText();
    }
    public boolean userRegistered() {
        return driver.findElement(MESSAGE_USER_REGISTERED).isDisplayed();
    }
}
