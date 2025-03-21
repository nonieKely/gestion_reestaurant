package org.restaurant.models;

import org.restaurant.DAO.OrderDAO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id_order_status;
    private int id_order;
    private String status;
    private ArrayList<DishOrder> dishOrders = new ArrayList<>();
    private LocalDateTime dateTime;

    public Order(int id_order_status, int id_order, String status, ArrayList<DishOrder> dishOrders, LocalDateTime dateTime) {
        this.id_order_status = id_order_status;
        this.id_order = id_order;
        this.status = status;
        this.dishOrders = dishOrders;
        this.dateTime = dateTime;
    }

    public Order(int id_order_status, String status, ArrayList<DishOrder> dishOrders, LocalDateTime dateTime) {
        this.id_order_status = id_order_status;
        this.status = status;
        this.dishOrders = dishOrders;
        this.dateTime = dateTime;
    }

    public Order() {
    }

    public int getId_order_status() {
        return id_order_status;
    }

    public void setId_order_status(int id_order_status) {
        this.id_order_status = id_order_status;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<DishOrder> getDishOrders() {
        return dishOrders;
    }

    public void setDishOrders(ArrayList<DishOrder> dishOrders) {
        this.dishOrders = dishOrders;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getActualStatus(){
        return new OrderDAO().getActualStatus(id_order);
    }

    public List<Dish> getDishOrder(){
        return new OrderDAO().getAllDishes(id_order);
    }
}
