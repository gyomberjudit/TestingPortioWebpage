package org.example.portio;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

public class BlogPage2Test extends BaseTest{
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testHomeLink() {
        testButtonSeeAllPosts();
        blogPage2.clickOnHomeLink();
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
        Allure.addAttachment("Failed navigation back to HomePage", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    @Epic("Content functionalities")
    @Story("CountItems")
    @Test
    public void testGetTotalItems() {
        testButtonSeeAllPosts();
        int actual = blogPage2.getTotalItems();
        Assertions.assertEquals(9, actual);
    }
    @Epic("Content functionalities")
    @Story("GetData")
    @Test
    public void testGetTags() {
        testButtonSeeAllPosts();
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
    @Epic("Technical functionalities")
    @Story("Filewriting")
    @Test
    public void testSavePicture() throws IOException {
        testButtonSeeAllPosts();
        blogPage2.savePicture();
    }
    @Epic("Technical functionalities")
    @Story("Filewriting")
    @Test
    public void testSavePicture2() {
        testButtonSeeAllPosts();
        blogPage2.savePicture2();
    }
    @Epic("Technical functionalities")
    @Story("Filewriting")
    @Test
    public void testWriteBlogThemesFile() {
        testButtonSeeAllPosts();
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
