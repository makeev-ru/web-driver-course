package pages.yandexMail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class YandexMailHomeMenuPage extends YandexMailHomeMessageArea {

    @FindBy(xpath = "//a[@title='Compose (w, c)']")
    private WebElement composeButton;

    @FindBy(xpath = "//span[@title='Check for new messages (F9)']")
    private WebElement updateButton;

    @FindBy(xpath = "//span[text()='Drafts']")
    private WebElement draftsButton;

    @FindBy(xpath = "//*[@class='mail-NestedList-Item-Name' and text()='Sent']")
    private WebElement sentButton;

    @FindBy(xpath = "//div[@class='mail-User-Name']")
    private WebElement usernameLoginTitle;

    @FindBy(xpath = "//*[@data-metric='Sign out of Yandex services']")
    private WebElement logoffButton;

    public YandexMailNewMessageModal clickComposeButton() {
        waitForElementsClickable(composeButton);
        composeButton.click();
        return new YandexMailNewMessageModal();
    }

    public YandexMailHomeMenuPage clickUpdateButton() {
        waitForElementsClickable(updateButton);
        updateButton.click();
        return new YandexMailHomeMenuPage();
    }

    public YandexMailHomeMenuPage clickDraftsLink() {
        waitForElementsClickable(draftsButton);
        draftsButton.click();
        return new YandexMailHomeMenuPage();
    }

    public YandexMailHomeMenuPage clickSentLink() {
        waitForElementsClickable(sentButton);
        sentButton.click();
        return new YandexMailHomeMenuPage();
    }

    public String getUsernameLoginTitle() {
        waitForElementsVisible(usernameLoginTitle);
        return usernameLoginTitle.getText();
    }

    public YandexMailHomeMenuPage findUsernameLoginTitle()
            throws org.openqa.selenium.NoSuchElementException {

        driver.findElement(By.xpath("//div[@class='mail-User-Name']")).isDisplayed();
        return new YandexMailHomeMenuPage();
    }

    public YandexMailHomeMenuPage clickUsernameLoginTitle() {
        waitForElementsVisible(usernameLoginTitle);
        usernameLoginTitle.click();
        return new YandexMailHomeMenuPage();
    }

    public YandexMailHomeMenuPage clickLogoffButton() {
        waitForElementsVisible(logoffButton);
        logoffButton.click();
        return new YandexMailHomeMenuPage();
    }
}
