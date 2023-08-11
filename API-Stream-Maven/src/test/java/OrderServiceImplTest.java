import apiStream.mapping.dtos.OrderDto;
import apiStream.repository.impl.OrderRepositoryImpl;
import apiStream.services.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceImplTest {
    @Test
    void testOrderRecent(){
        OrderServiceImpl operation = new OrderServiceImpl();
        OrderRepositoryImpl orderRepo = new OrderRepositoryImpl();
        List<OrderDto> expected = new ArrayList<>();
        expected.add(orderRepo.getAllOrders().get(3));
        expected.add(orderRepo.getAllOrders().get(4));
        List<OrderDto> result = operation.getRecentOrder();
        assertEquals(expected.size(), result.size(),"ERROR PROCESSING");
    }
}
