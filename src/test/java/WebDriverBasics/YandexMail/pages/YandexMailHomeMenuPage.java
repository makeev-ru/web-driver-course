package WebDriverBasics.YandexMail.pages;

import WebDriverBasics.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class YandexMailHomeMenuPage extends AbstractPage {

    public YandexMailHomeMenuPage(WebDriver driver) {
        super(driver);
    }

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
        return new YandexMailNewMessageModal(driver);
    }

    public YandexMailHomeMenuPage clickUpdateButton() {
        waitForElementsClickable(updateButton);
        updateButton.click();
        return new YandexMailHomeMenuPage(driver);
    }

    public YandexMailHomeMenuPage clickDraftsLink() {
        waitForElementsClickable(draftsButton);
        draftsButton.click();
        return new YandexMailHomeMenuPage(driver);
    }

    public YandexMailHomeMenuPage clickSentLink() {
        waitForElementsClickable(sentButton);
        sentButton.click();
        return new YandexMailHomeMenuPage(driver);
    }

    public String getUsernameLoginTitle() {
        waitForElementsVisible(usernameLoginTitle);
        return usernameLoginTitle.getText();
    }

    public By getUsernameLoginTitleLocator() {
        return By.xpath("//div[@class='mail-User-Name']");
    }

    public YandexMailHomeMenuPage clickUsernameLoginTitle() {
        waitForElementsVisible(usernameLoginTitle);
        usernameLoginTitle.click();
        return new YandexMailHomeMenuPage(driver);
    }

    public YandexMailHomeMenuPage clickLogoffButton() {
        waitForElementsVisible(logoffButton);
        logoffButton.click();
        return new YandexMailHomeMenuPage(driver);
    }
}
