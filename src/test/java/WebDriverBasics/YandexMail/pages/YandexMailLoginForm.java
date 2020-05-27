package WebDriverBasics.YandexMail.pages;

import WebDriverBasics.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class YandexMailLoginForm extends AbstractPage {

    public YandexMailLoginForm(WebDriver driver) {
        super(driver);
    }

    private static final String URL = "https://mail.yandex.com/";

    public YandexMailLoginForm open() {
        driver.get(URL);
        return new YandexMailLoginForm(driver);
    }

    @FindBy(xpath = "//span[text()='Log in']/parent::a")
    private WebElement loginButton;

    @FindBy(id = "passp-field-login")
    private WebElement usernameInput;

    @FindBy(id = "passp-field-passwd")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginToContinueButton;

    public YandexMailHomeMenuPage loginToYandexMail(String username, String password) {
        waitForElementsClickable(loginButton);
        loginButton.click();

        waitForElementsVisible(usernameInput);
        usernameInput.sendKeys(username);
        usernameInput.sendKeys(Keys.ENTER);

        waitForElementsVisible(passwordInput);
        passwordInput.sendKeys(password);

        waitForElementsClickable(loginToContinueButton);
        loginToContinueButton.submit();

        return new YandexMailHomeMenuPage(driver);
    }
}
