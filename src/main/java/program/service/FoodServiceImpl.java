package program.service;

import program.dao.FoodDAOImpl;
import program.model.FoodEntity;

public class FoodServiceImpl implements FoodService {

    private FoodDAOImpl dao;

    public FoodServiceImpl(FoodDAOImpl dao){
        this.dao = dao;
    }


    @Override
    public FoodEntity getFood(String foodName) {
        return dao.getFood(foodName);
    }
}
