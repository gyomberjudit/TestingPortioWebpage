package org.example.portio;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class FooterPageTest extends TestEnvironment{
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testGetInTouchButton() {
        loginPage.login();
        homePage.clickOnLinkContact();
        footerPage.clickGetINTouchButton();
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testAboutMeLink() throws InterruptedException {
        loginPage.login();
        homePage.clickOnLinkContact();
        footerPage.clickLinkAboutMe();
        String actual = footerPage.getChildWindowUrl();
        Allure.addAttachment("Failed navigation to About Me", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(Pages.ABOUT_ME.getUrl(), actual);
        driver.navigate().to(Pages.ABOUT_ME.getUrl());
        Assertions.assertFalse(footerPage.isFileNotFound());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testFrequentlyAskedQuestionLink() {
        loginPage.login();
        homePage.clickOnLinkContact();
        footerPage.clickLinkFAQ();
        Allure.addAttachment("Failed navigation to FAQ", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertNotEquals(Pages.LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testPrivacyAndPolicyLink() {
        loginPage.login();
        homePage.clickOnLinkContact();
        footerPage.clickLinkPrivacyAndPolicy();
        Allure.addAttachment("Failed navigation to Privacy and Policy", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertNotEquals(Pages.LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testLatestArticleLink() {
        loginPage.login();
        homePage.clickOnLinkContact();
        footerPage.clickLatestArticle();
        Assertions.assertNotEquals(Pages.LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
        Allure.addAttachment("Failed navigation to Latest Article", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testTermsAndConditionsLink() throws InterruptedException {
        loginPage.login();
        homePage.clickOnLinkContact();
        footerPage.clickTermsAndConditions();
        String actual = footerPage.getChildWindowUrl();
        Allure.addAttachment("Successful navigation to Terms and Conditions", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(Pages.TERMS_AND_CONDITIONS.getUrl(), actual);
        driver.navigate().to(Pages.TERMS_AND_CONDITIONS.getUrl());
        Assertions.assertTrue(footerPage.isTermsAndConditionsTextDisplayed());
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testFacebookLink() throws InterruptedException {
        loginPage.login();
        homePage.clickOnLinkContact();
        footerPage.clickIconFacebbok();
        String actual = footerPage.getChildWindowUrl();
        Allure.addAttachment("Successful navigation to Facebook", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(Pages.FACEBOOK.getUrl(), actual);
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testLinkedinLink() throws InterruptedException {
        loginPage.login();
        homePage.clickOnLinkContact();
        footerPage.clickIconLinkedin();
        String actual = footerPage.getChildWindowUrl();
        Allure.addAttachment("Successful navigation to Linkedin", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(Pages.LINKEDIN.getUrl(), actual);
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testPinterestLink() throws InterruptedException {
        loginPage.login();
        homePage.clickOnLinkContact();
        footerPage.clickIconPinterest();
        String actual = footerPage.getChildWindowUrl();
        Allure.addAttachment("Successful navigation to Pinterest", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(Pages.PINTEREST.getUrl(), actual);
    }
    @Epic("Technical functionalities")
    @Story("Navigating")
    @Test
    public void testTwitterLink() throws InterruptedException {
        loginPage.login();
        homePage.clickOnLinkContact();
        footerPage.clickIconTwitter();
        String actual = footerPage.getChildWindowUrl();
        Allure.addAttachment("Successful navigation to Twitter", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(Pages.TWITTER.getUrl(), actual);
    }
}
