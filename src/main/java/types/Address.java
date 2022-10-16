package types;

import java.util.Objects;

public class Address {

    private String buildingNumber;
    private String streetName;
    private String aptNumber;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public Address(String buildingNumber, String streetName, String aptNumber, String city, String state, String country, String zipCode) {
        this.buildingNumber = buildingNumber;
        this.streetName = streetName;
        this.aptNumber = aptNumber;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "buildingNumber='" + buildingNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", aptNumber='" + aptNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", Country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return getBuildingNumber().equals(address.getBuildingNumber()) && getStreetName().equals(address.getStreetName()) && getAptNumber().equals(address.getAptNumber()) && getCity().equals(address.getCity()) && getState().equals(address.getState()) && getCountry().equals(address.getCountry()) && getZipCode().equals(address.getZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBuildingNumber(), getStreetName(), getAptNumber(), getCity(), getState(), getCountry(), getZipCode());
    }
}
