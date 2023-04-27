package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BlogLinkPage extends BasePage {
    private final By BUTTON_SEE_ALL_POSTS = By.xpath("//*[@class=\"blog-preview__header_button desktop\"]/a");

    public BlogLinkPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.LANDING_PAGE.getUrl());
    }

    //Click on 'See All Posts' Button to navigate to all the posts
    @Step("1. Navigate to BlogPage")
    public void clickButtonSeeAllPosts() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(BUTTON_SEE_ALL_POSTS).click();
    }

    //Save one of the blogs' picture to image.jpg file
    public void savePicture(String fileName, By xpath, String format) {
        try {
            File file = new File(fileName);
            String src = driver.findElement(xpath).getAttribute("src");
            URL url = new URL(src);
            BufferedImage image = ImageIO.read(url);
            ImageIO.write(image, format, file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Create a new file image2.jpg and save one of the blogs' picture to it, or delete it if it exists
    public void savePicture2(String fileName, By xpath, String format) {
        try {
            File file = new File(fileName);
            String src = driver.findElement(xpath).getAttribute("src");
            URL url = new URL(src);
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

    //Compare two picture for assertion of saving picture
    public double getDifferencePercentage(String savedImg, String downloadedImg) {
        BufferedImage imgA = null;
        BufferedImage imgB = null;

        try {
            File fileA = new File(savedImg);
            File fileB = new File(downloadedImg);

            imgA = ImageIO.read(fileA);
            imgB = ImageIO.read(fileB);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assigning dimensions to image
        assert imgA != null;
        int width1 = imgA.getWidth();
        assert imgB != null;
        int width2 = imgB.getWidth();
        int height1 = imgA.getHeight();
        int height2 = imgB.getHeight();

        double percentage = 0.0;

        // Checking whether the images are of same size or not
        if ((width1 != width2) || (height1 != height2)) {
            System.out.println("Error: Images dimensions"
                    + " mismatch");
        } else {
            long difference = 0;

            // Outer loop for rows(height)
            for (int y = 0; y < height1; y++) {

                // Inner loop for columns(width)
                for (int x = 0; x < width1; x++) {

                    int rgbA = imgA.getRGB(x, y);
                    int rgbB = imgB.getRGB(x, y);
                    int redA = (rgbA >> 16) & 0xff;
                    int greenA = (rgbA >> 8) & 0xff;
                    int blueA = (rgbA) & 0xff;
                    int redB = (rgbB >> 16) & 0xff;
                    int greenB = (rgbB >> 8) & 0xff;
                    int blueB = (rgbB) & 0xff;

                    difference += Math.abs(redA - redB);
                    difference += Math.abs(greenA - greenB);
                    difference += Math.abs(blueA - blueB);
                }
            }

            // Total number of red pixels = width * height
            // Total number of blue pixels = width * height
            // Total number of green pixels = width * height
            // So total number of pixels = width * height * 3
            double total_pixels = width1 * height1 * 3;

            // Normalizing the value of different pixels for accuracy

            // Note: Average pixels per color component
            double avg_different_pixels
                    = difference / total_pixels;

            // There are 255 values of pixels in total
            percentage
                    = (avg_different_pixels / 255) * 100;
        }
        return percentage;
    }

    //Download image from Portio website to compare it with the saved file
    public void downloadImage(String fileName, String targetUrl, String format) throws IOException {
        File file = new File(fileName);
        URL url = new URL(targetUrl);
        BufferedImage image = ImageIO.read(url);
        ImageIO.write(image, format, file);
    }

}
