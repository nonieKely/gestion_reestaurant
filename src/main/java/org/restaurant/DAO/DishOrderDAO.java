package org.restaurant.DAO;

import org.restaurant.database.ConnectionDB;
import org.restaurant.models.Dish;
import org.restaurant.models.DishOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DishOrderDAO {
    public DishOrder getDishOrderbyId(int id){
        DishOrder dishOrder = null;
        String sql = "SELECT \n" +
                "    dio.id_dish_order,\n" +
                "    dio.id_dish,\n" +
                "    dio.quantity,\n" +
                "    dos.status,\n" +
                "    dos.datetime\n" +
                "FROM \n" +
                "    dish_order dio\n" +
                "JOIN \n" +
                "    dish_order_status dos ON dio.id_dish_order = dos.id_dish_order\n" +
                "WHERE \n" +
                "    dio.id_dish_order = ?\n" +
                "ORDER BY dos.datetime DESC\n" +
                "LIMIT 1;";

        try(Connection connection = ConnectionDB.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    dishOrder = new DishOrder();
                    Dish dish = new DishDAO().findById(resultSet.getInt("id_dish"));
                    dishOrder.setId_dish_order(resultSet.getInt("id_dish_order"));
                    dishOrder.setDish(dish);
                    dishOrder.setQuantity(resultSet.getInt("quantity"));
                    dishOrder.setStatus(resultSet.getString("status"));
                    dishOrder.setDateTime(resultSet.getTimestamp("datetime").toLocalDateTime());
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return dishOrder;
    }

    public String addDishOrder(Dish dish, int quantity) {
        String sql1 = "INSERT INTO one_order DEFAULT VALUES";
        String sql2 = "INSERT INTO dish_order(id_order, id_dish, quantity) VALUES(?, ?, ?)";

        try (Connection connection = ConnectionDB.connection()) {


            try (PreparedStatement preparedStatement1 = connection.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS)) {
                preparedStatement1.executeUpdate();

                ResultSet resultSet = preparedStatement1.getGeneratedKeys();
                if (resultSet.next()) {
                    int generatedIdOrder = resultSet.getInt(1);

                    try (PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)) {
                        preparedStatement2.setInt(1, generatedIdOrder);
                        preparedStatement2.setInt(2, dish.getId_dish());
                        preparedStatement2.setInt(3, quantity);

                        int rowsAffected = preparedStatement2.executeUpdate();
                        if (rowsAffected > 0) {
                            return "Commande ajoutée avec succès";
                        } else {
                            return "Erreur lors de l'ajout du plat à la commande";
                        }
                    }
                } else {
                    return "Erreur lors de la création de la commande";
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout de la commande: " + e.getMessage(), e);
        }
    }

}
