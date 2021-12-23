import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class creditController implements Initializable {
    public AnchorPane Pane;

    public void onClick(MouseEvent mouseEvent) {
        Logic.playAudio(new File("C:\\Users\\Deniz\\Desktop\\Test\\Sounds\\CreditClick.wav"));
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Mainscreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
            Stage x = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
            x.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void startTime(ActionEvent event){
        Logic.playAudio(new File("C:\\Users\\Deniz\\Desktop\\Test\\Sounds\\CreditClick.wav"));
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Stage stage = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("Mainscreen.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("Login");
                    stage.show();
                    Node node = (Node) event.getSource();
                    Stage thisStage = (Stage) node.getScene().getWindow();
                    thisStage.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 2000);
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       /* startTime(new ActionEvent());*/
    }
}
