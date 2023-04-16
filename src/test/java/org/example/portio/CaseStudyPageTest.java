package org.example.portio;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class CaseStudyPageTest extends TestEnvironment{
    @Epic("Technical functionalities")
    @Story("Navigation")
    @Test
    public void testLinkCaseStudyOne() {
        loginPage.login();
        homePage.clickOnLinkWork();
        workPage.clickLinkCaseStudyOne();
        Allure.addAttachment("Case Study One Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertTrue(caseStudyPage.isCaseStudyTextVisible());
        Assertions.assertEquals(Pages.CASE_STUDY_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Navigation")
    @Test
    public void testClickOnNextArrow() {
        loginPage.login();
        homePage.clickOnLinkWork();
        workPage.clickLinkCaseStudyOne();
        caseStudyPage.clickOnNextArrow();
        Assertions.assertEquals(Pages.EVENT_APP_CASE_STUDY.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Navigation")
    @Test
    public void testClickOnNextCase() {
        loginPage.login();
        homePage.clickOnLinkWork();
        workPage.clickLinkCaseStudyOne();
        Allure.addAttachment("First Case", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        do {
            caseStudyPage.clickNextCaseLink();
            Allure.addAttachment("Next Case", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } while (!caseStudyPage.isLinkNextCaseDisplayed());
        Assertions.assertTrue(recipeAppPage.isRecipeAppTextDisplayed());
    }
}
