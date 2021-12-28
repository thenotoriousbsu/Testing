package model;

import java.util.Objects;

public class User {

    private String memberId;
    private String password;

    public User(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(memberId, user.memberId) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "memberId='" + memberId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
