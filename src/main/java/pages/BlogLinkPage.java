package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;

public class BlogLinkPage extends BasePage {
    private final By BUTTON_SEE_ALL_POSTS = By.xpath("//*[@class=\"blog-preview__header_button desktop\"]/a");

    public BlogLinkPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.LANDING_PAGE.getUrl());
    }

    //Click on 'See All Posts' Button to navigate to all the posts
    public void clickButtonSeeAllPosts() {
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(BUTTON_SEE_ALL_POSTS);
        actions.moveToElement(button, 2, 2).click().build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_SEE_ALL_POSTS)).click();
    }
}
