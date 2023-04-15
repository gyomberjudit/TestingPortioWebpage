package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class SkillsPage extends BasePage{
//locate elements for SkillsPage
    private final By SKILLS_PAGE_TEXT = By.xpath("//*[contains(@id, \"why-hire-me\")]");
    private final By SKILLS_TYPES = By.xpath("//*[contains(@class, \"skill__progress_item\")]/span");
    private final By SKILLS_PERCENTS = By.xpath("//*[contains(@class, \"skill__progress_item\")]/div[1]/span");
    private final By SKILLS = By.xpath("//*[@class=\"skill__progress\"]/div[contains(@class, \"js-animation\")]");

//constructor
    public SkillsPage(WebDriver driver) {
        super(driver, Pages.LANDING_PAGE.getUrl());
    }

//methods for SkillsPage
    public String[] getSkillTypes() {
        List<WebElement> types = driver.findElements(SKILLS_TYPES);

        String[] items = new String[types.size()];
        int i=0;
        for (WebElement type : types) {
            items[i++] = type.getText();
        }
        return items;
    }
    public String[] getSkillPercents() {
        List<WebElement> percents = driver.findElements(SKILLS_PERCENTS);

        String[] items = new String[percents.size()];
        int i=0;
        for (WebElement percent : percents) {
            items[i++] = percent.getText();
        }
        return items;
    }
    public HashMap<String, String> getSkills() throws InterruptedException {
        List<WebElement> skills = driver.findElements(SKILLS);

        Thread.sleep(5000);
        HashMap<String, String> map = new HashMap<>();
        for (WebElement skill : skills) {
            String type = skill.findElement(By.xpath("./span")).getText();
            String percent = skill.findElement(By.xpath("./div/span")).getText();
            map.put(type, percent);
        }
        return map;
    }
//methods for assertion
    public boolean isSkillsPageTextDisplayed() {
        return driver.findElement(SKILLS_PAGE_TEXT).isDisplayed();
    }
}
