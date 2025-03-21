package org.restaurant.models;

import org.restaurant.DAO.IngredientHistoryDAO;

import java.time.LocalDateTime;
import java.util.List;

public class IngredientDate {
    private int id_history;
    private int id_ingredient;
    private String name;
    private double price;
    private Unit unit;
    private LocalDateTime date;

    public IngredientDate(int id_ingredient, String name, double price, Unit unit) {
        this.id_ingredient = id_ingredient;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public IngredientDate(int id_ingredient, String name, double price, Unit unit, LocalDateTime date) {
        this.id_ingredient = id_ingredient;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.date = date;
    }

    public IngredientDate(int id_history, int id_ingredient, String name, double price, Unit unit, LocalDateTime date) {
        this.id_history = id_history;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public int getId_history() {
        return id_history;
    }

    public void setId_history(int id_history) {
        this.id_history = id_history;
    }

    public List<IngredientDate> getMovement(){
        List<IngredientDate> movements = new IngredientHistoryDAO().getHistoryById(id_history);

        return movements;
    }
}
