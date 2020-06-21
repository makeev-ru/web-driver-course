package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String URL = "https://cloud.google.com/";

    public GoogleCloudHomePage open() {
        driver.get(URL);
        return new GoogleCloudHomePage();
    }

    @FindBy(xpath = "//button[@class='devsite-snackbar-action' and text()='OK']")
    private WebElement bannerOKButton;

    @FindBy(xpath = "//a[@track-name='see all products']")
    private WebElement seeAllProductsButton;

    public GoogleCloudHomePage clickBannerOKButton() {
        waitForElementsClickable(bannerOKButton);
        bannerOKButton.click();
        return new GoogleCloudHomePage();
    }

    public GoogleCloudProductsPage clickSeeAllProductsButton() {
        waitForElementsClickable(seeAllProductsButton);
        seeAllProductsButton.click();
        return new GoogleCloudProductsPage();
    }
}
