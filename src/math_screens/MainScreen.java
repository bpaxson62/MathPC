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


        GridPane myGrid = new GridPane();
        myGrid.setPrefSize(Configurations.MAIN_SCREEN_WIDTH + 2* Configurations.WINDOW_BOARDER,
                Configurations.MAIN_SCREEN_HEIGHT + 2*Configurations.WINDOW_BOARDER);

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
        //algebraButton.setId();
        String buttonStyle = " -fx-background-color:\n" +
                "    linear-gradient(#ffd65b, #e68400),\n" +
                "    linear-gradient(#ffef84, #f2ba44),\n" +
                "    linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" +
                "    linear-gradient(#f6ebbe, #e6c34d)\n" +
                "    linear-gradient(#ffea6a, #efaa22),\n" +
                "    linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,2,3,0;\n" +
                "    -fx-text-fill: #654b00;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-padding: 10 20 10 20;";


        algebraButton.setStyle(buttonStyle);
        geometryButton.setStyle(buttonStyle);
        functionButton.setStyle(buttonStyle);
        quadraticButton.setStyle(buttonStyle);


        myGrid.add(algebraButton, 0, 0);
        myGrid.add(geometryButton, 0, 1);
        myGrid.add(functionButton, 1, 0);
        myGrid.add(quadraticButton, 1, 1);

        getChildren().add(myGrid);
    }


}
