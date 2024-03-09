package by.ankudovich.mapper;

import by.ankudovich.api.Product.ProductRequest;
import by.ankudovich.api.Product.ProductResponse;
import by.ankudovich.api.User.UserRequest;
import by.ankudovich.api.User.UserResponse;
import by.ankudovich.entity.Product;
import by.ankudovich.entity.User;

public class ProductMapper {
    public ProductResponse toProductResponse (Product product){
        ProductResponse productResponse = new ProductResponse() ;
        productResponse.setId(product.getId());
        productResponse.setNameOfProduct(product.getNameOfProduct());
        productResponse.setCodeOfProduct(product.getCodeOfProduct());
        return  productResponse;
    }

    //метод для работы с полями из фронта
//    public Product toEntity (ProductRequest productRequest){
//       Product product = new Product();
//       product.setId(productRequest.getId());
//        return product ;
//    }
}
