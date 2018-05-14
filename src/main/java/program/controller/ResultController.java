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
import program.service.ResultService;

import java.util.Arrays;
import java.util.List;


public class ResultController extends Controller {
    public Label labelCaloria;
    public TextArea textArea;

    private Stage dialogStage;

    @FXML
    private void initialize() {
        List<String> workouttypes = Arrays.asList("Kocogás", "Futás-közepes tempó", "Biciklizés", "Úszás", "Aerobik", "Testépítés");
        List<Float> caloriesPerTen = Arrays.asList(9.0f, 15.0f, 9.0f, 12.0f, 8.0f, 7.0f);

        int sum = ResultService.getSum();
        labelCaloria.setText(String.valueOf(sum));

        for (int type = 0; type < 6; type++) {
            textArea.appendText(workouttypes.get(type) + "\t\t\t" + (int) (sum / caloriesPerTen.get(type)) + "\n");
        }
    }

    public void goToMainpage(ActionEvent actionEvent) {
        sceneSwitch(dialogStage, "mainController", actionEvent);
    }
}


