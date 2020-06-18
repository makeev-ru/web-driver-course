package pages.googleCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.DoublePriceRegexConverter;

public class GoogleCloudCalculatorPage extends AbstractPage {

    protected By devsiteIframe = By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe");

    @FindBy(xpath = "//iframe[@id='myFrame']")
    protected WebElement myFrame;

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//*[@id='input_58']")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//*[@id='input_59']")
    private WebElement whatAreTheseInstancesForInput;

    @FindBy(xpath = "//*[@id='select_container_71']")
    private WebElement operatingSystemDropDown;

    @FindBy(xpath = "//div[contains(text(), 'Free: Debian')]/ancestor::md-option")
    private WebElement operatingSystemFreeDebianItem; //changed

    @FindBy(xpath = "//*[@id='select_value_label_52']")
    private WebElement machineClassDropDown;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='regular']")
    private WebElement machineClassRegularItem; //changed

    @FindBy(xpath = "//*[@id='select_value_label_55']")
    private WebElement machineTypeDropDown;

    @FindBy(xpath = "//*[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement machineTypeN1Standard8; //changed

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']/md-select-value")
    private WebElement numberOfGPUsDropDown;

    @FindBy(xpath = "//*[@id='select_option_342']")
    private WebElement oneNumberOfGPUsOption;

    @FindBy(xpath = "//*[@id='select_value_label_333']")
    private WebElement typeGPUsDropDown;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement nvidiaV100TypeGPUsOption;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDDropDown;

    @FindBy(xpath = "//div[contains(text(), '2x375 GB')]/ancestor::md-option")
    private WebElement localSSDD2x375Option;

    @FindBy(xpath = "//*[@id='select_value_label_56']")
    private WebElement datacenterLocationDropDown;

    @FindBy(xpath = "//*[@id='select_option_181']")
    private WebElement datacenterLocationFrankfurtOption;

    @FindBy(xpath = "//*[@id='select_value_label_57']")
    private WebElement commitedUsageDropDown;

    @FindBy(xpath = "//*[@id='select_option_90']")
    private WebElement commitedUsageOneYearOption;

    @FindBy(xpath = "//button[@ng-click='cloudCartCtrl.showEmailForm();']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']/div/button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//*[@aria-label='Email Estiamte']/form")
    private WebElement emailForm;

    @FindBy(xpath = "//md-card-content//h2/b")
    private WebElement totalEstimatedCost;


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

    public GoogleCloudEmailEstimateForm clickEmailEstimateButton() {

        waitForElementsVisible(emailEstimateButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailEstimateButton);
        return new GoogleCloudEmailEstimateForm();
    }

    public double getTotalEstimatedCostFromCalculator() {
        waitForElementsVisible(totalEstimatedCost);

        return DoublePriceRegexConverter.
                getWebElementTextAndFindDoublePriceByRegex(totalEstimatedCost);
    }

}
