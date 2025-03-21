import org.junit.jupiter.api.Test;
import org.restaurant.models.DishIngredients;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGetAvailableQuantity {

    @Test
    void testGetAvailableQuantity_ShouldReturnSpecificAvailableStockForIngredient() {
        int id_ingredient = 3;

        DishIngredients dishIngredient = new DishIngredients(id_ingredient, 0);  // On met required_quantity à 0 car on ne l'utilise pas ici

        Double actual = dishIngredient.getAvalaibleQuantity();
        Double expected = 80.0;

        assertEquals(expected, actual, 0.01, "The available quantity should be 80");
    }
}
