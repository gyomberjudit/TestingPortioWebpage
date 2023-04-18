package org.example.portio;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.LinkedHashMap;

public class BlogPage2Test extends TestEnvironment{

    @DisplayName("Counting number of blog items")
    @Description("Add the number of blogs with paginating the pages")
    @Test
    public void testGetTotalItems() {
        loginPage.login();
        homePage.clickOnLinkBlog();
        blogPage.clickButtonSeeAllPosts();
        Assertions.assertEquals(Pages.BLOG_PAGE.getUrl(), driver.getCurrentUrl());
        int actual = blogPage2.getTotalItems();
        Assertions.assertEquals(9, actual);
    }
    @DisplayName("Collect blog titles and blogs' tag")
    @Description("Iterating the blogs one after each other get the blog's tag")
    @Test
    public void testGetTags() {
        loginPage.login();
        homePage.clickOnLinkBlog();
        blogPage.clickButtonSeeAllPosts();

        LinkedHashMap<String, String> expected = new LinkedHashMap<>();
        expected.put("Markdown Formatting Demo", "Website");
        expected.put("Designer Conference at Florida 2020", "Mobile");
        expected.put("Benjamin Franklins thoughts about new designers", "Website");
        expected.put("Designers thoughts about mobile UI", "Mobile");
        expected.put("How to become acreative designer", "Fun");
        expected.put("New designers limitations", "Website");
        expected.put("Things you must know as a designer", "Mobile");
        expected.put("World's Most Famous App Developers and Designers", "Fun");
        expected.put("You must know this before becoming a designer", "Fun");

        LinkedHashMap<String, String> actual = blogPage2.getTags();

        Assertions.assertEquals(expected, actual);
    }
    @DisplayName("Save picture1")
    @Description(("Save picture to an existing file"))
    @Test
    public void testSavePicture() throws IOException {
        loginPage.login();
        homePage.clickOnLinkBlog();
        blogPage.clickButtonSeeAllPosts();
        blogPage2.savePicture();
    }
    @DisplayName("Save picture2")
    @Description("Save picture with creating the file at the same time")
    @Test
    public void testSavePicture2() {
        loginPage.login();
        homePage.clickOnLinkBlog();
        blogPage.clickButtonSeeAllPosts();
        blogPage2.savePicture2();
    }
    @DisplayName("Write file")
    @Description("Collect bolg titles iterating through them and save the text to a file, then read them and compare with expected String")
    @Test
    public void testWriteBlogThemesFile() {
        loginPage.login();
        homePage.clickOnLinkBlog();
        blogPage.clickButtonSeeAllPosts();
        blogPage2.writeBlogThemesFile();

        String expected = """              
                Markdown Formatting Demo,
                Designer Conference at Florida 2020,
                Benjamin Franklins thoughts about new designers,
                Designers thoughts about mobile UI,
                How to become acreative designer,
                New designers limitations,
                Things you must know as a designer,
                World's Most Famous App Developers and Designers,
                You must know this before becoming a designer,
                """;   //text block instead of concatenation

        Assertions.assertEquals(expected, blogPage2.getFileData());
    }
}
