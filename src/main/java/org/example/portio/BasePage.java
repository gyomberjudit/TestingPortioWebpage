package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

//variables, location
    protected final WebDriver driver;
    private final String url;
    private final By BUTTON_ACCEPT_TERMS = By.id("terms-and-conditions-button");


//constructor
    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }


//global methods
    public void navigate() {
        driver.navigate().to(url);
    }
    public void acceptTerms() {
        driver.findElement(BUTTON_ACCEPT_TERMS).click();
    }
}
