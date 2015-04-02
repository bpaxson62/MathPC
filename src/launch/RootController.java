package launch;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;

public class RootController{

    private Group root; //Instance of scene game node
    private int lifePoints;  //Users life points
    private int score; //Users Score
    private int difficulty;

    RootController(Group mathScreen){
        this.root = mathScreen;
    }


    public void setScore(int score) {
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public int getLifePoints(){
        return lifePoints;
    }

    public int getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(){
        this.difficulty = difficulty;
    }

    public void decreaseLifePoints(){
        lifePoints--;
    }

    public void gameStart(){
        lifePoints=10;
        score = 0;
        difficulty = 1; //Need to make this set by user with default of 1(easy)
       // changeState(1);
    }




    public void increaseScore(){

    }

    public void changeState(Parent mathScreen) {
        //Group myGroup = new Group();
        ObservableList<Node> abc = root.getChildren();
        root.getChildren().removeAll(abc);
        root.getChildren().add(mathScreen);
        //root.setCenter(new Level(0));
        //root.setCenter(myGroup);

        //border.setCenter();
    }



}
