package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import testEnvironment.BaseTest;

import java.io.IOException;

@Epic("File handling")
public class DataSavingTest extends BaseTest {

    //Saving picture from a post to an existing file
    @DisplayName("TC20 - Save picture1")
    @Description(("TC20 - Save picture to an existing file"))
    @Story("Data saving")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataSaving")
    @Tag("savePicture")
    @Test
    public void testSavePicture() throws IOException{
        String username = "lovasia";
        String password = "kispal123";
        String fileName = "image.jpg";
        String downloadedFileName = "download.jpg";
        By xpath = By.xpath("//*[@class=\"row\"]/div[2]//img");
        String targetUrl = "https://lennertamas.github.io/portio/images/allpost/allPost-2.jpg";
        String format = "jpg";

        //login
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        Assertions.assertTrue(loggedIn);
        addAttachment("User is logged in");

        //saving picture to an existing file from the website and comparing it with the downloaded picture
        homePage.clickOnLinkBlog();
        blogLinkPage.savePicture(fileName, xpath, format);
        blogLinkPage.downloadImage(downloadedFileName, targetUrl, format);
        double expectedPercentage = 0.0;
        double actualPercentage = blogLinkPage.getDifferencePercentage(fileName, downloadedFileName);

        Assertions.assertEquals(expectedPercentage, actualPercentage);
    }

    //Saving picture from a post while making the file
    @DisplayName("TC21 - Save picture2")
    @Description("Save picture with creating the file at the same time or deleting it if it exists")
    @Story("Data saving")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataSaving")
    @Tag("savePicture")
    @Test
    public void testSavePicture2() throws IOException{
        String username = "lovasia";
        String password = "kispal123";
        String fileName = "image2.jpg";
        String downloadedFileName = "download2.jpg";
        By xpath = By.xpath("//*[@class=\"row\"]/div[3]//img");
        String targetUrl = "https://lennertamas.github.io/portio/images/allpost/allPost-7.jpg";
        String format = "jpg";

        //login
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        Assertions.assertTrue(loggedIn);
        addAttachment("User is logged in");

        //saving picture while creating the file to save it to from the website and comparing it with the downloaded picture
        homePage.clickOnLinkBlog();
        blogLinkPage.savePicture2(fileName, xpath, format);
        blogLinkPage.downloadImage(downloadedFileName, targetUrl, format);
        double expectedPercentage = 0.0;
        double actualPercentage = blogLinkPage.getDifferencePercentage(fileName, downloadedFileName);

        Assertions.assertEquals(expectedPercentage, actualPercentage);
    }

    //Downloading a file given on the website
    @DisplayName("TC22 - Test downloading CV")
    @Description("Failed download by clicking on 'Download CV' button")
    @Story("File download")
    @Severity(SeverityLevel.NORMAL)
    @Tag("fileDownload")
    @Test
    public void testFileDownload() throws InterruptedException {
        String username = "lovasia";
        String password = "kispal123";
        String filename = "CV.pdf";

        //login
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        Assertions.assertTrue(loggedIn);
        addAttachment("User is logged in");

        //download CV
        homePage.clickOnLinkAbout();
        aboutPage.scrollToDownloadButton();
        aboutPage.clickDownloadCV();
        boolean fileExists = aboutPage.isFileExist(filename);

        Assertions.assertTrue(fileExists);
    }
}
