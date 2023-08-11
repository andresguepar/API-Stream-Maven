package apiStream.services.impl;

import apiStream.domain.enums.ProductType;
import apiStream.mapping.dtos.ProductDto;
import apiStream.repository.ProductRepository;
import apiStream.repository.impl.ProductRepositoryImpl;
import apiStream.services.ProductService;

import java.util.*;
import java.util.stream.Stream;

public class ProductServiceImpl implements ProductService {

    static List<ProductDto> products;

    public ProductServiceImpl() {
        ProductRepository repoProduct = new ProductRepositoryImpl();
        products = repoProduct.getAllProducts();
    }

    // 1. List of products higher than $5.00
    public List<ProductDto> getHigherProducts() {
        return products.stream()
                .filter(p -> p.price() > 5.00)
                .filter(p -> p.category().equals(ProductType.BEAKED))
                .toList();
    }

    // 2. List of products for category Frezee
    @Override
    public List<ProductDto> getProductsFreeze() {
        return products.stream()
                .filter(p -> p.category().equals(ProductType.FREZEE))
                .toList();
    }

    // 3. List of products with 10%% of discount
    @Override
    public List<ProductDto> getProductsDiscount() {
        return products.stream()
                .filter(p -> p.category().equals(ProductType.CANDY))
                .map(p -> {
                    double discountPrice = p.price() - (p.price() * 0.10);
                    return new ProductDto(p.id(), p.name(), p.category(),discountPrice);
                })
                .toList();
    }

    // 5. List minimun price of beaked products
    @Override
    public Optional<ProductDto> getProductsMinPrice() {
        return products.stream()
                .filter(p -> p.category().equals(ProductType.BEAKED))
                .min(Comparator.comparing(ProductDto::price));
    }


    // 10. Maximun price per category
    @Override
    public List<ProductDto> getProductsMaxPricePerCategory() {
         Map<String , ProductDto> expensiveProduct = new HashMap<>();
        for (ProductDto product : products) {
            expensiveProduct
                    .merge(String.valueOf(product.category()),product ,
                            (e, r) -> e.price() > r.price() ? e : r);
        }
        return new ArrayList<>(expensiveProduct.values());
    }

    @Override
    public List<ProductDto> getAllProducts(ProductType category) {
        return products;
    }

    // 11. Use of runAsync
    public static void sleepThread(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void longProcess() {
        sleepThread(5000);
        List<ProductDto> f = products.stream()
                .filter(p -> p.category().equals(ProductType.BEAKED))
                .toList();
        System.out.println("Long process ended ");
    }
}
