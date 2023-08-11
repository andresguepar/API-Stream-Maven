package apiStream.mapping.mapper;

import apiStream.domain.models.Order;
import apiStream.mapping.dtos.OrderDto;

import java.util.List;

public class OrderMapper {
        public static OrderDto mapFrom(Order source){
            return new OrderDto(source.getOrderId(),
                    source.getStatus(),
                    source.getOrderDate(),
                    source.getDeliveryDate(),
                    source.getProducts(),
                    source.getCustomer());
        }

        public static Order mapFrom(OrderDto source){
            return new Order(source.id(),
                    source.status(),
                    source.orderDate(),
                    source.deliveryDate(),
                    source.products(),
                    source.client());
        }

        public static List<Order> mapFrom(List<OrderDto> source){
        return source.parallelStream()
                .map(OrderMapper::mapFrom)
                .toList();

    }
        public static List<OrderDto> mapFromDto(List<Order> source){
        return source.parallelStream()
                .map(OrderMapper::mapFrom)
                .toList();

    }
}
