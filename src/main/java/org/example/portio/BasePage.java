package org.example.portio;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected final WebDriver driver;
    private final String url;

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public void navigate() {
        driver.navigate().to(url);
    }
}
