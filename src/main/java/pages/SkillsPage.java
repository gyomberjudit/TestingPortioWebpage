package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;

import java.util.HashMap;
import java.util.List;

public class SkillsPage extends BasePage {
    private final By SKILLS = By.xpath("//*[@class=\"skill__progress\"]/div[contains(@class, \"js-animation\")]");

    public SkillsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.LANDING_PAGE.getUrl());
    }


    //Get the types and percents of skills and store them in a HashMap
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
}
