package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingMainPage extends BasePage {

    @FindBy(css = "[type=search]")
    private WebElement searchField;

    @FindBy(css = "button[type=submit]")
    private WebElement searchButton;

    public BookingMainPage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(String keyword) {
        searchField.click();
        searchField.sendKeys(keyword);
        searchButton.click();
    }
}
