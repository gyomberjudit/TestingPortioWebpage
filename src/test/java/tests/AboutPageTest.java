package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

@Epic("File handling")
public class AboutPageTest extends BaseTest {

    @DisplayName("Test downloading CV")
    @Description("Failed download by clicking on 'Download CV' button")
    @Severity(SeverityLevel.NORMAL)
    @Tag("File download")
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
