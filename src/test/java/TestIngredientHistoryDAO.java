import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.restaurant.models.IngredientDate;
import org.restaurant.models.Unit;

import java.sql.Timestamp;
import java.util.*;

public class TestIngredientHistoryDAO {

    @Test
    void testGetHistory_Oeuf_ShouldReturnExpectedHistory() {
        int idHistory = 3;
        IngredientDate ingredientDate = new IngredientDate();
        ingredientDate.setId_history(idHistory);

        List<IngredientDate> expectedHistory = new ArrayList<>();

        IngredientDate expectedIngredientDate = new IngredientDate();
        expectedIngredientDate.setId_ingredient(3);
        expectedIngredientDate.setName("Oeuf");
        expectedIngredientDate.setPrice(1000.000);
        expectedIngredientDate.setUnit(Unit.U);
        expectedIngredientDate.setDate(Timestamp.valueOf("2025-02-28 21:23:41.599144").toLocalDateTime().withNano(0));

        expectedHistory.add(expectedIngredientDate);

        List<IngredientDate> actualHistory = ingredientDate.getMovement();

        assertNotNull(actualHistory, "The history list should not be null");
        assertFalse(actualHistory.isEmpty(), "The history list should not be empty");
        assertEquals(expectedHistory.size(), actualHistory.size(), "The number of records should match");

        IngredientDate actualIngredientDate = actualHistory.get(0);
        assertEquals(expectedIngredientDate.getId_ingredient(), actualIngredientDate.getId_ingredient(), "The ID should match");
        assertEquals(expectedIngredientDate.getName(), actualIngredientDate.getName(), "The name should match");
        assertEquals(expectedIngredientDate.getPrice(), actualIngredientDate.getPrice(), "The price should match");
        assertEquals(expectedIngredientDate.getUnit(), actualIngredientDate.getUnit(), "The unit should match");
        assertEquals(expectedIngredientDate.getDate().withNano(0), actualIngredientDate.getDate().withNano(0), "The date should match");
    }
}
