package program.service.api;

import program.model.WorkoutEntity;

public interface WorkoutService {

    WorkoutEntity getWorkout(String workoutName);

    String getWorkoutNameById(Long id);

    float getWorkoutCalorieById(Long id);
}
