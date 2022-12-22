package com.test.task.service;

import com.test.task.model.DiscountCard;

import java.util.List;

public interface DiscountCardService<E> {

    List<DiscountCard> giveAccessToDiscountCardRepository ();
}
