package org.example.portio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecipeAppPage extends BasePage{

//locate elements on RecipeAppPage
    private final By RECIPE_APP_TEXT = By.xpath("//*[@class=\"case-details-title\"]/h1");

//constructor
    public RecipeAppPage(WebDriver driver) {
        super(driver, Pages.RECIPE_APP_PAGE.getUrl());
    }

//methods
    public boolean isRecipeAppTextVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement recipeAppText = wait.until(ExpectedConditions.visibilityOfElementLocated(RECIPE_APP_TEXT));
        return recipeAppText.isDisplayed();
    }
}
