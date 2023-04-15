package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactPage extends BasePage{

//locate elements for ContactPage
    private final By CONTACT_ME_TEXT = By.xpath("//*[@class=\"col-12 text-center\"]/h3");
    private final By CONTACT_INFOS = By.xpath("//*[@class=\"section contact__info\"]/div/div/div");
    private final By INPUT_NAME = By.name("Name");
    private final By INPUT_EMAIL = By.name("email");
    private final By INPUT_MESSAGE = By.id("message");
    private final By CHECKBOX = By.id("aggrement");
    private final By INPUT_SEND_MESSAGE = By.xpath("//*[@type=\"submit\"]");
    private final By HOME_LINK = By.xpath("//*[@class=\"breadcrumb-item\"]/a");
    private final By MESSAGE_STATUS = By.id("contact-form-status");


//constructor
    public ContactPage(WebDriver driver) {
        super(driver, Pages.CONTACT_PAGE.getUrl());
    }



//methods for contactPage
    public Map<String, String> getContactInfo() {
        List<WebElement> contactInfos = driver.findElements(CONTACT_INFOS);

        Map<String, String> map = new HashMap<>();
        for (WebElement info : contactInfos) {
            String title = info.findElement(By.xpath(".//h4")).getText();
            String data = info.findElement(By.xpath(".//p")).getText();
            map.put(title, data);
        }
        return map;
    }
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
    public boolean isContactMeTextDisplayed() {
        return driver.findElement(CONTACT_ME_TEXT).isDisplayed();
    }
    public String getMessageStatusText() {
        return driver.findElement(MESSAGE_STATUS).getText();
    }
    public String getTooltipMessage() {
        Actions actions = new Actions(driver);
        WebElement checkbox = driver.findElement(CHECKBOX);
        actions.moveToElement(checkbox).perform();
        WebElement toolTip = driver.findElement(By.xpath("//*[@id=\"aggrement\"]"));
        return toolTip.getText();
    }
}
