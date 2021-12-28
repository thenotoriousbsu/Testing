package service;

import model.Location;

public class LocationsCreator {
    public static final String TESTDATA_FROM_LOCATION_ONE_WAY = "testdata.test.fromLocation.oneWay";
    public static final String TESTDATA_TO_LOCATION_ONE_WAY = "testdata.test.toLocation.oneWay";
    public static final String TESTDATA_FROM_LOCATION_ROUND_TRIP = "testdata.test.fromLocation.roundTrip";
    public static final String TESTDATA_TO_LOCATION_ROUND_TRIP = "testdata.test.toLocation.roundTrip";

    public static Location locationsFromPropertyOneWay() {
        return new Location(TestDataReader.getTestData(TESTDATA_FROM_LOCATION_ONE_WAY),
                TestDataReader.getTestData(TESTDATA_TO_LOCATION_ONE_WAY));
    }

    public static Location locationWithEmptyToLocationOneWay() {
        return new Location(TestDataReader.getTestData(TESTDATA_FROM_LOCATION_ONE_WAY),"");
    }

    public static Location locationsFromPropertyRoundTrip() {
        return new Location(TestDataReader.getTestData(TESTDATA_FROM_LOCATION_ROUND_TRIP),
                TestDataReader.getTestData(TESTDATA_TO_LOCATION_ROUND_TRIP));
    }

    public static Location locationWithEmptyToLocationRoundTrip() {
        return new Location(TestDataReader.getTestData(TESTDATA_FROM_LOCATION_ROUND_TRIP),"");
    }

}
