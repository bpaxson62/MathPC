package math_screens;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import launch.Configurations;
import launch.Main;
import javafx.scene.text.*;


/**
 * Created by brian on 3/24/2015.
 */
public class MainScreen extends MathScreen {
    Button algebraButton;
    Button geometryButton;
    Button functionButton;
    Button quadraticButton;
    private static AlgebraScreen algebraScreen;
    private static FunctionPlotScreen functionPlotScreen;
    private static GeometryScreen geometryScreen;
    private static QuadraticScreen quadraticScreen;
    public MainScreen() {
        super();


        GridPane myGrid = new GridPane();
        myGrid.setPrefSize(Configurations.MAIN_SCREEN_WIDTH + 2* Configurations.WINDOW_BOARDER,
                Configurations.MAIN_SCREEN_HEIGHT + 2*Configurations.WINDOW_BOARDER);

        myGrid.setPadding(new Insets(150, 100, 150, 100));
        myGrid.setVgap(50);
        myGrid.setHgap(50);
        
        Text t = new Text(10, 50, "This is a test");
        t.setFont(new Font(40));
                
        algebraButton = new Button("Algebra");
       // algebraButton.setStyle("-fx-font-size: 40pt;");
        algebraButton.setFont(new Font(40));

        geometryButton = new Button("Geometry");
        functionButton = new Button("Plotting");
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
                    if (algebraScreen==null){
                        algebraScreen = new AlgebraScreen();
                    }
                    Main.getGameController().changeState(algebraScreen);
            }else if(e.getSource() == geometryButton){
                    if (geometryScreen==null){
                        geometryScreen = new GeometryScreen();
                    }
                    Main.getGameController().changeState(geometryScreen);
                }else if(e.getSource() == functionButton){
                    if (algebraScreen==null){
                        functionPlotScreen = new FunctionPlotScreen();
                    }
                    Main.getGameController().changeState(functionPlotScreen);
                }else if(e.getSource() == quadraticButton){
                    if (quadraticScreen==null){
                        quadraticScreen = new QuadraticScreen();
                    }
                    Main.getGameController().changeState(quadraticScreen);
                }
            }
        };

        algebraButton.setOnAction(actionListener);
        geometryButton.setOnAction(actionListener);
        functionButton.setOnAction(actionListener);
        quadraticButton.setOnAction(actionListener);
        //algebraButton.setId();



        algebraButton.setStyle(Configurations.buttonStyle);
        geometryButton.setStyle(Configurations.buttonStyle);
        functionButton.setStyle(Configurations.buttonStyle);
        quadraticButton.setStyle(Configurations.buttonStyle);


        myGrid.add(algebraButton, 0, 0);
        myGrid.add(geometryButton, 0, 1);
        myGrid.add(functionButton, 1, 0);
        myGrid.add(quadraticButton, 1, 1);

        getChildren().add(myGrid);
    }


}
