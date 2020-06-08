import org.testng.Assert;
import org.testng.annotations.Test;
import pages.googleCloud.EmailGeneratorPage;
import pages.googleCloud.GoogleCloudCalculatorPage;
import pages.googleCloud.GoogleCloudHomePage;

public class GoogleCloudTests {

    @Test
    public void hardcoreScenario() {
        EmailGeneratorPage emailGeneratorPage = new EmailGeneratorPage();

        GoogleCloudCalculatorPage homePage = new GoogleCloudHomePage().
                open().
                clickBannerOKButton().
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
                fillEmailInput(emailGeneratorPage.generateEmail()).
                clickSendEmailButton();

        double priceFromCalculator = homePage.getTotalEstimatedCostFromCalculator();
        double priceFromEmail = emailGeneratorPage.getTotalEstimatedCostFromEmail();

        Assert.assertEquals(priceFromCalculator, priceFromEmail,"Prices are not equal");
    }

//    @AfterClass(description = "Close browser")
//    public void kill() {
//        WebDriverSingleton.kill();
//    }
}
