package apiStream.mapping.mapper;

import apiStream.domain.models.Customer;
import apiStream.mapping.dtos.CustomerDto;

import java.util.List;

public class CustomerMapper {
    public static CustomerDto mapFrom(Customer source){
        return new CustomerDto(source.getClientId(),
                source.getName(),
                source.getTier());
    }

    public static Customer mapFrom(CustomerDto source){
        return new Customer(source.id(),
                source.name(),
                source.tier());
    }

    public static List<Customer> mapFrom(List<CustomerDto> source){
        return source.parallelStream()
                .map(CustomerMapper::mapFrom)
                .toList();

    }
    public static List<CustomerDto> mapFromDto(List<Customer> source){
        return source.parallelStream()
                .map(CustomerMapper::mapFrom)
                .toList();

    }
}
