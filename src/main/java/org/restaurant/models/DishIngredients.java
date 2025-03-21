package org.restaurant.models;

import org.restaurant.DAO.StockDAO;

public class DishIngredients {
    private int id_Dish;
    private int id_ingredient;
    private double required_quantity;
    private Unit unit;

    public DishIngredients(int id_Dish, int id_ingredient, double required_quantity, Unit unit) {
        this.id_Dish = id_Dish;
        this.id_ingredient = id_ingredient;
        this.required_quantity = required_quantity;
        this.unit = unit;
    }

    public DishIngredients(int id_ingredient, double required_quantity) {
        this.id_ingredient = id_ingredient;
        this.required_quantity = required_quantity;
    }

    public DishIngredients() {
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

    public double getRequired_quantity() {
        return required_quantity;
    }

    public void setRequired_quantity(double required_quantity) {
        this.required_quantity = required_quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Double getAvalaibleQuantity(){
        return new StockDAO().getAvailableQuantity(id_ingredient).getFirst().getAvailable_stock();
    }
}
