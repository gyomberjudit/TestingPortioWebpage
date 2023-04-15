package org.example.portio;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CaseStudyPage extends BasePage{

//locate elements for caseStudyPage
    private final By CASE_STUDY_TEXT = By.xpath("//*[@class=\"case-details-title\"]/h1");
    private final By NEXT_ARROW = By.xpath("//*[@data-name=\"Group 1244\"]");
    private final By LINK_NEXT_CASE = By.xpath("//*[@class=\" content text-right\"]/h5/a");

//constructor
    public CaseStudyPage(WebDriver driver) {
        super(driver, Pages.CASE_STUDY_PAGE.getUrl());
    }

//methods for caseStudyPage
    public boolean isCaseStudyTextVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement caseStudyText = wait.until(ExpectedConditions.visibilityOfElementLocated(CASE_STUDY_TEXT));
        return caseStudyText.isDisplayed();
    }
    public void clickOnNextArrow() {
        Actions actions = new Actions(driver);
        WebElement nextArrow = driver.findElement(NEXT_ARROW);
        actions.moveToElement(nextArrow).click().build().perform();
    }
    public void clickNextCaseLink() {
        Actions actions = new Actions(driver);
        WebElement nextCase = driver.findElement(LINK_NEXT_CASE);
        actions.moveToElement(nextCase).click().build().perform();
    }
    public boolean isLinkNextCaseDisplayed() {
        return driver.findElement(LINK_NEXT_CASE).isDisplayed();
    }
}
