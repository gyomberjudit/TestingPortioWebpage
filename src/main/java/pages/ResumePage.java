package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResumePage extends BasePage {
    private final By BUTTON_EXPERIENCES = By.xpath("//*[@href=\"#experience\"]");
    private final By EXPERIENCES_ITEMS = By.xpath("//*[@id=\"experience\"]/div");
    private final By EXPERIENCE_YEARS = By.xpath("//*[@id=\"experience\"]/div/span");
    private final By EXPERIENCES = By.xpath("//*[@id=\"experience\"]/div/h4");

    public ResumePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.LANDING_PAGE.getUrl());
    }


    //Clicking on Experiences button to get to know the workplaces and years
    public void clickExperiences() throws InterruptedException {
        scrollToElement(BUTTON_EXPERIENCES);
        driver.findElement(BUTTON_EXPERIENCES).click();
    }

    //Get the number of workplaces
    public int quantityOfExperiences() {
        List<WebElement> experiences = driver.findElements(EXPERIENCES_ITEMS);
        return experiences.size();
    }

    //Get the years of work
    public String[] getYearsOfExperience() {
        List<WebElement> years = driver.findElements(EXPERIENCE_YEARS);

        String[] items = new String[years.size()];
        int i=0;
        for (WebElement year : years) {
            items[i++] = year.getText();
        }
        return items;
    }

    //Get the names of workplaces
    public String[] getFirmsOfExperience() {
        List<WebElement> firms = driver.findElements(EXPERIENCES);

        String[] items = new String[firms.size()];
        int i=0;
        for (WebElement firm : firms) {
            String text = firm.getText();
            items[i++] = text;
        }
        return items;
    }

    //Method for reading the given firms.txt file to compare it with getFirmsOfExperience method
    public String[] readFile(String fileName) {
        List<String> firms = new ArrayList<>();
        try {
            File text = new File(fileName);
            Scanner sc = new Scanner(text);
            while (sc.hasNextLine()) {
                String firm = sc.nextLine();
                firms.add(firm);
            }
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return firms.toArray(new String[0]);
    }
}
