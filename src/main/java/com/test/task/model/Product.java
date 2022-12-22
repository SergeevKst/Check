package com.test.task.model;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String productName;
    private int price;
    private String discount;


    @Override
    public String toString() {
        return "Product[" +
                "id=" + id +
                ", product name='" + productName + '\'' +
                ", price=" + price +
                ", discount='" + discount + '\'' +
                ']';
    }
}
