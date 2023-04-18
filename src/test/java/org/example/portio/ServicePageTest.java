package org.example.portio;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServicePageTest extends TestEnvironment{
    @DisplayName("Move slider1")
    @Description("Move slider from the first item to the last one with pressing right arrow")
    @Test
    public void testMoveSlider() throws InterruptedException {
        loginPage.login();
        homePage.clickOnLinkService();
        servicePage.moveSliderWithRightArrow();
        Assertions.assertTrue(servicePage.isLastSlideDisplayed());
    }
    @DisplayName("Move slider2")
    @Description("Move slider from the first item to the last one with drag and drop")
    @Test
    public void testSlider() {
        loginPage.login();
        homePage.clickOnLinkService();
        servicePage.moveSliderWithDragAndDrop();
        Assertions.assertTrue(servicePage.isLastSlideDisplayed());
    }
    @Disabled
    @DisplayName("Count items in slider")
    @Description("Count the number of items in the slider")
    @Test
    public void testQuantityOfSlides2() {
        loginPage.login();
        homePage.clickOnLinkService();
        Assertions.assertEquals(6, servicePage.quantityOfSlides());
    }
}
