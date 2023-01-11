package com.lxnh.entity;

public class parameterModel {
    private String companyName;
    private String companyAddress;
    private String companyPhoneNumber;
    private String donViNhanHang;

    public parameterModel(String companyName, String companyAddress, String companyPhoneNumber, String donViNhanHang) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhoneNumber = companyPhoneNumber;
        this.donViNhanHang = donViNhanHang;
    }
    public parameterModel() {

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public String getDonViNhanHang() {
        return donViNhanHang;
    }

    public void setDonViNhanHang(String donViNhanHang) {
        this.donViNhanHang = donViNhanHang;
    }
}
