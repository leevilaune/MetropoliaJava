package com.leevilaune.collections;

import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

public class GroceryListManager {

    private ArrayList<String> groceryList;

    public GroceryListManager(){
        this.groceryList = new ArrayList<>();
    }

    public static void main(String[] args){
        GroceryListManager groceryListManager = new GroceryListManager();
        groceryListManager.addItem("Apples");
        groceryListManager.addItem("Milk");
        groceryListManager.addItem("Bread");
        System.out.println("Grocery List");
        System.out.println(groceryListManager.displayList());

        System.out.println("Is \"Milk\" in the grocery list? " + groceryListManager.isOnList("Milk"));
        System.out.println("\nRemoving \"Milk\" from the list...");
        groceryListManager.removeItem("Milk");
        System.out.println("\nUpdated grocery list");
        System.out.println(groceryListManager.displayList());
    }

    public void addItem(String item){
        this.groceryList.add(item);
    }
    public void removeItem(String item){
        this.groceryList.remove(item);
    }
    public String displayList(){
        StringBuilder list = new StringBuilder();
        int i = 1;
        for(String s : this.groceryList){
            list.append(i).append(". ").append(s).append("\n");
            i++;
        }
        return list.toString();
    }
    public boolean isOnList(String item){
        return this.groceryList.contains(item);
    }
}
