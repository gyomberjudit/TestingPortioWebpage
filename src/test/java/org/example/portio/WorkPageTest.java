package org.example.portio;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class WorkPageTest extends TestEnvironment{
    @DisplayName("Number of Recent Works")
    @Description("Count numer of Recent Works")
    @Test
    public void testQuantityOfPortfolio() {
        loginPage.login();
        homePage.clickOnLinkWork();
        Assertions.assertEquals(4, workPage.quantityOfPortfolio());
    }
    @DisplayName("Titles of Recent Works")
    @Description("Get all the titles of Recent Works in a String array")
    @Test
    public void testContentOfPortfolio() {
        String[] text = {"Case Study One", "Event App Case Study", "UX Case Study for Agriculture App", "Recipe App Ux Study"};
        loginPage.login();
        homePage.clickOnLinkWork();
        Allure.addAttachment("Content of portfolio", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertArrayEquals(text, workPage.contentOfPortfolio());
    }
}
