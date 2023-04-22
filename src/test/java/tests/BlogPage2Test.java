package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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
    @Attachment("C:\\Users\\Gyömbér Judit\\IdeaProjects\\TestingPortioWebpage\\image.jpg")
    @Tag("dataSaving")
    @Tag("savePicture")
    @Test
    public void testSavePicture() throws IOException, InterruptedException {
        String image = "image.jpg";
        String url = "https://lennertamas.github.io/portio/images/allpost/allPost-2.jpg";
        String format = "jpg";
        loginPage.login();
        homePage.clickOnLinkBlog();
        blogLinkPage.clickButtonSeeAllPosts();
        blogPage.savePicture(image, url, format);
    }

    //Saving picture from a post while making a file, or deleting it if exists
    @DisplayName("Save picture2")
    @Description("Save picture with creating the file at the same time or deleting it if it exists")
    @Story("Data saving")
    @Severity(SeverityLevel.NORMAL)
    @Attachment("C:\\Users\\Gyömbér Judit\\IdeaProjects\\TestingPortioWebpage\\image2.jpg")
    @Tag("dataSaving")
    @Tag("savePicture")
    @RepeatedTest(2)
    public void testSavePicture2() throws InterruptedException {
        String image = "image2.jpg";
        String url = "https://lennertamas.github.io/portio/images/allpost/allPost-5.jpg";
        String format = "jpg";
        loginPage.login();
        homePage.clickOnLinkBlog();
        blogLinkPage.clickButtonSeeAllPosts();
        blogPage.savePicture2(image, url, format);
    }
}
