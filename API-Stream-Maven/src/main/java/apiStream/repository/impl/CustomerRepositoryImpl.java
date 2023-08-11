package apiStream.repository.impl;

import apiStream.domain.enums.CustomerType;
import apiStream.domain.models.Customer;
import apiStream.mapping.dtos.CustomerDto;
import apiStream.mapping.mapper.CustomerMapper;
import apiStream.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> customers;
    public CustomerRepositoryImpl() {
        customers = new ArrayList<>();

        customers.add(new Customer(1, "Wu Bi", CustomerType.LEVEL1));
        customers.add(new Customer(2, "Su Yu", CustomerType.LEVEL2));
        customers.add(new Customer(3, "Cho", CustomerType.LEVEL3));
    }

    @Override
    public List<CustomerDto> getAllClients() {
        return CustomerMapper.mapFromDto(customers);
    }
}
