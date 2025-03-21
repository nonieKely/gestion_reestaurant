import org.junit.jupiter.api.Test;
import org.restaurant.DAO.DishOrderDAO;
import org.restaurant.models.Dish;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddDishOrder {

    @Test
    void testAddDishOrder_ShouldReturnSuccessMessage() {

        Dish dish = new Dish();
        dish.setId_dish(1);
        int quantity = 2;
        int id_order = 1;

        DishOrderDAO dishOrderDAO = new DishOrderDAO();

        String result = dishOrderDAO.addDishOrder(id_order, dish, quantity);

        assertEquals("Commande ajoutée avec succès", result, "La commande n'a pas été ajoutée correctement.");
    }
}
