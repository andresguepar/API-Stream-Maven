package apiStream.services;

import apiStream.domain.enums.OrderType;
import apiStream.domain.models.Customer;
import apiStream.domain.models.Product;
import apiStream.mapping.dtos.OrderDto;

import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;

public interface OrderService {

    HashMap<Customer, List<OrderDto>> getMapOrder();
    OptionalDouble getAverageOrder();
    double getTotalPriceOrder();
    List<OrderDto>  getRecentOrder();
    List<Product> getListOrderByDate();

    List<OrderDto> getAllOrders(OrderType status);
}
