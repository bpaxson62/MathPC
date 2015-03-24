package math_screens;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import launch.Configurations;
import launch.Main;




/**
 * Created by brian on 3/24/2015.
 */
public class MainScreen extends MathScreen {
    Button algebraButton;
    Button geometryButton;
    Button functionButton;
    Button quadraticButton;
    public MainScreen() {
        super();
//        StackPane myStack = new StackPane();
//        myStack.setPrefSize(Configurations.MAIN_SCREEN_WIDTH + 2* Configurations.WINDOW_BOARDER,
//                Configurations.MAIN_SCREEN_HEIGHT + 2*Configurations.WINDOW_BOARDER);

        GridPane myGrid = new GridPane();
        myGrid.setPrefSize(Configurations.MAIN_SCREEN_WIDTH + 2* Configurations.WINDOW_BOARDER,
                Configurations.MAIN_SCREEN_HEIGHT + 2*Configurations.WINDOW_BOARDER);
       // myStack.getChildren().add(myGrid);

       // myStack.setAlignment(myGrid,Pos.CENTER);
        myGrid.setPadding(new Insets(150, 100, 150, 100));
        myGrid.setVgap(50);
        myGrid.setHgap(50);
        algebraButton = new Button("Algebra");
        geometryButton = new Button("Geometry");
        functionButton = new Button("Function Plot");
        quadraticButton = new Button("Quadratic");

        algebraButton.setPrefHeight(150);
        algebraButton.setPrefWidth(250);
        geometryButton.setPrefHeight(150);
        geometryButton.setPrefWidth(250);
        functionButton.setPrefHeight(150);
        functionButton.setPrefWidth(250);
        quadraticButton.setPrefHeight(150);
        quadraticButton.setPrefWidth(250);

        EventHandler actionListener = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                if (e.getSource() == algebraButton){
                    Main.getGameController().changeState(new AlgebraScreen());
                }else if(e.getSource() == geometryButton){
                    Main.getGameController().changeState(new GeometryScreen());
                }else if(e.getSource() == functionButton){
                    Main.getGameController().changeState(new FunctionPlotScreen());
                }else if(e.getSource() == quadraticButton){
                    Main.getGameController().changeState(new QuadraticScreen());
                }
            }
        };

        algebraButton.setOnAction(actionListener);
        geometryButton.setOnAction(actionListener);
        functionButton.setOnAction(actionListener);
        quadraticButton.setOnAction(actionListener);

//        myButton1.setAlignment(Pos.CENTER);
//        myButton2.setAlignment(Pos.CENTER);
//        myButton3.setAlignment(Pos.CENTER);
//        myButton4.setAlignment(Pos.CENTER);

        myGrid.add(algebraButton, 0, 0);
        myGrid.add(geometryButton, 0, 1);
        myGrid.add(functionButton, 1, 0);
        myGrid.add(quadraticButton, 1, 1);
//        myGrid.setAlignment(Pos.CENTER);
//        myButton.setText("hell;
//o Raspberry pi");
//        myButton.prefWidth(500);
//        myButton.prefHeight(500);
//        myButton.setLayoutY(250);
//        myButton.setLayoutX(250);
        getChildren().add(myGrid);
    }


}
