package service;

import model.User;

public class UserCreator {
    public static final String TESTDATA_MEMBER_ID = "testdata.member.id";
    public static final String TESTDATA_USER_PASSWORD = "testdata.password";

    public static User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_MEMBER_ID),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }
}
