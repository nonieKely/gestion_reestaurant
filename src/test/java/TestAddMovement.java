import org.junit.jupiter.api.Test;
import org.restaurant.DAO.IngredientHistoryDAO;
import org.restaurant.models.IngredientDate;
import org.restaurant.models.Unit;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddMovement {

    @Test
    void testAddMovement_ShouldInsertIngredientSuccessfully() {
        IngredientDate ingredient = new IngredientDate(3, "Oeuf", 2.5, Unit.U);
        IngredientHistoryDAO ingredientDAO = new IngredientHistoryDAO();


        assertDoesNotThrow(() -> ingredientDAO.addMovement(ingredient));


    }
}

