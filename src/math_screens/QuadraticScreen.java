package math_screens;

import javafx.scene.control.Button;

/**
 * Created by brian on 3/14/2015.
 */
public class QuadraticScreen extends MathGame{

    public QuadraticScreen(){
        super();
        Button myButton = new Button();
        myButton.setText("hello Raspberry pi");
        myButton.prefWidth(500);
        myButton.prefHeight(500);
        myButton.setLayoutY(250);
        myButton.setLayoutX(250);
        getChildren().add(myButton);
    }
}
