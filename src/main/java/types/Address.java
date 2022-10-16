package types;

public class Address {
    private String code;
    private String city;
    private String state;
    private String Country;
    private String zipcode;

    public Address (String code, String city, String state, String Country, String zipcode){
        this.code = code;
        this.city = city;
        this.state = state;
        this.Country = Country;
        this.zipcode = zipcode;
    }

    public String getCode (){
        return code;
    }
    public String getCity (){
        return city;
    }
    public String getState (){
        return state;
    }
    public String getCountry(){
        return Country;
    }
    public String getZipcode(){
        return zipcode;
    }

    public void setCode (String code) {
        this.code = code;
    }
    public void setCity (String city){
        this.city = city;
    }
    public void setState (String state){
        this.state = state;
    }
    public void setCountry(String Country){
        this.Country = Country;
    }
    public void setZipcode(String zipcode){
        this.zipcode = zipcode;
    }
}
