package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;

public class BlogLinkPage extends BasePage {
    private final By BUTTON_SEE_ALL_POSTS = By.xpath("//*[contains(@class, \"desktop\")]/a");

    public BlogLinkPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.LANDING_PAGE.getUrl());
    }

    //Click on 'See All Posts' Button to navigate to all the posts
    public void clickButtonSeeAllPosts() throws InterruptedException {
        scrollToElement(BUTTON_SEE_ALL_POSTS);
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_SEE_ALL_POSTS)).click();
    }
}
