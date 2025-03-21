package org.restaurant.DAO;

import org.restaurant.database.ConnectionDB;
import org.restaurant.models.Dish;
import org.restaurant.models.Order;
import org.restaurant.models.DishOrder;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public Order getOrderById(int id_order) {
        Order order = null;
        String sql = "SELECT  * FROM order_status os WHERE os.id_order_status = ?";

        try (Connection connection = ConnectionDB.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id_order);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    order = new Order();
                    order.setId_order(resultSet.getInt("id_order"));
                    order.setStatus(resultSet.getString("status"));
                    order.setDateTime(resultSet.getTimestamp("datetime").toLocalDateTime());
                    order.setId_order_status(resultSet.getInt("id_order_status"));

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return order;
    }

    public String AddOrder() {
        String sql1 = "INSERT INTO one_order DEFAULT VALUES";
        String sql2 = "INSERT INTO order_status(id_order) VALUES(?)";

        try (Connection connection = ConnectionDB.connection()) {

            try (PreparedStatement preparedStatement1 = connection.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS)) {
                preparedStatement1.executeUpdate();

                try (ResultSet resultSet = preparedStatement1.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        int id_order = resultSet.getInt(1);

                        try (PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)) {
                            preparedStatement2.setInt(1, id_order);
                            preparedStatement2.executeUpdate();

                            return "Order created successfully";
                        }
                    } else {
                        return "Failed to create order - No ID generated";
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error creating order: " + e.getMessage(), e);
        }
    }


    public String getActualStatus(int id_order) {
        String sql = "SELECT status FROM order_status os WHERE os.id_order = ? ORDER BY os.datetime DESC LIMIT 1";
        String status = null;

        try (Connection connection = ConnectionDB.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id_order);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    status = resultSet.getString("status");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching the order status: " + e.getMessage(), e);
        }

        return status;
    }

    public List<Dish> getAllDishes(int id_order) {
        ArrayList<Dish> dishes = new ArrayList<>();
        String sql = "SELECT d.id_dish, d.name, d.unit_price, dor.quantity " +
                "FROM dish_order dor " +
                "JOIN dish d ON dor.id_dish = d.id_dish " +
                "WHERE dor.id_order = ?";

        try (Connection connection = ConnectionDB.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id_order);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    Dish dish = new Dish();
                    dish.setId_dish(resultSet.getInt("id_dish"));
                    dish.setName(resultSet.getString("name"));
                    dish.setUnit_price(resultSet.getDouble("unit_price"));

                    dishes.add(dish);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching dish orders: " + e.getMessage(), e);
        }

        return dishes;
    }

}
