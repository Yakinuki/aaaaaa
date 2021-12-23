import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainscreenContoller implements Initializable {

    @FXML
    public Button PLAYButton;
    @FXML
    public javafx.scene.layout.AnchorPane AnchorPane;
    @FXML
    private Button scoreboardButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void launchEasy(ActionEvent event) {
       /* Logic.playAudio(new File("C:\\Users\\Deniz\\Desktop\\Test\\Sounds\\CreditClick.wav"));*/

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("configuration.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage x = (Stage) AnchorPane.getScene().getWindow();
            x.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void showScore(ActionEvent event) {

    }
}
