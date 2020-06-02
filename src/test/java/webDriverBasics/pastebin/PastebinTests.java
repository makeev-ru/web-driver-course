package webDriverBasics.pastebin;

import webDriverBasics.pastebin.pages.PastebinHomePage;
import webDriverBasics.pastebin.pages.PastebinResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PastebinTests {
    private static WebDriver driver;
    private static final String PASTE_CODE =
            "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    //WebDriver course: I Can Win
    @Test(description = "First scenario: create New Paste")
    public void createNewPasteHelloWeb() {
        PastebinHomePage homePage = new PastebinHomePage(driver);
        homePage.open();

        String code = "Hello from WebDriver";
        PastebinResultsPage pastebinResultsPage = homePage.
                fillPasteInput(code).
                selectPasteExpiration10min().
                fillPasteNameTitleInput("helloweb").
                pressCreateNewPasteButton();

    }

    //WebDriver course: Bring It On
    @Test(description = "1. Get Page Title")
    public void verifyPageTitle() {
        PastebinHomePage homePage = new PastebinHomePage(driver);
        homePage.open();

        String pasteNameTitle = "how to gain dominance among developers";
        PastebinResultsPage pastebinResultsPage = homePage.
                fillPasteInput(PASTE_CODE).
                selectPasteExpiration10min().
                selectSyntaxHighlightingBash().
                fillPasteNameTitleInput(pasteNameTitle).
                pressCreateNewPasteButton();

        Assert.assertEquals(driver.getTitle(), "[Bash] " + pasteNameTitle + " - Pastebin.com",
                "Wrong Page Title");

    }

    @Test(description = "2. Verify Paste Format")
    public void verifyPasteFormat() {
        PastebinHomePage homePage = new PastebinHomePage(driver);
        homePage.open();

        String pasteNameTitle = "how to gain dominance among developers";
        PastebinResultsPage pastebinResultsPage = homePage.
                fillPasteInput(PASTE_CODE).
                selectPasteExpiration10min().
                selectSyntaxHighlightingBash().
                fillPasteNameTitleInput(pasteNameTitle).
                pressCreateNewPasteButton();

        Assert.assertEquals(pastebinResultsPage.getPasteInputFormat(), "Bash","Wrong Paste Format");

    }

    @Test(description = "3. Verify paste text")
    public void verifyPasteText() {
        PastebinHomePage homePage = new PastebinHomePage(driver);
        homePage.open();

        String pasteNameTitle = "how to gain dominance among developers";
        PastebinResultsPage pastebinResultsPage = homePage.
                fillPasteInput(PASTE_CODE).
                selectPasteExpiration10min().
                selectSyntaxHighlightingBash().
                fillPasteNameTitleInput(pasteNameTitle).
                pressCreateNewPasteButton();


        Assert.assertEquals(pastebinResultsPage.getResultPasteInput(), PASTE_CODE,"Wrong Paste Text");

    }
}
