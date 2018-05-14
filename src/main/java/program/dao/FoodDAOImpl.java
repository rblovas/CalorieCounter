package program.dao;

/*-
 * #%L
 * KaloriaSzamolo
 * %%
 * Copyright (C) 2018 University of Debrecen
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import program.dao.api.FoodDAO;
import program.model.FoodEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FoodDAOImpl implements FoodDAO {

    private EntityManager entityManager;

    public FoodDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public FoodEntity getFood(String foodName) {

        Query query = entityManager.createQuery("SELECT f FROM FoodEntity f WHERE foodName = :foodName");
        query.setParameter("foodName", foodName);

        return (FoodEntity) query.getSingleResult();
    }

    @Override
    public void persist(FoodEntity foodEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(foodEntity);
        entityManager.getTransaction().commit();
    }


}
