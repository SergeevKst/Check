package com.test.task.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
@Data
public class Cart {

    private static List<Product> cart= new ArrayList<>();


    public List<Product> getCart() {
        return cart;
    }

    public List<Product> serCart(){

        if (cart.size()!=0){
            return new ArrayList<>();
        }else return cart;
    }
}
