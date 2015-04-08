package math_screens;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import launch.Main;

import java.io.InputStream;


/**
 * Created by brian on 3/24/2015.
 */
public class MathGame extends MathScreen{
    private static MainScreen mainScreen;
    public MathGame(){
        super();

        EventHandler actionListener = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                if(mainScreen == null){
                    mainScreen = new MainScreen();
                }
                Main.getGameController().changeState(mainScreen);
            }
        };

        StackPane myStack = new StackPane();
       // this.getClass().getClassLoader().getResourceAsStream( "media/back.png");
        //URL url = this.getClass().getClassLoader().getResource("back.png");
        InputStream inputStream = this.getClass().getResourceAsStream("Media/back.png");
        Image back = new Image(inputStream);
        ImageView backImage = new ImageView(back);
        Button backButton = new Button();
        backButton.setPrefHeight(120);

        backButton.setPrefWidth(120);
        backButton.setStyle("-fx-background-color: transparent;");
        backButton.setOnAction(actionListener);
        myStack.setPrefHeight(120);
        myStack.setPrefWidth(120);
        myStack.getChildren().add(backImage);
        myStack.getChildren().add(backButton);
        myStack.setLayoutX(1250);
//        HBox hAlign = new HBox();
//        hAlign.getChildren().add(myStack);
//        hAlign.setAlignment(Pos.TOP_RIGHT);

        //myStack.setAlignment(Pos.TOP_RIGHT);
        getChildren().add(myStack);



    }
}
