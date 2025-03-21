import org.junit.jupiter.api.Test;
import org.restaurant.models.Dish;

import static org.junit.jupiter.api.Assertions.*;

public class TestDish {

    @Test
    public void testFindById_ShouldReturnDish_WhenDishExists() {
        Dish dish = new Dish();
        dish.setId_dish(1);

        Dish foundDish = dish.findDishById();

        assertNotNull(foundDish, "Dish should not be null");
        assertEquals(1, foundDish.getId_dish(), "ID should match");
        assertEquals("Hot Dog", foundDish.getName(), "Name should match");
        assertEquals(15000, foundDish.getUnit_price(), 0.01, "Price should match");
    }

    @Test
    public void testFindById_ShouldReturnNull_WhenDishDoesNotExist() {
        Dish dish = new Dish();
        dish.setId_dish(9999);

        Dish foundDish = dish.findDishById();

        assertNull(foundDish, "Dish should be null for non-existing ID");
    }
}
