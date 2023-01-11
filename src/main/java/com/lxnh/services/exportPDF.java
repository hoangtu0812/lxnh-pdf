package com.lxnh.services;

import com.lowagie.text.pdf.PdfName;
import com.lxnh.entity.lineData;
import com.lxnh.entity.parameterModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class exportPDF {
    public String lxnhPDF(String companyName) {
        try {
            //Prepare details data for testing
            List<lineData> list = new ArrayList<lineData>();
            list.add(new lineData("1", "123", "Sat", "KG", "1", "TAN", "1", "123"));
            list.add(new lineData("2", "124", "Thep", "KG", "1", "TAN", "1", "123"));
            //create datasource for details
            JRBeanCollectionDataSource itemJRBean = new JRBeanCollectionDataSource(list);
            //Mapping data to template
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("CollectionBeanParam", itemJRBean);
            parameters.put("companyName", companyName);
            //Template path
            InputStream inputStream = new FileInputStream("C:\\Users\\tu.pham\\Desktop\\spring-pdf-rest\\src\\main\\resources\\lxnh_3.jrxml");
            //Load template
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            //compile template
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            //Fill data to template
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            //Export to pdf file
            JasperExportManager.exportReportToPdfFile(print, "test1.pdf");
            //Export to base64 String
            byte[] pdfAsByte = JasperExportManager.exportReportToPdf(print);
            String base64Encoded = Base64.getEncoder().encodeToString(pdfAsByte);
            return base64Encoded;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
            System.out.println("Error while Export PDF!");
            return "Fail to export pdf!";
        }
    }
    public String lxnhPDF(parameterModel parameterModel, List<lineData> listLineData) {
        try {
            //Prepare details data for testing
            List<lineData> list = new ArrayList<lineData>();
            list.add(new lineData("1", "123", "Sat", "KG", "1", "TAN", "1", "123"));
            list.add(new lineData("2", "124", "Thep", "KG", "1", "TAN", "1", "123"));
            //create datasource for details
            System.out.println(listLineData);
            JRBeanCollectionDataSource itemJRBean = new JRBeanCollectionDataSource(listLineData);
            //Mapping data to template
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("CollectionBeanParam", itemJRBean);
            parameters.put("companyName", parameterModel.getCompanyName());
            parameters.put("companyAddress", parameterModel.getCompanyAddress());
            parameters.put("companyPhoneNumber", parameterModel.getCompanyPhoneNumber());
            parameters.put("donViNhanHang", parameterModel.getDonViNhanHang());
            //Template path
            InputStream inputStream = new FileInputStream("C:\\Users\\tu.pham\\Desktop\\spring-pdf-rest\\src\\main\\resources\\lxnh_3.jrxml");
            //Load template
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            //compile template
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            //Fill data to template
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            //Export to pdf file
            JasperExportManager.exportReportToPdfFile(print, "test1.pdf");
            //Export to base64 String
            byte[] pdfAsByte = JasperExportManager.exportReportToPdf(print);
            String base64Encoded = Base64.getEncoder().encodeToString(pdfAsByte);
            return base64Encoded;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
            System.out.println("Error while Export PDF!");
            return "Fail to export pdf!";
        }
    }
}
