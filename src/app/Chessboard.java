package app;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 * Displays an 8x8 checkerboard with a chess piece and three randomly chosen Egyption Hieroglyphics
 */
public class Chessboard extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        CreateCheckerBoard(primaryStage).show();
        CreateHieroglyphics(new Stage()).show();
    }
    public static void main(String[] args) throws Exception
    {
        launch(args);
    }
    public Stage CreateCheckerBoard(Stage stage)
    {
        GridPane grid = new GridPane();
        grid.heightProperty().addListener((obs, oldVal, newVal) -> // Anchors the Height of the objects in the grid to the grid itself
        {
            double height = (double)newVal;
            for(Node node : grid.getChildren())
            {
                if(node instanceof Rectangle)
                {
                    ((Rectangle)node).setHeight(height/8);
                }
                if(node instanceof ImageView)
                {
                    ((ImageView)node).setFitHeight(height/8);
                }
            }
        });
        grid.widthProperty().addListener((obs, oldVal, newVal) -> // Anchors the width
        {
            double width = (double)newVal;
            for(Node node : grid.getChildren())
            {
                if(node instanceof Rectangle)
                {
                    ((Rectangle)node).setWidth(width/8);
                }
                if(node instanceof ImageView)
                {
                    ((ImageView)node).setFitWidth(width/8);
                }
            }
        });
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++) // J is the xpos i is the ypos
            {
                if(i == 2 && j == 0)
                {
                    Image img = new Image("file:src/app/Images/black_king.png");
                    ImageView iv = new ImageView(img);
                    iv.setFitWidth(75);
                    iv.setFitHeight(75);
                    iv.setPreserveRatio(true);
                    grid.add(iv, j, i);
                    continue;
                }
                Rectangle rect = new Rectangle(75, 75);
                if((i + j) % 2 == 0) { rect.setFill(Color.RED); }
                else { rect.setFill(Color.BLACK); }
                rect.setX(j * rect.getWidth());
                rect.setY(i * rect.getHeight());
                grid.add(rect, j, i);
            }
        }
        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.setTitle("Chessboard / CheckerBoard");
        return stage;
    }
    public Stage CreateHieroglyphics(Stage stage)
    {
        GridPane grid = new GridPane();
        Random random = new Random();
        for(int i = 0; i < 3; i++)
        {
            int rand = random.nextInt(61);
            System.out.println(rand);
            Image glyph = new Image("file:src/app/Images/Hieroglyphics/" + rand + ".png");
            System.out.println(glyph.getUrl());
            ImageView iv = new ImageView(glyph);
            iv.autosize();
            grid.add(iv, i, 0);
        }
        stage.setScene(new Scene(grid));
        return stage;
    }
}