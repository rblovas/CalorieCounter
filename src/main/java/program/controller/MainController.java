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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import program.dao.FoodDAOImpl;
import program.service.FoodServiceImpl;
import program.service.ResultService;
import program.service.api.FoodService;
import program.utility.Manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainController extends Controller {

    @FXML
    public ChoiceBox food1;
    @FXML
    public ChoiceBox food2;
    @FXML
    public ChoiceBox food3;
    @FXML
    public ChoiceBox food4;
    @FXML
    public ChoiceBox food5;
    @FXML
    public ChoiceBox food6;
    public TextField textAmount1;
    public TextField textAmount2;
    public TextField textAmount3;
    public TextField textAmount4;
    public TextField textAmount5;
    public TextField textAmount6;


    private FoodService foodService = new FoodServiceImpl(new FoodDAOImpl(Manager.getInstance()));

    private Stage dialogStage;

    private List<String> foods = new ArrayList<>();
    private List<Integer> calories = new ArrayList<>();


    @FXML
    private void initialize() {

        ResultService.setSum(0);

        foodService.uploadFoods(foods, calories);

        List<ChoiceBox> boxes = Arrays.asList(food1, food2, food3, food4, food5, food6);

        for (int box = 0; box < 6; box++) {
            boxes.get(box).getItems().addAll(foods);
        }
    }


    @FXML
    public void buttonCalculate(ActionEvent actionEvent) {
        List<ChoiceBox> boxes = Arrays.asList(food1, food2, food3, food4, food5, food6);
        List<TextField> texts = Arrays.asList(textAmount1, textAmount2, textAmount3, textAmount4, textAmount5, textAmount6);
        /* List<Integer> calories = Arrays.asList(440, 82, 4000, 3370, 78, 5000, 0);*/

        try {
            int sum = 0;
            for (int text = 0; text < 6; text++) {
                if (texts.get(text).getText().isEmpty()) {
                    texts.get(text).setText("0");
                }
                if (boxes.get(text).getItems().isEmpty()) {
                    boxes.get(text).getSelectionModel().selectLast();
                }
                if (Integer.parseInt(texts.get(text).getText()) < 0) {
                    errorBox("Nem megfelelő adatot adtál meg darabszámnak. Legalább 0-val kell egyenlőnek lennie.", "Hiba", "Hiba történt!");
                }
                if (Integer.parseInt(texts.get(text).getText()) != 0 && !boxes.get(text).getSelectionModel().getSelectedItem().equals("-")) {
                    for (int i = 0; i < foods.size(); i++) {
                        if (foods.get(i) == boxes.get(text).getSelectionModel().getSelectedItem()) {
                            sum += calories.get(i) * Integer.parseInt(texts.get(text).getText());
                        }
                    }


                }
            }

            try {
                ResultService.setSum(sum);
                sceneSwitch(dialogStage, "resultController", actionEvent);
            } catch (Exception e) {
                errorBox("A program nem tud átlépni a következő oldalra, mert béna a programozója.", "Hiba", "Hiba történt!");
            }


        } catch (Exception e) {
            errorBox("Nem megfelelő adatot adtál meg darabszámnak. Számot adj meg", "Hiba", "Hiba történt!");
        }
    }

}
