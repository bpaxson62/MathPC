package math_screens;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import launch.Configurations;

/**
 * Created by brian on 3/14/2015.
 */

public class QuadraticScreen extends MathGame{
    Button a1 = new Button("Cat");
    Button a2 = new Button("Dog");
    Button a3 = new Button("Horse");
    Button a4 = new Button("Horse");
    Label label1 = new Label("Hi");
    Label label2 = new Label("");
    Label label3 = new Label("");
    Label label4 = new Label("");


    public QuadraticScreen(){
        super();


        a1.setStyle(Configurations.buttonStyle);
        a2.setStyle(Configurations.buttonStyle);
        a3.setStyle(Configurations.buttonStyle);
        a4.setStyle(Configurations.buttonStyle);

        a1.setPrefSize(200,100);
        a2.setPrefSize(200,100);
        a3.setPrefSize(200,100);
        a4.setPrefSize(200,100);



        GridPane.setConstraints(a1,0,0);

        GridPane.setConstraints(a2,1,0);

        GridPane.setConstraints(a3,0,1);

        GridPane.setConstraints(a4,1,1);

//        GridPane.setConstraints(label1,0,1,3,1);

        GridPane grid = new GridPane();

        grid.setVgap(30);

        grid.setHgap(30);

        grid.setLayoutX(250);
        grid.setLayoutY(250);

        getChildren().add(grid);

        grid.getChildren().addAll(a1, a2, a3, a4);



    }
}
