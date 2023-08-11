package apiStream.repository;

import apiStream.mapping.dtos.OrderDto;

import java.util.List;

public interface OrderRepository {
    List<OrderDto> getAllOrders();
}
