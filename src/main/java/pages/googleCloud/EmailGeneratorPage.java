package pages.googleCloud;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.DoublePriceRegexConverter;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class EmailGeneratorPage extends AbstractPage {
    private static final String URL = "https://10minutemail.com";

    @FindBy(xpath = "//*[@id='qcCmpButtons']/button[text()=' I accept ']")
    private WebElement acceptButton;

    @FindBy(xpath = "//*[@id='copy_address']")
    private WebElement copyButton;

    @FindBy(xpath = "//span[text()='Google Cloud Platform Price Estimate']/ancestor::div[@class='mail_message']")
    private WebElement messageFromGoogleCloudLink;

    @FindBy(xpath = "//*[@id='mobilepadding']/td/h2")
    private WebElement totalEstimatedCost;


    public String generateEmail() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        switchToTab(1);
        driver.get(URL);

        waitForElementsClickable(acceptButton);
        acceptButton.click();

        waitForElementsClickable(copyButton);
        copyButton.click();

        String email = null;
        try {
            email = Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        switchToTab(0); // switch back to main screen

        return email;
    }

    public double getTotalEstimatedCostFromEmail() {
        switchToTab(1);

        waitForElementsVisible(messageFromGoogleCloudLink, 30);
        messageFromGoogleCloudLink.click();
        waitForElementsVisible(totalEstimatedCost);

        return DoublePriceRegexConverter.
                getWebElementTextAndFindDoublePriceByRegex(totalEstimatedCost);
    }

    public void switchToTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }
}
