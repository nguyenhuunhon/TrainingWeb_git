package Model;

import DAO.AddressDAO;
import DAO.InforCustomerDAO;

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

    public Address(String provincial, String district, String ward, String specifically, String companyName, String apartment) {
        setIDAddress();
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

    public void setIDAddress() {
        for(int i = 0; i< AddressDAO.mapAddress.size()+1000; i++){
            String id="DC"+(i+1);
            if(!AddressDAO.mapAddress.keySet().contains(id)){
                this.IDAddress=id;
                break;
            }
        }
    }

    public void setProvincial(String provincial) {
        this.provincial = provincial;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setWard(String ward) {
        Ward = ward;
    }

    public void setSpecifically(String specifically) {
        this.specifically = specifically;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
