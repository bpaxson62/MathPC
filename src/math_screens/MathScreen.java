package math_screens;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import launch.Configurations;

import java.util.Random;

/**
 * Created by brian on 3/14/2015.
 */
public class MathScreen extends Parent{
    private Pane myPane;
    public MathScreen(){
        myPane = new Pane();
        myPane.prefHeight(Configurations.MAIN_SCREEN_HEIGHT + 2*Configurations.WINDOW_BOARDER);
        myPane.prefWidth(Configurations.MAIN_SCREEN_WIDTH + 2* Configurations.WINDOW_BOARDER);
        Random rand = new Random(System.currentTimeMillis());
        String eq1 = "y = ";
        String eq2 = "x + ";


        for (int i = 0; i < 100; i++) {
            int x = rand.nextInt(Configurations.MAIN_SCREEN_HEIGHT + 2*Configurations.WINDOW_BOARDER);
            int y = rand.nextInt(Configurations.MAIN_SCREEN_WIDTH + 2* Configurations.WINDOW_BOARDER);
            int red = rand.nextInt(255);
            int green = rand.nextInt(255);
            int blue = rand.nextInt(255);
            Text text = new Text(x, y, eq1 + rand.nextInt(99) + eq2+rand.nextInt(99));
            int rot = rand.nextInt(360);
            text.setFill(Color.rgb(red, green, blue, .99));
            text.setRotate(rot);
            myPane.getChildren().add(text);
        }
        myPane.setStyle("-fx-background-color: #6bb0cd;");

        getChildren().add(myPane);
        //getChildren().add(new Text(500,500,"hello"));
    }

}
