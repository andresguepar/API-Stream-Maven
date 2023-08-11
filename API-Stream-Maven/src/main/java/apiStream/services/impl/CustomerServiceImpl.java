package apiStream.services.impl;

import apiStream.domain.enums.CustomerType;
import apiStream.mapping.dtos.CustomerDto;
import apiStream.repository.CustomerRepository;
import apiStream.repository.impl.CustomerRepositoryImpl;
import apiStream.services.CustomerService;

import java.util.List;
public class CustomerServiceImpl implements CustomerService {

    List<CustomerDto> customers;

    public CustomerServiceImpl() {
        CustomerRepository repoCustomer = new CustomerRepositoryImpl();
        customers = repoCustomer.getAllClients();
    }
    @Override
    public List<CustomerDto> getAllClients(CustomerType tier) {
        return customers;
    }
}
