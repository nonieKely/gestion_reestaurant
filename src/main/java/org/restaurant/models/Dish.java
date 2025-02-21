package org.restaurant.models;

import java.util.ArrayList;

public class Dish {
    private int id_dish;
    private String name;
    private int unit_price;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    public Dish(int id_dish, String name, int unit_price, ArrayList<Ingredient> ingredients) {
        this.id_dish = id_dish;
        this.name = name;
        this.unit_price = unit_price;
        this.ingredients = ingredients;
    }

    public Dish(int id_dish, String name, int unit_price) {
        this.id_dish = id_dish;
        this.name = name;
        this.unit_price = unit_price;
    }

    public int getId_dish() {
        return id_dish;
    }

    public void setId_dish(int id_dish) {
        this.id_dish = id_dish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
