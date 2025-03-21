package org.restaurant.models;

import java.time.LocalDateTime;

public class DishOrder {
    private int id_dish_order;
    private int id_order;
    private Dish dish;
    private int quantity;
    private String status;
    private LocalDateTime dateTime;

    public DishOrder() {
    }

    public DishOrder(int id_dish_order, int id_order, Dish dish, int quantity, String status, LocalDateTime dateTime) {
        this.id_dish_order = id_dish_order;
        this.id_order = id_order;
        this.dish = dish;
        this.quantity = quantity;
        this.status = status;
        this.dateTime = dateTime;
    }

    public DishOrder(int id_dish_order, Dish dish, int quantity, String status, LocalDateTime dateTime) {
        this.id_dish_order = id_dish_order;
        this.dish = dish;
        this.quantity = quantity;
        this.status = status;
        this.dateTime = dateTime;
    }

    public int getId_dish_order() {
        return id_dish_order;
    }

    public void setId_dish_order(int id_dish_order) {
        this.id_dish_order = id_dish_order;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getActualStatus(){
        return this.getStatus();
    }
}
