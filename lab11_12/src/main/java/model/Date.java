package model;

public class Date {
    private String departDate;
    private String returnDate;

    public String getDepartDate() {
        return departDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Date(String departDate, String returnDate) {
        this.departDate = departDate;
        this.returnDate = returnDate;
    }
}
