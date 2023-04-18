package org.example.portio;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class SkillsPageTest extends TestEnvironment{
    @DisplayName("Skill types")
    @Description("Collect all the Skill types in a String array")
    @Test
    public void testGetSkillTypes() {
        String[] expected = {"HTML", "CSS", "Javascript"};
        loginPage.login();
        homePage.clickOnLinkSkills();
        String[] actual = skillsPage.getSkillTypes();
        Assertions.assertArrayEquals(expected, actual);
    }
    @DisplayName("Skill percents")
    @Description("Collect all the Skill percents in a String array")
    @Test
    public void testGetSkillPercents() {
        String[] expected = {"69", "60", "85"};
        loginPage.login();
        homePage.clickOnLinkSkills();
        String[] actual = skillsPage.getSkillPercents();
        Assertions.assertArrayEquals(expected, actual);
    }
    @DisplayName("Skill types & percents HashMap")
    @Description("Collect all the Skill types & percents in a HashMap")
    @Test
    public void testGetSkills() throws InterruptedException {
        loginPage.login();
        homePage.clickOnLinkSkills();
        HashMap<String, String> expected = new HashMap<>();
                expected.put("HTML", "69");
                expected.put("CSS", "60");
                expected.put("Javascript", "85");
        HashMap<String, String> actual = skillsPage.getSkills();
        Assertions.assertEquals(expected, actual);
    }
}
