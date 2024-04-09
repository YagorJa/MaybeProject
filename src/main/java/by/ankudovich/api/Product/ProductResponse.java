package by.ankudovich.api.Product;

import by.ankudovich.enums.ProductRole;
import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    public Long codeOfProduct;
    private String nameOfProduct;
    private ProductRole.PRODUCT typeOfProduct;
    private double price;
    private long quantity;
}
