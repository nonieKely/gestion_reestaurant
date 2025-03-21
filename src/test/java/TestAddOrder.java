import org.junit.jupiter.api.Test;
import org.restaurant.DAO.OrderDAO;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddOrder {

    @Test
    void testAddOrder_ShouldReturnSuccessMessage() {
        OrderDAO orderDAO = new OrderDAO();

        String result = orderDAO.AddOrder();

        assertEquals("Order created successfully", result, "The order was not created successfully.");
    }
}

