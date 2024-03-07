package by.ankudovich.api.Product;

import lombok.Data;

@Data
public class ProductRequest {
    private Long id;
    public Long codeOfProduct;
    private String nameOfProduct;
    private double price;
    private long quantity;
}
