package org.example.portio;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AboutPageTest extends TestEnvironment{
    @DisplayName("Test Hire me button")
    @Description("Test is Hire me button navigates to Contact page")
    @Test
    public void testButtonHireMe() throws InterruptedException {
        loginPage.login();
        homePage.clickOnLinkAbout();
        aboutPage.clickOnHireMe();
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @DisplayName("Test downloading CV")
    @Description("Clicking on Download button CV should be downloaded")
    @Test
    public void testFileDownload() {
        String filename = "CV";
        loginPage.login();
        homePage.clickOnLinkAbout();
        aboutPage.clickDownloadCV();
        Assertions.assertTrue(aboutPage.isFileExist(filename));
    }
}
