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

    @DisplayName("Sequential login")
    @Description("Login repeatedly with valid credentials from file.")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("login")
    @Test
    public void testLoginMultipleUsers() throws IOException, ParseException {
        loginPage.navigate();
        loginPage.acceptTerms();

        String fileName = "users.json";
        String keys = "login";
        String values = "password";
        Map<String, String> map = loginPage.jsonParser(fileName, keys, values);
        for(String key : map.keySet()){
            loginPage.login2(key, map.get(key));
            addAttachment("Logged in with multiple different credentials");
            boolean loggedIn = homePage.isPortioLogoDisplayed();

            Assertions.assertTrue(loggedIn);
            loginPage.navigate();
        }
    }
}
