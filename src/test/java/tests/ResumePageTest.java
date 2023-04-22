package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

@Epic("Data handling")
public class ResumePageTest extends BaseTest {

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

    ////Compare workplaces stored in a JSON file (using file reading) with workplaces from ResumePage
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
}
