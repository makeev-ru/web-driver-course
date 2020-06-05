package pages.pastebin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class PastebinResultsPage extends AbstractPage {

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

    public String getTitle() {
        return driver.getTitle();
    }


}
