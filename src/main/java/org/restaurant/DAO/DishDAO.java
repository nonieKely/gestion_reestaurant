package org.restaurant.DAO;

import org.restaurant.database.ConnectionDB;
import org.restaurant.models.Dish;
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
                    dish.setUnit_price(resultSet.getInt("unit_price"));
                    dish.setIngredients(new ArrayList<>());
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dish;
    }
}
