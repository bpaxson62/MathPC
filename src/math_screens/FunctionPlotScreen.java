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
///
        Text t = new Text();
        t.setFont(new Font(40));
        t.setWrappingWidth(200);
        t.setTextAlignment(TextAlignment.JUSTIFY);
        t.setText("f(x)=mx+b");
        
        Text t2 = new Text();
        t2.setFont(new Font(40));
        t2.setWrappingWidth(200);
        t2.setTextAlignment(TextAlignment.JUSTIFY);
        t2.setText("f(x)=n^x");
        
        Text t3 = new Text();
        t3.setFont(new Font(40));
        t3.setWrappingWidth(200);
        t3.setTextAlignment(TextAlignment.JUSTIFY);
        t3.setText("f(x)=sqrt(x)");
        
        Text t4 = new Text();
        t4.setFont(new Font(40));
        t4.setWrappingWidth(200);
        t4.setTextAlignment(TextAlignment.JUSTIFY);
        t4.setText("f(x)=|x|");
        
        Text t5 = new Text();
        t5.setFont(new Font(40));
        t5.setWrappingWidth(200);
        t5.setTextAlignment(TextAlignment.JUSTIFY);
        t5.setText("f(x)=ln(x)");
///
        final TextField function_field = new TextField("0");
        final TextField function_field2 = new TextField("0");
        Button submit = new Button("tSubmit");

        final TextField function_field3 = new TextField("x");
        Button submit2 = new Button("Submit");
        
        final TextField function_field4 = new TextField("0");
        Button submit3 = new Button("Submit");
        
        final TextField function_field5 = new TextField("0");
        Button submit4 = new Button("Submit");
        
        final TextField function_field6 = new TextField("0");
        Button submit5 = new Button("Submit");
///
        GridPane text_grid = new GridPane();
        GridPane grid = new GridPane();
        
        GridPane text_grid2 = new GridPane();
        GridPane grid2 = new GridPane();
        
        GridPane text_grid3 = new GridPane();
        GridPane grid3 = new GridPane();
        
        GridPane text_grid4 = new GridPane();
        GridPane grid4 = new GridPane();
        
        GridPane text_grid5 = new GridPane();
        GridPane grid5 = new GridPane();
///
        grid.setVgap(10);
        grid.setHgap(50);

        grid.setLayoutX(750);
        grid.setLayoutY(120);

        text_grid.setVgap(30);
        text_grid.setHgap(50);

        text_grid.setLayoutX(750);
        text_grid.setLayoutY(70);
///        
        grid2.setVgap(10);
        grid2.setHgap(50);

        grid2.setLayoutX(750);
        grid2.setLayoutY(250);

        text_grid2.setVgap(30);
        text_grid2.setHgap(50);

        text_grid2.setLayoutX(750);
        text_grid2.setLayoutY(210);
///     
        grid3.setVgap(10);
        grid3.setHgap(50);

        grid3.setLayoutX(750);
        grid3.setLayoutY(350);

        text_grid3.setVgap(30);
        text_grid3.setHgap(50);

        text_grid3.setLayoutX(750);
        text_grid3.setLayoutY(300);  
 ///     
        grid4.setVgap(10);
        grid4.setHgap(50);

        grid4.setLayoutX(750);
        grid4.setLayoutY(450);

        text_grid4.setVgap(30);
        text_grid4.setHgap(50);

        text_grid4.setLayoutX(750);
        text_grid4.setLayoutY(400);   
///
        grid5.setVgap(10);
        grid5.setHgap(50);

        grid5.setLayoutX(750);
        grid5.setLayoutY(550);

        text_grid5.setVgap(30);
        text_grid5.setHgap(50);

        text_grid5.setLayoutX(750);
        text_grid5.setLayoutY(500);   
 ///
        GridPane.setConstraints(t,0,0);

        GridPane.setConstraints(function_field,0,0);
        GridPane.setConstraints(function_field2,1,0);
        GridPane.setConstraints(submit,0,1);
 ///
        text_grid2.setConstraints(t2, 0, 0);
        text_grid2.setConstraints(function_field3, 1, 1);
        text_grid2.setConstraints(submit2, 0, 1);
 ///       
        text_grid3.setConstraints(t3, 0, 0);
        text_grid3.setConstraints(function_field4, 1, 1);
        text_grid3.setConstraints(submit3, 0, 1);
///       
        text_grid4.setConstraints(t4, 0, 0);
        text_grid4.setConstraints(function_field5, 1, 1);
        text_grid4.setConstraints(submit4, 0, 1);    
