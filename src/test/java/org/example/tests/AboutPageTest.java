package org.example.tests;

import io.qameta.allure.*;
import org.example.pages.Pages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Navigation")
@Epic("File handling")
public class AboutPageTest extends BaseTest {

    @DisplayName("Test Hire me button")
    @Description("Test if Hire me button navigates to Contact page")
    @Story("Navigation with button")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Navigation")
    @Test
    public void testButtonHireMe() {
        loginPage.login();
        homePage.clickOnLinkAbout();
        aboutPage.clickOnHireMe();
        String expected = Pages.CONTACT_PAGE.getUrl();
        String actual = driver.getCurrentUrl();

        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Test downloading CV")
    @Description("Clicking on Download button CV should be downloaded")
    @Story("File download")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Download file")
    @Test
    public void testFileDownload() {
        String filename = "CV";
        loginPage.login();
        homePage.clickOnLinkAbout();
        aboutPage.clickDownloadCV();
        boolean fileExists = aboutPage.isFileExist(filename);

        Assertions.assertTrue(fileExists);
    }
}
