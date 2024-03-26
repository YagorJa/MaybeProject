package by.ankudovich.repository.product;

import by.ankudovich.entity.Product;

import java.util.Collection;
import java.util.List;

public interface ProductRepositoryInter {
    public Product add(Product product);
    public void  deleteProductById(long productId);
    public Collection<Product> allProducts();
    public long productIdGenerator();
    Product findByName(String productName);

    Product findById(long productId);
    List<Product> getProductsByIds(List<Long> ids);
}
