package service;

import model.Date;

public class DatesCreator {
    public static final String TESTDATA_DEPART_DATE_ONE_WAY="testdata.test.departDate.oneWay";
    public static final String TESTDATA_RETURN_DATE_ONE_WAY="testdata.test.returnDate.oneWay";
    public static final String TESTDATA_DEPART_DATE_ROUND_TRIP="testdata.test.departDate.roundTrip";
    public static final String TESTDATA_RETURN_DATE_ROUND_TRIP="testdata.test.returnDate.roundTrip";

    public static Date datesFromPropertyOneWay() {
        return new Date(TestDataReader.getTestData(TESTDATA_DEPART_DATE_ONE_WAY),
                TestDataReader.getTestData(TESTDATA_RETURN_DATE_ONE_WAY));
    }
    public static Date dateWithEmptyReturnDateOneWay() {
        return new Date(TestDataReader.getTestData(TESTDATA_DEPART_DATE_ONE_WAY),"");
    }

    public static Date datesFromPropertyRpundTrip() {
        return new Date(TestDataReader.getTestData(TESTDATA_DEPART_DATE_ROUND_TRIP),
                TestDataReader.getTestData(TESTDATA_RETURN_DATE_ROUND_TRIP));
    }
    public static Date dateWithEmptyReturnDateRoundTrip() {
        return new Date(TestDataReader.getTestData(TESTDATA_DEPART_DATE_ROUND_TRIP),"");
    }

}
