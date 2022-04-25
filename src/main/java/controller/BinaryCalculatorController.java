package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.BinaryCalculatorModel;
import model.InvalidDivisionException;

public class BinaryCalculatorController {

    private BinaryCalculatorModel model;

    @FXML
    Label eredmenyLabel;

    @FXML
    private TextField elsoSzamText;

    @FXML
    private TextField masodikSzamText;

    @FXML
    public void initialize(){
        model = new BinaryCalculatorModel();
    }

    public void calculate(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();
        switch(button.getId()){
            case "osszeadas" -> eredmenyLabel.setText(model.binaryAdd(elsoSzamText.getText(),masodikSzamText.getText()));
            case "kivonas" -> eredmenyLabel.setText(model.binarySubtract(elsoSzamText.getText(),masodikSzamText.getText()));
            case "szorzas" -> eredmenyLabel.setText(model.binaryMultiply(elsoSzamText.getText(),masodikSzamText.getText()));
            case "osztas" -> {
                try{
                    eredmenyLabel.setText(model.binaryDivide(elsoSzamText.getText(),masodikSzamText.getText()));
                }catch(InvalidDivisionException e){
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("0-val nem lehet osztani");
                    a.show();
                }
            }
        }
    }
}
