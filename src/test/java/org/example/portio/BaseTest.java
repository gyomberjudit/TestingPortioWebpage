package org.example.portio;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class BaseTest extends TestEnvironment{
    @Epic("Technical functionalities")
    @Story("Profile")
    @Test
    public void testSetProfile() {
        String username = "teszteszter";
        String password = "teszt";
        String name ="Teszt Eszti";
        String bio ="female";
        String phone ="06301112233";
        registerPage.registration();
        registerPage.clickLoginButton();
        loginPage.login2(username, password);
        Assertions.assertTrue(homePage.isPortioLogoDisplayed());
        homePage.clickProfile();
        profilePage.setProfile(name, bio, phone);
        Assertions.assertEquals("Profile Edited!", profilePage.getProfileMessage());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testLinkAbout() {
        loginPage.login();
        homePage.clickOnLinkAbout();
        Assertions.assertTrue(aboutPage.isAboutPageTextDisplayed());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testLinkService() {
        loginPage.login();
        homePage.clickOnLinkService();
        Assertions.assertTrue(servicePage.isServicePageTextDisplayed());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testLinkWork() {
        loginPage.login();
        homePage.clickOnLinkWork();
        Assertions.assertTrue(workPage.isWorkPageTextDisplayed());
    }
    @Epic("Technical functionalities")
    @Story("Navigation")
    @Test
    public void testLinkCaseStudyOne() {
        testLinkWork();
        workPage.clickLinkCaseStudyOne();
        Allure.addAttachment("Case Study One Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertTrue(caseStudyPage.isCaseStudyTextVisible());
        Assertions.assertEquals(Pages.CASE_STUDY_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Navigation")
    @Test
    public void testLinkResume() {
        loginPage.login();
        homePage.clickOnLinkResume();
        Assertions.assertTrue(resumePage.isResumePageTextDisplayed());
    }
    @Epic("Technical functionalities")
    @Story("Navigation")
    @Test
    public void testLinkSkills() {
        loginPage.login();
        homePage.clickOnLinkSkills();
        Assertions.assertTrue(skillsPage.isSkillsPageTextDisplayed());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testLinkBlog() {
        loginPage.login();
        homePage.clickOnLinkBlog();
        Assertions.assertTrue(blogPage.isBlogPageTextDisplayed());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void
    testButtonSeeAllPosts() {
        testLinkBlog();
        blogPage.clickButtonSeeAllPosts();
        Assertions.assertTrue(blogPage2.isBlogPage2TextDisplayed());
        Assertions.assertEquals(Pages.BLOG_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testLinkContact() {
        loginPage.login();
        homePage.clickOnLinkContact();
        Assertions.assertTrue(footerPage.isFooterPageTextDisplayed());
    }
}
