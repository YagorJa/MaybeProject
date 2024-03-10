package by.ankudovich.repository;

import by.ankudovich.entity.Product;

import java.util.Collection;

public interface ProductRepositoryInter {
    public Product add(Product product);
    public void  deleteProductById(long productId);
    public Collection<Product> allProducts();
    public long productIdGenerator();

}
