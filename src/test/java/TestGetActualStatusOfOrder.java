import org.junit.jupiter.api.Test;
import org.restaurant.models.Order;

import static org.junit.jupiter.api.Assertions.*;

public class TestGetActualStatusOfOrder {

    @Test
    void testGetActualStatus_ShouldReturnLatestStatus() {

        Order order1 = new Order();
        order1.setId_order(1);

        String status1 = order1.getActualStatus();
        assertEquals("CONFIRMÉ", status1, "Le statut pour la commande 1 devrait être CONFIRMÉ.");

    }
}
