package com.leevilaune.currency.model;

public class Currency {
    private String code;
    private String name;
    private double toUSD;

    public Currency(String code,String name, double toUSD){
        this.code = code;
        this.name = name;
        this.toUSD = toUSD;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getToUSD() {
        return toUSD;
    }

    public void setToUSD(double toUSD) {
        this.toUSD = toUSD;
    }
}
