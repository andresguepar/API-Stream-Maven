package apiStream.repository.impl;

import apiStream.domain.enums.ProductType;
import apiStream.domain.models.Product;
import apiStream.mapping.dtos.ProductDto;
import apiStream.mapping.mapper.ProductMapper;
import apiStream.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> products;
    public ProductRepositoryImpl() {
        products = new ArrayList<>();

        products.add(new Product(1, "Cake", ProductType.BEAKED, 15.00));
        products.add(new Product(2, "Ice Cream", ProductType.FREZEE, 4.50));
        products.add(new Product(3, "Sorbet", ProductType.BEVERAGE, 3.00));
        products.add(new Product(4, "Lemon Pie", ProductType.BEAKED, 12.50));
        products.add(new Product(5, "Popsicles", ProductType.FREZEE, 1.75));
        products.add(new Product(6, "Cookies", ProductType.BEAKED, 5.00));
        products.add(new Product(7, "Jelly Beans", ProductType.CANDY, 2.50));
        products.add(new Product(8, "Milkshake", ProductType.BEVERAGE, 6.00));
        products.add(new Product(9, "Marshmallows", ProductType.CANDY, 3.50));
        products.add(new Product(10, "Macarons", ProductType.BEAKED, 2.00));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return ProductMapper.mapFromDto(products);
    }
}
