import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
