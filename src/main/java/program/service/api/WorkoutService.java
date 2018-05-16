package program.service.api;

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

import program.model.WorkoutEntity;

/**
 * Az edzések szolgáltatásainak interfésze.
 */
public interface WorkoutService {

    WorkoutEntity getWorkout(String name);

    /**
     * Egy edzés nevének megkapása id alapján.
     * @param id - edzés idja.
     * @return - edzés kalória/perce.
     */
    String getWorkoutNameById(Long id);

    /**
     * Egy edzés kalóra/perc értékének megkapása id alapján.
     * @param id - edzés idja.
     * @return - edzés kalória/perce.
     */
    float getWorkoutCalorieById(Long id);

    void createWorkout(WorkoutEntity workoutEntity);
    void deleteWorkout(WorkoutEntity workoutEntity);
}
