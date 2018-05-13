package program.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import program.dao.FoodDAOImpl;
import program.model.FoodEntity;
import program.service.FoodService;
import program.service.FoodServiceImpl;
import program.service.ResultService;
import program.utility.Manager;

import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;





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



    private FoodService foodService;
    private FoodEntity foodEntity;
    private Stage dialogStage;


    @FXML
    private void initialize(){
        ResultService.setSum(0);

        List<String> foods = Arrays.asList("tej","főtt tojás","cukor","liszt","alma","talicska", "-");
        List<Integer> calories = Arrays.asList(440, 82, 4000, 3370, 78, 5000, 0);
        List<ChoiceBox> boxes = Arrays.asList(food1,food2,food3,food4,food5,food6);


        foodService = new FoodServiceImpl(new FoodDAOImpl(Manager.getInstance()));

        for (int box = 0; box < 6; box++){
            boxes.get(box).getItems().addAll(foods);
        }
    }


    @FXML
    public void buttonCalculate(ActionEvent actionEvent) {
        List<ChoiceBox> boxes = Arrays.asList(food1,food2,food3,food4,food5,food6);
        List<TextField> texts = Arrays.asList(textAmount1,textAmount2, textAmount3, textAmount4, textAmount5, textAmount6);
        List<Integer> calories = Arrays.asList(440, 82, 4000, 3370, 78, 5000, 0);

        try {
            int sum = 0;
            for (int text = 0; text < 6; text++){
                if(texts.get(text).getText().isEmpty()){
                    texts.get(text).setText("0");
                }
                if(boxes.get(text).getItems().isEmpty()){
                    boxes.get(text).getSelectionModel().selectLast();
                }
                if(Integer.parseInt(texts.get(text).getText()) < 0){
                    errorBox("Nem megfelelő adatot adtál meg darabszámnak. Legalább 0-val kell egyenlőnek lennie.", "Hiba", "Hiba történt!");
                }
                if(Integer.parseInt(texts.get(text).getText()) != 0 && !boxes.get(text).getSelectionModel().getSelectedItem().equals("-")){
                    sum += calories.get(text) * Integer.parseInt(texts.get(text).getText());
                }
            }

            try {
                ResultService.setSum(sum);
                sceneSwitch(dialogStage, "resultController", actionEvent);
            } catch (Exception e){
                errorBox("A program nem tud átlépni a következő oldalra, mert béna a programozója.", "Hiba", "Hiba történt!");
            }



        } catch (Exception e){
            errorBox("Nem megfelelő adatot adtál meg darabszámnak. Számot adj meg", "Hiba", "Hiba történt!");
        }
    }

}
