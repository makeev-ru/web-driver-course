package pages.googleCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class GoogleCloudCalculatorPage extends AbstractPage {

    private By devsiteIframe = By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe");

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement myFrame;

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//*[@id='input_58']")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//*[@id='input_59']")
    private WebElement whatAreTheseInstancesForInput;

    @FindBy(xpath = "//*[@id='select_container_71']")
    private WebElement operatingSystemDropDown;

    @FindBy(xpath = "//*[@id='select_option_60']")
    private WebElement operatingSystemFreeDebianItem;

    @FindBy(xpath = "//*[@id='select_value_label_52']")
    private WebElement machineClassDropDown;

    @FindBy(xpath = "//*[@id='select_option_72']")
    private WebElement machineClassRegularItem;

    @FindBy(xpath = "//*[@id='select_value_label_55']")
    private WebElement machineTypeDropDown;

    @FindBy(xpath = "//*[@id='select_option_212']")
    private WebElement machineTypeN1Standard8;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//*[@id='select_value_label_332']")
    private WebElement numberOfGPUsDropDown;

    @FindBy(xpath = "//*[@id='select_option_339']")
    private WebElement oneNumberOfGPUsOption;

    @FindBy(xpath = "//*[@id='select_value_label_333']")
    private WebElement typeGPUsDropDown;

    @FindBy(xpath = "//*[@id='select_option_346']")
    private WebElement nvidiaV100TypeGPUsOption;

    @FindBy(xpath = "//*[@id='select_value_label_169']")
    private WebElement localSSDDropDown;

    @FindBy(xpath = "//*[@id='select_option_233']")
    private WebElement localSSDD2x375Option;

    @FindBy(xpath = "//*[@id='select_value_label_56']")
    private WebElement datacenterLocationDropDown;

    @FindBy(xpath = "//*[@id='select_option_181']")
    private WebElement datacenterLocationFrankfurtOption;

    @FindBy(xpath = "//*[@id='select_value_label_57']")
    private WebElement commitedUsageDropDown;

    @FindBy(xpath = "//*[@id='select_option_90']")
    private WebElement commitedUsageOneYearOption;

    @FindBy(xpath = "//*[@id='email_quote']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']/div/button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement addToEstimateButton;


    public GoogleCloudCalculatorPage clickComputeEngineButton() {
        waitForElementsPresent(devsiteIframe);
        driver.switchTo().frame(driver.findElement(devsiteIframe));
        driver.switchTo().frame(myFrame);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", computeEngineButton);
        return new GoogleCloudCalculatorPage();
    }

    public GoogleCloudCalculatorPage fillNumberOfInstancesInput(int number) {
        waitForElementsClickable(numberOfInstancesInput);
        numberOfInstancesInput.sendKeys(String.valueOf(number));
        return new GoogleCloudCalculatorPage();
    }

    public GoogleCloudCalculatorPage leaveEmptyWhatAreTheseInstancesForInput() {
        waitForElementsClickable(whatAreTheseInstancesForInput);
        whatAreTheseInstancesForInput.clear();
        return new GoogleCloudCalculatorPage();
    }

    public GoogleCloudCalculatorPage selectFreeDebianOperatingSystem() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", operatingSystemDropDown);

        waitForElementsClickable(operatingSystemFreeDebianItem);
        js.executeScript("arguments[0].click();", operatingSystemFreeDebianItem);

        return new GoogleCloudCalculatorPage();
    }

    public GoogleCloudCalculatorPage selectRegularMachineClass() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", machineClassDropDown);

        waitForElementsClickable(machineClassRegularItem);
        js.executeScript("arguments[0].click();", machineClassRegularItem);

        return new GoogleCloudCalculatorPage();
    }

    public GoogleCloudCalculatorPage selectN1Standard8MachineType() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", machineTypeDropDown);

        waitForElementsClickable(machineTypeN1Standard8);
        js.executeScript("arguments[0].click();", machineTypeN1Standard8);

        return new GoogleCloudCalculatorPage();
    }

    public GoogleCloudCalculatorPage clickAddGPUsCheckbox() {
        waitForElementsClickable(addGPUsCheckbox);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addGPUsCheckbox);

        return new GoogleCloudCalculatorPage();
    }

    public GoogleCloudCalculatorPage selectNumberOfGPUs() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", numberOfGPUsDropDown);

        waitForElementsClickable(oneNumberOfGPUsOption);
        js.executeScript("arguments[0].click();", oneNumberOfGPUsOption);

        return new GoogleCloudCalculatorPage();
    }

    public GoogleCloudCalculatorPage selectGPUType() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", numberOfGPUsDropDown);

        waitForElementsClickable(oneNumberOfGPUsOption);
        js.executeScript("arguments[0].click();", nvidiaV100TypeGPUsOption);

        return new GoogleCloudCalculatorPage();
    }

    public GoogleCloudCalculatorPage selectLocalSSDType() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", localSSDDropDown);

        waitForElementsClickable(localSSDD2x375Option);
        js.executeScript("arguments[0].click();", localSSDD2x375Option);

        return new GoogleCloudCalculatorPage();
    }

    public GoogleCloudCalculatorPage selectDatacenterLocation() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", datacenterLocationDropDown);

        waitForElementsClickable(datacenterLocationFrankfurtOption);
        js.executeScript("arguments[0].click();", datacenterLocationFrankfurtOption);

        return new GoogleCloudCalculatorPage();
    }

    public GoogleCloudCalculatorPage selectCommitedUsage() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", commitedUsageDropDown);

        waitForElementsClickable(commitedUsageOneYearOption);
        js.executeScript("arguments[0].click();", commitedUsageOneYearOption);

        return new GoogleCloudCalculatorPage();
    }

    public GoogleCloudCalculatorPage clickAddToEstimateButton() {
        waitForElementsClickable(addToEstimateButton);
        addToEstimateButton.submit();

        return new GoogleCloudCalculatorPage();
    }


}
