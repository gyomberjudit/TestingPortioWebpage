package org.example.portio;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class CaseStudyPageTest extends BaseTest{
    @Epic("Technical functionalities")
    @Story("Navigation")
    @Test
    public void testCaseStudyOneLink() {
        testLinkWork();
        workPage.clickLinkCaseStudyOne();
        Allure.addAttachment("Case Study One Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertTrue(caseStudyPage.isCaseStudyTextVisible());
        Assertions.assertEquals(Pages.CASE_STUDY_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Navigation")
    @Test
    public void testClickOnNextArrow() {
        testLinkWork();
        workPage.clickLinkCaseStudyOne();
        Assertions.assertTrue(caseStudyPage.isCaseStudyTextVisible());
        caseStudyPage.clickOnNextArrow();
        Assertions.assertEquals(Pages.EVENT_APP_CASE_STUDY.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Navigation")
    @Test
    public void testClickOnNextCase() {
        testLinkWork();
        workPage.clickLinkCaseStudyOne();
        Assertions.assertTrue(caseStudyPage.isCaseStudyTextVisible());
        Allure.addAttachment("First Case", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        do {
            caseStudyPage.clickNextCaseLink();
            Allure.addAttachment("Next Case", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } while (!caseStudyPage.isLinkNextCaseDisplayed());
        Assertions.assertTrue(recipeAppPage.isRecipeAppTextDisplayed());
    }
}
