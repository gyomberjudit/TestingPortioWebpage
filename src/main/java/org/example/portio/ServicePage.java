package org.example.portio;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ServicePage extends BasePage{

//locate elements for ServicePAge
    private final By SERVICE_PAGE_TEXT = By.id("creative-services");
    private final By SLIDER_FIRST_ELEMENT = By.xpath("//*[contains(@class, \"service__slider\")]/div/div/div[1]");
    private final By SLIDER_LAST_ELEMENT = By.xpath("//*[contains(@class, \"service__slider\")]/div/div/div[6]");
    private final By SLIDES = By.id("//*[@class=\"slick-track\"]/div[contains(@class, \"service__slider\")]");


//constructor
    public ServicePage(WebDriver driver) {
        super(driver, Pages.LANDING_PAGE.getUrl());
    }


//methods for ServicePage
    public void moveSliderWithRightArrow() throws InterruptedException {
        WebElement slider = driver.findElement(SLIDER_FIRST_ELEMENT);
        for (int i=1; i<6; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
            Thread.sleep(1000);
        }
    }
    public void moveSliderWithDragAndDrop() {
        WebElement firstSlide = driver.findElement(SLIDER_FIRST_ELEMENT);
        WebElement lastSlide = driver.findElement(SLIDER_LAST_ELEMENT);
        Actions actions = new Actions(driver);
        actions.moveToElement(firstSlide).clickAndHold(firstSlide).moveToElement(lastSlide).release(lastSlide).build().perform();
    }
    public int quantityOfSlides() {
        List<WebElement> slides = driver.findElements(SLIDES);
        return slides.size();
    }

//methods for assertions
    public boolean isServicePageTextDisplayed() {
        return driver.findElement(SERVICE_PAGE_TEXT).isDisplayed();
    }
    public boolean isLastSlideDisplayed() {
        return driver.findElement(SLIDER_LAST_ELEMENT).isDisplayed();
    }
}
