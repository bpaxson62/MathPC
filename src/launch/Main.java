package launch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import math_screens.MainScreen;

public class Main extends Application {

    private static RootController rootController;
    public static RootController getGameController(){
        return rootController;
    }
    private void init(Stage primaryStage) {

        //BorderPane borderPane = new BorderPane();
//        final TabPane tabPane = new TabPane();
//        tabPane.setPrefSize(520, 360);
//        tabPane.setSide(Side.TOP);
//        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
//        final Tab tab1 = new Tab();
//        tab1.setText("Geometry");
//
//        tab1.setContent(new Rectangle(200,200, Color.LIGHTSTEELBLUE));

        //tab1.setContent();

//        final Tab tab2 = new Tab();
//        tab2.setText("Quadratic");
//        final Tab tab3 = new Tab();
//        tab3.setText("Agebra");
//        final Tab tab4 = new Tab();
//        tab4.setText("Plot Function");



//        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
        //borderPane.setCenter(tabPane);
        //root.getChildren().add(borderPane);
    }

    @Override public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        //primaryStage.setScene(new Scene(root));
        rootController = new RootController(root);
        primaryStage.setTitle("Math PC");
        primaryStage.setResizable(false);
        primaryStage.setWidth(Configurations.MAIN_SCREEN_WIDTH + 2*Configurations.WINDOW_BOARDER);
        primaryStage.setHeight(Configurations.MAIN_SCREEN_HEIGHT + 2*Configurations.WINDOW_BOARDER);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        primaryStage.show();
        rootController.changeState(new MainScreen());
        //init(primaryStage);
        //primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}