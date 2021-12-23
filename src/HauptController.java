import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HauptController implements Initializable {
    @FXML
    public Label number1;
    @FXML
    public Label operator1;
    @FXML
    public Label number2;
    @FXML
    public Label operator2;
    @FXML
    public Label number3;
    @FXML
    public Label operator3;
    @FXML
    public Label number4;
    @FXML
    public Label correct;
    @FXML
    public Label wrong;
    @FXML
    private TextField answerfield;
    @FXML
    private AnchorPane anchorPane;

    Integer ri = 0;
    Integer wr = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUp();
        answerfield.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                try {
                    if (ke.getCode().equals(KeyCode.ENTER)) {
                        if (answerfield.getText().equals("")) {
                            Logic.playAudio(new File("C:\\Users\\Deniz\\Desktop\\Test\\Sounds\\Wrong.wav"));
                        }
                        if (Integer.parseInt(answerfield.getText()) == Logic.solution) {
                            Logic.generateMath(Logic.operator, Logic.diff);
                            setUp();
                            answerfield.clear();
                            ri++;
                            correct.setText(String.valueOf(ri));
                            Logic.playAudio(new File("C:\\Users\\Deniz\\Desktop\\Test\\Sounds\\Pickup_Coin7.wav"));
                        } else {
                            wr++;
                            wrong.setText(String.valueOf(wr));
                            Logic.playAudio(new File("C:\\Users\\Deniz\\Desktop\\Test\\Sounds\\Wrong.wav"));
                        }
                    }
                } catch (NumberFormatException e) {
                    ViewHelper.showError("Please enter a number");
                }

            }
        });

        answerfield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    answerfield.setText(newValue.replaceAll("[^\\d]", ""));
                    Logic.playAudio(new File("C:\\Users\\Deniz\\Desktop\\Test\\Sounds\\Character_Sound.wav"));
                } else {
                    Logic.playAudio(new File("C:\\Users\\Deniz\\Desktop\\Test\\Sounds\\Blip_Select12.wav"));
                }
            }
        });


    }

    @FXML
    public void whenUserTypes(KeyEvent event) {
        answerfield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    answerfield.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    public void userResult(ActionEvent actionEvent) {

    }

    public void setUp() {
        correct.setText(String.valueOf(ri));
        wrong.setText(String.valueOf(wr));
        if (Logic.displayedOperator.equals(" : ")) {
            operator1.setText(Logic.displayedOperator);
            number1.setText(String.valueOf(Logic.v1));
            number2.setText(String.valueOf(Logic.v2));

            number3.setText(null);
            number4.setText(null);
            operator3.setText(null);
            operator2.setText(null);
        } else {
            operator1.setText(Logic.displayedOperator);
            operator2.setText(Logic.displayedOperator);
            operator3.setText(Logic.displayedOperator);

            number1.setText(String.valueOf(Logic.v1));
            number2.setText(String.valueOf(Logic.v2));
            number3.setText(String.valueOf(Logic.v3));
            number4.setText(String.valueOf(Logic.v4));
        }
    }

}