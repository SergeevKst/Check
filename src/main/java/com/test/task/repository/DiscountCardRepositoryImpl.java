package com.test.task.repository;

import com.test.task.util.ConnectionManagerUtil;
import com.test.task.model.DiscountCard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiscountCardRepositoryImpl implements DiscountCardRepository<DiscountCard>{

    @Override
    public List<DiscountCard> createDiscountCardRepository() {
        List<DiscountCard> discountCardRepository = new ArrayList<>();

        try (Statement statement = ConnectionManagerUtil.openConnection().createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT * FROM store.discount_card");
            while (resultSet.next()){
                DiscountCard discountCard =new DiscountCard();

                discountCard.setIdCard(resultSet.getInt("id"));


                discountCardRepository.add(discountCard);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return discountCardRepository;
    }
}
