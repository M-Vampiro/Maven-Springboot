package com.vtxlab.exercise;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    HashMap<Furniture, Integer> ordersOfFurnitures;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        this.ordersOfFurnitures = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        this.ordersOfFurnitures.put(type, furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return this.ordersOfFurnitures;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        float sum = 0;
        for (Map.Entry<Furniture, Integer> ordersOfFurnitures : ordersOfFurnitures.entrySet()) {
            sum += ordersOfFurnitures.getKey().cost() * ordersOfFurnitures.getValue();
        }
        return sum;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        return ordersOfFurnitures.getOrDefault(type, 0);
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        return type.cost() * getTypeCount(type);
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        int sum = 0;
        for (Map.Entry<Furniture, Integer> ordersOfFurnitures : ordersOfFurnitures.entrySet()) {
            sum += ordersOfFurnitures.getValue();
        }
        return sum;
    }
}