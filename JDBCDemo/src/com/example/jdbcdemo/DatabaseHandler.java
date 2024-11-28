package com.example.jdbcdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class DatabaseHandler {
    private String jdbcUrl;
    private String jdbcUser;
    private String jdbcPassword;
    private Connection connection;

    public DatabaseHandler(String jdbcUrl, String jdbcUser, String jdbcPassword) {
        this.jdbcUrl = jdbcUrl;
        this.jdbcUser = jdbcUser;
        this.jdbcPassword = jdbcPassword;
    }

    private void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
    }

    private void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public List<Product> getProducts(String query) {
        List<Product> products = new ArrayList<>();
        try {
            connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("Product_id");  // Updated column name to Product_id
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");
                String supplier = rs.getString("supplier");

                Product product = new Product(id, name, price, quantity, category, supplier);
                products.add(product);
            }
            rs.close();
            stmt.close();
            disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public JSONArray getProductsAsJson(String query) {
        List<Product> products = getProducts(query);
        JSONArray jsonArray = new JSONArray();
        for (Product product : products) {
            jsonArray.put(product.toJson());
        }
        return jsonArray;
    }

    public static void main(String[] args) {
        DatabaseHandler dbHandler = new DatabaseHandler("jdbc:mysql://localhost:3306/err", "root", "Subha#2005");

        List<Product> products = dbHandler.getProducts("SELECT * FROM products");
        for (Product product : products) {
            System.out.println(product);
        }

        JSONArray jsonData = dbHandler.getProductsAsJson("SELECT * FROM products");
        System.out.println(jsonData.toString(2));
    }
}