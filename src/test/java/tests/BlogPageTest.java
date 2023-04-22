package tests;

import org.junit.jupiter.api.Tag;
import io.qameta.allure.*;
import utilPages.Pages;
import org.junit.jupiter.api.*;
import testEnvironment.BaseTest;

@Epic("Data handling")
public class BlogPageTest extends BaseTest {

    //Count the number of blog posts with pagination
    @DisplayName("Counting number of blog items")
    @Description("Add the number of blog posts with paginating the pages")
    @Story("List traversal with pagination")
    @Severity(SeverityLevel.MINOR)
    @Tag("Data listing")
    @Tag("Pagination")
    @Tag("Count items")
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

    //Saving data (by file writing) and comparing them to data at BlogPage (by file reading)
    @DisplayName("Write file")
    @Description("Collect bolg posts' titles iterating through them and save the text to a file, then read them and compare with expected String")
    @Story("List traversal with pagination")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Data listing")
    @Tag("Pagination")
    @Tag("Data saving")
    @Tag("File writing")
    @Tag("File reading")
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
