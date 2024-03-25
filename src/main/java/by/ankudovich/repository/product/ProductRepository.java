package by.ankudovich.repository.product;

import by.ankudovich.entity.Product;
import by.ankudovich.repository.exception.ProductNotFound;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductRepository implements ProductRepositoryInter {

    private final String filename = "C:\\tms\\TempDz4\\src\\main\\resources\\Products";
    private List<Product> products;

    public ProductRepository() {
        products = deserializeProduct();
    }

    @Override
    public Product add(Product product) {
        long id = productIdGenerator();
        product.setId(id);
        products.add(product);

        serealizeProduct();
        return product;
    }

public long productIdGenerator(){
        long lastId = 0;
        List<Product> products = allProducts();
    if (!products.isEmpty()) {
       lastId = products.get(products.size() - 1).getId();
    }
    return lastId + 1;
}

    @Override
    public void deleteProductById(long productId) {
        products.removeIf(product -> product.getId().equals(productId));
        serealizeProduct();
    }

    @Override
    public List<Product> allProducts() {
        return products;
    }

    public long productsIdGenerator() {
        return products.size() + 1;
    }
    public Product findProduct(long idProduct){
        for (Product product : products){
            if (product.getId().equals(idProduct) ) {
                return product;
            }
        }
        throw new ProductNotFound(idProduct);
    }

    public boolean isInStock(long idProduct) {
        Product product = findProduct(idProduct); // создаем продукт и передаем в него айди, присваем
                                                    // этот продукт продукту в методе и возрашаем истину  если он сущесвтует и количесвто больше 0
        return product!= null && product.getQuantity() > 0;
    }

    @Override
    public Product findById(long productId) {
        return allProducts().stream().filter(product -> product.getId() == productId).findFirst().orElse(null);
    }
    @Override
    public Product findByName(String productName) {
        Collection<Product> allProducts = allProducts();
        for (Product product : allProducts) {
            if (product.getNameOfProduct().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    private void serealizeProduct() {
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);


            out.writeObject(products);

            out.close();
            file.close();

            System.out.println("Продукты были сериализованы");
        } catch (IOException ex) {
            throw new RuntimeException("Продукты не сериализовались", ex);
        }

    }

    private List<Product> deserializeProduct() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<Product> deserUsers = (List<Product>) ois.readObject();
            return deserUsers;


        } catch (IOException | ClassNotFoundException e) {

        }
        return new ArrayList<>();
    }

}

