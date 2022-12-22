package com.test.task.service;

import com.test.task.model.Product;
import com.test.task.repository.ProductRepository;
import com.test.task.repository.ProductRepositoryImpl;
import com.test.task.util.ConnectionManagerUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService<Product>{

    @Override
    public Product getProductByIdFromDb(int index) {

    try (Connection connection = ConnectionManagerUtil.openConnection()){

    PreparedStatement statement = connection.prepareStatement("SELECT * FROM store.product WHERE id=?");

    statement.setInt(1,index);

    ResultSet resultSet = statement.executeQuery();

    Product product =new Product();


    while (resultSet.next()){

        product.setId(resultSet.getInt("id"));
        product.setProductName(resultSet.getString("product_name"));
        product.setPrice(resultSet.getInt("price"));
        product.setDiscount(resultSet.getString("discount"));


    }
        return product;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    @Override
    public List<Product> giveAccessToProductRepository() {

        ProductRepository<Product> productRepository= new ProductRepositoryImpl();

        return productRepository.createProductRepository();
}
}
