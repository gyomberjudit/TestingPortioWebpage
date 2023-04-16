package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResumePage extends BasePage{

//locate elements for ServicePAge
    private final By RESUME_PAGE_TEXT = By.id("my-expertises");
    private final By BUTTON_EXPERIENCES = By.xpath("//*[@href=\"#experience\"]");
    private final By BUTTON_EDUCATION = By.xpath("//*[@href=\"#education\"]");
    private final By EXPERIENCES_ITEMS = By.xpath("//*[@id=\"experience\"]/div");
    private final By EXPERIENCE_YEARS = By.xpath("//*[@id=\"experience\"]/div/span");
    private final By EXPERIENCES = By.xpath("//*[@id=\"experience\"]/div/h4");
    private final By EDUCATION_YEAR = By.xpath("//*[@id=\"education\"]/div[1]/span");
    private final By EDUCATION = By.xpath("//*[@id=\"education\"]/div[1]/h4");

//constructor
    public ResumePage(WebDriver driver) {
        super(driver, Pages.LANDING_PAGE.getUrl());
    }

//methods for ResumePage
    public void clickExperiences() {
        moveToElement(BUTTON_EXPERIENCES);
    }
    public void clickEducation() {
        moveToElement(BUTTON_EDUCATION);
    }
    public int quantityOfExperiences() {
        List<WebElement> experiences = driver.findElements(EXPERIENCES_ITEMS);
        int quantity = 0;
        for (int i=0; i< experiences.size(); i++) {
            quantity++;
        }
        return quantity;
    }
    public int quantityOfExperiences2() {
        List<WebElement> experiences = driver.findElements(EXPERIENCES_ITEMS);
        return experiences.size();
    }
    public String[] getYearsOfExperience() {
        List<WebElement> years = driver.findElements(EXPERIENCE_YEARS);

        String[] items = new String[years.size()];
        int i=0;
        for (WebElement year : years) {
            items[i++] = year.getText();
        }
        return items;
    }
    public String[] getFirmsOfExperience() {
        List<WebElement> firms = driver.findElements(EXPERIENCES);

        String[] items = new String[firms.size()];
        int i=0;
        for (WebElement firm : firms) {
            items[i++] = firm.getText();
        }
        return items;
    }
    public String getEducation() {
        String year = driver.findElement(EDUCATION_YEAR).getText();
        String education = driver.findElement(EDUCATION).getText();
        return year + ", " + education;
    }

    public boolean isResumePageTextDisplayed() {
        return driver.findElement(RESUME_PAGE_TEXT).isDisplayed();
    }
}
