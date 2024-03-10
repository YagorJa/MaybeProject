package by.ankudovich.repository.exception;

public class ProductNotFound extends RuntimeException {
    public long idProduct;

        public ProductNotFound (long idProduct) {
        super("Товар с таким ID " + idProduct + " не найден!");
        this.idProduct = idProduct;
    }

    public long getIdProduct() {
        return idProduct;
    }
}
