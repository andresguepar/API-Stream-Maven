package apiStream.domain.models;

import apiStream.domain.enums.ProductType;

public class Product {
    private final long productId;
    private final String name;
    private final ProductType category;
    private final double price;


    public Product(long productId, String name, ProductType category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public ProductType getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Product -> " +
                "Id =" + productId +
                ", Name ='" + name + '\'' +
                ", Category =" + category +
                ", Price = $" + price +
                "||";
    }
}
