package com.leevilaune.currency.controller;

import com.leevilaune.currency.dao.CurrencyDao;
import com.leevilaune.currency.entity.Currency;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CurrencyController {

    private Map<String, Currency> currencies;
    private DecimalFormat decimalFormat;
    private CurrencyDao currencyDao;

    public CurrencyController(){
        this.currencies = new HashMap<>();
        this.decimalFormat = new DecimalFormat("####0.00");
        this.currencyDao = new CurrencyDao();

    }

    public double getConversion(String curr1,String curr2,double multiplier){
        if(this.currencyDao.find(curr1) == null || this.currencyDao.find(curr2)==null){
            return -1;
        }
        double rate1 = this.currencyDao.find(curr1).getToUSD();
        double rate2 = this.currencyDao.find(curr2).getToUSD();

        if(rate1 == -1 || rate2 == -1){
            return -1;
        }
        return Double.parseDouble(decimalFormat.format(multiplier*(rate2/rate1)));
    }

    public Set<String> getCurrencies(){
        if(this.currencyDao.findAll()==null){
            return null;
        }
        Set<String> currencies = this.currencyDao.findAll().stream().map(Currency::getCode).collect(Collectors.toSet());
        if(currencies.isEmpty()){
            return null;
        }
        return currencies;
    }

    public void addCurrency(String code, String name, double toUSD){
        this.currencyDao.persist(new Currency(code,name,toUSD));
    }
}
