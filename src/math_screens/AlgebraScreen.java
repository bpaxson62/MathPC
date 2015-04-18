package math_screens;


import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;
import launch.Configurations;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by brian on 3/14/2015.
 */
public class AlgebraScreen extends MathGame {
    private Timeline timeline;
    private Timeline timeline2;
    private Integer answers[];
    private String myEquation;
    private AnimationTimer timer;
    private ArrayList<Ball> circles;
    private ArrayList<StackPane> panes;
    //variable for storing actual frame
    private Integer i = 0;
    private Integer score;
    private Text myScoreTextValue;
    private Text myScoreEq;
    private Text scoreText;
    private Integer answer = 0;
    private Text myEquationText;
    private Rectangle scoreRectangle;
    private Button scoreButton;

    //    private Button scoreRectangle;
    public AlgebraScreen() {
        score = 0;
        GridPane myScoreGrid = new GridPane();
        StackPane stackScore = new StackPane();
        scoreText = new Text("Score: ");
        myScoreEq = new Text(myEquation);
        scoreRectangle = new Rectangle();
        scoreRectangle.setX(300);
        scoreRectangle.setY(150);
        scoreButton = new Button();
        scoreButton.setPrefSize(300, 150);
        scoreButton.setStyle(Configurations.backGroundStyle);
        myScoreTextValue = new Text(score.toString());
        GridPane.setConstraints(myScoreEq, 0, 0);
        GridPane.setConstraints(scoreText, 0, 1);
        GridPane.setConstraints(myScoreTextValue, 1, 1);
        GridPane.setHalignment(scoreText, HPos.RIGHT);
        GridPane.setHalignment(myScoreEq, HPos.CENTER);
        myScoreGrid.setVgap(30);
        scoreRectangle.setStyle(Configurations.backGroundStyle);
        myScoreGrid.getChildren().addAll(myScoreEq, scoreText, myScoreTextValue);
        stackScore.getChildren().addAll(scoreButton, scoreRectangle, myScoreGrid);
        stackScore.setTranslateX(Configurations.MAIN_SCREEN_WIDTH / 2.5);
        stackScore.setTranslateY(Configurations.MAIN_SCREEN_HEIGHT / 2.5);
        getChildren().add(stackScore);
        createLevel();
    }

    public void createLevel() {

        initialize();


        Collections.shuffle(panes);
        getChildren().addAll(panes);

        myScoreEq.setText(myEquation);
        play();
    }


    public void initialize() {
        Random rand = new Random();
        EventHandler<MouseEvent> myAction;
        answers = new Integer[9];
        createAnswers();
        circles = new ArrayList<Ball>();
        StackPane stack;
        Text myText;
        panes = new ArrayList<StackPane>();
        Ball myBall;
        double x = 100;
        double y = Configurations.MAIN_SCREEN_HEIGHT / 4;

        for (int i = 0; i < 9; i++) {
            stack = new StackPane();
            final Circle circle = new Circle(50, Color.web("1c89f4"));

            stack.setLayoutX(x += 150);
            stack.setLayoutY(y);
            if (i % 3 == 0 && i != 0 && i != 9) {
                y += 150;
                x = 100;
            }
            final Integer myIndex = i;
            myAction = new EventHandler<MouseEvent>() {


                public void handle(MouseEvent event) {
//                while (true) {
//                    checkShapeIntersection(circle);

                    if (answer.equals(Integer.parseInt(circles.get(myIndex).myText.getText()))) {
                        addScore();

                    } else {
                        circles.get(myIndex).ball.setFill(Color.RED);
                        subtractScore();
                    }

                    //}
                }
            };
            circle.addEventHandler(MouseEvent.MOUSE_PRESSED, myAction);
            myText = new Text();
            myText.setText(answers[i].toString());
            myText.setPickOnBounds(false);


            stack.getChildren().addAll(circle, myText);
            int dirY = (rand.nextInt(2) % 2 == 0) ? -1 : 1;
            int dirX = (rand.nextInt(2) % 2 == 0) ? -1 : 1;
            panes.add(stack);
            circles.add(new Ball(stack, circle, dirY, dirX, myText));
        }

//        initLevel();
//        initStartingTimeline();
        initTimeline();
//        initInfoPanel();
    }

