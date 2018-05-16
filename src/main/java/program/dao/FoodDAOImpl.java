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

import lombok.extern.slf4j.Slf4j;
import program.dao.api.FoodDAO;
import program.model.FoodEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Az ételek DAO függvényeit tartalmazó interfész implementálása.
 */
@Slf4j
public class FoodDAOImpl implements FoodDAO {

    private EntityManager entityManager;

    /**
     * Az osztály konstruktora.
     * @param entityManager - A paraméterként kapott {@link EntityManager}.
     */
    public FoodDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Egy étel entitás lekérését teszi lehetővé, nevének megadása által.
     * @param foodName - a lekérdezni kívánt étel neve.
     * @return - étel entitás.
     */
    @Override
    public FoodEntity getFood(String foodName) {

        Query query = entityManager.createQuery("SELECT f FROM FoodEntity f WHERE foodName = :foodName");
        query.setParameter("foodName", foodName);

        return (FoodEntity) query.getSingleResult();
    }

    /**
     * Lekéri az ételeket tartalmazó adatbázisból az összes entitást.
     * @return étel entitások listája.
     */
    @Override
    public List<FoodEntity> getAllFood() {
        TypedQuery<FoodEntity> typedQuery = entityManager.createQuery("select f from FoodEntity f", FoodEntity.class);
        return typedQuery.getResultList();
    }

    /**
     * Új étel entitás bevitele az adatbázisba.
     * @param entity - új entitás.
     */
    @Override
    public void persist(FoodEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    /**
     * Étel entitás törlése az adatbázisból.
     * @param entity - törölni kívánt entitás.
     */
    @Override
    public void delete(FoodEntity entity){
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
