package ge.edu.btu.product.dao;

import ge.edu.btu.product.model.Product;

import java.util.List;

public interface ProductDAO {

    void addProduct(Product product) throws Exception;

    void deleteProductById(long id) throws Exception;

    void setDiscountPercent(long id, double percent) throws Exception;

    List<Product> getAll() throws Exception;

    void closeConnection() throws Exception;
}
