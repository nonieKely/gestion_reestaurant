import org.junit.jupiter.api.Test;
import org.restaurant.models.Dish;
import org.restaurant.models.Order;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TestGetDishOrder {

    @Test
    public void testGetAllDishes() {
        Order order = new Order();
        order.setId_order(1);

        List<Dish> dishes = order.getDishOrder();

        assertNotNull(dishes);
        assertFalse(dishes.isEmpty());
        Dish dish = dishes.get(0);
        assertEquals(1, dish.getId_dish());
        assertEquals("Hot Dog", dish.getName());
        assertEquals(15000, dish.getUnit_price(), 0.01);
    }
}
