package org.example.portio;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AboutPageTest extends BaseTest{
    @Epic("Technical functionalities")
    @Story("Navigation")
    @Test
    public void testButtonHireMe() throws InterruptedException {
        testLinkAbout();
        aboutPage.clickOnHireMe();
        Assertions.assertTrue(contactPage.isContactMeTextDisplayed());
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("FileDownloading")
    @Test
    public void testFileDownload() {
        String filename = "CV";
        testLinkAbout();
        aboutPage.clickDownloadCV();
        Assertions.assertTrue(aboutPage.isFileExist(filename));
    }
}
