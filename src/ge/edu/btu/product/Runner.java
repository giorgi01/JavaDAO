package ge.edu.btu.product;

import ge.edu.btu.product.dao.ProductDAO;
import ge.edu.btu.product.dao.ProductDAOImpl;
import ge.edu.btu.product.model.Product;

import java.util.List;

public class Runner {

    public static void main(String[] args) throws Exception {
        ProductDAO ProductDAO = new ProductDAOImpl();

        ProductDAO.addProduct(new Product(420000001, "Coca-Cola 1L", "Soft Drinks", 2.5, 0));
        ProductDAO.addProduct(new Product(420000002, "Coca-Cola 2L", "Soft Drinks", 3.2, 20));
        ProductDAO.addProduct(new Product(420000003, "Coca-Cola 3L", "Soft Drinks", 5, 0));

        ProductDAO.setDiscountPercent(420000003, 50);

//        for (int i=420000001; i<420000004; i++) ProductDAO.deleteProductById(i);

        List<Product> products = ProductDAO.getAll();
        for (Product product : products) {
            System.out.println(product);
        }

        ProductDAO.closeConnection();
    }
}