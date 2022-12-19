package app;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 * Displays a 10x10 grid of buttons and a 10x10 grid of randomly generated 0s and 1s
 */
public class Lund_lab5a extends Application {
  @Override
  public void start(Stage primaryStage) {
    GridPane gp = new GridPane();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        Button btn = new Button();
        btn.setPrefHeight(25);
        btn.setPrefWidth(25);
        gp.add(btn, j, i);
      }
    }
    HBox box = new HBox(gp);
    box.setAlignment(Pos.CENTER);
    Scene sc = new Scene(box);
    primaryStage.setScene(sc);
    primaryStage.setTitle("Lab 5: JavaFX Basics");
    primaryStage.show();
    // Part B
    Random rand = new Random();
    GridPane gp2 = new GridPane();
    for(int i = 0; i < 10; i++)
    {
      for(int j = 0; j < 10; j++)
      {
        TextField tf = new TextField();
        tf.setPrefHeight(25);
        tf.setPrefWidth(25);
        tf.setText(rand.nextInt(2) + "");
        tf.setAlignment(Pos.CENTER);
        gp2.add(tf, j, i);
      }
    }
    HBox box2 = new HBox(gp2);
    box.setAlignment(Pos.CENTER);
    Scene scene2 = new Scene(box2);
    Stage secondaryStage = new Stage();
    secondaryStage.setScene(scene2);
    secondaryStage.show();
  }
  public static void main(String[] args) throws Exception
  { 
    launch(args);
  }
}
