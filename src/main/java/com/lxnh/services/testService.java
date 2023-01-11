package com.lxnh.services;

import com.lxnh.entity.dataModel;
import com.lxnh.entity.lineData;

import java.util.Arrays;
import java.util.List;

public class testService {
    public List<lineData> lineDataGen(){
        return Arrays.asList( new lineData("1", "123", "Test", "KG" , "6" , "KG", "10", "1010"),
        new lineData("1", "123", "Test", "KG" , "6" , "KG", "10", "1010")
        ,new lineData("1", "123", "Test", "KG" , "6" , "KG", "10", "1010")
        ,new lineData("1", "123", "Test", "KG" , "6" , "KG", "10", "1010"));
    }
    public dataModel dataModelGen() {
        return new dataModel( "Citek", "2 Hong Ha" ,"0914989487", "Hoang Tu");
    }

}
