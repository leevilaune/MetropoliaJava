package com.leevilaune.shoppingcart;

import java.util.HashMap;

public class ShoppingCart {

    private HashMap<String, Double> cart;

    public ShoppingCart(){
        this.cart = new HashMap<>();
    }

    public void addItem(String name, double cost){
        if(name == null || name.isEmpty() || cost < 0){
            return;
        }
        this.cart.put(name,cost);
    }
    public void removeItem(String name){
        this.cart.remove(name);
    }

    public int getItemCount(){
        return this.cart.size();
    }
    public double calculateTotal(){
        double[] sum = new double[1];
        this.cart.values().forEach(i -> sum[0]+=i);
        return sum[0];
    }
}
