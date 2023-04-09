package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class WorkPage extends BasePage{

//locate elements for workPage
    private final By WORKPAGE_TEXT = By.id("check-some-of-my-recent-work");
    private final By WORKS = By.xpath("//*[@class=\"portfolio-item\"]");
    private final By WORK_TITLES = By.xpath("//*[@class=\"portfolio-item\"]/div/h3/a");
    private final By LINK_CASE_STUDY_ONE = By.xpath("//*[text()=\"Case Study One\"]");

//constructor
    public WorkPage(WebDriver driver) {
        super(driver, Pages.LANDING_PAGE.getUrl());
    }

//methods for workPage
    public int quantityOfPortfolio() {
        List<WebElement> works = driver.findElements(WORKS);

        int quantity = 0;
        for (int i=0; i< works.size(); i++) {
            quantity ++;
        }
        return quantity;
    }
    public String[] contentOfPortfolio() {
        List<WebElement> works = driver.findElements(WORK_TITLES);

        String[] items = new String[works.size()];
        int i=0;
        for (WebElement work : works) {
            items[i++] = work.getText();
        }
        return items;
    }
    public void clickLinkCaseStudyOne() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement caseStudyLink = driver.findElement(LINK_CASE_STUDY_ONE);
        js.executeScript("arguments[0].scrollIntoView();", caseStudyLink);
        js.executeScript("arguments[0].click();", caseStudyLink);
    }

//methods for assertions
    public boolean isWorkPageTextVisible() {
        return driver.findElement(WORKPAGE_TEXT).isDisplayed();
    }
}
