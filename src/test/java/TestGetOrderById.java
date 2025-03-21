import org.junit.jupiter.api.Test;
import org.restaurant.DAO.OrderDAO;
import org.restaurant.models.Order;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGetOrderById {

    @Test
    void testGetOrderById_ShouldReturnCorrectOrder() {
        int id_order = 1;
        String expectedStatus = "CONFIRMÉ";
        LocalDateTime expectedDateTime = LocalDateTime.of(2025, 2, 6, 14, 5);
        int expectedIdOrderStatus = 1;


        OrderDAO orderDAO = new OrderDAO();

        Order actualOrder = orderDAO.getOrderById(id_order);

        assertEquals(id_order, actualOrder.getId_order(), "The order ID should match.");
        assertEquals(expectedStatus, actualOrder.getStatus(), "The status should match.");
        assertEquals(expectedDateTime, actualOrder.getDateTime(), "The date time should match.");
        assertEquals(expectedIdOrderStatus, actualOrder.getId_order_status(), "The order status ID should match.");
    }
}
