package org.restaurant.models;

import java.math.BigDecimal;

public class DishIngredients {
    private int id_Dish;
    private int id_ingredient;
    private BigDecimal required_quantity;
    private Unit unit;

    public DishIngredients(int id_Dish, int id_ingredient, BigDecimal required_quantity, Unit unit) {
        this.id_Dish = id_Dish;
        this.id_ingredient = id_ingredient;
        this.required_quantity = required_quantity;
        this.unit = unit;
    }

    public int getId_Dish() {
        return id_Dish;
    }

    public void setId_Dish(int id_Dish) {
        this.id_Dish = id_Dish;
    }

    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public BigDecimal getRequired_quantity() {
        return required_quantity;
    }

    public void setRequired_quantity(BigDecimal required_quantity) {
        this.required_quantity = required_quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
