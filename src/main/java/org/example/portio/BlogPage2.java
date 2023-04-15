package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.*;

public class BlogPage2 extends BasePage{

    private final By BLOG_PAGE2_TEXT = By.xpath("//*[@class=\"breadCrumb__title\"]");
    private final By BLOG_ITEMS = By.xpath("//*[@class=\"section blog-page\"]/div/div/div");
    private final By NEXT_ARROW = By.xpath("//*[contains(@class, \"pagination\")]/li[3]/a");
    private final By LINK_HOME = By.xpath("//*[@class=\"breadcrumb-item\"]/a");
    private final By BLOG_THEMES = By.xpath("//h5[@class=\"mb-0\"]/a");
    private final By TAG = By.xpath("//*[@class=\"post-meta\"]/li[3]/a");


    public BlogPage2(WebDriver driver) {
        super(driver, Pages.BLOG_PAGE.getUrl());
    }



    public int getItemsNumber() {
         return driver.findElements(BLOG_ITEMS).size();
    }
    public boolean isArrowClickable() {
        Actions actions = new Actions(driver);
        WebElement nextArrow = driver.findElement(NEXT_ARROW);
        if (nextArrow.isDisplayed()) {
            actions.moveToElement(nextArrow).pause(Duration.ofSeconds(3)).click().perform();
            return true;
        }
        return false;
    }
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
    public void clickOnHomeLink() {
        driver.findElement(LINK_HOME).click();
    }
    public LinkedHashMap<String, String> getTags() {
        List<WebElement> items =  driver.findElements(BLOG_THEMES);

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        try {
            do {
                for (WebElement item : items) {
                    String key = item.getText();
                    item.click();
                    WebElement tagName = driver.findElement(TAG);
                    String value = tagName.getText();
                    map.put(key, value);
                    driver.navigate().back();
                }
            } while (isArrowClickable());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    public boolean isBlogPage2TextDisplayed() {
        return driver.findElement(BLOG_PAGE2_TEXT).isDisplayed();
    }
    public void savePicture() throws IOException {
        File file = new File("image.jpg");
        URL url = new URL("https://lennertamas.github.io/portio/images/allpost/allPost-2.jpg");
        BufferedImage image = ImageIO.read(url);
        ImageIO.write(image, "jpg", file);
    }
    public void savePicture2() {
        try {
            File file = new File("image2.jpg");
            URL url = new URL("https://lennertamas.github.io/portio/images/allpost/allPost-5.jpg");
            BufferedImage image = ImageIO.read(url);
            if (file.createNewFile()) {
                ImageIO.write(image, "jpg", file);
            } else {
                ImageIO.write(image, "jpg", file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeBlogThemesFile() {
        List<WebElement> items =  driver.findElements(BLOG_THEMES);

        try {
            String themes = "";
            FileWriter writer = new FileWriter("blogThemes.txt");
            do {
                for (WebElement item : items) {
                    String theme = item.getText();
                    themes += theme + ",\n";
                    writer.write(themes);
                }
            } while (!isArrowClickable());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getFileData() {
        StringBuilder data = new StringBuilder();
        try {
            File file = new File("blogThemes.txt");
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
