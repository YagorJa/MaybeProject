package by.ankudovich.repository;

import by.ankudovich.entity.Product;

import java.util.Collection;

public interface ProductRepositoryInter {
    public void add(Product product);
    public void  deleteProductById(long productId);
    public Collection<Product> allProducts();

}
