package com.hemonth.bean;

public class CamelBean {
    public String map1(String input){
        return input.replaceAll(",","*");
    }
}