    private void addScore() {


        createAnswers();

        for (int i = 0; i < answers.length; i++) {
            circles.get(i).myText.setText(Integer.toString(answers[i]));
            circles.get(i).ball.setFill(Color.web("1c89f4"));
        }
        myScoreEq.setText(myEquation);
        myScoreTextValue.setText(Integer.toString(Integer.valueOf(myScoreTextValue.getText()) + 1));
    }

    private void subtractScore() {
        myScoreTextValue.setText(Integer.toString(Integer.valueOf(myScoreTextValue.getText()) - 1));
    }


    public void initTimeline() {
        timeline = new Timeline();
        final StackPane tempPane;
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame kf;
        KeyFrame kf2;
        kf = new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                for (int i = 0; i < circles.size(); i++) {
                    checkBounds(circles.get(i));
                    circleIntersection(circles.get(i));
                    circles.get(i).pane.setTranslateX(circles.get(i).pane.getTranslateX() + circles.get(i).directionX * 1);
                    circles.get(i).pane.setTranslateY(circles.get(i).pane.getTranslateY() + circles.get(i).directionY * 1);
                }

            }
        });
//        kf2 = new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent event) {
//                for (int i = 0; i < circles.size(); i++) {
//                    checkBounds(circles.get(i));
//                    circleIntersection(circles.get(i));
//                    circles.get(i).pane.setTranslateX(circles.get(i).pane.getTranslateX() + circles.get(i).directionX * 500);
//                    circles.get(i).pane.setTranslateY(circles.get(i).pane.getTranslateY() + circles.get(i).directionY * 500);
//                }
//
//            }
//        });
        timeline.getKeyFrames().addAll(kf);
    }

    private void createAnswers() {
        Random rand = new Random(System.currentTimeMillis());
        int x = rand.nextInt(99);
        int z = rand.nextInt(99);
        int eqType = rand.nextInt(3);
        int myAnswer = 1;

        if (eqType == 0) {
            myEquation = "solve for, y  = " + x + "+ " + z;
            myAnswer = x + z;
        } else if (eqType == 1) {
            myEquation = "solve for, y  = " + x + "- " + z;
            myAnswer = x - z;
        } else if (eqType == 2) {
            myEquation = "solve for, y  = " + x + "* " + z;
            myAnswer = x * z;
        } else if (eqType == 3) {
            myEquation = "solve for, y = " + x + "/ " + z;
            myAnswer = x / z;
        }

        for (int i = 0; i < answers.length - 1; i++) {
            answers[i] = Utilities.randInt(myAnswer - 20, myAnswer + 20);
        }
        answers[answers.length - 1] = myAnswer;
        answer = myAnswer;
    }

    public void checkBounds(Ball myBall) {
        /*
        if ball hits walls
         */
//        System.out.println(getLayoutX());
//        System.out.println(getBoundsInLocal().getMaxX());
////        System.out.println(getLayoutY());
//        if (myBall.pane.getBoundsInParent().getMinX() <= getBoundsInLocal().getMinX() && myBall.pane.getBoundsInParent().getMinX() >= -10) {
//            myBall.directionX = 1;
//        }
//        if (myBall.pane.getBoundsInParent().getMaxX() >= getBoundsInLocal().getMaxX() && myBall.pane.getBoundsInParent().getMaxX() <= 1410) {
//            myBall.directionX = -1;
//        }
//        if (myBall.pane.getBoundsInParent().getMinY() <= getBoundsInLocal().getMinY() && myBall.pane.getBoundsInParent().getMinY() >= -30) {
//            myBall.directionY = 1;
//        }
//        if (myBall.pane.getBoundsInParent().getMaxY() >= getBoundsInLocal().getMaxY() - myBall.ball.getRadius()
//                && myBall.pane.getBoundsInParent().getMaxY() <= 730 - myBall.ball.getRadius()) {
//            myBall.directionY = -1;
//        }

        if (myBall.pane.getBoundsInParent().getMinX() <= 0 && myBall.pane.getBoundsInParent().getMinX() >= -5) {
            myBall.directionX = 1;
        }
        if (myBall.pane.getBoundsInParent().getMaxX() >= 1400 && myBall.pane.getBoundsInParent().getMaxX() <= 1405) {
            myBall.directionX = -1;
        }
        if (myBall.pane.getBoundsInParent().getMinY() <= 0 && myBall.pane.getBoundsInParent().getMinY() >= -5) {
            myBall.directionY = 1;
        }
        if (myBall.pane.getBoundsInParent().getMaxY() >= 700 - myBall.ball.getRadius()
                && myBall.pane.getBoundsInParent().getMaxY() <= 705 - myBall.ball.getRadius()) {
            myBall.directionY = -1;
        }

        /*
        if ball leaves screen
         */
        if ( myBall.pane.getBoundsInParent().getMinX() <= -10) {
            myBall.pane.setLayoutX(Configurations.MAIN_SCREEN_WIDTH / 2.5);
            myBall.pane.setLayoutY(Configurations.MAIN_SCREEN_HEIGHT / 2.5);
        }
        if (myBall.pane.getBoundsInParent().getMaxX() >= 1405) {
            myBall.pane.setLayoutX(Configurations.MAIN_SCREEN_WIDTH / 2.5);
            myBall.pane.setLayoutY(Configurations.MAIN_SCREEN_HEIGHT / 2.5);
        }
        if (myBall.pane.getBoundsInParent().getMinY() <= -10) {
            myBall.pane.setLayoutX(Configurations.MAIN_SCREEN_WIDTH / 2.5);
            myBall.pane.setLayoutY(Configurations.MAIN_SCREEN_HEIGHT / 2.5);
        }
        if (myBall.pane.getBoundsInParent().getMaxY() >= 710 - myBall.ball.getRadius()) {
            myBall.pane.setLayoutX(Configurations.MAIN_SCREEN_WIDTH / 2.5);
            myBall.pane.setLayoutY(Configurations.MAIN_SCREEN_HEIGHT / 2.5);
        }

//        if (myBall.pane.getBoundsInParent().getMaxY() >= 730 - myBall.ball.getRadius()
//                || myBall.pane.getBoundsInParent().getMinY() <= -30
//                || myBall.pane.getBoundsInParent().getMaxX() <= 1430
//                || myBall.pane.getBoundsInParent().getMinX() <= -30) {
//            myBall.pane.setLayoutX(Configurations.MAIN_SCREEN_WIDTH / 2.5);
//            myBall.pane.setLayoutY(Configurations.MAIN_SCREEN_HEIGHT / 2.5);
////        }
//        }
    }

    private void circleIntersection(Ball myBall) {
        Shape block = myBall.ball;

        for (final Ball myShape : circles) {
            if (myShape.ball != block) {


                Shape intersect = Shape.intersect(block, myShape.ball);

                if (intersect.getBoundsInLocal().getWidth() != -1 || intersect.getBoundsInLocal().getHeight() != -1 && myShape.activeBound != false) {
                    myBall.directionX *= -1;
                    myBall.directionY *= -1;
                    myShape.directionX *= -1;
                    myShape.directionY *= -1;
                    myBall.activeBound = false;
//                    new Timer().schedule(new TimerTask() {
//                        @Override
//                        public void run() {
//                            myShape.activeBound = true;
//                        }
//                    }, 2000);
                }
            }
        }
    }

    public void play() {
//        startingTimeline.play();
        timeline.play();

//        group.getChildren().get(0).requestFocus();
//        updateScore(0);
//        updateLives();
    }

    public void stop() {
        timeline.stop();
        timer.stop();

    }


}


class Ball {

    public Ball(StackPane myPane, Circle myCircle, int directionY, int directionX, Text myText) {
        pane = myPane;
        ball = myCircle;
        this.directionY = directionY;
        this.directionX = directionX;
        this.myText = myText;
        boolean activeBound = true;
    }

    boolean activeBound;
    public StackPane pane;
    Circle ball;
    int directionY;
    int directionX;
    Text myText;

}