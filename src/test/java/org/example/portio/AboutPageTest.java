package org.example.portio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AboutPageTest extends TestEnvironment{
    @DisplayName("Test Hire me button")
    @Test
    public void testButtonHireMe() throws InterruptedException {
        loginPage.login();
        homePage.clickOnLinkAbout();
        aboutPage.clickOnHireMe();
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @DisplayName("Test downloading CV")
    @Test
    public void testFileDownload() {
        String filename = "CV";
        loginPage.login();
        homePage.clickOnLinkAbout();
        aboutPage.clickDownloadCV();
        Assertions.assertTrue(aboutPage.isFileExist(filename));
    }
}
