package org.example.portio;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class CaseStudyPageTest extends TestEnvironment{
    @DisplayName("Test Case Study One link")
    @Description("Scroll down to Recent Works and click on the first work, CAse Study One")
    @Test
    public void testLinkCaseStudyOne() {
        loginPage.login();
        homePage.clickOnLinkWork();
        workPage.clickLinkCaseStudyOne();
        Allure.addAttachment("Case Study One Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertTrue(caseStudyPage.isCaseStudyTextVisible());
        Assertions.assertEquals(Pages.CASE_STUDY_PAGE.getUrl(), driver.getCurrentUrl());
    }
    //Pagination using do-while, making screenshot of every page
    @DisplayName("Pagination with case study links")
    @Description("Click on the first recent work (Case Study One) and then click case study links one after each other, at the buttom of the page")
    @Test
    public void testClickOnNextCase() {
        loginPage.login();
        homePage.clickOnLinkWork();
        workPage.clickLinkCaseStudyOne();
        Allure.addAttachment("First Case: Case Study One", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        do {
            caseStudyPage.clickNextCaseLink();
            Allure.addAttachment("Next Case: Event App Case Study", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } while (!caseStudyPage.isLinkNextCaseDisplayed());
        Assertions.assertTrue(recipeAppPage.isRecipeAppTextDisplayed());
    }
    @DisplayName("Pagination with next arrow")
    @Description("Failed pagination, next-arrow doesn't work")
    @Test
    public void testClickOnNextArrow() {
        loginPage.login();
        homePage.clickOnLinkWork();
        workPage.clickLinkCaseStudyOne();
        caseStudyPage.clickOnNextArrow();
        Assertions.assertEquals(Pages.EVENT_APP_CASE_STUDY.getUrl(), driver.getCurrentUrl());
    }
}
