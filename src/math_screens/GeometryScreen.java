package math_screens;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;
import launch.Configurations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by brian on 3/14/2015.
 */
public class GeometryScreen extends MathGame {
    private HashMap<Shape, String> equationMap = new HashMap<Shape, String>();
    private EventHandler<MouseEvent> myAction;
    private ArrayList<MyShape> myShapes = new ArrayList<MyShape>();
    public static ArrayList<StackPane> rectangles = new ArrayList<StackPane>();
    public static ArrayList<Rectangle> rectangles2 = new ArrayList<Rectangle>();
    public static ArrayList<Text> rectangles3 = new ArrayList<Text>();
    private Text text1 = new Text();
    private Text text2= new Text();
    private Text text3 = new Text();
    private ArrayList<String> equations = new ArrayList<String>();



    public GeometryScreen() {
        String arr[] = new String[]{"(x−h)2+(y−k)2=r2","p = 2L + 2W","p = 4*Length"};
        for(String myEq : arr){
            equations.add(myEq);
        }
        rectangles3.add(text1);
        rectangles3.add(text2);
        rectangles3.add(text3);
        Circle myCircle = new Circle(50);
        myCircle.setStyle(Configurations.shapeStyle);
        final MyShape circle = new MyShape(myCircle);
        myShapes.add(circle);
        myCircle.setVisible(false);
        myCircle.setLayoutX(Configurations.MAIN_SCREEN_WIDTH / 2);
        myCircle.setLayoutY(Configurations.MAIN_SCREEN_HEIGHT - 150);
        circle.equation = "(x−h)2+(y−k)2=r2";

        Rectangle myRect = new Rectangle(150,100);
        myRect.setStyle(Configurations.shapeStyle);
        final MyShape rectangle = new MyShape(myRect);
        myShapes.add(rectangle);
        myRect.setVisible(false);
        myRect.setLayoutX(Configurations.MAIN_SCREEN_WIDTH / 2);
        myRect.setLayoutY(Configurations.MAIN_SCREEN_HEIGHT - 150);
        rectangle.equation = "p = 2L + 2W";


        Rectangle meSquare = new Rectangle(150,150);
        meSquare.setStyle(Configurations.shapeStyle);
        final MyShape square = new MyShape(meSquare);
        myShapes.add(square);
        meSquare.setVisible(false);
        meSquare.setLayoutX(Configurations.MAIN_SCREEN_WIDTH / 2);
        meSquare.setLayoutY(Configurations.MAIN_SCREEN_HEIGHT - 200);
        square.equation = "p = 4*Length";
//        myCircle.setCenterX(200);
//        myCircle.setCenterY(200);

        rectangles.add(new StackPane());
        rectangles.add(new StackPane());
        rectangles.add(new StackPane());
        HBox myHbox = new HBox(100);
        for(int i =0; i<3; i++){
            Rectangle rect = new Rectangle(300,200);
            rectangles2.add(rect);
            rect.setStyle(Configurations.answers);
            rectangles.get(i).getChildren().add(rect);
            rectangles.get(i).getChildren().add(rectangles3.get(i));
            myHbox.getChildren().add(rectangles.get(i));
        }
        myHbox.setAlignment(Pos.CENTER);
        myHbox.setLayoutY(50);
        myHbox.setLayoutX(Configurations.MAIN_SCREEN_WIDTH/10);


        myAction = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {



                System.out.println(event.getScreenX());
                Shape myShape = (Shape) event.getSource();
                System.out.println(myShape.getLayoutX());
                MyShape getShape = null;
                for(MyShape shape : myShapes){
                    if(myShape.equals(shape.myShape)){
                        getShape = shape;
                    }
                }
                System.out.println("event " + event.getX());
                if(event.getX()<40 && event.getX() > -40){
                    getShape.direction= new int[]{0,-10};
                }
                if(event.getX() <-40){
                    getShape.direction= new int[]{-10,-10};
                }
                if(event.getX()>40){
                    getShape.direction= new int[]{10,-10};
                };
//                circle.direction = new int[]{0, 1}
                getShape.timeline.playFromStart();


            }
        };
        myRect.addEventHandler(MouseEvent.MOUSE_DRAGGED, myAction);
        myCircle.addEventHandler(MouseEvent.MOUSE_DRAGGED, myAction);
        meSquare.addEventHandler(MouseEvent.MOUSE_DRAGGED, myAction);

