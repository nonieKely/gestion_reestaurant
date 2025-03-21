package org.restaurant.DAO;

import org.restaurant.database.ConnectionDB;
import org.restaurant.models.Dish;
import org.restaurant.models.DishIngredients;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DishDAO {

    public Dish findById(int id) {
        Dish dish = null;
        String sql = "SELECT d.id_dish, d.name, d.unit_price FROM dish d WHERE d.id_dish = ?";

        try (Connection connection = ConnectionDB.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    dish = new Dish();
                    dish.setId_dish(resultSet.getInt("id_dish"));
                    dish.setName(resultSet.getString("name"));
                    dish.setUnit_price(resultSet.getFloat("unit_price"));
                    dish.setIngredients(new ArrayList<>());
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dish;
    }

    public double getGrossMargin(String dishName) {
        double result = 0;

        String sql1 = "SELECT SUM(i.unit_price * di.required_quantity) " +
                "FROM dish d " +
                "JOIN dish_ingredient di ON d.id_dish = di.id_dish " +
                "JOIN ingredient i ON di.id_ingredient = i.id_ingredient " +
                "WHERE d.name = ?;";

        String sql2 = "SELECT unit_price FROM dish WHERE name = ?;";

        try (Connection connection = ConnectionDB.connection();
             PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
             PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)) {

            preparedStatement1.setString(1, dishName);
            preparedStatement2.setString(1, dishName);

            try (ResultSet resultSet1 = preparedStatement1.executeQuery()) {
                if (resultSet1.next()) {
                    result = resultSet1.getDouble(1);
                }
            }

            try (ResultSet resultSet2 = preparedStatement2.executeQuery()) {
                if (resultSet2.next()) {
                    float salePrice = resultSet2.getFloat("unit_price");
                    result = salePrice - result;
                } else {
                    throw new SQLException("Dish not found in the database");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }

        return result;
    }

    public int getPossibleNumber(int id_dish) {
        Dish dish = new Dish();
        String sql = "SELECT * FROM dish_ingredient di WHERE di.id_dish = ?";

        try (Connection connection = ConnectionDB.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id_dish);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    DishIngredients dish_ingredient = new DishIngredients(
                            resultSet.getInt("id_ingredient"),
                            resultSet.getDouble("required_quantity")
                    );

                    dish.getIngredients().add(dish_ingredient);
                    dish.setId_dish(resultSet.getInt("id_dish"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dish.getAvailableDish();
    }

}
