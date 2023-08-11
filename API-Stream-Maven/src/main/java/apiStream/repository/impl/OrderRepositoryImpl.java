package apiStream.repository.impl;

import apiStream.domain.enums.OrderType;
import apiStream.domain.models.Customer;
import apiStream.domain.models.Order;
import apiStream.domain.models.Product;
import apiStream.mapping.dtos.OrderDto;
import apiStream.mapping.mapper.CustomerMapper;
import apiStream.mapping.mapper.OrderMapper;
import apiStream.mapping.mapper.ProductMapper;
import apiStream.repository.CustomerRepository;
import apiStream.repository.OrderRepository;
import apiStream.repository.ProductRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private final List<Order> orders;

    public OrderRepositoryImpl() {
        CustomerRepository repoCustomer = new CustomerRepositoryImpl();
        ProductRepository repoProduct = new ProductRepositoryImpl();

        List<Product> products = ProductMapper.mapFrom(repoProduct.getAllProducts());
        List<Customer> customers = CustomerMapper.mapFrom(repoCustomer.getAllClients());
        orders = new ArrayList<>();

        Customer customer1 = customers.get(0);
        Customer customer2 = customers.get(1);
        Customer customer3 = customers.get(2);

        List<Product> proOrder1 = new ArrayList<>();
        proOrder1.add(products.get(0));
        proOrder1.add(products.get(1));
        proOrder1.add(products.get(3));

        Order order1 = new Order(1,OrderType.DELIVERED, LocalDate.of(2023, 2,28),
                LocalDate.of(2023, 3, 4),proOrder1,customer1);
        orders.add(order1);

        List<Product> proOrder2 = new ArrayList<>();
        proOrder2.add(products.get(4));
        proOrder2.add(products.get(5));
        proOrder2.add(products.get(9));

        Order order2 = new Order(2,OrderType.PREPARING, LocalDate.of(2023, 3,18),
                LocalDate.of(2023, 3,26),proOrder2,customer2);
        orders.add(order2);

        List<Product> proOrder3 = new ArrayList<>();
        proOrder3.add(products.get(8));
        proOrder3.add(products.get(9));
        proOrder3.add(products.get(6));

        Order order3 = new Order(3,OrderType.DELIVERED, LocalDate.of(2023, 2, 2),
                LocalDate.of(2023, 2,21),proOrder3,customer3);
        orders.add(order3);

        List<Product> proOrder4 = new ArrayList<>();
        proOrder4.add(products.get(2));
        proOrder4.add(products.get(4));
        proOrder4.add(products.get(8));

        Order order4 = new Order(4,OrderType.ON_WAY, LocalDate.of(2023, 5,12),
                LocalDate.of(2023, 5,21),proOrder4,customer1);
        orders.add(order4);

        List<Product> proOrder5 = new ArrayList<>();
        proOrder5.add(products.get(1));
        proOrder5.add(products.get(3));
        proOrder5.add(products.get(9));

        Order order5 = new Order(5,OrderType.PREPARING, LocalDate.of(2023, 4,28),
                LocalDate.of(2023, 5,15),proOrder5,customer3);
        orders.add(order5);


    }

    @Override
    public List<OrderDto> getAllOrders() { return OrderMapper.mapFromDto(orders);
    }
}
