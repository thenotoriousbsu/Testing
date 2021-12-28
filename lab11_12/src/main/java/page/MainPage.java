package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    private static final String BASE_URL = "https://ecolines.by/by/ru";
    private String parentWindow;
    private final By routeLocator = By.xpath("//label[contains(@class,'btn btn-default btn-sm')]");
    private final By fromLocation = By.xpath("//button[contains(@data-id,'form-origin')]");
    private final By inputLocation = By.xpath("//div[@class='bs-searchbox']//input[contains(@class,'form-control')]");
    private final By inputDepartDate = By.xpath("//input[contains(@name,'outwardDate')]");
    private final By inputReturnDate = By.xpath("//input[contains(@name,'returnDate')]");
    private final By searchButton = By.xpath("//button[contains(@type,'submit')]");
    private final By roundTripSelector = By.xpath("//input[contains(@id,'ecolines-booking-form-roundtrip')]");
    private final By toLocation = By.xpath("//button[contains(@data-id,'form-destination')]");
    private final By inputDateToRoundTrip = By.xpath("//td[text()='28']");
    private final By inputDateFromRoundTrip = By.xpath("//td[text()='29']");




    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public MainPage clickOnRoundTrip() {
        findByLocator(roundTripSelector).click();
        return this;
    }

    public MainPage clickOnRoute() {
        WebElement element = findAll(routeLocator).get(1);
        element.click();
        return this;
    }

    public MainPage clickOnFromLocation() {
        findByLocator(fromLocation).click();
        return this;
    }

    public MainPage enterFromLocation(String location) {
        WebElement element = findByLocator(inputLocation);
        element.click();
        element.sendKeys(location);
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public MainPage enterToLocation(String location) {
        WebElement element = findAll(inputLocation).get(1);
        element.sendKeys(location);
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public MainPage enterDepartDate(String date) {
        WebElement element = findByLocatorClickable(inputDepartDate);
        element.sendKeys(date);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public MainPage clickOnDepartDate() {
        WebElement element = findByLocator(inputDateToRoundTrip);
        element.click();
        return this;
    }

    public MainPage clickOnReturnDate() {
        WebElement element = findAll(inputDateFromRoundTrip).get(1);
        element.click();
        return this;
    }

    public MainResultPage clickOnSearchButton() {
        findByLocator(searchButton).click();
        return new MainResultPage(driver);
    }



}
