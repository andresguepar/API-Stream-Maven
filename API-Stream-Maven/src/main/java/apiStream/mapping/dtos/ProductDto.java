package apiStream.mapping.dtos;

import apiStream.domain.enums.ProductType;

public record ProductDto(long id,
                         String name,
                         ProductType category,
                         double price) {
}
