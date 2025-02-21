package org.restaurant.DAO;

import org.restaurant.database.ConnectionDB;
import org.restaurant.models.Criterias;
import org.restaurant.models.Dish;
import org.restaurant.models.Ingredient;
import org.restaurant.models.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Ingredient> FilterIngredientsPerwhateverYouWant(List<Criterias> criteriasList, int pageSize, int pageNumber) {
        List<Ingredient> ingredients = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM ingredient WHERE 1=1");

        List<String> validColumns = List.of("id_ingredient", "name", "unit_price", "unit", "update_datetime");
        List<Object> param = new ArrayList<>();

        for (Criterias criteria : criteriasList) {
            if (validColumns.contains(criteria.getColumn())) {
                sql.append(" AND ").append(criteria.getColumn()).append(" LIKE ?");
                param.add("%" + criteria.getValue() + "%");
            }
        }

        for (Criterias criteria : criteriasList) {
            if (validColumns.contains(criteria.getColumn()) && criteria.getOrder() != null) {
                sql.append(" ORDER BY ").append(criteria.getColumn()).append(" ").append(criteria.getOrder());
                break;
            }
        }

        sql.append(" LIMIT ? OFFSET ?");
        param.add(pageSize);
        param.add((pageNumber - 1) * pageSize);

        try (Connection connection = ConnectionDB.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {

            for (int i = 0; i < param.size(); i++) {
                if (param.get(i) instanceof Integer) {
                    preparedStatement.setInt(i + 1, (Integer) param.get(i));
                } else {
                    preparedStatement.setString(i + 1, (String) param.get(i));
                }
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Ingredient ingredient = new Ingredient();
                    ingredient.setId_ingredient(resultSet.getInt("id_ingredient"));
                    ingredient.setName(resultSet.getString("name"));
                    ingredient.setUnit_price(resultSet.getInt("unit_price"));
                    ingredient.setUnit(Unit.valueOf(resultSet.getString("unit")));
                    ingredient.setUpdate_dateTime(resultSet.getTimestamp("update_datetime").toLocalDateTime());
                    ingredients.add(ingredient);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error filtering ingredients", e);
        }

        return ingredients;
    }
}
