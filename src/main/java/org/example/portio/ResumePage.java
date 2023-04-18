package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResumePage extends BasePage{

//locate elements for ServicePAge
    private final By BUTTON_EXPERIENCES = By.xpath("//*[@href=\"#experience\"]");
    private final By EXPERIENCES_ITEMS = By.xpath("//*[@id=\"experience\"]/div");
    private final By EXPERIENCE_YEARS = By.xpath("//*[@id=\"experience\"]/div/span");
    private final By EXPERIENCES = By.xpath("//*[@id=\"experience\"]/div/h4");

//constructor
    public ResumePage(WebDriver driver) {
        super(driver, Pages.LANDING_PAGE.getUrl());
    }

//methods for ResumePage
    public void clickExperiences() throws InterruptedException {
        scrollToElement(BUTTON_EXPERIENCES);
        driver.findElement(BUTTON_EXPERIENCES).click();
    }
    public int quantityOfExperiences() {
        List<WebElement> experiences = driver.findElements(EXPERIENCES_ITEMS);
        return experiences.size();
    }
    public String[] getYearsOfExperience() {
        List<WebElement> years = driver.findElements(EXPERIENCE_YEARS);

        String[] items = new String[years.size()];
        int i=0;
        for (WebElement year : years) {
            items[i++] = year.getText();
        }
        return items;
    }
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
    public String[] readFile() {
        List<String> firms = new ArrayList<>();
        try {
            File text = new File("firms.txt");
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
