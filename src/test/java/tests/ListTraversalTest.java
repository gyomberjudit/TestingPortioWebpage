package tests;

import org.junit.jupiter.api.Tag;
import io.qameta.allure.*;
import utilPages.Pages;
import org.junit.jupiter.api.*;
import testEnvironment.BaseTest;

@Epic("Data handling")
public class ListTraversalTest extends BaseTest {

    //Count the number of blog posts with pagination
    @DisplayName("TC13 - Counting number of blog items")
    @Description("Add the number of blog posts with paginating the pages")
    @Story("List traversal with pagination")
    @Severity(SeverityLevel.MINOR)
    @Tag("dataListing")
    @Tag("Pagination")
    @Tag("dataCount")
    @Test
    public void testGetTotalItems() throws InterruptedException {
        String username = "lovasia";
        String password = "kispal123";

        //login
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        Assertions.assertTrue(loggedIn);
        addAttachment("User is logged in");

        //navigate to BlogPage
        homePage.clickOnLinkBlog();
        blogLinkPage.clickButtonSeeAllPosts();
        blogPage.scrollWindow();
        Thread.sleep(2000);
        addAttachment("There are 6 items on the first page");
        Assertions.assertEquals(Pages.BLOG_PAGE.getUrl(), driver.getCurrentUrl());

        //get the number of blog posts
        int expected = 9;
        int actual = blogPage.getTotalItems();
        addAttachment("There are 3 items on the second page");

        Assertions.assertEquals(Pages.BLOG_PAGE_TWO.getUrl(), driver.getCurrentUrl());
        Assertions.assertEquals(expected, actual);
    }

    //Saving data (by file writing) and comparing them to data at BlogPage (by file reading)
    @DisplayName("TC14 - Write file")
    @Description("Collect bolg posts' titles iterating through them and save the text to a file, then read them and compare with expected String")
    @Story("List traversal with pagination")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataListing")
    @Tag("pagination")
    @Tag("dataSaving")
    @Tag("fileWriting")
    @Tag("fileReading")
    @Test
    public void testWriteBlogTitlesFile() throws InterruptedException {
        String username = "lovasia";
        String password = "kispal123";
        String file = "blogTitles.txt";

        //login
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        Assertions.assertTrue(loggedIn);
        addAttachment("User is logged in");

        //navigate to BlogPage
        homePage.clickOnLinkBlog();
        blogLinkPage.clickButtonSeeAllPosts();
        blogPage.scrollWindow();
        Thread.sleep(2000);
        addAttachment("Blog titles on the first page");
        Assertions.assertEquals(Pages.BLOG_PAGE.getUrl(), driver.getCurrentUrl());

        //write blog posts' titles to blogTitles.txt file and compare it - by reading the file - with the expected text block
        blogPage.writeBlogTitlesFile(file);
        addAttachment("Blog titles on the second page");
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

        Assertions.assertEquals(Pages.BLOG_PAGE_TWO.getUrl(), driver.getCurrentUrl());
        Assertions.assertEquals(expected, actual);
    }
}
