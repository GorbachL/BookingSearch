package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.SearchItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import pages.BookingMainPage;
import pages.BookingSearchPage;

import java.util.List;

import static com.sun.jmx.snmp.ThreadContext.contains;
import static org.testng.AssertJUnit.assertEquals;

public class BookingSearchSteps {

    private static final String BOOKING_URL = "https://www.booking.com/searchresults.en-gb.html";
    private BookingMainPage bookingMainPage;
    private BookingSearchPage bookingSearchPage;
    private WebDriver driver;
    private SearchItem searchItem;

    @Given("Keyword for search is {string}")
    public void keywordForSearchIs(String keyword) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        searchItem = new SearchItem(keyword);
    }

    @When("User performs search")
    public void userPerformsSearch() {
        driver = new ChromeDriver();
        driver.get(BOOKING_URL);
        bookingMainPage = new BookingMainPage(driver);
        bookingMainPage.searchByKeyword(searchItem.getSearchItem());
        bookingSearchPage = new BookingSearchPage(driver);
    }

    @Then("Hotel {string} appears in the search page")
    public void hotelAppearsInTheSearchPage(String result) {
        bookingSearchPage = new BookingSearchPage(driver);
        List<String> hotels = bookingSearchPage.getResultLinks();
        assertThat(hotels, contains(result));
    }

    private void assertThat(List<String> hotels, boolean contains) {
    }

    @And("Hotel {string} has rating {string}")
    public void hotelHasRating(String hotelName, String ratingForHotel) {
        bookingSearchPage = new BookingSearchPage(driver);
        String rating = driver.findElement(bookingSearchPage.getRatingFor(hotelName)).getText();
        assertEquals(rating, ratingForHotel);
        driver.quit();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
    }
}
