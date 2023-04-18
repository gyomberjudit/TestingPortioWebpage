package org.example.portio;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResumePageTest extends TestEnvironment{
    @DisplayName("Number of workplaces")
    @Description("Get the size of workplaces' list")
    @Test
    public void testQuantityOfExperiences() throws InterruptedException {
        loginPage.login();
        resumePage.clickExperiences();
        Assertions.assertEquals(4, resumePage.quantityOfExperiences());
    }
    @DisplayName("Periods of working time")
    @Description("Collect the work years in String array")
    @Test
    public void testYearsOfExperience() throws InterruptedException {
        String[] years = {"2016-Present", "2010-2016", "2005-2010", "2001-2005"};
        loginPage.login();
        resumePage.clickExperiences();
        String[] actual = resumePage.getYearsOfExperience();
        Assertions.assertArrayEquals(years, actual);
    }
    //file reading
    @DisplayName("Workplaces")
    @Description("Collecting workplaces in String array and compare a given file")
    @Test
    public void testExperience() throws InterruptedException {
        String[] expected = resumePage.readFile();
        String[] actual = resumePage.getFirmsOfExperience();
        loginPage.login();
        resumePage.clickExperiences();
        Assertions.assertArrayEquals(expected, actual);
    }
}
