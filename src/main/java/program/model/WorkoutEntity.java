package program.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Entity
@Table(name = "WORKOUTS")
@Data
@NoArgsConstructor
public class WorkoutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "WORKOUTNAME")
    private String workoutName;

    /**
     * Kalória/perc
     */
    @Column(name = "KCAL")
    private float kcal;

}
