package org.example.portio;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class WorkPageTest extends BaseTest{
    @Epic("Content functionalities")
    @Story("Portfolio")
    @Test
    public void testQuantityOfPortfolio() {
        testLinkWork();
        Assertions.assertEquals(4, workPage.quantityOfPortfolio());
    }@Epic("Content functionalities")
    @Story("Portfolio")
    @Test
    public void testQuantityOfPortfolio2() {
        testLinkWork();
        Assertions.assertEquals(4, workPage.quantityOfPortfolio2());
    }
    @Epic("Content functionalities")
    @Story("Portfolio")
    @Test
    public void testContentOfPortfolio() {
        String[] text = {"Case Study One", "Event App Case Study", "UX Case Study for Agriculture App", "Recipe App Ux Study"};
        testLinkWork();
        Allure.addAttachment("Content of portfolio", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertArrayEquals(text, workPage.contentOfPortfolio());
    }
}
