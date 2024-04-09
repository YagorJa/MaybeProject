package by.ankudovich.api.Product;

import by.ankudovich.enums.ProductRole;
import lombok.Data;

@Data
public class ProductRequest {

    public Long codeOfProduct;
    private String nameOfProduct;
    private ProductRole.PRODUCT typeOfProduct;
    private double price;
    private long quantity;


}
