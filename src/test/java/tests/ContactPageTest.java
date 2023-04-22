package tests;

import io.qameta.allure.*;
import utilPages.Pages;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import testEnvironment.BaseTest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Epic("Data handling")
public class ContactPageTest extends BaseTest {

    //Compare data given in JSON file with data collected into HashMap from ContactPage
    @DisplayName("Contact information")
    @Description("Compare expected HashMap of Contact information with a given JSON file")
    @Story("Data listing")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Data listing")
    @Tag("HasMap")
    @Tag("JSON")
    @Test
    public void testGetContactInfo() throws IOException, ParseException {
        loginPage.login();
        Assertions.assertTrue(homePage.isPortioLogoDisplayed());
        homePage.navigateWithHireMeNowButton();
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

        addAttachment("Given contact information on ContactPage");
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Send message with Contact Form")
    @Description("Unsuccessful message sending: 'Oops! There was a problem.'")
    @Story("Data input")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Data input")
    @Tag("Send message")
    @Test
    public void testContactForm() throws InterruptedException {
        String name = "Kis Pal";
        String email = "kispal@gmail.com";
        String message = "Let's work together";
        loginPage.login();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        Assertions.assertTrue(loggedIn);

        homePage.navigateWithContactMeButton();
        contactPage.fillContactMeForm(name, email, message);
        contactPage.checkCheckbox();
        contactPage.sendMessage();
        contactPage.waitForMessage();
        addAttachment("Sending contact form is unsuccessful");
        String expected = "Message was sent successfully";
        String actual = contactPage.getMessageStatusText();

        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Send message without checking checkbox")
    @Description("Unsuccessful message sending: 'Tooltip warning to check checkbox'")
    @Story("Data input")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Data input")
    @Tag("Tooltip")
    @Disabled
    @Test
    public void testContactFormWithoutCheckingCheckbox() throws InterruptedException {
        String name = "Kis Pal";
        String email = "kispal@gmail.com";
        String message = "Let's work together";
        loginPage.login();
        Assertions.assertTrue(homePage.isPortioLogoDisplayed());
        homePage.navigateWithContactMeButton();
        Assertions.assertTrue(contactPage.isContactMeTextDisplayed());
        contactPage.fillContactMeForm(name, email, message);
        contactPage.sendMessage();
        addAttachment("Warning message visible if checkbox is not checked");
        String warningMessage = "Please, tick this box if you want to proceed.";
        String tooltip = contactPage.getTooltipMessage();

        Assertions.assertEquals(warningMessage, tooltip);
    }
}
