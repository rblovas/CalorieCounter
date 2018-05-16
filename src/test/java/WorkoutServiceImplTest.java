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
import org.junit.*;
import program.dao.WorkoutDAOImpl;
import program.model.WorkoutEntity;
import program.service.WorkoutServiceImpl;
import program.utility.Manager;


import static junit.framework.TestCase.assertEquals;

public class WorkoutServiceImplTest {

    private WorkoutDAOImpl dao = new WorkoutDAOImpl(Manager.getInstance());
    private WorkoutServiceImpl workoutService = new WorkoutServiceImpl(dao);

    private static WorkoutEntity createTestEntity(){
        WorkoutEntity workoutEntity = new WorkoutEntity();
        workoutEntity.setId(100L);
        workoutEntity.setWorkoutName("Teszt");
        workoutEntity.setKcal(5.0f);

        return workoutEntity;
    }

    @BeforeClass
    public static void asd(){
        WorkoutDAOImpl dao = new WorkoutDAOImpl(Manager.getInstance());
        WorkoutServiceImpl workoutService = new WorkoutServiceImpl(dao);
        workoutService.createWorkout(createTestEntity());
    }

    @AfterClass
    public static void after(){
        WorkoutDAOImpl dao = new WorkoutDAOImpl(Manager.getInstance());
        WorkoutServiceImpl workoutService = new WorkoutServiceImpl(dao);
        workoutService.deleteWorkout(workoutService.getWorkout("Teszt"));

    }

    private WorkoutEntity workout = createTestEntity();

    @Test
    public void getWorkoutNameByIdTest(){
        String resultName = workoutService.getWorkoutNameById(workout.getId());
        assertEquals("Teszt",resultName);
    }

    @Test
    public void getWorkoutCalorieByIdTest(){
        float resultCal = workoutService.getWorkoutCalorieById(workout.getId());
        assertEquals(5.0f, resultCal);
    }
}
