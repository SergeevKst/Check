package com.test.task.service;

import com.test.task.model.Cart;
import com.test.task.model.Product;

import java.util.List;

public class CartServiceImpl implements CartService<Product> {
    private final Cart cart = new Cart();

    @Override
    public List<Product> createCart(List<Product> productsList) {

        List<Product> list = cart.getCart();
        list.addAll(productsList);

        return list;

    }
}
