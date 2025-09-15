package com.leevilaune.currency.controller;

import com.leevilaune.currency.model.Currency;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CurrencyController {

    private Map<String, Currency> currencies;
    private DecimalFormat decimalFormat;

    public CurrencyController(){
        this.currencies = new HashMap<>();
        this.setRates();
        this.decimalFormat = new DecimalFormat("####0.00");

    }

    public double getConversion(String curr1,String curr2){

        return Double.parseDouble(decimalFormat.format(currencies.get(curr2).getToUSD()/currencies.get(curr1).getToUSD()));
    }

    public Set<String> getCurrencies(){
        return this.currencies.keySet();
    }

    private void setRates(){
        currencies.put("USD", new Currency("USD", "United States Dollar", 1.0));
        currencies.put("EUR", new Currency("EUR", "Euro", 0.8515200899));
        currencies.put("GBP", new Currency("GBP", "British Pound Sterling", 0.7357800845));
        currencies.put("JPY", new Currency("JPY", "Japanese Yen", 147.4063972024));
        currencies.put("CNY", new Currency("CNY", "Chinese Yuan Renminbi", 7.1235407404));
        currencies.put("CHF", new Currency("CHF", "Swiss Franc", 0.7958601138));
        currencies.put("CAD", new Currency("CAD", "Canadian Dollar", 1.3830001467));
        currencies.put("AUD", new Currency("AUD", "Australian Dollar", 1.5010102343));
        currencies.put("NZD", new Currency("NZD", "New Zealand Dollar", 1.6771501893));
        currencies.put("SGD", new Currency("SGD", "Singapore Dollar", 1.2815301285));
        currencies.put("HKD", new Currency("HKD", "Hong Kong Dollar", 7.7783111511));
        currencies.put("INR", new Currency("INR", "Indian Rupee", 88.1605639443));
        currencies.put("BRL", new Currency("BRL", "Brazilian Real", 5.3386706255));
        currencies.put("RUB", new Currency("RUB", "Russian Ruble", 83.1874093011));
        currencies.put("DKK", new Currency("DKK", "Danish Krone", 6.3577710368));
        currencies.put("NOK", new Currency("NOK", "Norwegian Krone", 9.8348217829));
        currencies.put("SEK", new Currency("SEK", "Swedish Krona", 9.3068211648));
        currencies.put("CZK", new Currency("CZK", "Czech Koruna", 20.7068638092));
        currencies.put("PLN", new Currency("PLN", "Polish Zloty", 3.6166705714));
        currencies.put("HUF", new Currency("HUF", "Hungarian Forint", 332.1580889305));
        currencies.put("RON", new Currency("RON", "Romanian Leu", 4.3141107291));
        currencies.put("BGN", new Currency("BGN", "Bulgarian Lev", 1.661050307));
        currencies.put("HRK", new Currency("HRK", "Croatian Kuna", 6.228751199));
        currencies.put("RSD", new Currency("RSD", "Serbian Dinar", 99.2142029888));
        currencies.put("ISK", new Currency("ISK", "Icelandic Krona", 121.6297663303));
        currencies.put("UAH", new Currency("UAH", "Ukrainian Hryvnia", 41.3648050354));
        currencies.put("TRY", new Currency("TRY", "Turkish Lira", 41.3467072603));
        currencies.put("GEL", new Currency("GEL", "Georgian Lari", 2.6939705335));
        currencies.put("AMD", new Currency("AMD", "Armenian Dram", 381.702665681));
        currencies.put("AZN", new Currency("AZN", "Azerbaijani Manat", 1.7));
    }
}
