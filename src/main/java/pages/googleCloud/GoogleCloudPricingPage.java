package pages.googleCloud;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class GoogleCloudPricingPage extends AbstractPage {

    @FindBy(xpath = "//a[@track-name='pricingNav/calculators']")
    private WebElement calculatorsButton;

    public GoogleCloudCalculatorPage clickCalculatorsButton() {
        waitForElementsClickable(calculatorsButton);
        calculatorsButton.click();
        return new GoogleCloudCalculatorPage();
    }
}
