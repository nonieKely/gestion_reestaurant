import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.restaurant.DAO.IngredientHistoryDAO;
import org.restaurant.models.IngredientDate;
import java.sql.Timestamp;
import org.restaurant.models.Unit;

import java.util.*;

public class TestIngredientHistoryDAO {

    @Test
    void testGetHistory_Saucisse_ShouldReturnExpectedHistory() {


        String ingredientName = "Saucisse";
        List<IngredientDate> expectedHistory = new ArrayList<>();


        IngredientDate expectedIngredientDate1 = new IngredientDate();
        expectedIngredientDate1.setId_ingredient(1);
        expectedIngredientDate1.setName("Saucisse");
        expectedIngredientDate1.setPrice(20);
        expectedIngredientDate1.setUnit(Unit.G);
        expectedIngredientDate1.setDate(Timestamp.valueOf("2025-02-21 18:23:17").toLocalDateTime().withNano(0));
        expectedHistory.add(expectedIngredientDate1);


        IngredientDate expectedIngredientDate2 = new IngredientDate();
        expectedIngredientDate2.setId_ingredient(1);
        expectedIngredientDate2.setName("Saucisse");
        expectedIngredientDate2.setPrice(18);
        expectedIngredientDate2.setUnit(Unit.G);
        expectedIngredientDate2.setDate(Timestamp.valueOf("2025-01-17 09:00:00").toLocalDateTime().withNano(0));
        expectedHistory.add(expectedIngredientDate2);


        IngredientHistoryDAO ingredientHistoryDAO = new IngredientHistoryDAO();
        List<IngredientDate> actualHistory = ingredientHistoryDAO.getHistory(ingredientName);

        assertNotNull(actualHistory, "The history list should not be null");
        assertFalse(actualHistory.isEmpty(), "The history list should not be empty");
        assertEquals(expectedHistory.size(), actualHistory.size(), "The number of records should match");

        for (int i = 0; i < expectedHistory.size(); i++) {
            IngredientDate expectedIngredientDate = expectedHistory.get(i);
            IngredientDate actualIngredientDate = actualHistory.get(i);

            assertEquals(expectedIngredientDate.getId_ingredient(), actualIngredientDate.getId_ingredient(), "The ID should match");
            assertEquals(expectedIngredientDate.getName(), actualIngredientDate.getName(), "The name should match");
            assertEquals(expectedIngredientDate.getPrice(), actualIngredientDate.getPrice(), "The price should match");
            assertEquals(expectedIngredientDate.getUnit(), actualIngredientDate.getUnit(), "The unit should match");


            assertEquals(expectedIngredientDate.getDate().withNano(0), actualIngredientDate.getDate().withNano(0), "The date should match");
        }
    }
}
