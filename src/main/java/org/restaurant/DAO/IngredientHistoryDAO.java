package org.restaurant.DAO;

import org.restaurant.database.ConnectionDB;
import org.restaurant.models.IngredientDate;
import org.restaurant.models.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientHistoryDAO {

    public List<IngredientDate> getHistoryById(int id_history) {
        List<IngredientDate> listOfHistory = new ArrayList<>();
        String sql = "SELECT * FROM ingredientdate WHERE ingredientdate.id_history = ?";

        try (Connection connection = ConnectionDB.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id_history);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    IngredientDate history = new IngredientDate();
                    history.setId_ingredient(resultSet.getInt("id_ingredient"));
                    history.setName(resultSet.getString("name"));
                    history.setPrice(resultSet.getDouble("price"));
                    history.setUnit(Unit.valueOf(resultSet.getString("unit")));
                    history.setDate(resultSet.getTimestamp("date_time").toLocalDateTime());


                    history.setId_history(123);

                    listOfHistory.add(history);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listOfHistory;
    }

    public void addMovement(IngredientDate parameter) {
        String sql = "INSERT INTO ingredientdate (id_ingredient, name, price, unit) VALUES (? , ? , ? , ?::unit)";

        try (Connection connection = ConnectionDB.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, parameter.getId_ingredient());
            preparedStatement.setString(2, parameter.getName());
            preparedStatement.setDouble(3, parameter.getPrice());
            preparedStatement.setString(4, parameter.getUnit().name());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
