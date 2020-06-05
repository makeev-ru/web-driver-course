package pages.googleCloud;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class GoogleCloudProductsPage extends AbstractPage {

    @FindBy(xpath = "//a[@track-name='seePricing']")
    private WebElement seePricingButton;

    public GoogleCloudPricingPage clickSeePricingButton() {
        waitForElementsClickable(seePricingButton);
        seePricingButton.click();
        return new GoogleCloudPricingPage();
    }
}
