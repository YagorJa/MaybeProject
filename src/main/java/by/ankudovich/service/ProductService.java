package by.ankudovich.service;

import by.ankudovich.api.Product.ProductRequest;
import by.ankudovich.api.Product.ProductResponse;
import by.ankudovich.entity.Product;
import by.ankudovich.mapper.ProductMapper;
import by.ankudovich.repository.product.ProductRepositoryInter;
import by.ankudovich.repository.product.ProductRepositoryJDBC;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private ProductRepositoryInter productRepository;

    public ProductService() {
        this.productRepository = new ProductRepositoryJDBC();
    }
    public ProductResponse add(ProductRequest productRequest) {
        ProductMapper productMapper = new ProductMapper();
        Product product = productMapper.toEntity(productRequest);
        product = productRepository.add(product);
        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> allProducts(){
        List<Product> products = (List<Product>) productRepository.allProducts();
        ProductMapper productMapper = new ProductMapper();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product: products) {
            ProductResponse productResponse = productMapper.toProductResponse(product);
            productResponses.add(productResponse);
        }
        return productResponses;
    }
    public void deleteProduct(long productId) {
        productRepository.deleteProductById(productId);
    }


    public ProductResponse getProductById(long productId) {
        ProductMapper productMapper = new ProductMapper();
        Product product = productRepository.findById(productId);
        if (product != null) {
            return productMapper.toProductResponse(product);
        } else {
            return null;
        }
    }
    public ProductResponse getProductByName(String productName) {
        ProductMapper productMapper = new ProductMapper();
        Product product = productRepository.findByName(productName);
        if (product != null) {
            return productMapper.toProductResponse(product);
        } else {
            return null;
        }
    }
}

