package com.lxnh.entity;

public class lxnhResponeEntity {
    private String pdfBase64;

    public lxnhResponeEntity(String pdfBase64) {
        this.pdfBase64 = pdfBase64;
    }

    public String getPdfBase64() {
        return pdfBase64;
    }

    public void setPdfBase64(String pdfBase64) {
        this.pdfBase64 = pdfBase64;
    }
}
