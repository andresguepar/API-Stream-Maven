package apiStream.mapping.mapper;

import apiStream.domain.models.Product;
import apiStream.mapping.dtos.ProductDto;

import java.util.List;

public class ProductMapper {
    public static ProductDto mapFrom(Product source){
        return new ProductDto(source.getProductId(),
                source.getName(),
                source.getCategory(),
                source.getPrice());
    }

    public static Product mapFrom(ProductDto source){
        return new Product(source.id(),
                source.name(),
                source.category(),
                source.price());
    }

    public static List<Product> mapFrom(List<ProductDto> source){
        return source.parallelStream()
                .map(ProductMapper::mapFrom)
                .toList();

    }

    public static List<ProductDto> mapFromDto(List<Product> source){
        return source.parallelStream()
                .map(ProductMapper::mapFrom)
                .toList();

    }


}
