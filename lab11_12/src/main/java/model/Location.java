package model;

import java.util.Objects;

public class Location {
    private String fromLocation;
    private String toLocation;

    public Location(String fromLocation, String toLocation) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(fromLocation, location.fromLocation) && Objects.equals(toLocation, location.toLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromLocation, toLocation);
    }
}
