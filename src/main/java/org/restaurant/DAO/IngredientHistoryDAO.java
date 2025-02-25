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

    public List<IngredientDate> getHistory(String ingredientName){
        List<IngredientDate> listOfupdates = new ArrayList<>();
        String sql = "SELECT * FROM ingredientdate WHERE ingredientdate.name = ?";

        try(Connection connection = ConnectionDB.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, ingredientName);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    IngredientDate history = new IngredientDate();
                    history.setId_ingredient(resultSet.getInt("id_ingredient"));
                    history.setName(resultSet.getString("name"));
                    history.setPrice(resultSet.getInt("price"));
                    history.setUnit(Unit.valueOf(resultSet.getString("unit")));
                    history.setDate(resultSet.getTimestamp("date_time").toLocalDateTime());
                    listOfupdates.add(history);
                }
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return listOfupdates;
    }


}
