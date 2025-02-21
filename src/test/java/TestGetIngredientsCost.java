import org.junit.jupiter.api.Test;
import org.restaurant.DAO.IngredientsDAO;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestGetIngredientsCost {


        @Test
        void testGetIngredientCost_Hotdog_ShouldReturn5500() {

            String dishName = "Hot Dog";
            int expectedCost = 5500;

            IngredientsDAO ingredientsDAO = new IngredientsDAO();
            int actualCost = ingredientsDAO.getIngredientCost(dishName);

            assertEquals(expectedCost, actualCost, "The total cost should be 5500");
        }
    }


