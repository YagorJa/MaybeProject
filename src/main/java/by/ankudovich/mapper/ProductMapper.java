package by.ankudovich.mapper;

import by.ankudovich.api.Product.ProductRequest;
import by.ankudovich.api.Product.ProductResponse;
import by.ankudovich.entity.Product;


public class ProductMapper {
    //метотд который записывает ответ,который формирует бэк.
    public ProductResponse toProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setCodeOfProduct(product.getCodeOfProduct());
        productResponse.setNameOfProduct(product.getNameOfProduct());
        productResponse.setPrice(product.getPrice());
        productResponse.setQuantity(productResponse.getQuantity());
        productResponse.setTypeOfProduct(product.getTypeOfProduct());
        return productResponse;
    }

    //метод для работы с полями из фронта
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

