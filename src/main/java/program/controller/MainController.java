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
import program.utility.Manager;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;



public class MainController {

    @FXML
    public ChoiceBox food1;
    @FXML
    public TextField amount1;
    @FXML
    public Label food1Label;
    @FXML
    public ChoiceBox food2;
    @FXML
    public TextField amount2;
    @FXML
    public Label food2Label;
    @FXML
    public ChoiceBox food3;
    @FXML
    public Label food3Label;
    @FXML
    public TextField amount3;
    @FXML
    public ChoiceBox food4;
    @FXML
    public Label food4Label;
    @FXML
    public TextField amount4;
    @FXML
    public TextField amount5;
    @FXML
    public TextField amount6;
    @FXML
    public Label food5Label;
    @FXML
    public Label food6Label;
    @FXML
    public ChoiceBox food5;
    @FXML
    public ChoiceBox food6;

    private FoodService foodService;
    private FoodEntity foodEntity;

    List<String> foods = Arrays.asList("tej","tojás","cukor","liszt","alma","talicska");
    List<ChoiceBox> boxes = Arrays.asList(food1,food2,food3,food4,food5,food6);

    @FXML
    private void initialize(){

        foodService = new FoodServiceImpl(new FoodDAOImpl(Manager.getInstance()));
    }


    @FXML
    public void calculate(ActionEvent actionEvent) {

        int sum = 0;
        int actValue = 0;

        float amount;

        for(ChoiceBox box : boxes){

            String foodName = box.getSelectionModel().getSelectedItem().toString();
            amount = Integer.parseInt(food1Label.getText());
            if(foodName != null){
                foodEntity = foodService.getFood(foodName);


                actValue = (int) (foodEntity.getKcal() * amount);
            }
        }




        try {
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            Scene newScene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("/views/resultController.fxml"))));
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
