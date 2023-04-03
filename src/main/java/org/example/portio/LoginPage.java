package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

//login
    private final By INPUT_USERNAME_LOGIN = By.id("email");
    private final By INPUT_PASSWORD_LOGIN = By.id("password");
    private final By BUTTON_LOGIN1 = By.xpath("//*[@id=\"register\"]/button[2]");
    private final By BUTTON_LOGIN2 = By.xpath("//*[@id=\"login\"]/form//button");
    private final By MESSAGE_ALERT = By.xpath("//*[@id=\"login\"]//p");
    private final By PORTIO_LOGO = By.xpath("//*[@class=\"container\"]/a/img");

    public LoginPage(WebDriver driver) {
        super(driver, Pages.LOGIN_PAGE.getUrl());
    }

//method for login
    public void login() {
        String username = "teszteszter";
        String password = "teszt";
        driver.findElement(BUTTON_LOGIN1).click();
        driver.findElement(INPUT_USERNAME_LOGIN).sendKeys(username);
        driver.findElement(INPUT_PASSWORD_LOGIN).sendKeys(password);
        driver.findElement(BUTTON_LOGIN2).click();
    }
    public void wrongLogin(String username, String password) {
        driver.findElement(BUTTON_LOGIN1).click();
        driver.findElement(INPUT_USERNAME_LOGIN).sendKeys(username);
        driver.findElement(INPUT_PASSWORD_LOGIN).sendKeys(password);
        driver.findElement(BUTTON_LOGIN2).click();
    }
    public void loginWithEnter() {
        String username = "teszteszter";
        String password = "teszt";
        driver.findElement(BUTTON_LOGIN1).click();
        driver.findElement(INPUT_USERNAME_LOGIN).sendKeys(username);
        driver.findElement(INPUT_PASSWORD_LOGIN).sendKeys(password);
        driver.findElement(BUTTON_LOGIN2).sendKeys(Keys.ENTER);
    }
    public boolean isPortioLogoVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement portioLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(PORTIO_LOGO));
        return portioLogo.isDisplayed();
    }
    public String getAlertMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_ALERT));
        return alertMessage.getText();
    }
    public boolean isAlertMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement registerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_ALERT));
        return registerButton.isDisplayed();
    }
    public boolean isLoginButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_LOGIN2));
        return loginButton.isDisplayed();
    }
}
