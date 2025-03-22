import org.junit.jupiter.api.Test;
import org.restaurant.models.Order;
import org.restaurant.models.Dish;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestGetOrderDishes {

    @Test
    void testGetDishOrder_HotDog() {
        Order order = new Order();
        order.setId_order(1);

        List<Dish> dishes = order.getDishOrder();

        assertNotNull(dishes, "The dishes list should not be null");

        assertEquals(3, dishes.size(), "The number of dishes should be 1");


        for (Dish dish : dishes) {
            assertEquals(1, dish.getId_dish(), "The id_dish should be 1");
            assertEquals("Hot Dog", dish.getName(), "The dish name should be 'Hot Dog'");
            assertEquals(15000, dish.getUnit_price(), 0.01, "The unit price should be 15000");
        }
    }
}
