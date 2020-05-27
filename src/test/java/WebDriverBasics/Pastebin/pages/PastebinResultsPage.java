package WebDriverBasics.Pastebin.pages;

import WebDriverBasics.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinResultsPage extends AbstractPage {

    public PastebinResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='selectable']/ol")
    private WebElement resultPasteInput;

    @FindBy(xpath = "//div[@id='code_buttons']/span[@class='h_640']/a")
    private WebElement resultPasteFormat;

    public String getResultPasteInput() {
        return resultPasteInput.getText();
    }

    public String getPasteInputFormat() {
        return resultPasteFormat.getText();
    }


}
