package utilPages;

import io.qameta.allure.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    @Step("Navigate to Portio website")
    public void navigate() {
        driver.navigate().to(url);
    }

    //global method for accepting terms before entering the website
    @Step("Accept terms")
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

    //global JSON parser method
    @Step("Parse JSON file to HashMap")
    public Map<String, String > jsonParser(String fileName, String keys, String values) throws IOException, ParseException {
        Map<String, String> map = new HashMap<>();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(fileName));
        JSONArray array = (JSONArray) obj;
        for (Object data : array) {
            String key = (String) ((JSONObject) data).get(keys);
            String value = (String) ((JSONObject) data).get(values);
            map.put(key, value);
        }
        return map;
    }
}
