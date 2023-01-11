package com.lxnh.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxnh.entity.lineData;
import com.lxnh.entity.lxnhResponeEntity;
import com.lxnh.entity.parameterModel;
import com.lxnh.services.exportPDF;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RestController
public class restPDFBase64 {

    @PostMapping(value = "/pdf")
    public String restPdfBase64(@RequestBody Map<String, Object> JSON) {
        exportPDF exporter = new exportPDF();
        String companyName = JSON.get("companyName").toString();
        System.out.println(JSON);

        return exporter.lxnhPDF(companyName);
    }
    @PostMapping(value = "/api-pdf-lxnh")
    public String restPdfBase64(@RequestBody String JsonString) throws JsonProcessingException {
        String companyName;
        String companyAddress;
        String companyPhoneNumber;
        String donViNhanHang;
        //convert String to Json Object
        JSONObject jsonObject = new JSONObject(JsonString);
        //Prepare parameter data
        parameterModel parameterModel = new parameterModel();
        if (jsonObject.has("companyName")) {
            companyName = jsonObject.get("companyName").toString();
            parameterModel.setCompanyName(companyName);
        }
        if (jsonObject.has("companyAddress")) {
            companyAddress = jsonObject.get("companyAddress").toString();
            parameterModel.setCompanyAddress(companyAddress);
        }
        if (jsonObject.has("companyPhoneNumber")) {
            companyPhoneNumber = jsonObject.get("companyPhoneNumber").toString();
            parameterModel.setCompanyPhoneNumber(companyPhoneNumber);
        }
        if (jsonObject.has("donViNhanHang")) {
            donViNhanHang = jsonObject.get("donViNhanHang").toString();
            parameterModel.setDonViNhanHang(donViNhanHang);
        }
        final List<String> keyParamList = new ArrayList<String>(Arrays.asList("companyName","companyAddress","companyPhoneNumber","donViNhanHang"));
        System.out.println(keyParamList);
        for(int i = 0; i < keyParamList.size(); i++) {
            switch (keyParamList.get(i)) {
                case "companyCode":

                    break;
            }
        }

        //Create Json Array
        List<lineData> detailList = new ArrayList<lineData>();
        if(jsonObject.has("detail")) {
            JSONArray jsonArray = jsonObject.getJSONArray("detail");
            System.out.println(jsonArray);
            for (int i = 0; i < jsonArray.length(); i++) {
                Object object = jsonArray.get(i);
                System.out.println(object);
                JSONObject objectToEasyGet = new JSONObject(object.toString());
                System.out.println(objectToEasyGet);
                lineData lineData = new lineData();
                String stt, tenVatTu, maVatTu, dvt, soLuong, dvtQuyDoi, soLuongQuyDoi, soLo;

                if (objectToEasyGet.has("stt")) {
                    stt = objectToEasyGet.get("stt").toString();
                    lineData.setStt(stt);
                }
                if (objectToEasyGet.has("maVatTu")) {
                    maVatTu = objectToEasyGet.get("maVatTu").toString();
                    lineData.setMaVatTu(maVatTu);
                }
                if (objectToEasyGet.has("tenVatTu")) {
                    tenVatTu = objectToEasyGet.get("tenVatTu").toString();
                    lineData.setTenVatTu(tenVatTu);
                }
                if (objectToEasyGet.has("dvt")) {
                    dvt = objectToEasyGet.get("dvt").toString();
                    lineData.setDvt(dvt);
                }
                if (objectToEasyGet.has("soLuong")) {
                    soLuong = objectToEasyGet.get("soLuong").toString();
                    lineData.setSoLuong(soLuong);
                }
                if (objectToEasyGet.has("dvtQuyDoi")) {
                    dvtQuyDoi = objectToEasyGet.get("dvtQuyDoi").toString();
                    lineData.setDvtQuyDoi(dvtQuyDoi);
                }
                if (objectToEasyGet.has("soLuongQuyDoi")) {
                    soLuongQuyDoi = objectToEasyGet.get("soLuongQuyDoi").toString();
                    lineData.setSoLuongQuyDoi(soLuongQuyDoi);
                }
                if (objectToEasyGet.has("soLo")) {
                    soLo = objectToEasyGet.get("soLo").toString();
                    lineData.setSoLo(soLo);
                }
                detailList.add(lineData);
            }
        }
        exportPDF exportPDF = new exportPDF();
        String pdfBase64 = exportPDF.lxnhPDF(parameterModel, detailList);
        return pdfBase64;
    }
    @PostMapping(value = "/api-pdf-lxnh-json")
    public ResponseEntity<lxnhResponeEntity> restPdfBase64Json(@RequestBody String JsonString) throws JsonProcessingException {
        String companyName;
        String companyAddress;
        String companyPhoneNumber;
        String donViNhanHang;
        //convert String to Json Object
        JSONObject jsonObject = new JSONObject(JsonString);
        //Prepare parameter data
        parameterModel parameterModel = new parameterModel();
        if (jsonObject.has("companyName")) {
            companyName = jsonObject.get("companyName").toString();
            parameterModel.setCompanyName(companyName);
        }
        if (jsonObject.has("companyAddress")) {
            companyAddress = jsonObject.get("companyAddress").toString();
            parameterModel.setCompanyAddress(companyAddress);
        }
        if (jsonObject.has("companyPhoneNumber")) {
            companyPhoneNumber = jsonObject.get("companyPhoneNumber").toString();
            parameterModel.setCompanyPhoneNumber(companyPhoneNumber);
        }
        if (jsonObject.has("donViNhanHang")) {
            donViNhanHang = jsonObject.get("donViNhanHang").toString();
            parameterModel.setDonViNhanHang(donViNhanHang);
        }
        final List<String> keyParamList = new ArrayList<String>(Arrays.asList("companyName","companyAddress","companyPhoneNumber","donViNhanHang"));
        System.out.println(keyParamList);
        for(int i = 0; i < keyParamList.size(); i++) {
            switch (keyParamList.get(i)) {
                case "companyCode":

                    break;
            }
        }

        //Create Json Array
        List<lineData> detailList = new ArrayList<lineData>();
        if(jsonObject.has("detail")) {
            JSONArray jsonArray = jsonObject.getJSONArray("detail");
            System.out.println(jsonArray);
            for (int i = 0; i < jsonArray.length(); i++) {
                Object object = jsonArray.get(i);
                System.out.println(object);
                JSONObject objectToEasyGet = new JSONObject(object.toString());
                System.out.println(objectToEasyGet);
                lineData lineData = new lineData();
                String stt, tenVatTu, maVatTu, dvt, soLuong, dvtQuyDoi, soLuongQuyDoi, soLo;

                if (objectToEasyGet.has("stt")) {
                    stt = objectToEasyGet.get("stt").toString();
                    lineData.setStt(stt);
                }
                if (objectToEasyGet.has("maVatTu")) {
                    maVatTu = objectToEasyGet.get("maVatTu").toString();
                    lineData.setMaVatTu(maVatTu);
                }
                if (objectToEasyGet.has("tenVatTu")) {
                    tenVatTu = objectToEasyGet.get("tenVatTu").toString();
                    lineData.setTenVatTu(tenVatTu);
                }
                if (objectToEasyGet.has("dvt")) {
                    dvt = objectToEasyGet.get("dvt").toString();
                    lineData.setDvt(dvt);
                }
                if (objectToEasyGet.has("soLuong")) {
                    soLuong = objectToEasyGet.get("soLuong").toString();
                    lineData.setSoLuong(soLuong);
                }
                if (objectToEasyGet.has("dvtQuyDoi")) {
                    dvtQuyDoi = objectToEasyGet.get("dvtQuyDoi").toString();
                    lineData.setDvtQuyDoi(dvtQuyDoi);
                }
                if (objectToEasyGet.has("soLuongQuyDoi")) {
                    soLuongQuyDoi = objectToEasyGet.get("soLuongQuyDoi").toString();
                    lineData.setSoLuongQuyDoi(soLuongQuyDoi);
                }
                if (objectToEasyGet.has("soLo")) {
                    soLo = objectToEasyGet.get("soLo").toString();
                    lineData.setSoLo(soLo);
                }
                detailList.add(lineData);
            }
        }
        exportPDF exportPDF = new exportPDF();
        String pdfBase64 = exportPDF.lxnhPDF(parameterModel, detailList);
        lxnhResponeEntity lxnhResponeEntity = new lxnhResponeEntity(pdfBase64);
        ResponseEntity<lxnhResponeEntity> entity = new ResponseEntity<>(lxnhResponeEntity, HttpStatus.OK);
        return entity;
    }

    public void mappingToParameter(String key, parameterModel parameterModel) {

    }
}
