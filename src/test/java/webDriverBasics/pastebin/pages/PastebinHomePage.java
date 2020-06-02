package webDriverBasics.pastebin.pages;

import webDriverBasics.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinHomePage extends AbstractPage {

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    private static final String URL = "https://pastebin.com";

    @FindBy(id = "paste_code")
    private WebElement newPasteInput;

    public void open() {
        driver.get(URL);
    }

    @FindBy(id = "submit")
    private WebElement createNewPasteButton;

    @FindBy(xpath = "//select[@name='paste_expire_date']/option[@value='10M']")
    private WebElement pasteExpiration10min;

    @FindBy(name = "paste_name")
    private WebElement pasteNameTitleInput;

    @FindBy(xpath = "//select[@name='paste_format']/option[@value='8']")
    private WebElement syntaxHighlightingBash;

    public PastebinHomePage fillPasteInput(String query) {
        newPasteInput.sendKeys(query);
        return new PastebinHomePage(driver);
    }

    public PastebinHomePage selectPasteExpiration10min() {
        pasteExpiration10min.click();
        return new PastebinHomePage(driver);
    }

    public PastebinHomePage selectSyntaxHighlightingBash() {
        syntaxHighlightingBash.click();
        return new PastebinHomePage(driver);
    }

    public PastebinHomePage fillPasteNameTitleInput(String query) {
        pasteNameTitleInput.sendKeys(query);
        return new PastebinHomePage(driver);
    }

    public PastebinResultsPage pressCreateNewPasteButton() {
        waitForElementsClickable(createNewPasteButton);
        createNewPasteButton.submit();
        return new PastebinResultsPage(driver);
    }
}
