package org.example.portio;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ServicePageTest extends TestEnvironment{
    @Epic("Content functionalities")
    @Story("Slider")
    @Test
    public void testMoveSlider() throws InterruptedException {
        loginPage.login();
        homePage.clickOnLinkService();
        servicePage.moveSliderWithRightArrow();
        Assertions.assertTrue(servicePage.isLastSlideDisplayed());
    }
    @Epic("Content functionalities")
    @Story("Slider")
    @Test
    public void testSlider() {
        loginPage.login();
        homePage.clickOnLinkService();
        servicePage.moveSliderWithDragAndDrop();
        Assertions.assertTrue(servicePage.isLastSlideDisplayed());
    }
    @Disabled
    @Epic("Content functionalities")
    @Story("Slider")
    @Test
    public void testQuantityOfSlides2() {
        loginPage.login();
        homePage.clickOnLinkService();
        Assertions.assertEquals(6, servicePage.quantityOfSlides());
    }
}
