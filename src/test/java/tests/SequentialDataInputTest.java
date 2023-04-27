package tests;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testEnvironment.BaseTest;

import java.io.IOException;
import java.util.Map;

@Epic("Data handling")
public class SequentialDataInputTest extends BaseTest {

    @DisplayName("TC17 - Sequential login")
    @Description("Login repeatedly with valid credentials from JSON file.")
    @Story("SequentialDataInput")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("login")
    @Test
    public void testLoginMultipleUsers() throws IOException, ParseException {
        String fileName = "users.json";
        String keys = "login";
        String values = "password";

        loginPage.navigate();
        loginPage.acceptTerms();

        Map<String, String> map = loginPage.jsonParser(fileName, keys, values);
        for(String key : map.keySet()){
            loginPage.inputUsername(key);
            loginPage.inputPassword(map.get(key));
            loginPage.clickLoginButton();
            boolean loggedIn = homePage.isPortioLogoDisplayed();
            addAttachment("Logged in with multiple different credentials");

            Assertions.assertTrue(loggedIn);
            loginPage.navigate();
        }
    }
}
