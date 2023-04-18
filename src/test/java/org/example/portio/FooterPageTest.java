package org.example.portio;

import io.qameta.allure.Allure;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class FooterPageTest extends TestEnvironment{
    @DisplayName("Test Frequently asked questions link")
    @Description("Clicking on FAQ link the user is thrown out of Portio webpage")
    @Test
    public void testFrequentlyAskedQuestionLink() throws InterruptedException {
        loginPage.login();
        footerPage.clickLinkFAQ();
        Allure.addAttachment("Failed navigation to FAQ", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertNotEquals(Pages.LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @DisplayName("Test Privacy and policy link")
    @Description("Clicking on Privacy and Policy link the user is thrown out of Portio webpage")
    @Test
    public void testPrivacyAndPolicyLink() throws InterruptedException {
        loginPage.login();
        footerPage.clickLinkPrivacyAndPolicy();
        Allure.addAttachment("Failed navigation to Privacy and Policy", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertNotEquals(Pages.LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }
    @DisplayName("Test Facebook link")
    @Description("Clicking on Facebook link the user navigates to Facebook webpage")
    @Test
    public void testFacebookLink() throws InterruptedException {
        loginPage.login();
        footerPage.clickIconFacebbok();
        Thread.sleep(3000);
        String actual = footerPage.getChildWindowUrl();
        Allure.addAttachment("Successful navigation to Facebook", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(Pages.FACEBOOK.getUrl(), actual);
    }
    @DisplayName("Test Linkedin link")
    @Description("Clicking on Linkedin link the user navigates to Linkedin webpage")
    @Test
    public void testLinkedinLink() throws InterruptedException {
        loginPage.login();
        footerPage.clickIconLinkedin();
        String actual = footerPage.getChildWindowUrl();
        Allure.addAttachment("Successful navigation to Linkedin", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(Pages.LINKEDIN.getUrl(), actual);
    }
}
