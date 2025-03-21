package org.restaurant.models;

import org.restaurant.DAO.IngredientHistoryDAO;
import org.restaurant.DAO.StockDAO;

import java.time.LocalDateTime;
import java.util.List;

public class Ingredient {
    private int id_ingredient;
    private String name;
    private double unit_price;
    private Unit unit;
    private LocalDateTime update_dateTime;

    public Ingredient(int id_ingredient, String name, double unit_price, Unit unit, LocalDateTime update_dateTime) {
        this.id_ingredient = id_ingredient;
        this.name = name;
        this.unit_price = unit_price;
        this.unit = unit;
        this.update_dateTime = update_dateTime;
    }

    public Ingredient() {

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

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public LocalDateTime getUpdate_dateTime() {
        return update_dateTime;
    }

    public void setUpdate_dateTime(LocalDateTime update_dateTime) {
        this.update_dateTime = update_dateTime;
    }






}
