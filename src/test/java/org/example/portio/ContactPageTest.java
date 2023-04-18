package org.example.portio;

import io.qameta.allure.Description;
import org.json.simple.JSONObject;
import io.qameta.allure.Allure;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ContactPageTest extends TestEnvironment{
    @DisplayName("Contact information")
    @Description("Compare expected HashMap of information with a given json file")
    @Test
    public void testGetContactInfo() throws IOException, ParseException {
        loginPage.login();
        Assertions.assertTrue(homePage.isPortioLogoDisplayed());
        homePage.navigateToContactPageWithHireMeNowButton();
        Assertions.assertTrue(contactPage.isContactMeTextDisplayed());
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());
        Map<String, String> actual = contactPage.getContactInfo();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("contactInfo.json"));
        JSONArray contactInfos = (JSONArray) obj;

        Map<String, String> expected = new HashMap<>();
        for (Object info : contactInfos) {
            String key = (String) ((JSONObject) info).get("title");
            String value = (String) ((JSONObject) info).get("data");
            expected.put(key, value);
        }
        Assertions.assertEquals(expected, actual);
    }
    @DisplayName("Send message with Contact Form")
    @Description("Unsuccessful message sending: 'Oops! There was a problem.'")
    @Test
    public void testContactForm() {
        String name = "Kis Pal";
        String email = "kispal@gmail.com";
        String message = "Let's work together";
        loginPage.login();
        Assertions.assertTrue(homePage.isPortioLogoDisplayed());
        homePage.navigateToContactPageWithContactMeButton();
        contactPage.fillContactMeForm(name, email, message);
        contactPage.checkCheckbox();
        contactPage.sendMessage();
        Assertions.assertEquals("Message was sent successfully", contactPage.getMessageStatusText());
        Allure.addAttachment("Sending contact form is unsuccessful", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    @Disabled
    @Test
    public void testContactFormWithoutCheckingCheckbox() {
        String name = "Kis Pal";
        String email = "kispal@gmail.com";
        String message = "Let's work together";
        String warningMessage = "Please, tick this box if you want to proceed.";
        loginPage.login();
        Assertions.assertTrue(homePage.isPortioLogoDisplayed());
        homePage.navigateToContactPageWithContactMeButton();
        Assertions.assertTrue(contactPage.isContactMeTextDisplayed());
        contactPage.fillContactMeForm(name, email, message);
        contactPage.sendMessage();
        Allure.addAttachment("Warning message in case not checking checkbox", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(warningMessage, contactPage.getTooltipMessage());
    }
}
