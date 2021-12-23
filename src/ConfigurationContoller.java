import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfigurationContoller implements Initializable {

    public javafx.scene.layout.AnchorPane AnchorPane;
    @FXML
    public MenuButton ButtonMenuOp;
    @FXML
    public MenuButton ButtonMenuDiff;
    @FXML
    public Label OPLabel;
    @FXML
    public Label DiffLabel;
    @FXML
    private TextField Enter;
    @FXML
    private MenuItem einfach;
    @FXML
    private MenuItem geteilt;
    @FXML
    private MenuItem mittel;
    @FXML
    private MenuItem multiplikation;
    @FXML
    private MenuItem plus;
    @FXML
    private MenuItem schwer;
    @FXML
    private Button startButton;
    @FXML
    private MenuItem subtraktion;
    @FXML
    void startGameButton(ActionEvent event) {
        if(!(OPLabel.getText() == "") && !(DiffLabel.getText() == "")) {
            try {
                Logic.generateMath(OPLabel.getText(), DiffLabel.getText());
                Logic.saveInfo(OPLabel.getText());
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("haupt.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                Stage x = (Stage) AnchorPane.getScene().getWindow();
                x.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            ViewHelper.showError("Please Select an operator and a difficulty !");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void setDivision(ActionEvent actionEvent) {
        OPLabel.setText("Division");
    }

    public void setAddition(ActionEvent actionEvent) {
        OPLabel.setText("Addition");
    }

    public void setMultiplication(ActionEvent actionEvent) {
        OPLabel.setText("Multiplication");
    }

    public void setSubtraction(ActionEvent actionEvent) {
        OPLabel.setText("Subtraction");
    }

    public void setEasy(ActionEvent actionEvent) {
        DiffLabel.setText("Easy");
    }

    public void setMedium(ActionEvent actionEvent) {
        DiffLabel.setText("Medium");
    }

    public void setHard(ActionEvent actionEvent) {
        DiffLabel.setText("Hard");
    }
}

