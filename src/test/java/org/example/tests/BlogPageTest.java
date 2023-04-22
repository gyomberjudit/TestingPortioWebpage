package org.example.tests;

import io.qameta.allure.*;
import org.example.pages.Pages;
import org.junit.jupiter.api.*;

import java.io.IOException;

@Epic("Lists of data")
@Epic("File handling")
public class BlogPageTest extends BaseTest {

    //Count the number of blog posts with pagination
    @DisplayName("Counting number of blog items")
    @Description("Add the number of blog posts with paginating the pages")
    @Story("Data count")
    @Severity(SeverityLevel.MINOR)
    @Tag("List traversal with pagination")
    @Test
    public void testGetTotalItems() throws InterruptedException {
        loginPage.login();
        homePage.clickOnLinkBlog();
        blogLinkPage.clickButtonSeeAllPosts();
        Thread.sleep(500);
        Assertions.assertEquals(Pages.BLOG_PAGE.getUrl(), driver.getCurrentUrl());
        int expected = 9;
        int actual = blogPage.getTotalItems();

        Assertions.assertEquals(expected, actual);
    }

    //Saving picture from a post to an existing file
    @DisplayName("Save picture1")
    @Description(("Save picture to an existing file"))
    @Story("Save picture")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Data saving")
    @Test
    public void testSavePicture() throws IOException {
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
    @Description("Save picture with creating the file at the same time")
    @Story("Save picture")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Data saving")
    @RepeatedTest(2)
    public void testSavePicture2() {
        String image = "image2.jpg";
        String url = "https://lennertamas.github.io/portio/images/allpost/allPost-5.jpg";
        String format = "jpg";
        loginPage.login();
        homePage.clickOnLinkBlog();
        blogLinkPage.clickButtonSeeAllPosts();
        blogPage.savePicture2(image, url, format);
    }

    //Saving data (by file writing) and comparing them to data at BlogPage (by file reading)
    @DisplayName("Write file")
    @Description("Collect bolg titles iterating through them and save the text to a file, then read them and compare with expected String")
    @Story("Write file")
    @Severity(SeverityLevel.NORMAL)
    @Tag("List traversal with pagination")
    @Tag("File writing")
    @Tag("Data saving")
    @Test
    public void testWriteBlogThemesFile() {
        String file = "blogThemes.txt";
        loginPage.login();
        homePage.clickOnLinkBlog();
        blogLinkPage.clickButtonSeeAllPosts();
        blogPage.writeBlogThemesFile(file);
        String expected = """              
                Markdown Formatting Demo
                Designer Conference at Florida 2020
                Benjamin Franklins thoughts about new designers
                Designers thoughts about mobile UI
                How to become acreative designer
                New designers limitations
                Things you must know as a designer
                World's Most Famous App Developers and Designers
                You must know this before becoming a designer
                """;   //text block instead of concatenation
        String actual = blogPage.getFileData(file);

        Assertions.assertEquals(expected, actual);
    }
}
