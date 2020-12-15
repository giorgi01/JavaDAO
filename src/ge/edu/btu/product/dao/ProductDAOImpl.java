package ge.edu.btu.product.dao;

import ge.edu.btu.product.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private Connection connection;

    public ProductDAOImpl() throws Exception {
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);

        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "toor");
    }

    @Override
    public void addProduct(Product product) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (id, product_name, category, price, discount_percent) VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setLong(1, product.getId());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setString(3, product.getCategory());
        preparedStatement.setDouble(4, product.getPrice());
        preparedStatement.setDouble(5, product.getDiscountPercent());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void deleteProductById(long id) throws Exception {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM products WHERE id = " + id);
        statement.close();
    }

    @Override
    public void setDiscountPercent(long id, double percent) throws Exception {
        Statement update_statement = connection.createStatement();
        update_statement.executeUpdate("UPDATE products SET discount_percent = " + percent + " WHERE id = " + id);
        update_statement.close();
    }


    @Override
    public List<Product> getAll() throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM products");

        List<Product> list = new ArrayList<>();
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String productName = resultSet.getString("product_name");
            String category = resultSet.getString("category");
            double price = resultSet.getDouble("price");
            double discountPercent = resultSet.getDouble("discount_percent");
            Product systemProduct = new Product(id, productName, category, price, discountPercent);
            list.add(systemProduct);
        }

        statement.close();

        return list;
    }

    public void closeConnection() throws Exception {
        connection.close();
    }
}