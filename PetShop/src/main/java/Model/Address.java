package Model;

public class Address {
    private String IDAddress;
    private String provincial;
    private String district;
    private String Ward;
    private String specifically;
    private String companyName;
    private String apartment;

    public Address(String IDAddress,String provincial, String district, String ward, String specifically, String companyName, String apartment) {
        this.IDAddress=IDAddress;
        this.provincial = provincial;
        this.district = district;
        Ward = ward;
        this.specifically = specifically;
        this.companyName = companyName;
        this.apartment = apartment;
    }

    public String getIDAddress() {
        return IDAddress;
    }

    public String getProvincial() {
        return provincial;
    }

    public String getDistrict() {
        return district;
    }

    public String getWard() {
        return Ward;
    }

    public String getSpecifically() {
        return specifically;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getApartment() {
        return apartment;
    }
}
