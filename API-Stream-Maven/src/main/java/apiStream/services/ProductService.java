package apiStream.services;

import apiStream.domain.enums.ProductType;
import apiStream.mapping.dtos.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDto> getProductsMaxPricePerCategory();
    List<ProductDto> getProductsFreeze();
    Optional<ProductDto> getProductsMinPrice();
    List<ProductDto> getProductsDiscount();
    List<ProductDto> getHigherProducts();

    List<ProductDto> getAllProducts(ProductType category);
}
