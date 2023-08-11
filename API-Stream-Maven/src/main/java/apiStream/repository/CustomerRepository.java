package apiStream.repository;

import apiStream.mapping.dtos.CustomerDto;

import java.util.List;

public interface CustomerRepository {
    List<CustomerDto> getAllClients();

}
