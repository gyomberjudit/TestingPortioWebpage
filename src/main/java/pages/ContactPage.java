package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactPage extends BasePage {
    private final By CONTACT_ME_TEXT = By.xpath("//*[@class=\"col-12 text-center\"]/h3");
    private final By CONTACT_INFO = By.xpath("//*[@class=\"section contact__info\"]/div/div/div");
    private final By INPUT_NAME = By.name("Name");
    private final By INPUT_EMAIL = By.name("email");
    private final By INPUT_MESSAGE = By.id("message");
    private final By CHECKBOX = By.id("aggrement");
    private final By INPUT_SEND_MESSAGE = By.xpath("//*[@type=\"submit\"]");
    private final By MESSAGE_STATUS = By.id("contact-form-status");

    public ContactPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.CONTACT_PAGE.getUrl());
    }


    //Iterating through Contact information List, write the data into HashMap
    public Map<String, String> getContactInfo() {
        List<WebElement> contactInfo = driver.findElements(CONTACT_INFO);

        Map<String, String> map = new HashMap<>();
        for (WebElement info : contactInfo) {
            String title = info.findElement(By.xpath(".//h4")).getText();
            String data = info.findElement(By.xpath(".//p")).getText();
            map.put(title, data);
        }
        return map;
    }

    //Give data and message while filling the Contact Form
    public void inputName(String name) {
        driver.findElement(INPUT_NAME).sendKeys(name);
    }
    public void inputEmail(String email) {
        driver.findElement(INPUT_EMAIL).sendKeys(email);
    }
    public void inputMessage(String message) {
        driver.findElement(INPUT_MESSAGE).sendKeys(message);
    }

    //Check checkbox by clicking on the box
    public void checkCheckbox() {
        driver.findElement(CHECKBOX).click();
    }

    //Sending message by clicking on Send Message button
    public void sendMessage() {
        driver.findElement(INPUT_SEND_MESSAGE).click();
    }

    //scroll to the message to take screenshot
    public void scrollWindow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
    }

    //Checking if navigating to ContactPage is successful
    public boolean isContactMeTextDisplayed() {
        return driver.findElement(CONTACT_ME_TEXT).isDisplayed();
    }

    //Checking if sending message was successful
    public String getMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_STATUS)).getText();
    }


}
