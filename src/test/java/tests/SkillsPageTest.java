package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

import java.util.HashMap;

@Epic("Data handling")
public class SkillsPageTest extends BaseTest {

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
}
