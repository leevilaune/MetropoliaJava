package com.leevilaune.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.MissingFormatArgumentException;

public class GroceryListManager {

    private final ArrayList<String> groceryList;
    private final HashMap<String,Double> listWithCosts;
    private final ArrayList<GroceryListItem> groceryListItems;

    public GroceryListManager(){
        this.groceryList = new ArrayList<>();
        this.listWithCosts = new HashMap<>();
        this.groceryListItems = new ArrayList<>();
    }

    public static void main(String[] args) {
        GroceryListManager groceryListManager = new GroceryListManager();

        System.out.println("=== Testing ArrayList (groceryList) ===");
        groceryListManager.addItem("Apples");
        groceryListManager.addItem("Bread");
        groceryListManager.addItem("Milk");
        System.out.println("Raw groceryList contents: " + groceryListManager.groceryList);
        System.out.println("Display formatted list:\n" + groceryListManager.displayList());

        System.out.println("Is \"Bread\" on list? " + groceryListManager.isOnList("Bread"));
        groceryListManager.removeItem("Milk");
        System.out.println("After removing Milk: " + groceryListManager.groceryList);
        System.out.println();

        System.out.println("=== Testing HashMap (listWithCosts) ===");
        groceryListManager.addItem("Eggs", 3.20);     // adds to listWithCosts
        groceryListManager.addItem("Juice", 2.75);
        System.out.println("Raw HashMap contents: " + groceryListManager.listWithCosts);
        System.out.println("Calculated total cost (HashMap only): $" + groceryListManager.calculateTotalCost());
        System.out.println();

        System.out.println("=== Testing ArrayList (groceryListItems) ===");
        groceryListManager.addItem("Bananas", 1.20, "Fruits", 10);
        groceryListManager.addItem("Cheese", 3.50, "Dairy", 2);

        System.out.println("Display items by category 'Fruits':");
        System.out.println(groceryListManager.displayByCategory("Fruits"));

        System.out.println("Updating quantity of Bananas to 5...");
        groceryListManager.updateQuantity("Bananas", 5);
        System.out.println("Available items (quantity > 0):");
        System.out.println(groceryListManager.displayAvailableItems());
    }

    public void addItem(String item){
        if(this.groceryListItems.stream().anyMatch(g -> g.getItemName().equalsIgnoreCase(item))){
            return;
        }
        this.groceryListItems.add(new GroceryListItem(item));
        this.groceryList.add(item);
    }
    public void addItem(String item, double cost){
        if(this.groceryListItems.stream().anyMatch(g -> g.getItemName().equalsIgnoreCase(item))){
            return;
        }
        this.groceryListItems.add(new GroceryListItem(item,cost));
        this.listWithCosts.put(item,cost);
    }
    public void addItem(String item,double cost,String category){
        if(this.groceryListItems.stream().anyMatch(g -> g.getItemName().equalsIgnoreCase(item))){
            return;
        }
        this.groceryListItems.add(new GroceryListItem(item,cost,category));
    }
    public void addItem(String item,double cost,String category,int quantity){
        if(this.groceryListItems.stream().anyMatch(g -> g.getItemName().equalsIgnoreCase(item))){
            return;
        }
        this.groceryListItems.add(new GroceryListItem(item,cost,category,quantity));
    }
    public void removeItem(String item){
        this.groceryList.remove(item);
    }
    public double calculateTotalCost(){
        double totalCost = 0;
        for(double d : this.listWithCosts.values()){
            totalCost += d;
        }
        if(this.listWithCosts.isEmpty()){
            for(GroceryListItem g : this.groceryListItems){
                totalCost += g.getCost();
            }
        }
        return totalCost;
    }
    public void updateQuantity(String name, int quantity){
        this.groceryListItems.stream().filter(g->g.getItemName().equalsIgnoreCase(name)).findFirst().get().setQuantity(quantity);
    }
    public String displayByCategory(String category){
        StringBuilder byCategory = new StringBuilder();
        int i = 1;
        for(GroceryListItem g : this.groceryListItems){
            if(g.getCategory() == null){
                continue;
            }
            if(g.getCategory().equalsIgnoreCase(category)){
                byCategory.append(i).append(". ").append(g.getItemName()).append("\n");
                i++;
            }
        }
        return byCategory.toString();
    }
    public String displayList(){
        StringBuilder list = new StringBuilder();
        int i = 1;
        for(String s : this.groceryList){
            list.append(i).append(". ").append(s).append("\n");
            i++;
        }
        if(this.groceryList.isEmpty()){
            for(GroceryListItem g : this.groceryListItems){
                list.append(i).append(". ").append(g.getItemName()).append("\n");
                i++;
            }
        }
        return list.toString();
    }
    public String displayAvailableItems(){
        StringBuilder list = new StringBuilder();
        int i = 1;
        for(GroceryListItem g :groceryListItems){
            if(g.getQuantity()>0){
                list.append(i).append(". ").append(g.getItemName()).append("\n");
                i++;
            }
        }
        return list.toString();
    }
    public boolean isOnList(String item){
        return this.groceryList.contains(item);
    }
}
