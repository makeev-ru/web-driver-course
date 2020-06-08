package pages.googleCloud;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudEmailEstimateForm extends GoogleCloudCalculatorPage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    public GoogleCloudEmailEstimateForm fillEmailInput(String email) {
        driver.switchTo().frame(driver.findElement(devsiteIframe));
        driver.switchTo().frame(myFrame);

        emailInput.sendKeys(email);
        return new GoogleCloudEmailEstimateForm();
    }

    public GoogleCloudCalculatorPage clickSendEmailButton() {
        waitForElementsClickable(sendEmailButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", sendEmailButton);
        return new GoogleCloudCalculatorPage();
    }
}
