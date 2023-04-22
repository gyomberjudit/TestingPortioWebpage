package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class BlogPage extends BasePage{
    private final By BLOG_ITEMS = By.xpath("//*[@class=\"section blog-page\"]/div/div/div");
    private final By NEXT_ARROW = By.xpath("//*[contains(@class, \"pagination\")]/li[3]/a");
    private final By BLOG_THEMES = By.xpath("//h5[@class=\"mb-0\"]/a");

    public BlogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.BLOG_PAGE.getUrl());
    }

    //Count numbers of blog items
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
    //Save one of the blogs' picture to image.jpg file
    public void savePicture(String imageFile,String targetUrl, String format) throws IOException {
        File file = new File(imageFile);
        URL url = new URL(targetUrl);
        BufferedImage image = ImageIO.read(url);
        ImageIO.write(image, format, file);
    }
    //Create a new file image2.jpg and save one of the blogs' picture to it, or delete it if it exists
    public void savePicture2(String imageFile, String targetUrl, String format) {
        try {
            File file = new File(imageFile);
            URL url = new URL(targetUrl);
            BufferedImage image = ImageIO.read(url);
            if (file.createNewFile()) {
                ImageIO.write(image, format, file);
            } else {
                file.deleteOnExit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Write Blog's Titles to blogThemes file
    public void writeBlogThemesFile(String file) {
        try {
            FileWriter writer = new FileWriter(file);
            String text = "";
            do {
                List<WebElement> items =  driver.findElements(BLOG_THEMES);

                for (WebElement item : items) {
                    String theme = item.getText();
                    text += theme + "\n";
                }
                writer.write(text);
            } while (isArrowClickable());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Read text from blogThemes file
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
