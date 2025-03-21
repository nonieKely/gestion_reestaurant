package org.restaurant.DAO;

import org.restaurant.database.ConnectionDB;
import org.restaurant.models.AvailableStock;
import org.restaurant.models.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockDAO {

    public List<String> getMovement(int id) {
        List<String> movements = new ArrayList<>();
        String sql = "SELECT movement FROM stock WHERE id_ingredient = ?";

        try (Connection connection = ConnectionDB.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    movements.add(resultSet.getString("movement"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return movements;
    }
    public List<AvailableStock> getAvailableQuantity(int id_ingredient) {
        String sql = "SELECT " +
                "    s.id_ingredient, " +
                "    i.unit, " +
                "    SUM(CASE WHEN s.movement = 'entrée' THEN s.used_quantity ELSE 0 END) - " +
                "    SUM(CASE WHEN s.movement = 'sortie' THEN s.used_quantity ELSE 0 END) AS stock_final, " +
                "    CURRENT_TIMESTAMP AS date_time " +
                "FROM stock s " +
                "JOIN ingredient i ON s.id_ingredient = i.id_ingredient " +
                "WHERE s.id_ingredient = ? " +
                "GROUP BY s.id_ingredient, i.unit;";

        List<AvailableStock> stocks = new ArrayList<>();

        try (Connection connection = ConnectionDB.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id_ingredient);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    AvailableStock stock = new AvailableStock();
                    stock.setId_ingredient(resultSet.getInt("id_ingredient"));
                    stock.setUnit(Unit.valueOf(resultSet.getString("unit")));
                    stock.setAvailable_stock(resultSet.getDouble("stock_final"));
                    stock.setDate_time(resultSet.getTimestamp("date_time").toLocalDateTime());
                    stocks.add(stock);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stocks;
    }

}


