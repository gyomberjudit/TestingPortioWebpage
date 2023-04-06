package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage{

//locate elements for ContactPage
    private final By CONTACT_ME_TEXT = By.xpath("//*[@class=\"col-12 text-center\"]/h3");
    private final By INPUT_NAME = By.name("Name");
    private final By INPUT_EMAIL = By.name("email");
    private final By INPUT_MESSAGE = By.id("message");
    private final By CHECKBOX = By.name("agreement");
    private final By INPUT_SEND_MESSAGE = By.xpath("//*[@type=\"submit\"]");
    private final By HOME_LINK = By.xpath("//*[@class=\"breadcrumb-item\"]/a");
    private final By MESSAGE_STATUS = By.id("contact-form-status");

//constructor
    public ContactPage(WebDriver driver) {
        super(driver, Pages.CONTACT_PAGE.getUrl());
    }

//methods for contactPage
    public void fillContactMeForm(String name, String email, String message) {
        driver.findElement(INPUT_NAME).sendKeys(name);
        driver.findElement(INPUT_EMAIL).sendKeys(email);
        driver.findElement(INPUT_MESSAGE).sendKeys(message);
    }
    public void checkCheckbox() {
        driver.findElement(CHECKBOX).click();
    }
    public void sendMessage() {
        driver.findElement(INPUT_SEND_MESSAGE).click();
    }
    public void getBackToHomePage() {
        driver.findElement(HOME_LINK).click();
    }

//methods for assertions
    public boolean isContactMeTextVisible() {
        return driver.findElement(CONTACT_ME_TEXT).isDisplayed();
    }
    public String getMessageStatusText() {
        return driver.findElement(MESSAGE_STATUS).getText();
    }
    public String getWarningMessage() {
        return driver.switchTo().alert().getText();
    }
}
