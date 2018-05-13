package program.dao.api;

import program.model.FoodEntity;

import java.io.Serializable;

public interface FoodDAO<T, ID extends Serializable> {

    FoodEntity getFood(String foodName);
}
