import model.Date;
import model.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;
import page.MainResultPage;
import service.DatesCreator;
import service.LocationsCreator;

public class TicketSearchTest extends CommonConditions{
    private final String EXPECTED_DEPART_TIME = "16:45";
    private final String EXPECTED_CITY_FROM = "Bialystok";
    @Test
    public void searchTickets() {
        MainPage mainPage = new MainPage(driver);
        Location location = LocationsCreator.locationWithEmptyToLocationOneWay();
        Date date = DatesCreator.dateWithEmptyReturnDateOneWay();

        MainResultPage mainResultPage = mainPage.openPage()
                .clickOnRoute()
                .clickOnFromLocation()
                .enterFromLocation(location.getFromLocation())
                .enterDepartDate(date.getDepartDate())
                .clickOnSearchButton();
        String resultDepartTime = mainResultPage.getDepartTime();
        Assert.assertEquals(resultDepartTime, EXPECTED_DEPART_TIME);
    }

    @Test
    public void searchRoundTripTickets() {
        MainPage mainPage = new MainPage(driver);
        Location location = LocationsCreator.locationsFromPropertyRoundTrip();
        Date date = DatesCreator.dateWithEmptyReturnDateRoundTrip();

        MainResultPage mainResultPage = mainPage.openPage()
                .clickOnRoundTrip()
                .clickOnFromLocation()
                .enterFromLocation(location.getFromLocation())
                .enterToLocation(location.getToLocation())
                .clickOnDepartDate()
                .clickOnReturnDate()
                .clickOnSearchButton();
        String resultCityFrom = mainResultPage.getCityFrom();
        Assert.assertEquals(resultCityFrom, EXPECTED_CITY_FROM);
    }
}
