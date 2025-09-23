package com.leevilaune.currency.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    @Column(name = "rate_to_usd")
    private double toUSD;

    public Currency(String code,String name, double toUSD){
        this.code = code;
        this.name = name;
        this.toUSD = toUSD;
    }

    public Currency(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
