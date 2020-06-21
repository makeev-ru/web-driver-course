import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.EmailGeneratorPage;
import pages.GoogleCloudCalculatorPage;
import pages.GoogleCloudHomePage;
import utils.WebDriverSingleton;

public class GoogleCloudTests {

    @Test
    public void hardcoreScenario() {
        EmailGeneratorPage emailGeneratorPage = new EmailGeneratorPage();

        GoogleCloudCalculatorPage homePage = new GoogleCloudHomePage().
                open().
                clickBannerOKButton(). //no banner using soucelabs env
                        clickSeeAllProductsButton().
                        clickSeePricingButton().
                        clickCalculatorsButton().
                        clickComputeEngineButton().
                        fillNumberOfInstancesInput(4).
                        leaveEmptyWhatAreTheseInstancesForInput().
                        selectFreeDebianOperatingSystem().
                        selectRegularMachineClass().
                        selectN1Standard8MachineType().
                        clickAddGPUsCheckbox().
                        selectNumberOfGPUs().
                        selectGPUType().
                        selectLocalSSDType().
                        selectDatacenterLocation().
                        selectCommitedUsage().
                        clickAddToEstimateButton().
                        clickEmailEstimateButton().
                        fillEmailInput(new EmailGeneratorPage().generateEmail()).
                        clickSendEmailButton();

        double priceFromCalculator = homePage.getTotalEstimatedCostFromCalculator();
        double priceFromEmail = emailGeneratorPage.getTotalEstimatedCostFromEmail();

        Assert.assertEquals(priceFromCalculator, priceFromEmail, "Prices are not equal");
    }

    @AfterClass(description = "Close browser")
    public void kill() {
        WebDriverSingleton.closeDriver();
    }
}
