package webDriverBasics.yandexMail.pages;

import webDriverBasics.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexMailHomeMessageArea extends AbstractPage {

    public YandexMailHomeMessageArea(WebDriver driver) {
        super(driver);
    }

    private By messageLinkBySubject;

    public YandexMailNewMessageModal clickMessageLinkBySubject(String subject) {
        String locator = "//span[@title='" + subject + "']/ancestor::div[@class='mail-MessageSnippet-Content']";

        messageLinkBySubject = By.xpath(locator);
        waitForElementsClickable(messageLinkBySubject);
        driver.findElement(messageLinkBySubject).click();
        return new YandexMailNewMessageModal(driver);
    }

    public By getMessageLinkBySubject(String subject) {
        String locator = "//span[@title='" + subject + "']/ancestor::div[@class='mail-MessageSnippet-Content']";
        messageLinkBySubject = By.xpath(locator);
        return messageLinkBySubject;
    }

    public By getMessageLinkBySubjectWithWaiter(String subject) {
        String locator = "//span[@title='" + subject + "']/ancestor::div[@class='mail-MessageSnippet-Content']";
        messageLinkBySubject = By.xpath(locator);
        waitForElementsPresent(messageLinkBySubject);
        return messageLinkBySubject;
    }

}
