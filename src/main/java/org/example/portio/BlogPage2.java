package org.example.portio;

import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class BlogPage2 extends BasePage{

//locate elements for BlogPage
    private final By BLOG_ITEMS = By.xpath("//*[@class=\"section blog-page\"]/div/div/div");
    private final By NEXT_ARROW = By.xpath("//*[contains(@class, \"pagination\")]/li[3]/a");
    private final By BLOG_THEMES = By.xpath("//h5[@class=\"mb-0\"]/a");

//constructor
    public BlogPage2(WebDriver driver) {
        super(driver, Pages.BLOG_PAGE.getUrl());
    }

//methods for BlogPage
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
//Save pictures
    public void savePicture() throws IOException {
        File file = new File("image.jpg");
        URL url = new URL("https://lennertamas.github.io/portio/images/allpost/allPost-2.jpg");
        BufferedImage image = ImageIO.read(url);
        ImageIO.write(image, "jpg", file);
    }
   /* public void savePicture2() {
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
    }*/
    public void savePicture2() {
        try {
            File file = new File("image2.jpg");
            URL url = new URL("https://lennertamas.github.io/portio/images/allpost/allPost-5.jpg");
            BufferedImage image = ImageIO.read(url);
            if (file.createNewFile()) {
                ImageIO.write(image, "jpg", file);
            } else {
                file.deleteOnExit();
                //ImageIO.write(image, "jpg", file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


  /*  File obj = new File("fájlnév.txt");
    if (obj.exists()) {
        System.out.pritnln("..." + obj.getName());
        vagy lehet törölni is
    } else {
        System.out.println("The file doesn't exist.");
    }*/



//Write file
    public void writeBlogThemesFile() {
        try {
            String text = "";
            FileWriter writer = new FileWriter("blogThemes.txt");

            do {
                List<WebElement> items =  driver.findElements(BLOG_THEMES);
                for (WebElement item : items) {
                    String theme = item.getText();
                    text += theme + ",\n";
                    writer.write(text);
                }
            } while (isArrowClickable());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//Read file
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
