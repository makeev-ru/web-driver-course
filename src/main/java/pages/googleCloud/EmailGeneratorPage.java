package pages.googleCloud;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.DoublePriceRegexConverter;

import java.util.ArrayList;

public class EmailGeneratorPage extends AbstractPage {

    private static final String URL = "https://temp-mail.org";

    @FindBy(xpath = "//button[@class='btn-rds icon-btn bg-theme click-to-copy copyIconGreenBtn']")
    private WebElement copyButton;

    @FindBy(xpath = "//a[text()='Google Cloud Platform Price Estimate']")
    private WebElement messageFromGoogleCloudLink;

    @FindBy(xpath = "//*[@id='mobilepadding']/td/h2")
    private WebElement totalEstimatedCost;


    public EmailGeneratorPage generateEmail() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        switchToTab(1);
        driver.get(URL);

        waitForElementsClickable(copyButton);
        copyButton.click();

        switchToTab(0); // switch back to main screen
        return new EmailGeneratorPage();
    }

    public double getTotalEstimatedCostFromEmail() {
        switchToTab(1);

        waitForElementsClickable(messageFromGoogleCloudLink, 60);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", messageFromGoogleCloudLink);
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
