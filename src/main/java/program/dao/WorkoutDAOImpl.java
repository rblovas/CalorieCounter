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
import program.dao.api.WorkoutDAO;
import program.model.WorkoutEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * WorkoutDAO implementálása.
 */
@Slf4j
public class WorkoutDAOImpl implements WorkoutDAO{

    private EntityManager entityManager;

    /**
     * Az osztály konstruktora.
     * @param entityManager -  A paraméterként kapott {@link EntityManager}.
     */
    public WorkoutDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Egy edzés entitás lekérése a neve alapján.
     * @param workoutName - lekérdezni kívánt edzésnév.
     * @return - edzés entitás.
     */
    public WorkoutEntity getWorkout(String workoutName) {

        Query query = entityManager.createQuery("SELECT w FROM WorkoutEntity w WHERE workoutName = :workoutName");
        query.setParameter("workoutName", workoutName);

        return (WorkoutEntity) query.getSingleResult();
    }

    /**
     * Egy edzés nevének lekérése az id-ja alapján.
     * @param  id - lekérdezni kívánt entitás id-ja.
     * @return - edzésnév.
     */
    public String getWorkoutNameById(Long id) {
        Query query = entityManager.createQuery("SELECT w.workoutName FROM WorkoutEntity w WHERE id = :id");
        query.setParameter("id", id);

        return (String) query.getSingleResult();
    }

    /**
     * Egy edzés kalória/perc lekérése id alapján.
     * @param id - - lekérdezni kívánt entitás id-ja.
     * @return - edzés kalória/perce.
     */
    public float getWorkoutCalorieById(Long id) {
        Query query = entityManager.createQuery("SELECT w.kcal FROM WorkoutEntity w WHERE id = :id");
        query.setParameter("id", id);

        return (float) query.getSingleResult();
    }

    @Override
    public void persist(WorkoutEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(WorkoutEntity entity){
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
