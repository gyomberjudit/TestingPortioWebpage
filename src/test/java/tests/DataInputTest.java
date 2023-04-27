package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testEnvironment.BaseTest;

@Epic("Data handling")
public class DataInputTest extends BaseTest {

    //Setting profile (with registration because of incognito mode)
    @DisplayName("TC15 - Set Profile")
    @Description("Set profile by giving credentials")
    @Story("Data input")
    @Severity(SeverityLevel.NORMAL)
    @Tag("dataInput")
    @Tag("profile")
    @Test
    public void testSetProfile() {
        String username = "teszteszter";
        String password = "teszt";
        String email = "teszteszter5@gmail.com";
        String name ="Teszt Eszti";
        String bio ="female";
        String phone ="06301112233";

        //registration
        registerPage.navigate();
        registerPage.acceptTerms();
        registerPage.clickButtonRegister();
        registerPage.inputUsername(username);
        registerPage.inputPassword(password);
        registerPage.inputEmail(email);
        registerPage.clickButtonRegister2();
        boolean userRegistered = registerPage.userRegistered();
        Assertions.assertTrue(userRegistered);

        //logging in
        registerPage.clickLoginButton();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        Assertions.assertTrue(loggedIn);

        //setting profile
        homePage.clickProfile();
        profilePage.inputName(name);
        profilePage.inputBio(bio);
        profilePage.inputPhone(phone);
        profilePage.clickSaveButton();
        String expectedMessage = "Profile Edited!";
        String actualMessage = profilePage.getProfileMessage();

        addAttachment("Success message visible after setting profile: 'Profile edited'");
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    //Send message with Contact form
    @DisplayName("TC16 - Send message with Contact Form")
    @Description("Unsuccessful message sending: 'Oops! There was a problem.'")
    @Story("Data input")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("dataInput")
    @Tag("sendMessage")
    @Test
    public void testContactForm() throws InterruptedException {
        String username = "lovasia";
        String password = "kispal123";
        String name = "Kis Pal";
        String email = "kispal@gmail.com";
        String message = "Let's work together";

        //login
        loginPage.navigate();
        loginPage.acceptTerms();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        boolean loggedIn = homePage.isPortioLogoDisplayed();
        Assertions.assertTrue(loggedIn);

        //fill Contact form
        homePage.clickContactMeButton();
        contactPage.inputName(name);
        contactPage.inputEmail(email);
        contactPage.inputMessage(message);
        contactPage.checkCheckbox();
        contactPage.sendMessage();
        contactPage.scrollWindow();
        Thread.sleep(2000);
        addAttachment("Sending contact form is unsuccessful");
        String expected = "Message was sent successfully";
        String actual = contactPage.getMessage();

        Assertions.assertEquals(expected, actual);
    }
}
