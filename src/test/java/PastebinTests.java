import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pastebin.PastebinHomePage;
import pages.pastebin.PastebinResultsPage;

public class PastebinTests {
    private static final String PASTE_CODE =
            "git config --global user.name  \"New Sheriff in Town\"\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force";

    //WebDriver course: I Can Win
    @Test(description = "Create New Paste")
    public void createNewPasteHelloWeb() {
        PastebinHomePage homePage = new PastebinHomePage();
        homePage.open();

        String code = "Hello from WebDriver";
        PastebinResultsPage pastebinResultsPage = homePage.
                fillPasteInput(code).
                selectPasteExpiration10min().
                fillPasteNameTitleInput("helloweb").
                pressCreateNewPasteButton();

    }

    //WebDriver course: Bring It On
    @Test(description = "Get Page Title")
    public void verifyPageTitle() {
        PastebinHomePage homePage = new PastebinHomePage();
        homePage.open();

        String pasteNameTitle = "how to gain dominance among developers";
        PastebinResultsPage pastebinResultsPage = homePage.
                fillPasteInput(PASTE_CODE).
                selectPasteExpiration10min().
                selectSyntaxHighlightingBash().
                fillPasteNameTitleInput(pasteNameTitle).
                pressCreateNewPasteButton();

        Assert.assertEquals(pastebinResultsPage.getTitle(), "[Bash] " + pasteNameTitle + " - Pastebin.com",
                "Wrong Page Title");

    }

    @Test(description = "Verify Paste Format")
    public void verifyPasteFormat() {
        PastebinHomePage homePage = new PastebinHomePage();
        homePage.open();

        String pasteNameTitle = "how to gain dominance among developers";
        PastebinResultsPage pastebinResultsPage = homePage.
                fillPasteInput(PASTE_CODE).
                selectPasteExpiration10min().
                selectSyntaxHighlightingBash().
                fillPasteNameTitleInput(pasteNameTitle).
                pressCreateNewPasteButton();

        Assert.assertEquals(pastebinResultsPage.getPasteInputFormat(), "Bash", "Wrong Paste Format");

    }

    @Test(description = "Verify paste text")
    public void verifyPasteText() {
        PastebinHomePage homePage = new PastebinHomePage();
        homePage.open();

        String pasteNameTitle = "how to gain dominance among developers";
        PastebinResultsPage pastebinResultsPage = homePage.
                fillPasteInput(PASTE_CODE).
                selectPasteExpiration10min().
                selectSyntaxHighlightingBash().
                fillPasteNameTitleInput(pasteNameTitle).
                pressCreateNewPasteButton();


        Assert.assertEquals(pastebinResultsPage.getResultPasteInput(), PASTE_CODE, "Wrong Paste Text");

    }
}
