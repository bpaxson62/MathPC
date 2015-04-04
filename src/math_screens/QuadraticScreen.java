package math_screens;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import launch.Configurations;

import java.awt.*;
import java.math.BigDecimal;

import static java.lang.Math.*;


public class QuadraticScreen extends MathGame{

    TextField operand1 = new TextField("0");
    TextField operand2 = new TextField("0");
    TextField operand3 = new TextField("0");

    //TextField operand1 = TextFieldBuilder.create().promptText("Enter Coefficient A").build();

    TextField root_result_1 = new TextField(null);
    TextField root_result_2 = new TextField(null);

    Button submit = new Button("Submit");

    Label label1 = new Label("Hi");
    Label label2 = new Label("");
    Label label3 = new Label("");
    Label label4 = new Label("");

    static double root1=0;
    static double root2=0;
    static double discriminant=0;


    static double op1 =0;
    static double op2 =0;
    static double op3 =0;
/*
    Double op1 = Double.valueOf(String.valueOf(operand2));
    Double op2 = Double.valueOf(String.valueOf(operand2));
    Double op3 = Double.valueOf(String.valueOf(operand3));
*/
    Double extractDouble(final String possibleNumber)
    {
        Double extractedNumber;
        try
        {
            extractedNumber = new Double(possibleNumber);
        }
        catch (NumberFormatException nfe)
        {
            extractedNumber = null;
        }
        return extractedNumber;
    }

    //@Override
    public Number fromString(String text) {
        return Double.valueOf(text);
    }

    public static void quadraticEquationRoots(Double a, Double b, Double c){

        discriminant = Math.pow(b, 2) - (4 * a * c);
        root1 = ((-1 * b) + Math.sqrt(discriminant)) / (2 * a);
        root2 = ((-1 * b) - Math.sqrt(discriminant)) / (2 * a);

        System.out.println ("Root #1: " + root1);
        System.out.println ("Root #2: " + root2);

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
        double operand2_buff = submit.onActionProperty(quadraticEquationRoots(operand1,operand2,operand3));
*/

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                // label.setText("Accepted");
                op1 = Double.parseDouble(operand1.getText());
                System.out.println("value of op1 "+ op1);
                op2 = Double.parseDouble(operand2.getText());
                op3 = Double.parseDouble(operand3.getText());
                quadraticEquationRoots(op1, op2, op3);
                System.out.print(get_root1()+" "+get_root2());
                root_result_1.setText(String.valueOf(get_root1()));
                root_result_2.setText(String.valueOf(get_root2()));

            }
        });


/*
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println(textField.getText());

            }
        });
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
