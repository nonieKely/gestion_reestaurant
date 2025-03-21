import org.junit.jupiter.api.Test;
import org.restaurant.DAO.IngredientsDAO;
import org.restaurant.models.Criterias;
import org.restaurant.models.Ingredient;
import org.restaurant.models.Unit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class  TestFilterIngredientPerWhateverYouWant {

    @Test
    public void testFilterIngredientsByName() {
        IngredientsDAO ingredientsDAO = new IngredientsDAO();

        List<Criterias> criteriasList = new ArrayList<>();
        criteriasList.add(new Criterias("name", "Saucisse", "ASC"));

        int pageSize = 10;
        int pageNumber = 1;

        List<Ingredient> ingredients = ingredientsDAO.FilterIngredientsPerwhateverYouWant(criteriasList, pageSize, pageNumber);

        assertNotNull(ingredients);
        assertFalse(ingredients.isEmpty());
        assertEquals(1, ingredients.size());
        assertEquals("Saucisse", ingredients.get(0).getName());
        assertEquals(20.0, ingredients.get(0).getUnit_price(), 0.01);
        assertEquals(Unit.G, ingredients.get(0).getUnit());
    }

    @Test
    public void testFilterIngredientsByPriceAndDateRange() {
        IngredientsDAO ingredientsDAO = new IngredientsDAO();

        List<Criterias> criteriasList = new ArrayList<>();
        criteriasList.add(new Criterias("unit_price", "20000", null));
        criteriasList.add(new Criterias("update_datetime", "2024-01-01T00:00:00,2025-12-31T23:59:59", null));

        int pageSize = 10;
        int pageNumber = 1;

        List<Ingredient> ingredients = ingredientsDAO.FilterIngredientsPerwhateverYouWant(criteriasList, pageSize, pageNumber);

        assertNotNull(ingredients);
        assertFalse(ingredients.isEmpty());

        assertTrue(ingredients.stream().allMatch(ingredient ->
                ingredient.getUnit_price() >= 500.0 && ingredient.getUnit_price() <= 20000.0
        ));

        assertTrue(ingredients.stream().allMatch(ingredient ->
                ingredient.getUpdate_dateTime().isAfter(LocalDateTime.of(2024, 1, 1, 0, 0)) &&
                        ingredient.getUpdate_dateTime().isBefore(LocalDateTime.of(2025, 12, 31, 23, 59))
        ));
    }
}
