package program.dao;

import program.dao.api.FoodDAO;
import program.model.FoodEntity;

import javax.persistence.*;

public class FoodDAOImpl implements FoodDAO {

    private EntityManager entityManager;

    public FoodDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public FoodEntity getFood(String foodName) {

        Query query = entityManager.createQuery("SELECT f FROM FoodEntity f WHERE foodName = :foodName");
        query.setParameter("foodName",foodName);

        return (FoodEntity) query.getSingleResult();


    }
}