///       
        text_grid5.setConstraints(t5, 0, 2);
        text_grid5.setConstraints(function_field6, 1, 1);
        text_grid5.setConstraints(submit5, 0, 1);  
///
        getChildren().add(grid);
        getChildren().add(text_grid);
///
        getChildren().add(grid2);
        getChildren().add(text_grid2);
///
        getChildren().add(grid3);
        getChildren().add(text_grid3);   
///
        getChildren().add(grid4);
        getChildren().add(text_grid4);
///
        getChildren().add(grid5);
        getChildren().add(text_grid5);  
 ///
        grid2.getChildren().addAll(function_field3,submit2);
        text_grid2.getChildren().addAll(t2);  
///
        grid.getChildren().addAll(function_field,function_field2, submit);
        text_grid.getChildren().addAll(t);
///
        grid3.getChildren().addAll(function_field4,submit3);
        text_grid3.getChildren().addAll(t3);          
///
        grid4.getChildren().addAll(function_field5,submit4);
        text_grid4.getChildren().addAll(t4);   
///
        grid5.getChildren().addAll(function_field6,submit5);
        text_grid4.getChildren().addAll(t5);           
///
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
                series.setName("f(x)=mx+b");
                //populating the series with data
                series.getData().add(new XYChart.Data(0, eq1));
                series.getData().add(new XYChart.Data(eq2, eq1+1));               

                lineChart.getData().add(series);
                getChildren().addAll(lineChart);

            }
        });
        
        submit2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                // label.setText("Accepted");

                double eq3 = Double.parseDouble(function_field3.getText());
                //double eq2 = Double.parseDouble(function_field2.getText());
                //System.out.println("Equation Entered:  "+ eq);
                //quadraticEquationRoots(op1, op2, op3);
                //System.out.print(get_root1()+" "+get_root2());
                //root_result_1.setText(String.valueOf(get_root1()));
                //root_result_2.setText(String.valueOf(get_root2()));         
                lineChart.setPrefHeight(700);
                lineChart.setPrefWidth(700);
                //lineChart.setTitle("Plotting Y equation");
                //defining a series
                XYChart.Series series = new XYChart.Series();
                series.setName("f(x)=n^x");
                //populating the series with data
                for (int i=0;i<5; i++){
                	series.getData().add(new XYChart.Data(i, i*eq3*i));
                }
               // series.getData().add(new XYChart.Data(eq2, eq1+1));               

                lineChart.getData().add(series);
                getChildren().addAll(lineChart);

            }
        });
        submit3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                // label.setText("Accepted");

                double eq4 = Double.parseDouble(function_field4.getText());
      
                lineChart.setPrefHeight(700);
                lineChart.setPrefWidth(700);
                //lineChart.setTitle("Plotting Y equation");
                //defining a series
                XYChart.Series series = new XYChart.Series();
                series.setName("f(x)=sqrt(x)");
                //populating the series with data
                int n=0;
                for  (int i=(int) eq4;i<15; i++){
                	series.getData().add(new XYChart.Data(n,Math.sqrt(i)));
                	n++;
                }
               // series.getData().add(new XYChart.Data(eq2, eq1+1));               

                lineChart.getData().add(series);
                getChildren().addAll(lineChart);

            }
        });
        submit4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                // label.setText("Accepted");

                double eq5 = Math.abs(Double.parseDouble(function_field5.getText()));
      
                lineChart.setPrefHeight(700);
                lineChart.setPrefWidth(700);
                //lineChart.setTitle("Plotting Y equation");
                //defining a series
                XYChart.Series series = new XYChart.Series();
                series.setName("f(x)=|x|");
                //populating the series with data
                for (int i=0;i<10; i++){
                	series.getData().add(new XYChart.Data(i,eq5));
                	
                }
               // series.getData().add(new XYChart.Data(eq2, eq1+1));               
                lineChart.getData().add(series);
                getChildren().addAll(lineChart);

            }
        });
        
        submit5.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                // label.setText("Accepted");

                double eq6 = (Double.parseDouble(function_field6.getText()));
      
                lineChart.setPrefHeight(700);
                lineChart.setPrefWidth(700);
                //lineChart.setTitle("Plotting Y equation");
                //defining a series
                XYChart.Series series = new XYChart.Series();
                series.setName("f(x)=ln(x)");
                //populating the series with data
                for (int i=0;i<10; i++){
                	series.getData().add(new XYChart.Data(i,Math.log(eq6)));
                }
               // series.getData().add(new XYChart.Data(eq2, eq1+1));               
                lineChart.getData().add(series);
                getChildren().addAll(lineChart);

            }
        });

    }
}
