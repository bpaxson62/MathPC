package math_screens;

import javafx.scene.Group;
import javafx.scene.Parent;
import launch.Configurations;

/**
 * Created by brian on 3/14/2015.
 */
public class MathScreen extends Parent{
    private Group myGroup;
    public MathScreen(){
        myGroup = new Group();
        myGroup.prefHeight(Configurations.MAIN_SCREEN_HEIGHT + 2*Configurations.WINDOW_BOARDER);
        myGroup.prefWidth(Configurations.MAIN_SCREEN_WIDTH + 2* Configurations.WINDOW_BOARDER);
        getChildren().add(myGroup);
        //getChildren().add(new Text(500,500,"hello"));
    }

}
