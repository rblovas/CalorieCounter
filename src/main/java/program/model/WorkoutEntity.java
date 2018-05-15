package program.model;

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

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 * Edzéseket tartalmazó adatbázistábla.
 */
@Slf4j
@Entity
@Table(name = "WORKOUTS")
@Data
@NoArgsConstructor
public class WorkoutEntity {

    /**
     * Az edzés id-ja.
     */
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    /**
     * Az edzés neve.
     */
    @Column(name = "WORKOUTNAME")
    private String workoutName;

    /**
     * Az edzéssel percenként ledolgozható kalóriamennyiség.
     */
    @Column(name = "KCAL")
    private float kcal;

}
