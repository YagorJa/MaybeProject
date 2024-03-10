package by.ankudovich.entity;

import by.ankudovich.enums.ProductRole;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class Product implements Serializable {
    private Long id;
    public Long codeOfProduct;
    private String nameOfProduct;
    private double price;
    private long quantity;
    private ProductRole.PRODUCT typeOfProduct;

    public Product(Long id, Long codeOfProduct, String nameOfProduct, double price, long quantity) {
        this.id = id;
        this.codeOfProduct = codeOfProduct;
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(Long id, Long codeOfProduct, String nameOfProduct, double price, long quantity, ProductRole.PRODUCT typeOfProduct) {
        this.id = id;
        this.codeOfProduct = codeOfProduct;
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.quantity = quantity;
        this.typeOfProduct = typeOfProduct;
    }

    public Product(Long codeOfProduct, String nameOfProduct, double price, long quantity, ProductRole.PRODUCT typeOfProduct) {
        this.codeOfProduct = codeOfProduct;
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.quantity = quantity;
        this.typeOfProduct = typeOfProduct;
    }



    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && quantity == product.quantity && Objects.equals(id, product.id) && Objects.equals(codeOfProduct, product.codeOfProduct) && Objects.equals(nameOfProduct, product.nameOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codeOfProduct, nameOfProduct, price, quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", codeOfProduct=" + codeOfProduct +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", typeOfProduct=" + typeOfProduct +
                '}';
    }
}
