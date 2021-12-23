import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Logic {
    static int v1 = 0;
    static int v2 = 0;
    static int v3 = 0;
    static int v4 = 0;
    static Random rand = new Random();
    static String operator = "" ;
    static String displayedOperator = "" ;
    static String diff = "";

    static int solution = 0;



    public static void generateNumbers(int max, int min){
        v1 = rand.nextInt((max - min) + 1) + min;
        v2 = rand.nextInt((max - min) + 1) + min;
        v3 = rand.nextInt((max - min) + 1) + min;
        v4 = rand.nextInt((max - min) + 1) + min;
    }
    public static void saveInfo(String Operator){
        switch (Operator){
            case "Addition" : displayedOperator = " + "; operator = "Addition"; break;
            case "Subtraction" : displayedOperator  = " - ";operator = "Subtraction"; break;
            case "Multiplication" : displayedOperator  = " * ";operator = "Multiplication"; break;
            case "Division" : displayedOperator  = " : ";operator = "Division"; break;
        }
    }

    public static int generateNumber(int max, int min){
        return rand.nextInt((max - min) + 1) + min;

    }

    public static void generateMath(String operator,String difficulty){
        diff = difficulty;
        switch (difficulty){
            case "Easy" :
                generateNumbers(10,1);
                switch (operator) {
                    case "Addition":
                        solution = v1 + v2 + v3 + v4;
                        break;
                    case "Subtraction":
                        solution = v1 - v2 - v3 - v4;
                        if (solution < 0) {
                            generateMath(operator, difficulty);
                        }
                        break;
                    case "Multiplication":
                        solution = v1 * v2 * v3 * v4;
                        if (solution > 500) {
                            generateMath(operator, difficulty);
                        }
                        break;
                    case "Division":
                        solution = v1 / v2 ;
                        while (v1 < v2 || v1 % v2 != 0 || v1 == v2) {
                            // while (!(v1 >= v2 && v1 % v2 == 0)) {
                           /*generateNumbers(50,1);*/
                            v1 = generateNumber(100,50);
                            v2 = generateNumber(50,3);
                            solution = v1 / v2;
                        }
                        System.out.println(v1 + " " + v2 );
                }
                break;
            case "Medium" :
                generateNumbers(200,1);
                switch (operator) {
                    case "Addition":
                        solution = v1 + v2 + v3 + v4;
                        break;
                    case "Subtraction":
                        solution = v1 - v2 - v3 - v4;
                        if (solution < 0) {
                            generateMath(operator, difficulty);
                        }
                        break;
                    case "Multiplication":
                        solution = v1 * v2 * v3 * v4;
                        break;
                    case "Division":
                        solution = v1 / v2 ;
                        System.out.println(solution);
                        while (v1 < v2 || v1 % v2 != 0 || v1 == v2 ) {
                            v1 = generateNumber(300,50);
                            v2 = generateNumber(150,3);
                            solution = v1 / v2;
                        }
                }
                break;
            case"Hard" :
                generateNumbers(200,-100);
                switch (operator) {
                    case "Addition":
                        solution = v1 + v2 + v3 + v4;
                        break;
                    case "Subtraction":
                        solution = v1 - v2 - v3 - v4;
                        if (solution < 0) {
                            generateMath(operator, difficulty);
                        }
                        break;
                    case "Multiplication":
                        solution = v1 * v2 * v3 * v4;
                        break;
                    case "Division":
                        solution = v1 / v2 ;
                        while (v1 < v2 || v1 % v2 != 0 ) {
                            v1 = generateNumber(1000,50);
                            v2 = generateNumber(500,3);
                            solution = v1 / v2 ;
                        }
                }
                break;
        }
    }


    public static void playAudio(File file){
        try {
            Clip clip = null;
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(String.valueOf(file))));
            clip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayAll(){
        System.out.println(
            "Number 1 : "+ v1 +
                    ""


        );


    }
}
