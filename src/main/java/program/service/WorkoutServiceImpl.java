package program.service;

import program.dao.WorkoutDAOImpl;
import program.model.WorkoutEntity;
import program.service.api.WorkoutService;

public class WorkoutServiceImpl implements WorkoutService {

    private WorkoutDAOImpl dao;

    public WorkoutServiceImpl(WorkoutDAOImpl dao) {
        this.dao = dao;
    }

    @Override
    public WorkoutEntity getWorkout(String workoutName) {
        return dao.getWorkout(workoutName);
    }

    @Override
    public String getWorkoutNameById(Long id) {
        return dao.getWorkoutNameById(id);
    }

    @Override
    public float getWorkoutCalorieById(Long id) {
        return dao.getWorkoutCalorieById(id);
    }
}
