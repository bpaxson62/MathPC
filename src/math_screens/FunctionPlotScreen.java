package math_screens;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.scene.text.*;


/**
 * Created by geoff on 4/10/2015.
 */
public class FunctionPlotScreen extends MathGame{

    static double eq1=0;
    static double eq2=0;

    public FunctionPlotScreen(){

        Text t = new Text();
        t.setFont(new Font(50));
        t.setWrappingWidth(200);
        t.setTextAlignment(TextAlignment.JUSTIFY);
        t.setText("y=mx+b");

        final TextField function_field = new TextField("0");
        final TextField function_field2 = new TextField("0");
        Button submit = new Button("Submit");

        GridPane text_grid = new GridPane();
        GridPane grid = new GridPane();

        grid.setVgap(30);
        grid.setHgap(50);

        grid.setLayoutX(750);
        grid.setLayoutY(250);

        text_grid.setVgap(30);
        text_grid.setHgap(50);

        text_grid.setLayoutX(750);
        text_grid.setLayoutY(180);

        GridPane.setConstraints(t,0,0);

        GridPane.setConstraints(function_field,0,0);
        GridPane.setConstraints(function_field2,1,0);
        GridPane.setConstraints(submit,0,1);

        getChildren().add(grid);
        getChildren().add(text_grid);

        grid.getChildren().addAll(function_field,function_field2, submit);
        text_grid.getChildren().addAll(t);


        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X-axis");
        yAxis.setLabel("Y-axis");
        //creating the chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);


        /////
        //event handler
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                // label.setText("Accepted");

                double eq1 = Double.parseDouble(function_field.getText());
                double eq2 = Double.parseDouble(function_field2.getText());
                //System.out.println("Equation Entered:  "+ eq);
                //quadraticEquationRoots(op1, op2, op3);
                //System.out.print(get_root1()+" "+get_root2());
                //root_result_1.setText(String.valueOf(get_root1()));
                //root_result_2.setText(String.valueOf(get_root2()));

              

                lineChart.setPrefHeight(700);
                lineChart.setPrefWidth(700);

                
                lineChart.setTitle("Plotting Y equation");
                //defining a series
                XYChart.Series series = new XYChart.Series();
                series.setName("Plotted points");
                //populating the series with data
                series.getData().add(new XYChart.Data(0, eq1));
                series.getData().add(new XYChart.Data(eq2, eq1+1));

                /*
                series.getData().add(new XYChart.Data(2, 14));
                series.getData().add(new XYChart.Data(3, 15));
                series.getData().add(new XYChart.Data(4, 24));
                series.getData().add(new XYChart.Data(5, 34));
                series.getData().add(new XYChart.Data(6, 36));
                series.getData().add(new XYChart.Data(7, 22));
                series.getData().add(new XYChart.Data(8, 45));
                series.getData().add(new XYChart.Data(9, 43));
                series.getData().add(new XYChart.Data(10, 17));
                series.getData().add(new XYChart.Data(11, 29));
                series.getData().add(new XYChart.Data(12, 25));
                */

                lineChart.getData().add(series);
                getChildren().addAll(lineChart);

            }
        });

    }
}
