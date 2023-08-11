package apiStream.services.impl;

import apiStream.domain.enums.CustomerType;
import apiStream.domain.enums.OrderType;
import apiStream.domain.models.Customer;
import apiStream.domain.models.Product;
import apiStream.mapping.dtos.OrderDto;
import apiStream.repository.OrderRepository;
import apiStream.repository.impl.OrderRepositoryImpl;
import apiStream.services.OrderService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    List<OrderDto> orders;


    public OrderServiceImpl() {
        OrderRepository repoOrder = new OrderRepositoryImpl();
        orders = repoOrder.getAllOrders();
    }

    // 4. List of product ordered by a client Level 2
    @Override
    public List<Product> getListOrderByDate() {
        return orders.stream()
                .filter(p -> p.client().getTier().equals(CustomerType.LEVEL2))
                .filter(o -> o.orderDate().isAfter(LocalDate.of(2023, 2, 1)))
                .filter(p -> p.deliveryDate().isBefore(LocalDate.of(2023, 4, 1)))
                .flatMap(p -> p.products().stream())
                .distinct()
                .toList();

    }

    // 6. List of lastest orders
    @Override
    public List<OrderDto> getRecentOrder() {
        return orders.stream()
                .sorted(Comparator.comparing(OrderDto::orderDate).reversed())
                .limit(2)
                .toList();
    }

    // 7. Total order in 2023-02-02
    @Override
    public double getTotalPriceOrder() {
        return orders.stream()
                .filter(o -> o.orderDate()
                        .isEqual(LocalDate.of(2023, 2, 2)))
                .flatMap(o -> o.products()
                        .stream())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    // 8. Average price in 2023-04-28
    @Override
    public OptionalDouble getAverageOrder() {
        return  OptionalDouble.of(orders.stream()
                .filter(o -> o.orderDate()
                        .isEqual(LocalDate.of(2023, 4, 28)))
                .flatMap(o -> o.products().stream())
                .mapToDouble(Product::getPrice)
                .average()
                .getAsDouble());
    }

    // 9. Data map
    @Override
    public HashMap<Customer, List<OrderDto>> getMapOrder() {
        return orders.stream()
                .collect(Collectors
                        .groupingBy(OrderDto::client, HashMap::new,Collectors.toList()));
    }



    @Override
    public List<OrderDto> getAllOrders(OrderType orderType) {
        return orders;
    }
}
