package org.example.portio;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class ResumePageTest extends BaseTest{
    @Epic("Content functionalities")
    @Story("Resume")
    @Test
    public void testQuantityOfExperiences() {
        testLinkResume();
        resumePage.clickExperiences();
        Assertions.assertEquals(4, resumePage.quantityOfExperiences());
    }
    @Epic("Content functionalities")
    @Story("Resume")
    @Test
    public void testQuantityOfExperiences2() {
        testLinkResume();
        resumePage.clickExperiences();
        Assertions.assertEquals(4, resumePage.quantityOfExperiences2());
    }
    @Epic("Content functionalities")
    @Story("Resume")
    @Test
    public void testYearsOfExperience() {
        String[] years = {"2016-Present", "2010-2016", "2005-2010", "2001-2005"};
        testLinkResume();
        resumePage.clickExperiences();
        Allure.addAttachment("Years of experience", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertArrayEquals(years, resumePage.getYearsOfExperience());
    }
    @Epic("Content functionalities")
    @Story("Resume")
    @Test
    public void testExperience() {
        String[] firms = {"Umbrella co.", "Aperture Science", "ACME Inc.", "LexCorp"};
        testLinkResume();
        resumePage.clickExperiences();
        Allure.addAttachment("Firms to get experience", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertArrayEquals(firms, resumePage.getFirmsOfExperience());
    }
    @Epic("Content functionalities")
    @Story("Resume")
    @Test
    public void testEducation() throws InterruptedException {
        String education = "2008-2010, Master in Arts";
        testLinkResume();
        resumePage.clickEducation();
        Allure.addAttachment("Education", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(education, resumePage.getEducation());
    }
}
