package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudProductsPage extends AbstractPage {

    @FindBy(xpath = "//a[@track-name='seePricing']")
    private WebElement seePricingButton;

    public GoogleCloudPricingPage clickSeePricingButton() {
        waitForElementsClickable(seePricingButton);
        seePricingButton.click();
        return new GoogleCloudPricingPage();
    }
}
