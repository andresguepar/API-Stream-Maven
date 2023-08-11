package apiStream.domain.models;

import apiStream.domain.enums.OrderType;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private final long orderId;
    private OrderType status;
    private final LocalDate orderDate;
    private final LocalDate deliveryDate;
    private final List<Product> products;
    private final Customer customer;

    public Order(long orderId, OrderType status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.orderId = orderId;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    public long getOrderId() {
        return orderId;
    }

    public OrderType getStatus() {
        return status;
    }

    public void setStatus(OrderType status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }


    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }


    public Customer getCustomer() {
        return customer;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + orderId +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
