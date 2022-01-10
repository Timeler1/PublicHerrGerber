package com.example.currencycalculator;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CurrencyCalculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CurrencyCalculator.class.getResource("graphsc1.fxml"));
        Parent root = fxmlLoader.load();
        Scene insideofstage = new Scene(root);
        stage.setTitle("Currency Calculator");
        IntroSceneController controller = fxmlLoader.getController();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("dogeicon.png")));
        stage.setScene(insideofstage);
        stage.show();
        insideofstage.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent){

                if (keyEvent.getCode() == KeyCode.ENTER){
                    String text = controller.textAbbreviation.getText();
                    double value;
                    try {
                        value = main.getvalue(text);
                    }
                    catch (Exception e){
                        value = 0.0;
                    }
                    System.out.println(value);
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            launch(args);
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}