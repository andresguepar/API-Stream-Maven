package apiStream.repository;

import apiStream.mapping.dtos.ProductDto;

import java.util.List;

public interface ProductRepository {
    List<ProductDto> getAllProducts();
}
