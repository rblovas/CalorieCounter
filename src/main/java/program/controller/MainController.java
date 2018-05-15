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
import lombok.extern.slf4j.Slf4j;
import program.dao.FoodDAOImpl;
import program.service.FoodServiceImpl;
import program.service.ResultService;
import program.service.api.FoodService;
import program.utility.Manager;

import java.util.Arrays;
import java.util.List;

@Slf4j
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

    @FXML
    private void initialize() {
        ResultService.setSum(0);

        List<ChoiceBox> boxes = Arrays.asList(food1, food2, food3, food4, food5, food6);
        List<String> foodlist;
        foodlist = foodService.getAllFoodName();

        for (ChoiceBox box : boxes) {
            box.getItems().addAll(foodlist);
        }

        log.info("Feltöltődött az összes adat a choiceboxokba.");
    }


    @FXML
    public void buttonCalculate(ActionEvent actionEvent) {
        List<ChoiceBox> boxes = Arrays.asList(food1, food2, food3, food4, food5, food6);
        List<TextField> texts = Arrays.asList(textAmount1, textAmount2, textAmount3, textAmount4, textAmount5, textAmount6);

        try {
            int sum = 0;
            for (int text = 0; text < 6; text++) {
                if (texts.get(text).getText().isEmpty()) {
                    texts.get(text).setText("0");
                }
                if (boxes.get(text).getItems().isEmpty()) {
                    boxes.get(text).getSelectionModel().selectFirst();
                }
                if (Integer.parseInt(texts.get(text).getText()) < 0) {
                    log.warn("Negatív számot adott meg a felhasználó darabszámnak.");
                    errorBox("Nem megfelelő adatot adtál meg darabszámnak. Nem lehet negatív.", "Hiba", "Hiba történt!");
                }
                if (Integer.parseInt(texts.get(text).getText()) != 0 && !boxes.get(text).getSelectionModel().getSelectedItem().equals("-")) {
                    sum += Integer.parseInt(texts.get(text).getText()) * foodService.getFood(boxes.get(text).getSelectionModel().getSelectedItem().toString()).getKcal();

                }
            }

            ResultService.setSum(sum);
            log.info("A felhasználó helyesen megadta az összetevőket és a mennyiségeket és átlép a következő oldalra.");
            sceneSwitch("resultController", actionEvent);

        } catch (Exception e) {
            log.error("Nem megfelelő típusú adatot adott meg darabszámnak a felhasználó.");
            errorBox("Nem megfelelő adatot adtál meg darabszámnak. Számot adj meg", "Hiba", "Hiba történt!");
        }
    }

}
