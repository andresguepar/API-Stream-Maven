package apiStream.services;

import apiStream.domain.enums.CustomerType;
import apiStream.mapping.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllClients(CustomerType tier);


}
