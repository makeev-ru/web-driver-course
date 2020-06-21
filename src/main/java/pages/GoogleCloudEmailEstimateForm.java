package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudEmailEstimateForm extends GoogleCloudCalculatorPage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    public GoogleCloudEmailEstimateForm fillEmailInput(EmailGeneratorPage emailGeneratorPage) {

        driver.switchTo().frame(driver.findElement(devsiteIframe)).switchTo().frame(myFrame);

        waitForElementsClickable(emailInput);
//        emailInput.click();
        emailInput.sendKeys(Keys.LEFT_CONTROL + "v");

        return new GoogleCloudEmailEstimateForm();
    }

    public GoogleCloudCalculatorPage clickSendEmailButton() {
        waitForElementsClickable(sendEmailButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", sendEmailButton);
        return new GoogleCloudCalculatorPage();
    }
}
