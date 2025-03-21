import org.junit.jupiter.api.Test;
import org.restaurant.DAO.DishOrderDAO;
import org.restaurant.models.DishOrder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDishOrder {
    @Test
    void testGetDishOrderbyId_ShouldReturnCorrectDishOrder() {
        int id_dish_order = 1;
        int id_dish = 1;
        int quantity = 2;
        String status = "SERVI";
        LocalDateTime datetime = LocalDateTime.of(2025, 2, 6, 14, 30);

        DishOrderDAO dishOrderDAO = new DishOrderDAO();

        DishOrder actualDishOrder = dishOrderDAO.getDishOrderbyId(id_dish_order);

        assertEquals(id_dish_order, actualDishOrder.getId_dish_order(), "The dish_order ID should match.");
        assertEquals(id_dish, actualDishOrder.getDish().getId_dish(), "The dish ID should match.");
        assertEquals(quantity, actualDishOrder.getQuantity(), "The quantity should match.");
        assertEquals(status, actualDishOrder.getStatus(), "The status should match.");
        assertEquals(datetime, actualDishOrder.getDateTime(), "The date time should match.");
    }
}
