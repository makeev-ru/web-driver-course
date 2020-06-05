package pages.pastebin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class PastebinHomePage extends AbstractPage {

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
        return new PastebinHomePage();
    }

    public PastebinHomePage selectPasteExpiration10min() {
        pasteExpiration10min.click();
        return new PastebinHomePage();
    }

    public PastebinHomePage selectSyntaxHighlightingBash() {
        syntaxHighlightingBash.click();
        return new PastebinHomePage();
    }

    public PastebinHomePage fillPasteNameTitleInput(String query) {
        pasteNameTitleInput.sendKeys(query);
        return new PastebinHomePage();
    }

    public PastebinResultsPage pressCreateNewPasteButton() {
        waitForElementsClickable(createNewPasteButton);
        createNewPasteButton.submit();
        return new PastebinResultsPage();
    }
}
