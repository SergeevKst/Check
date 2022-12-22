package com.test.task.service;

import com.test.task.model.DiscountCard;
import com.test.task.repository.DiscountCardRepository;
import com.test.task.repository.DiscountCardRepositoryImpl;

import java.util.List;

public class DiscountCardServiceImpl implements DiscountCardService<DiscountCard> {

    private DiscountCardRepository<DiscountCard> discountCardRepository = new DiscountCardRepositoryImpl();
    @Override
    public List<DiscountCard> giveAccessToDiscountCardRepository() {
        return discountCardRepository.createDiscountCardRepository();
    }
}


