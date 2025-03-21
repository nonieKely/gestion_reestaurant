import org.junit.jupiter.api.Test;
import org.restaurant.models.Dish;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGetIngredientsCost {

    @Test
    void testGetIngredientCost_Hotdog_ShouldReturn5500() {
        Dish dish = new Dish();
        dish.setId_dish(1);

        double actualCost = dish.getIngredientCost();
        double expectedCost = 5500.0;

        assertEquals(expectedCost, actualCost, 0.01, "The total cost should be 5500");
    }
}
