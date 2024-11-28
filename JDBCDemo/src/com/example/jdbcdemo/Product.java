package com.example.jdbcdemo;

import org.json.JSONObject;

public class Product {
    private int productId;
    private String name;
    private double price;
    private int quantity;
    private String category;
    private String supplier;

    public Product(int productId, String name, double price, int quantity, String category, String supplier) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.supplier = supplier;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                ", supplier='" + supplier + '\'' +
                '}';
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ProductID", productId);
        jsonObject.put("Name", name);
        jsonObject.put("Price", price);
        jsonObject.put("Quantity", quantity);
        jsonObject.put("Category", category);
        jsonObject.put("Supplier", supplier);
        return jsonObject;
    }
}