package com.test.task.repository;

import com.test.task.util.ConnectionManagerUtil;
import com.test.task.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository<Product>{

    @Override
    public List<Product> createProductRepository() {
        List<Product> productRepository = new ArrayList<>();

        try (Statement statement = ConnectionManagerUtil.openConnection().createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT * FROM store.product");
            while (resultSet.next()){
                Product product = new Product();

                product.setId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setPrice(resultSet.getInt("price"));
                product.setDiscount(resultSet.getString("discount"));

                productRepository.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productRepository;
    }


    @Override
    public void readProductRepository() {

        List<Product> productList = createProductRepository();

        productList.forEach(System.out::println);
    }
}
