import org.junit.jupiter.api.Test;
import org.restaurant.DAO.DishDAO;
import org.restaurant.models.Dish;

import static org.junit.jupiter.api.Assertions.*;

public class TestDish {

    @Test
    public void testFindById_ShouldReturnDish_WhenDishExists() {
        DishDAO dishDAO = new DishDAO();
        int dishId = 1;

        Dish dish = dishDAO.findById(dishId);

        assertNotNull(dish);
        assertEquals(dishId, dish.getId_dish());
        assertEquals("Hot Dog", dish.getName());
        assertEquals(15000, dish.getUnit_price());
    }

    @Test
    public void testFindById_ShouldReturnNull_WhenDishDoesNotExist() {
        DishDAO dishDAO = new DishDAO();
        int nonExistingDishId = 9999;

        Dish dish = dishDAO.findById(nonExistingDishId);

        assertNull(dish);
    }
}
