package com.lxnh.entity;

public class dataModel {
    private String companyName;
    private String companyAddress;
    private String companyPhoneNumber;
    private String donViNhanHang;
//    private lineData detail;

    public dataModel(String companyName, String companyAddress, String companyPhoneNumber, String donViNhanHang) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhoneNumber = companyPhoneNumber;
        this.donViNhanHang = donViNhanHang;
//        this.detail = detail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public String getDonViNhanHang() {
        return donViNhanHang;
    }
}
