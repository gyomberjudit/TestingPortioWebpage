package org.example.portio;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class SkillsPageTest extends TestEnvironment{
    @Epic("Content functionalities")
    @Story("GetData")
    @Test
    public void testGetSkillTypes() {
        String[] expected = {"HTML", "CSS", "Javascript"};
        loginPage.login();
        homePage.clickOnLinkSkills();
        String[] actual = skillsPage.getSkillTypes();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Epic("Content functionalities")
    @Story("GetData")
    @Test
    public void testGetSkillPercents() {
        String[] expected = {"69", "60", "85"};
        loginPage.login();
        homePage.clickOnLinkSkills();
        String[] actual = skillsPage.getSkillPercents();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Epic("Content functionalities")
    @Story("GetData")
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
