package tests;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;
import utilPages.Pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Epic("Data handling")
public class DataListingTest extends BaseTest {

    @DisplayName("Number of workplaces")
    @Description("Get the size of workplaces' list")
    @Story("Data listing")
    @Severity(SeverityLevel.MINOR)
    @Tag("dataListing")
    @Tag("dataCount")
    @Test
    public void testQuantityOfExperiences() throws InterruptedException {
        loginPage.login();
        resumePage.clickExperiences();
        int expected = 4;
        int actual = resumePage.quantityOfExperiences();

        Assertions.assertEquals(expected, actual);
    }

    //Compare work years stored in a String array with years from ResumePage
    @DisplayName("Periods of working times")
    @Description("Collect the work years in String array")
    @Story("Data listing")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataListing")
    @Test
    public void testYearsOfExperience() throws InterruptedException {
        loginPage.login();
        resumePage.clickExperiences();
        String[] years = {"2016-Present", "2010-2016", "2005-2010", "2001-2005"};
        String[] actual = resumePage.getYearsOfExperience();

        Assertions.assertArrayEquals(years, actual);
    }

    //Compare workplaces stored in a txt file (using file reading) with workplaces from ResumePage
    @DisplayName("Names of workplaces")
    @Description("Collect workplaces in String array and compare to a given file")
    @Story("Data listing")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataListing")
    @Tag("readFile")
    @Test
    public void testExperience() throws InterruptedException {
        String fileName = "firms.txt";
        loginPage.login();
        resumePage.clickExperiences();
        String[] expected = resumePage.readFile(fileName);
        String[] actual = resumePage.getFirmsOfExperience();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Compare data given in a HashMap with data collected into HashMap from SkillsPage
    @DisplayName("Skill types & percents in HashMap")
    @Description("Collect all the Skill types & percents in a HashMap")
    @Story("Data listing")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataListing")
    @Tag("HashMap")
    @Test
    public void testGetSkills() throws InterruptedException {
        loginPage.login();
        homePage.clickOnLinkSkills();
        HashMap<String, String> expected = new HashMap<>();
                expected.put("HTML", "69");
                expected.put("CSS", "60");
                expected.put("Javascript", "85");
        HashMap<String, String> actual = skillsPage.getSkills();
        addAttachment("Skill types and percents");

        Assertions.assertEquals(expected, actual);
    }

    //Compare data given in JSON file with data collected into HashMap from ContactPage
    @DisplayName("Contact information")
    @Description("Compare expected HashMap of Contact information with a given JSON file")
    @Story("Data listing")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataListing")
    @Tag("HashMap")
    @Tag("JSON")
    @Test
    public void testGetContactInfo() throws IOException, ParseException {
        loginPage.login();

        Assertions.assertTrue(homePage.isPortioLogoDisplayed());

        homePage.navigateWithHireMeNowButton();

        Assertions.assertTrue(contactPage.isContactMeTextDisplayed());
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());

        String fileName = "contactInfo.json";
        String keys = "title";
        String values = "data";
        Map<String, String> expected = contactPage.jsonParser(fileName, keys, values);
        Map<String, String> actual = contactPage.getContactInfo();

        addAttachment("Given contact information on ContactPage");
        Assertions.assertEquals(expected, actual);
    }
}
