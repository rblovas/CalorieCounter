package program.dao;

import lombok.extern.slf4j.Slf4j;
import program.model.WorkoutEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Slf4j
public class WorkoutDAOImpl {

    private EntityManager entityManager;

    public WorkoutDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public WorkoutEntity getWorkout(String workoutName) {

        Query query = entityManager.createQuery("SELECT w FROM WorkoutEntity w WHERE workoutName = :workoutName");
        query.setParameter("workoutName", workoutName);

        return (WorkoutEntity) query.getSingleResult();
    }

    public String getWorkoutNameById(Long id) {
        Query query = entityManager.createQuery("SELECT w.workoutName FROM WorkoutEntity w WHERE id = :id");
        query.setParameter("id", id);

        return (String) query.getSingleResult();
    }

    public float getWorkoutCalorieById(Long id) {
        Query query = entityManager.createQuery("SELECT w.kcal FROM WorkoutEntity w WHERE id = :id");
        query.setParameter("id", id);

        return (float) query.getSingleResult();
    }
}