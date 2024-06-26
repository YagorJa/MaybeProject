package by.ankudovich.mapper;

import by.ankudovich.api.Product.ProductRequest;
import by.ankudovich.api.Product.ProductResponse;
import by.ankudovich.entity.Product;


public class ProductMapper {

    public ProductResponse toProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setCodeOfProduct(product.getCodeOfProduct());
        productResponse.setNameOfProduct(product.getNameOfProduct());
        productResponse.setPrice(product.getPrice());
        productResponse.setQuantity(product.getQuantity());
        productResponse.setTypeOfProduct(product.getTypeOfProduct());
        return productResponse;
    }


    public Product toEntity (ProductRequest productRequest){
        Product product = new Product();

        product.setCodeOfProduct(productRequest.getCodeOfProduct());
        product.setNameOfProduct(productRequest.getNameOfProduct());
        product.setTypeOfProduct(productRequest.getTypeOfProduct());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        return product;
    }
}

