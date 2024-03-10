package by.ankudovich.service;

import by.ankudovich.api.Product.ProductRequest;
import by.ankudovich.api.Product.ProductResponse;
import by.ankudovich.entity.Product;
import by.ankudovich.mapper.ProductMapper;
import by.ankudovich.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public ProductResponse add(ProductRequest productRequest) {
        ProductMapper productMapper = new ProductMapper();
        Product product = productMapper.toEntity(productRequest);
        product = productRepository.add(product);
        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> allProducts(){
        List<Product> products = productRepository.allProducts();
        ProductMapper productMapper = new ProductMapper();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product: products) {
            ProductResponse productResponse = productMapper.toProductResponse(product);
            productResponses.add(productResponse);
        }
        return productResponses;
    }
}

