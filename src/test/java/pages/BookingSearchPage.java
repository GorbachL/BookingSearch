package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class BookingSearchPage extends BasePage {

    @FindBy(xpath = "//a[@class='hotel_name_link url']")
    private List<WebElement> resultsLinks;

    String ratingLocator = "//div[contains(@class,'bui-review-score__badge')]";

    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResultLinks() {
        return resultsLinks.stream().map(result -> result.getAttribute("innerText"))
                .filter(result -> !result.isEmpty()).collect(Collectors.toList());
    }

    public By getRatingFor(String hotelName) {
        return By.xpath(String.format(ratingLocator, hotelName));
    }

}

