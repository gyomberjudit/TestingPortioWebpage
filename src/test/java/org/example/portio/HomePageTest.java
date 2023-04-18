package org.example.portio;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HomePageTest extends TestEnvironment{
    @DisplayName("Navigate to AboutPage")
    @Description("Clicking on About link navigating to About page")
    @Test
    public void testLinkAbout() {
        loginPage.login();
        homePage.clickOnLinkAbout();
        Assertions.assertTrue(aboutPage.isAboutPageTextDisplayed());
    }
    @DisplayName("Navigate to ServicePage")
    @Description("Clicking on Service link navigating to Service page")
    @Test
    public void testLinkService() {
        loginPage.login();
        homePage.clickOnLinkService();
        Assertions.assertTrue(servicePage.isServicePageTextDisplayed());
    }
    @DisplayName("Navigate to WorkPage")
    @Description("Clicking on Work link navigating to Work page")
    @Test
    public void testLinkWork() {
        loginPage.login();
        homePage.clickOnLinkWork();
        Assertions.assertTrue(workPage.isWorkPageTextDisplayed());
    }
    @DisplayName("Navigate to SkillsPage")
    @Description("Clicking on Skills link navigating to Skills page")
    @Test
    public void testLinkSkills() {
        loginPage.login();
        homePage.clickOnLinkSkills();
        Assertions.assertTrue(skillsPage.isSkillsPageTextDisplayed());
    }
    @DisplayName("Navigate to BlogPage")
    @Description("Clicking on Blog link navigating to Blog page")
    @Test
    public void testLinkBlog() {
        loginPage.login();
        homePage.clickOnLinkBlog();
        Assertions.assertTrue(blogPage.isBlogPageTextDisplayed());
    }
}
