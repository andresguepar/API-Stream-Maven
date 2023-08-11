import apiStream.domain.enums.ProductType;
import apiStream.domain.models.Product;
import apiStream.mapping.dtos.ProductDto;
import apiStream.repository.impl.ProductRepositoryImpl;
import apiStream.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceImplTest {
    @Test
    void testProductHigher(){
        ProductServiceImpl operation = new ProductServiceImpl();
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

        List<ProductDto> expected = new ArrayList<>();
        expected.add(productRepository.getAllProducts().get(0));
        expected.add(productRepository.getAllProducts().get(3));
        List<ProductDto> result = operation.getHigherProducts();
        assertEquals(expected, result,"ERROR ERROR PROCESSING");

    }
    @Test
    void testProductFreeze(){
        ProductServiceImpl operation = new ProductServiceImpl();
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

        List<ProductDto> expected = new ArrayList<>();
        expected.add(productRepository.getAllProducts().get(1));
        expected.add(productRepository.getAllProducts().get(4));
        List<ProductDto> result = operation.getProductsFreeze();
        assertEquals(expected, result,"ERROR PROCESSING");
    }


}
