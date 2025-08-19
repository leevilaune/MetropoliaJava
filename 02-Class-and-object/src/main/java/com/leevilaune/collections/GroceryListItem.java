package com.leevilaune.collections;

import java.util.Objects;

public class GroceryListItem {

    private String itemName;
    private double cost;
    private String category;
    private int quantity;

    public GroceryListItem(String itemName){
        this.itemName = itemName;
    }

    public GroceryListItem(String itemName, double cost){
        this.itemName = itemName;
        this.cost = cost;
    }

    public GroceryListItem(String itemName, double cost, String category){
        this.itemName = itemName;
        this.cost = cost;
        this.category = category;
    }

    public GroceryListItem(String itemName, double cost, String category, int quantity){
        this.itemName = itemName;
        this.cost = cost;
        this.category = category;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroceryListItem that = (GroceryListItem) o;
        return Double.compare(cost, that.cost) == 0 && quantity == that.quantity && Objects.equals(itemName, that.itemName) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, cost, category, quantity);
    }

    @Override
    public String toString() {
        return "GroceryListItem{" +
                "itemName='" + itemName + '\'' +
                ", cost=" + cost +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
