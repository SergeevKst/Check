package com.test.task.service;

import java.util.List;

public interface ProductService <E> {


    E  getProductByIdFromDb(int index);
    List<E> giveAccessToProductRepository();

}
