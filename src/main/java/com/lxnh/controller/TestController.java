package com.lxnh.controller;

import com.lxnh.entity.dataModel;
import com.lxnh.entity.lineData;
import com.lxnh.services.testService;
import jakarta.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
//import java.net.http.HttpRequest;
import java.util.*;


@RestController
public class TestController {
    @GetMapping(value = "/test")
    public String test() {
        System.out.println("test");
        return "index";
    }

    @GetMapping(value = "/api")
    public String api() {
        return "api";
    }

    @GetMapping(value = "/pdf")
    public String pdf() {
        try {
            String outputFile = "C:\\Users\\tu.pham\\Desktop\\spring-pdf-rest\\" + "test.pdf";
            List<lineData> list = new ArrayList<lineData>();
            list.add(new lineData("1", "123", "Sat", "KG", "1", "TAN", "1", "123"));
            list.add(new lineData("2", "124", "Thep", "KG", "1", "TAN", "1", "123"));
            JRBeanCollectionDataSource itemJRBean = new JRBeanCollectionDataSource(list);
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("CollectionBeanParam", itemJRBean);
            parameters.put("companyName", "Citek");
            InputStream inputStream = new FileInputStream(new File("C:\\Users\\tu.pham\\Desktop\\spring-pdf-rest\\src\\main\\resources\\lxnh_3.jrxml"));
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(print, "test1.pdf");
            return "ok";
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
            return "fail";
        }
    }
    @PostMapping(value = "/post")
    public String postTest(@RequestBody String string) {
        JSONObject jsonObject = new JSONObject(string);
        JSONArray jsonArray = jsonObject.getJSONArray("detail");
        System.out.println(jsonObject.toString());
        System.out.println(jsonArray.toString());
        String companyName = jsonObject.get("companyName").toString();

        return  companyName;
    }
}
