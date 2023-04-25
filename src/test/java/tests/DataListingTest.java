package tests;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Epic("Data handling")
public class DataListingTest extends BaseTest {

    //get the number of Experiences
    @DisplayName("Number of workplaces")
    @Description("Get the size of workplaces' list")
    @Story("Data listing")
    @Severity(SeverityLevel.MINOR)
    @Tag("dataListing")
    @Tag("dataCount")
    @Test
    public void testQuantityOfExperiences() throws InterruptedException {
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

        //get quantity of Experiences
        resumePage.scrollToExperiencesButton();
        resumePage.clickExperiences();
        int expected = 4;
        int actual = resumePage.quantityOfExperiences();

        Assertions.assertEquals(expected, actual);
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
        String username = "lovasia";
        String password = "kispal123";
        String fileName = "firms.txt";

        //login
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        Assertions.assertTrue(loggedIn);

        //Compare workplaces collected in a String array with firms.txt file
        resumePage.scrollToExperiencesButton();
        resumePage.clickExperiences();
        String[] expected = resumePage.readFile(fileName);
        String[] actual = resumePage.getFirmsOfExperience();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Compare expected data given in a HashMap with data collected into HashMap from SkillsPage
    @DisplayName("Skill types & percents in HashMap")
    @Description("Collect all the Skill types & percents in a HashMap")
    @Story("Data listing")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataListing")
    @Tag("HashMap")
    @Test
    public void testGetSkills() throws InterruptedException {
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

        //Compare expected data given in a HashMap with data collected into HashMap from SkillsPage
        homePage.clickOnLinkSkills();
        HashMap<String, String> expected = new HashMap<>();
                expected.put("HTML", "69");
                expected.put("CSS", "60");
                expected.put("Javascript", "85");
        HashMap<String, String> actual = skillsPage.getSkills();
        addAttachment("Skill types and percents");

        Assertions.assertEquals(expected, actual);
    }

    //Compare expected data given in JSON file with data collected into HashMap from ContactPage
    @DisplayName("Contact information")
    @Description("Compare expected HashMap of Contact information with a given JSON file")
    @Story("Data listing")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataListing")
    @Tag("HashMap")
    @Tag("JSON")
    @Test
    public void testGetContactInfo() throws IOException, ParseException {
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

        //navigálás a ContactPage-re
        homePage.clickHireMeNowButton();
        boolean contactPageVisible = contactPage.isContactMeTextDisplayed();
        Assertions.assertTrue(contactPageVisible);

        //Compare expected data given in JSON file with data collected into HashMap from ContactPage
        String fileName = "contactInfo.json";
        String keys = "title";
        String values = "data";
        Map<String, String> expected = contactPage.jsonParser(fileName, keys, values);
        Map<String, String> actual = contactPage.getContactInfo();
        addAttachment("Given contact information on ContactPage");

        Assertions.assertEquals(expected, actual);
    }
}
