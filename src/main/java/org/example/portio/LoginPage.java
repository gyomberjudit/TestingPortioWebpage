package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

//locate elements for login
    private final By INPUT_USERNAME_LOGIN = By.id("email");
    private final By INPUT_PASSWORD_LOGIN = By.id("password");
    private final By BUTTON_LOGIN = By.xpath("//*[@id=\"login\"]/form//button");
    private final By MESSAGE_ALERT = By.id("alert");

//constructor
    public LoginPage(WebDriver driver) {
        super(driver, Pages.LOGIN_PAGE.getUrl());
    }

//methods for login
    public void login() {
        String username = "lovasia";
        String password = "kispal123";
        navigate();
        acceptTerms();
        driver.findElement(INPUT_USERNAME_LOGIN).sendKeys(username);
        driver.findElement(INPUT_PASSWORD_LOGIN).sendKeys(password);
        driver.findElement(BUTTON_LOGIN).click();
    }
    public void login2(String username, String password) {
        driver.findElement(INPUT_USERNAME_LOGIN).sendKeys(username);
        driver.findElement(INPUT_PASSWORD_LOGIN).sendKeys(password);
        driver.findElement(BUTTON_LOGIN).click();
    }
    public void loginWithEnter(String username, String password) {
        navigate();
        acceptTerms();
        driver.findElement(INPUT_USERNAME_LOGIN).sendKeys(username);
        driver.findElement(INPUT_PASSWORD_LOGIN).sendKeys(password);
        driver.findElement(BUTTON_LOGIN).sendKeys(Keys.ENTER);
    }

//methods for assertions
    public String getAlertMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_ALERT));
        return alertMessage.getText();
    }
    public boolean isAlertMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement registerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_ALERT));
        return registerButton.isDisplayed();
    }
    public boolean isLoginButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_LOGIN));
        return loginButton.isDisplayed();
    }
}
