package utilPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    private final String url;
    private final By BUTTON_ACCEPT_TERMS = By.id("terms-and-conditions-button");

    public BasePage(WebDriver driver, WebDriverWait wait, String url) {
        this.driver = driver;
        this.wait = wait;
        this.url = url;
    }

    //global method for navigation
    public void navigate() {
        driver.navigate().to(url);
    }

    //global method for accepting terms before entering the website
    public void acceptTerms() {
        driver.findElement(BUTTON_ACCEPT_TERMS).click();
    }

    //global method for scrolling to elements
    public void scrollToElement(By xpath) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(xpath);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }
}
