package org.restaurant.DAO;

import org.restaurant.database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientsDAO {

    public int getIngredientCost(String dishName) {
        int totalPrice = 0;
        String sql = "SELECT SUM(i.unit_price * di.required_quantity) AS total_ingredient_price " +
                "FROM dish d " +
                "JOIN dish_ingredient di ON d.id_dish = di.id_dish " +
                "JOIN ingredient i ON di.id_ingredient = i.id_ingredient " +
                "WHERE d.name = ?;";

        try (Connection connection = ConnectionDB.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, dishName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    totalPrice = resultSet.getInt("total_ingredient_price");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return totalPrice;
    }



}
