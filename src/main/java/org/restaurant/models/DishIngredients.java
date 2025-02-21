package org.restaurant.models;

public class DishIngredients {
    private String id_Dish;
    private String id_ingredient;
    private int required_quantity;
    private Unit unit;

    public DishIngredients(String id_Dish, String id_ingredient, int required_quantity, Unit unit) {
        this.id_Dish = id_Dish;
        this.id_ingredient = id_ingredient;
        this.required_quantity = required_quantity;
        this.unit = unit;
    }

    public String getId_Dish() {
        return id_Dish;
    }

    public void setId_Dish(String id_Dish) {
        this.id_Dish = id_Dish;
    }

    public String getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(String id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public int getRequired_quantity() {
        return required_quantity;
    }

    public void setRequired_quantity(int required_quantity) {
        this.required_quantity = required_quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
