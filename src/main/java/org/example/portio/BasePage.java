package org.example.portio;

import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    public String getURL() {
        return URL;
    }

    private final String URL = "https://lennertamas.github.io/portio/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.navigate().to(URL);
    }
}
