package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

//login
    private final By INPUT_USERNAME_LOGIN = By.id("email");
    private final By INPUT_PASSWORD_LOGIN = By.id("password");
    private final By BUTTON_LOGIN = By.xpath("//*[@id=\"login\"]/form//button");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

//login
    public void enterUsernameLogin(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_USERNAME_LOGIN));
        usernameInput.sendKeys(username);
    }
    public void enterPasswordLogin(String password) {
        driver.findElement(INPUT_PASSWORD_LOGIN).sendKeys(password);
    }
    public void clickButtonLogin() {
        Actions actions = new Actions(driver);
        WebElement buttonLogin = driver.findElement(BUTTON_LOGIN);
        actions.moveToElement(buttonLogin,2,2).click().build().perform();
    }
    public void runJSLogin() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement buttonLogin = driver.findElement(BUTTON_LOGIN);
        js.executeScript("myFunction()", buttonLogin);
    }
    public void handleAlertBox() {
        driver.switchTo().alert().dismiss();
    }
    public void login() {
        String username = "teszteszter";
        String password = "teszt";
        navigate();
        clickButtonAccept();
        enterUsernameLogin(username);
        enterPasswordLogin(password);
        runJSLogin();
    }

}
