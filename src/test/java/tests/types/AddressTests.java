package tests.types;

import org.junit.jupiter.api.Test;
import types.Address;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressTests {

    private String buildingNumber = "123";
    private String streetName = "Paint St.";
    private String aptNumber = "";
    private String city = "Berkeley";
    private String state = "CA";
    private String country = "USA";
    private String zipCode = "99342";

    @Test
    public void getAddress() {
        Address address = new Address(buildingNumber, streetName, aptNumber, city, state, country, zipCode);

        assertTrue(buildingNumber.equals(address.getBuildingNumber()), "Building Number does not match");
        assertTrue(streetName.equals(address.getStreetName()), "street name oes not match");
        assertTrue(aptNumber.equals(address.getAptNumber()), "Apt/Room Number does not match");
        assertTrue(city.equals(address.getCity()), "City name does not match");
        assertTrue(state.equals(address.getState()), "State does not match");
        assertTrue(country.equals(address.getCountry()), "country does not match");
        assertTrue(zipCode.equals(address.getZipCode()), "zip code does not match");
    }
}
