package org.example.portio;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomePageTest extends TestEnvironment{
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
}
