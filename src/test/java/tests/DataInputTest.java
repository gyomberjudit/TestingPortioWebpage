package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testEnvironment.BaseTest;

@Epic("Data handling")
public class DataInputTest extends BaseTest {

    //Setting profile with registration because of incognito mode
    @DisplayName("Set Profile")
    @Description("Set profile by giving credentials")
    @Story("Data input")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataInput")
    @Tag("profile")
    @Test
    public void testSetProfile() {
        String username = "teszteszter";
        String password = "teszt";
        String name ="Teszt Eszti";
        String bio ="female";
        String phone ="06301112233";
        registerPage.registration();
        registerPage.clickLoginButton();
        loginPage.login2(username, password);
        boolean loggedIn = homePage.isPortioLogoDisplayed();

        Assertions.assertTrue(loggedIn);

        homePage.clickProfile();
        profilePage.setProfile(name, bio, phone);
        String expectedMessage = "Profile Edited!";
        String actualMessage = profilePage.getProfileMessage();

        addAttachment("Success message visible after setting profile: 'Profile edited'");
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("Send message with Contact Form")
    @Description("Unsuccessful message sending: 'Oops! There was a problem.'")
    @Story("Data input")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("dataInput")
    @Tag("sendMessage")
    @Test
    public void testContactForm() {
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
        String expected = "Message was sent successfully";
        String actual = contactPage.getMessage();
        addAttachment("Sending contact form is unsuccessful");

        Assertions.assertEquals(expected, actual);
    }

    /*@DisplayName("Send message without checking checkbox")
    @Description("Unsuccessful message sending: 'Tooltip warning to check checkbox'")
    @Story("Data input")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataInput")
    @Tag("tooltip")
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
    }*/
}
