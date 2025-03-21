import org.junit.jupiter.api.Test;
import org.restaurant.DAO.DishDAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGetAvailableDish {

    @Test
    void testGetPossibleNumber_HotDog() {
        int id_dish = 1;

        int actual = new DishDAO().getPossibleNumber(id_dish);

        int expected = 30;
        assertEquals(expected, actual, "The number of possible dishes should match the expected value");
    }
}
