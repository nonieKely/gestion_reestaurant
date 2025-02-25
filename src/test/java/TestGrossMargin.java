import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.restaurant.DAO.DishDAO;

import java.sql.SQLException;


public class TestGrossMargin {

    @Test
    void testGetGrossMargin_HotDog_ShouldReturn9500() {


        String dishName = "Hot Dog";
        double expectedMargin = 9500.00;


        DishDAO dishDAO = new DishDAO();


        double actualMargin = dishDAO.getGrossMargin(dishName);


        assertEquals(expectedMargin, actualMargin, "The gross margin should be 9500.00");
    }
}
