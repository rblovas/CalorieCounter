package program.service;

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

import program.dao.WorkoutDAOImpl;
import program.model.WorkoutEntity;
import program.service.api.WorkoutService;

/**
 * A WorkoutService implementálása.
 */
public class WorkoutServiceImpl implements WorkoutService {

    private WorkoutDAOImpl dao;

    /**
     * Az osztály konstruktora.
     * @param dao - {@link WorkoutDAOImpl} példánya.
     */
    public WorkoutServiceImpl(WorkoutDAOImpl dao) {
        this.dao = dao;
    }

    /**
     * Egy edzés nevének megkapása id alapján.
     * @param id - edzés idja.
     * @return - edzés neve.
     */
    @Override
    public String getWorkoutNameById(Long id) {
        return dao.getWorkoutNameById(id);
    }

    /**
     * Egy edzés kalóra/perc értékének megkapása id alapján.
     * @param id - edzés idja.
     * @return - edzés kalória/perce.
     */
    @Override
    public float getWorkoutCalorieById(Long id) {
        return dao.getWorkoutCalorieById(id);
    }

    @Override
    public void createWorkout(WorkoutEntity workoutEntity) {
        dao.persist(workoutEntity);
    }
}
