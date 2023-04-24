package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import testEnvironment.BaseTest;

import java.io.IOException;

@Epic("File handling")
@Epic("Data handling")
public class BlogPage2Test extends BaseTest {

    //Saving picture from a post to an existing file
    @DisplayName("Save picture1")
    @Description(("Save picture to an existing file"))
    @Story("Data saving")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataSaving")
    @Tag("savePicture")
    @Test
    public void testSavePicture() throws IOException{
        String fileName = "image.jpg";
        String downloadedFileName = "download.jpg";
        By xpath = By.xpath("//*[@class=\"row\"]/div[2]//img");
        String targetUrl = "https://lennertamas.github.io/portio/images/allpost/allPost-2.jpg";
        String format = "jpg";

        loginPage.login();
        homePage.clickOnLinkBlog();
        blogPage.savePicture(fileName, xpath, format);
        blogPage.downloadImage(downloadedFileName, targetUrl, format);
        double expectedPercentage = 0.0;
        double actualPercentage = blogPage.getDifferencePercentage(fileName, downloadedFileName);

        Assertions.assertEquals(expectedPercentage, actualPercentage);
    }

    @DisplayName("Save picture2")
    @Description("Save picture with creating the file at the same time or deleting it if it exists")
    @Story("Data saving")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataSaving")
    @Tag("savePicture")
    @RepeatedTest(2)
    public void testSavePicture3() throws IOException{
        String fileName = "image2.jpg";
        String downloadedFileName = "download2.jpg";
        By xpath = By.xpath("//*[@class=\"row\"]/div[3]//img");
        String targetUrl = "https://lennertamas.github.io/portio/images/allpost/allPost-7.jpg";
        String format = "jpg";

        loginPage.login();
        homePage.clickOnLinkBlog();
        blogPage.savePicture2(fileName, xpath, format);
        blogPage.downloadImage(downloadedFileName, targetUrl, format);
        double expectedPercentage = 0.0;
        double actualPercentage = blogPage.getDifferencePercentage(fileName, downloadedFileName);

        Assertions.assertEquals(expectedPercentage, actualPercentage);
    }
}
