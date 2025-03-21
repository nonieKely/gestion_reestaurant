package org.restaurant.models;

import org.restaurant.DAO.DishDAO;
import org.restaurant.DAO.IngredientsDAO;

import java.util.ArrayList;
import java.util.Collections;

public class Dish {
    private int id_dish;
    private String name;
    private double unit_price;
    private ArrayList<DishIngredients> ingredients = new ArrayList<>();

    public Dish(int id_dish, String name, double unit_price, ArrayList<DishIngredients> ingredients) {
        this.id_dish = id_dish;
        this.name = name;
        this.unit_price = unit_price;
        this.ingredients = ingredients;
    }

    public Dish(int id_dish, String name, double unit_price) {
        this.id_dish = id_dish;
        this.name = name;
        this.unit_price = unit_price;
    }

    public Dish() {

    }

    public Dish(int id_dish, ArrayList<DishIngredients> ingredients) {
        this.id_dish = id_dish;
        this.ingredients = ingredients;
    }

    public int getId_dish() {
        return id_dish;
    }

    public void setId_dish(int id_dish) {
        this.id_dish = id_dish;
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

    public ArrayList<DishIngredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<DishIngredients> ingredients) {
        this.ingredients = ingredients;
    }

    public double getIngredientCost(){
        double ingredientsDAO = new IngredientsDAO().getIngredientCost(id_dish);

        return ingredientsDAO;
    }

    public Dish findDishById(){
        Dish DishDAO = new DishDAO().findById(id_dish);

        return DishDAO;
    }

    public int getAvailableDish(){
        ArrayList<Integer> possibilities = new ArrayList<>();
        for (DishIngredients ingredient : ingredients){
            Double quantity = ingredient.getAvalaibleQuantity();
            Double requiredQuantity = ingredient.getRequired_quantity();

            int possibleDish = (int) Math.floor(quantity/requiredQuantity);
            possibilities.add(possibleDish);
        }
        return Collections.min(possibilities);
    }

}
