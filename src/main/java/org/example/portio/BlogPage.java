package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BlogPage extends BasePage{

//locate elements for BlogPage
    private final By BLOG_PAGE_TEXT = By.id("recent-article");
    private final By BUTTON_SEE_ALL_POSTS = By.xpath("//*[contains(@class, \"desktop\")]/a");

//constructor
    public BlogPage(WebDriver driver) {
        super(driver, Pages.LANDING_PAGE.getUrl());
    }

//methods for BlogPage
    public void clickButtonSeeAllPosts() {
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(BUTTON_SEE_ALL_POSTS);
        actions.moveToElement(button).pause(Duration.ofSeconds(5)).perform();
        actions.click(button).build().perform();
    }
    public boolean isBlogPageTextDisplayed() {
        return driver.findElement(BLOG_PAGE_TEXT).isDisplayed();
    }
}
