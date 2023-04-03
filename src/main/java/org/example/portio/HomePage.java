package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private final By LINK_LOGOUT = By.xpath("//*[@id=\"logout-link\"]/a");

    public HomePage(WebDriver driver) {
        super(driver, Pages.LANDING_PAGE.getUrl());
    }

    public void logout() {
        driver.findElement(LINK_LOGOUT).click();
    }
}
