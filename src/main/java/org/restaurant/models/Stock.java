package org.restaurant.models;

import java.time.LocalDateTime;

public class Stock {
    private int id_movement;
    private int id_ingredient;
    private Movement movement;
    private float usedQuantity;
    private Unit unit;
    private LocalDateTime dateTime;

    public Stock(Movement movement) {
        this.movement = movement;
    }

    public Stock() {
    }

    public Stock(int id_movement, int id_ingredient, Movement movement, float usedQuantity, Unit unit, LocalDateTime dateTime) {
        this.id_movement = id_movement;
        this.id_ingredient = id_ingredient;
        this.movement = movement;
        this.usedQuantity = usedQuantity;
        this.unit = unit;
        this.dateTime = dateTime;
    }

    public int getId_movement() {
        return id_movement;
    }

    public void setId_movement(int id_movement) {
        this.id_movement = id_movement;
    }

    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public float getUsedQuantity() {
        return usedQuantity;
    }

    public void setUsedQuantity(float usedQuantity) {
        this.usedQuantity = usedQuantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
