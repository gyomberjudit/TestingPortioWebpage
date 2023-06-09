package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilPages.BasePage;
import utilPages.Pages;

import java.io.ByteArrayInputStream;
import java.util.Set;

public class FooterPage extends BasePage {
    private final By LINK_PRIVACY_AND_POLICY = By.xpath("//*[@class=\"unstyle-list small\"]/li[3]/a");
    private final By ICON_FACEBOOK = By.xpath("//*[@class=\"unstyle-list\"]/li[1]/a");

    public FooterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, Pages.LANDING_PAGE.getUrl());
    }


    //navigate to Privacy and Policy page
    @Step("Scroll to footer")
    public void scrollToPrivacyAndPolicyLink() throws InterruptedException {
        scrollToElement(LINK_PRIVACY_AND_POLICY);
    }
    @Step("Click 'Privacy and Policy' link")
    public void clickPrivacyAndPolicyLink() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(LINK_PRIVACY_AND_POLICY).click();
    }

    //navigate to facebook
    @Step("Scroll to footer")
    public void scrollToFacebookIcon() throws InterruptedException {
        scrollToElement(ICON_FACEBOOK);
    }
    @Step("Click Icon Facebook")
    public void clickFacebokIcon() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(ICON_FACEBOOK).click();
    }

    //Checking if navigation to a new window was successful
    @Step("Successful navigation to Facebook")
    public String getChildWindowUrl() {
        String parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        StringBuilder url = new StringBuilder();
        for (String childWindow : windows) {
            if (!parentWindow.equals(childWindow)) {
                String childUrl = driver.switchTo().window(childWindow).getCurrentUrl();
                Allure.addAttachment("Facebook in new window", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
                url.append(childUrl);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        return url.toString();
    }
}
