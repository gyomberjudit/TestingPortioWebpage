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
    public void testClickOnNextArrow() {
        testLinkCaseStudyOne();
        caseStudyPage.clickOnNextArrow();
        Assertions.assertEquals(Pages.EVENT_APP_CASE_STUDY.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Navigation")
    @Test
    public void testClickOnNextCase() {
        testLinkCaseStudyOne();
        Allure.addAttachment("First Case", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        do {
            caseStudyPage.clickNextCaseLink();
            Allure.addAttachment("Next Case", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } while (!caseStudyPage.isLinkNextCaseDisplayed());
        Assertions.assertTrue(recipeAppPage.isRecipeAppTextDisplayed());
    }
}
