package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    private final String URL = "https://lennertamas.github.io/portio/";
    private final By BUTTON_ACCEPT_TERMS = By.id("terms-and-conditions-button");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.navigate().to(URL);
    }
    public void clickButtonAccept() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement acceptButton = wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_ACCEPT_TERMS));
        acceptButton.click();
    }
}
