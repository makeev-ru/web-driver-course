package utils;

import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoublePriceRegexConverter {
    public static double getWebElementTextAndFindDoublePriceByRegex(WebElement webElement) {

        String line = webElement.getText();
        String regex = "\\d+\\.\\d{2}";
        Pattern regexp = Pattern.compile(regex);
        Matcher match = regexp.matcher(line);
        boolean isFound = match.find();

        return Double.parseDouble(match.group());
    }
}
