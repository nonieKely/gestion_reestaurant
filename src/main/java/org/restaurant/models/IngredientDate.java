package org.restaurant.models;

import java.time.LocalDateTime;

public class IngredientDate {
    private int id_ingredient;
    private String name;
    private int price;
    private Unit unit;
    private LocalDateTime date;

    public IngredientDate(int id_ingredient, String name, int price, Unit unit) {
        this.id_ingredient = id_ingredient;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public IngredientDate(int id_ingredient, String name, int price, Unit unit, LocalDateTime date) {
        this.id_ingredient = id_ingredient;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.date = date;
    }

    public IngredientDate() {
    }

    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

