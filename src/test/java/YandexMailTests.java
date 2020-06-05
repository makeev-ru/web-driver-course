import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.yandexMail.YandexMailHomeMenuPage;
import pages.yandexMail.YandexMailHomeMessageArea;
import pages.yandexMail.YandexMailLoginForm;
import pages.yandexMail.YandexMailNewMessageModal;
import utils.WebDriverSingleton;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertThrows;

public class YandexMailTests {
    private static WebDriver driver;
    private static final String USERNAME = System.getenv("YANDEX_USERNAME");
    private static final String PASSWORD = System.getenv("YANDEX_PASSWORD");

    private static final String SEND_TO = USERNAME + "@ya.ru";

    @Test(description = "Assert, that the login is successful")
    public void loginAndVerify() {
        YandexMailHomeMenuPage homePage = new YandexMailLoginForm().
                open().
                loginToYandexMail(USERNAME, PASSWORD);

        Assert.assertEquals(homePage.getUsernameLoginTitle(), USERNAME);

    }

    @Test(description = "Verify the draft content (addressee/subject/body)")
    public void saveDraftMailAndVerifyContent() {
        String subject = RandomStringUtils.randomAlphanumeric(5);
        String body = RandomStringUtils.randomAlphanumeric(20);

        YandexMailNewMessageModal newMessageModal = new YandexMailLoginForm().
                open().
                loginToYandexMail(USERNAME, PASSWORD).
                clickComposeButton().
                fillNewMessageForm(SEND_TO, subject, body).
                clickCloseIcon().
                clickDraftsLink().
                clickUpdateButton().
                clickMessageLinkBySubject(subject);

        List<String> actualMessageContentList = newMessageModal.getMessageContent_to_subject_body();

        List<String> expectedMessageContentList = new ArrayList<>();
        expectedMessageContentList.add(SEND_TO);
        expectedMessageContentList.add(subject);
        expectedMessageContentList.add(body);

        Assert.assertEquals(actualMessageContentList, expectedMessageContentList, "Content doesn't match");
    }

    @Test(description = "Verify, that the mail disappeared from ‘Drafts’ folder")
    public void sendDraftMailAndVerifyItDisappearedFromDrafts() {
        String subject = RandomStringUtils.randomAlphanumeric(6);
        String body = RandomStringUtils.randomAlphanumeric(20);

        YandexMailHomeMessageArea messageArea = new YandexMailLoginForm().
                open().
                loginToYandexMail(USERNAME, PASSWORD).
                clickComposeButton().
                fillNewMessageForm(SEND_TO, subject, body).
                clickCloseIcon().
                clickDraftsLink().
                clickUpdateButton().
                clickMessageLinkBySubject(subject).
                clickSendButton().
                clickBackToInboxButton().
                clickDraftsLink();

        Assert.assertEquals(messageArea.getAmountOfMessagesBySubject(subject), 0,
                "The message is still in Drafts");
    }

    @Test(description = "Verify, that the mail is in ‘Sent’ folder")
    public void sendDraftMailAndVerifyInSent() {
        String subject = RandomStringUtils.randomAlphanumeric(7);
        String body = RandomStringUtils.randomAlphanumeric(20);

        YandexMailHomeMessageArea messageArea = new YandexMailLoginForm().
                open().
                loginToYandexMail(USERNAME, PASSWORD).
                clickComposeButton().
                fillNewMessageForm(SEND_TO, subject, body).
                clickCloseIcon().
                clickDraftsLink().
                clickUpdateButton().
                clickMessageLinkBySubject(subject).
                clickSendButton().
                clickBackToInboxButton().
                clickSentLink();

        Assert.assertEquals(messageArea.getAmountOfMessagesBySubjectWithWaiter(subject), 1,
                "The is no sent message in Sent folder");
    }

    @Test(description = "Log off and verify it")
    public void logoffAndVerify() {
        YandexMailHomeMenuPage homePage = new YandexMailLoginForm().
                open().
                loginToYandexMail(USERNAME, PASSWORD).
                clickUsernameLoginTitle().
                clickLogoffButton();

        assertThrows(org.openqa.selenium.NoSuchElementException.class,
                homePage::findUsernameLoginTitle);

    }

    @AfterClass(description = "Close browser")
    public void kill() {
        WebDriverSingleton.kill();
    }
}
