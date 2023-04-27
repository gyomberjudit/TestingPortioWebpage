package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class BlogPage extends BasePage {
    private final By BLOG_ITEMS = By.xpath("//*[@class=\"section blog-page\"]/div/div/div");
    private final By NEXT_ARROW = By.xpath("//*[contains(@class, \"pagination\")]/li[3]/a");
    private final By BLOG_TITLES = By.xpath("//h5[@class=\"mb-0\"]/a");
    private final By NUMBERS = By.xpath("//ul[@class='pagination justify-content-center pagination-lg']/li");

    public BlogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.BLOG_PAGE.getUrl());
    }

    //Count numbers of blog items
    @Step("2. Get the size of blogs on one page")
    public int getItemsNumber() {
         return driver.findElements(BLOG_ITEMS).size();
    }
    public boolean isArrowClickable() {
        WebElement nextArrow = driver.findElement(NEXT_ARROW);
        if (nextArrow.isDisplayed()) {
            nextArrow.click();
            return true;
        }
        return false;
    }
    @Step("3. Get the total size of blogs clicking on next arrow")
    public int getTotalItems() {
        int totalItems = 0;
        try {
            do {
                totalItems += getItemsNumber();
            } while (isArrowClickable());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalItems;
    }

    //scroll to blogs to take screenshot
    public void scrollWindow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
    }

    //Write Blog's Titles to blogTitles file
    @Step("2. Write the blogs' title to an existing file while paginating pages")
    public void writeBlogTitlesFile(String file) {
        try {
            FileWriter writer = new FileWriter(file);

            String titles = "";
            int numbers = driver.findElements(NUMBERS).size()-1;
            do {
                List<WebElement> items = driver.findElements(BLOG_TITLES);
                for (WebElement item : items) {
                    String title = item.getText();
                    titles += title + "\n";
                }
                if (numbers != 1) {
                    driver.findElement(NEXT_ARROW).click();
                }
                numbers--;
            } while (numbers > 0);
            writer.write(titles);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Read text from blogTitles file
    @Step("3. Read the written file to compare it with the expected text.")
    public String getFileData(String fileName) {
        StringBuilder data = new StringBuilder();
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                data.append(sc.nextLine()).append("\n");
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data.toString();
    }
}
