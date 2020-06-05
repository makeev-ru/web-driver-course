import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.googleCloud.GoogleCloudHomePage;
import utils.WebDriverSingleton;

public class GoogleCloudTests {
    private static WebDriver driver;

    @Test
    public void hardcoreScenario() {
        GoogleCloudHomePage homePage = new GoogleCloudHomePage();
        homePage.
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
                clickAddToEstimateButton();
    }

    @AfterClass(description = "Close browser")
    public void kill() {
        WebDriverSingleton.kill();
    }
}
