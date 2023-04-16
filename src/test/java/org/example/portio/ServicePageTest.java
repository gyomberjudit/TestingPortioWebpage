package org.example.portio;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServicePageTest extends BaseTest{
    @Epic("Content functionalities")
    @Story("Slider")
    @Test
    public void testMoveSlider() {
        testLinkService();
        servicePage.moveSliderWithRightArrow();
        Assertions.assertTrue(servicePage.isLastSlideDisplayed());
    }
    @Epic("Content functionalities")
    @Story("Slider")
    @Test
    public void testSlider() {
        testLinkService();
        servicePage.moveSliderWithDragAndDrop();
        Assertions.assertTrue(servicePage.isLastSlideDisplayed());
    }
}
