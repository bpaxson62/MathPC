package math_screens;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import launch.Configurations;

import static java.lang.Math.*;

/**
 * Created by brian on 3/14/2015.
 */

public class QuadraticScreen extends MathGame{
    TextField operand1 = new TextField("Operand 1");
    TextField operand2 = new TextField("Operand 2");
    TextField operand3 = new TextField("Operand 3");

    TextField root_result_1 = new TextField(null);
    TextField root_result_2 = new TextField(null);

    Button submit = new Button("Submit");

    Label label1 = new Label("Hi");
    Label label2 = new Label("");
    Label label3 = new Label("");
    Label label4 = new Label("");

    static int root1;
    static int root2;

    public static void quadraticEquationRoots(double a, double b, double c){

        double temp1 = Math.sqrt(b * b - 4 * a * c);

        double root1 = (-b +  temp1) / (2*a) ;
        double root2 = (-b -  temp1) / (2*a) ;
    }

    public static double get_root1(){

        return root1;
    }

    public static double get_root2(){

        return root2;
    }

    public QuadraticScreen(){
        super();

        //String answer = quadraticEquationRoot1(operand1.getCharacters(), operand2.getCharacters(), operand3.getCharacters());

        //submit.onMouseClickedProperty(root_result_1.setText());

        submit.setStyle(Configurations.buttonStyle);

        submit.setPrefSize(200,100);

        GridPane.setConstraints(operand1,0,0);

        GridPane.setConstraints(operand2,1,0);

        GridPane.setConstraints(operand3,0,1);

        GridPane.setConstraints(submit, 1,1);

        GridPane.setConstraints(root_result_1, 0,0);

        GridPane.setConstraints(root_result_2, 0,1);
/*
        double operand1_buff = double.parseInt(operand1.getCharacters().toString());
        int number = Integer.parseInt(cs.toString());

        double operand2_buff =
        double operand2_buff =

                submit.onActionProperty(quadraticEquationRoots(operand1,operand2,operand3));
*/

        //  GridPane.setConstraints(operand4,1,1);

//        GridPane.setConstraints(label1,0,1,3,1);

        GridPane grid = new GridPane();
        GridPane result_grid = new GridPane();

        result_grid.setVgap(30);
        result_grid.setHgap(50);

        grid.setVgap(30);
        grid.setHgap(30);

        result_grid.setLayoutX(750);
        result_grid.setLayoutY(250);


        grid.setLayoutX(250);
        grid.setLayoutY(250);

        getChildren().add(grid);
        getChildren().add(result_grid);


        grid.getChildren().addAll(operand1, operand2, operand3, submit);
        result_grid.getChildren().addAll(root_result_1, root_result_2);




    }
}
