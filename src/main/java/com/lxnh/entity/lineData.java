package com.lxnh.entity;


public class lineData {
    private String stt;
    private String maVatTu;
    private String tenVatTu;
    private String dvt;
    private String soLuong;
    private String dvtQuyDoi;
    private String soLuongQuyDoi;
    private String soLo;

    public lineData(String stt, String maVatTu, String tenVatTu, String dvt, String soLuong, String dvtQuyDoi, String soLuongQuyDoi, String soLo) {
        this.stt = stt;
        this.maVatTu = maVatTu;
        this.tenVatTu = tenVatTu;
        this.dvt = dvt;
        this.soLuong = soLuong;
        this.dvtQuyDoi = dvtQuyDoi;
        this.soLuongQuyDoi = soLuongQuyDoi;
        this.soLo = soLo;
    }
    public lineData() {}

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getMaVatTu() {
        return maVatTu;
    }

    public void setMaVatTu(String maVatTu) {
        this.maVatTu = maVatTu;
    }

    public String getTenVatTu() {
        return tenVatTu;
    }

    public void setTenVatTu(String tenVatTu) {
        this.tenVatTu = tenVatTu;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getDvtQuyDoi() {
        return dvtQuyDoi;
    }

    public void setDvtQuyDoi(String dvtQuyDoi) {
        this.dvtQuyDoi = dvtQuyDoi;
    }

    public String getSoLuongQuyDoi() {
        return soLuongQuyDoi;
    }

    public void setSoLuongQuyDoi(String soLuongQuyDoi) {
        this.soLuongQuyDoi = soLuongQuyDoi;
    }

    public String getSoLo() {
        return soLo;
    }

    public void setSoLo(String soLo) {
        this.soLo = soLo;
    }

    public String toString(){
        return stt + "\n" +
                maVatTu + "\n" +
                tenVatTu + "\n" +
                dvt + "\n" +
                soLuong + "\n" +
                soLo + "\n" +
                dvtQuyDoi + "\n" +
                soLuongQuyDoi + "\n" ;
    }
}
