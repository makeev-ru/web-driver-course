package WebDriverBasics.YandexMail;

import WebDriverBasics.YandexMail.pages.YandexMailHomeMenuPage;
import WebDriverBasics.YandexMail.pages.YandexMailHomeMessageArea;
import WebDriverBasics.YandexMail.pages.YandexMailLoginForm;
import WebDriverBasics.YandexMail.pages.YandexMailNewMessageModal;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class YandexMailTests {
    private static WebDriver driver;
    private static final String USERNAME = "testuser225";
    private static final String PASSWORD = "test_user225";

    private static final String TO = "testuser225@yandex.ru";

    @BeforeMethod
    public void setUp() {
//        System.setProperty("webdriver.edge.driver", "C:\\data\\drivers\\edge_win32\\msedgedriver.exe");
//        driver = new EdgeDriver();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test(description = "Assert, that the login is successful")
    public void loginAndVerify() {
        YandexMailLoginForm loginPage = new YandexMailLoginForm(driver);
        loginPage.open();

        YandexMailHomeMenuPage homePage = loginPage.loginToYandexMail(USERNAME, PASSWORD);

        Assert.assertEquals(USERNAME, homePage.getUsernameLoginTitle());
    }

    @Test(description = "Verify the draft content (addressee/subject/body)")
    public void saveDraftMailAndVerifyContent() {
        String subject = generateString(5);
        String body = generateString(20);

        YandexMailHomeMenuPage loginPage = new YandexMailLoginForm(driver).
                open().
                loginToYandexMail(USERNAME, PASSWORD).
                clickComposeButton().
                fillNewMessageForm(TO, subject, body).
                clickCloseIcon().
                clickDraftsLink().
                clickUpdateButton();

        YandexMailNewMessageModal newMessageModal = new YandexMailHomeMessageArea(driver).
                clickMessageLinkBySubject(subject);

        List<String> actualMessageContent = newMessageModal.getMessageContent_to_subject_body();

        List<String> expectedMessageContent = new ArrayList<>();
        expectedMessageContent.add(TO);
        expectedMessageContent.add(subject);
        expectedMessageContent.add(body);

        Assert.assertEquals(actualMessageContent, expectedMessageContent, "Wrong content");

    }

    @Test(description = "Verify, that the mail disappeared from ‘Drafts’ folder")
    public void sendDraftMailAndVerifyItDisappearedFromDrafts() {
        String subject = generateString(6);
        String body = generateString(20);

        YandexMailLoginForm loginPage = new YandexMailLoginForm(driver);

        loginPage.
                open().
                loginToYandexMail(USERNAME, PASSWORD).
                clickComposeButton().
                fillNewMessageForm(TO, subject, body).
                clickCloseIcon().
                clickDraftsLink().
                clickUpdateButton();

        YandexMailHomeMessageArea messageArea = new YandexMailHomeMessageArea(driver);
        messageArea.
                clickMessageLinkBySubject(subject).
                clickSendButton().
                clickBackToInboxButton().
                clickDraftsLink();

        Assert.assertEquals(driver.findElements(messageArea.
                        getMessageLinkBySubject(subject)).size(), 0,
                "The message is still in Drafts");

    }

    @Test(description = "Verify, that the mail is in ‘Sent’ folder")
    public void sendDraftMailAndVerifyInSent() {
        String subject = generateString(7);
        String body = generateString(20);

        YandexMailLoginForm loginPage = new YandexMailLoginForm(driver);

        loginPage.
                open().
                loginToYandexMail(USERNAME, PASSWORD).
                clickComposeButton().
                fillNewMessageForm(TO, subject, body).
                clickCloseIcon().
                clickDraftsLink().
                clickUpdateButton();

        YandexMailHomeMessageArea messageArea = new YandexMailHomeMessageArea(driver);

        messageArea.
                clickMessageLinkBySubject(subject).
                clickSendButton().
                clickBackToInboxButton().
                clickSentLink();

        Assert.assertEquals(driver.findElements(messageArea.
                        getMessageLinkBySubjectWithWaiter(subject)).size(), 1,
                "The is no sent message in Sent folder");
    }

    @Test(description = "Log off and verify it")
    public void logoffAndVerify() {

        YandexMailHomeMenuPage homePage = new YandexMailLoginForm(driver).
                open().
                loginToYandexMail(USERNAME, PASSWORD).
                clickUsernameLoginTitle().
                clickLogoffButton();

        Assert.assertEquals(driver.findElements(homePage.getUsernameLoginTitleLocator()).size(), 0,
                "The user is still logged in");

    }

    protected String generateString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }


}
