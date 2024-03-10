package by.ankudovich.api.Product;

import by.ankudovich.enums.ProductRole;
import lombok.Data;

@Data
public class ProductRequest {
   // private Long id;
    public Long codeOfProduct;
    private String nameOfProduct;
    private ProductRole.PRODUCT typeOfProduct;
    private double price;
    private long quantity;

    public ProductRequest(Long codeOfProduct, String nameOfProduct, ProductRole.PRODUCT typeOfProduct, double price, long quantity) {
        this.codeOfProduct = codeOfProduct;
        this.nameOfProduct = nameOfProduct;
        this.typeOfProduct = typeOfProduct;
        this.price = price;
        this.quantity = quantity;
    }
}
