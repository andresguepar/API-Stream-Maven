package apiStream.mapping.dtos;

import apiStream.domain.enums.OrderType;

import java.time.LocalDate;
import java.util.List;

public record OrderDto(long id,
                       OrderType status,
                       LocalDate orderDate,
                       LocalDate deliveryDate,
                       List<apiStream.domain.models.Product> products,
                       apiStream.domain.models.Customer client) {
}
