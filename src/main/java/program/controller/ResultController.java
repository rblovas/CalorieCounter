package program.controller;

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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import program.dao.WorkoutDAOImpl;
import program.service.ResultService;
import program.service.WorkoutServiceImpl;
import program.service.api.WorkoutService;
import program.utility.Manager;

@Slf4j
public class ResultController extends Controller {
    public Label labelCaloria;
    public TextArea textArea;

    private Stage dialogStage;
    private WorkoutService workoutService = new WorkoutServiceImpl(new WorkoutDAOImpl(Manager.getInstance()));

    @FXML
    private void initialize() {
        int sum = ResultService.getSum();
        labelCaloria.setText(String.valueOf(sum));
        log.info("Kiírásra került a kiszámolt kalóriamennyiség");

        for (long type = 1; type < 7; type++) {
            textArea.appendText(workoutService.getWorkoutNameById(type) + "\t\t" + (int) (sum / workoutService.getWorkoutCalorieById(type)) + "\n");
        }
        log.info("Az összes gyakorlat és perc kiírásra került.");
    }

    public void goToMainpage(ActionEvent actionEvent) {
        log.info("A felhasználó visszament a kezdőlapra.");
        sceneSwitch("mainController", actionEvent);
    }
}


