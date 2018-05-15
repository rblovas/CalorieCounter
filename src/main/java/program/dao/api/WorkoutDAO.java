package program.dao.api;

import program.model.WorkoutEntity;

public interface WorkoutDAO {

    WorkoutEntity getWorkout(String workoutName);

    String getWorkoutNameById(Long id);

    float getWorkoutCalorieById(Long id);
}
