package org.restaurant.models;

import java.time.LocalDateTime;

public class AvailableStock {

    private int id_ingredient;
    private double available_stock;
    private Unit unit;
    private LocalDateTime date_time;

    public AvailableStock() {
    }

    public AvailableStock(int id_ingredient, double available_stock, Unit unit, LocalDateTime date_time) {
        this.id_ingredient = id_ingredient;
        this.available_stock = available_stock;
        this.unit = unit;
        this.date_time = date_time;
    }

    public AvailableStock(int id_ingredient, double available_stock, Unit unit) {
        this.id_ingredient = id_ingredient;
        this.available_stock = available_stock;
        this.unit = unit;
    }

    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public double getAvailable_stock() {
        return available_stock;
    }

    public void setAvailable_stock(double available_stock) {
        this.available_stock = available_stock;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }
}