        initMainTimeline();
    getChildren().addAll(myHbox, myCircle,myRect, meSquare);
    }

    public void initMainTimeline() {
        final Timeline myTime = new Timeline();
        myTime.setCycleCount(Animation.INDEFINITE);

        KeyFrame kf;
        kf = new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
//                for (int i = 0; i < GeometryScreen.rectangles.size(); i++) {
                boolean gameAdd = true;
                for (int i = 0; i < myShapes.size(); i++) {
                    if (myShapes.get(i).status == 1) {
                        gameAdd = false;
                    }
                    if (gameAdd == true && i == myShapes.size() - 1) {
                    }
                }
                if (gameAdd == true) {
                    Collections.shuffle(myShapes);
//                    myShapes.get(0).myShape.setLayoutX(Configurations.MAIN_SCREEN_WIDTH / 2);
//                    myShapes.get(0).myShape.setLayoutY(Configurations.MAIN_SCREEN_HEIGHT - 150);

                    myShapes.get(0).myShape.setTranslateX(0);
                    myShapes.get(0).myShape.setTranslateY(0);
                    myShapes.get(0).status = 1;
                    myShapes.get(0).myShape.setVisible(true);
                    Collections.shuffle(equations);
                    boolean findEq = false;
                    int count = 0;
                    String equations1[] = new String[2];
                    while(findEq == false){
                        for(int i =0; i<equations.size(); i++){
                            if(!equations.get(i).equals(myShapes.get(0).equation)){
                                equations1[count] = equations.get(i);
                                count++;
                                if(count ==2){
                                    findEq=true;
                                    break;

                                }

                            }
                        }
                    }
                    String myEquations[] = new String[]{myShapes.get(0).equation,equations1[0],equations1[1] };
                    for(int i =0; i<3;i++){
                        rectangles2.get(i).setStyle(Configurations.answers);
                        rectangles3.get(i).setText(myEquations[i]);
                    }


                }
            }
        });
        myTime.getKeyFrames().add(kf);
        myTime.playFromStart();

    }

    public static boolean shapeIntersection(MyShape shape1) {
        Shape block = shape1.myShape;

        for (int i =0; i<3; i++) {


                Shape intersect = Shape.intersect(block, rectangles2.get(i));

                if (intersect.getBoundsInLocal().getWidth() != -1) {
                    System.out.println("truth");
                    if(shape1.equation.equals(rectangles3.get(i).getText())){
                        rectangles2.get(i).setStyle(Configurations.shapeStyle);

                    }else{
                        rectangles2.get(i).setStyle(Configurations.wrongAnswer);
                    }
                    return true;

                }

        }
        return false;
    }


}

class MyShape {
    public MyShape(final Shape shape) {
        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        myShape = shape;
        status = 0;
        KeyFrame kf;
        direction = new int[]{0,0};
        final MyShape setThis = this;
        kf = new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
//                for (int i = 0; i < GeometryScreen.rectangles.size(); i++) {
                if (GeometryScreen.shapeIntersection(setThis)) {
                    timeline.stop();
                    shape.setVisible(false);
                    status = 0;

                }
                shape.setTranslateX(shape.getTranslateX() + direction[0]);
                shape.setTranslateY(shape.getTranslateY() + direction[1]);
//                }
            }
        });
        timeline.getKeyFrames().add(kf);
    }

    public void setDirection() {

    }

    //    public int[] getDirection(){
//
//        return int[] = {0,1};
//    }
    int[] direction;
    Timeline timeline;

    HashMap<Shape, String> equationMap = new HashMap<Shape, String>();
    String equation;
    Shape myShape;
    int status;
}
