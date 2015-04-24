package math_screens;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import launch.Configurations;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Random;

import static java.lang.Math.*;


public class QuadraticScreen extends MathGame{
	
    TextField operand1 = new TextField("0");
    TextField operand2 = new TextField("0");
    TextField operand3 = new TextField("0");

    //TextField operand1 = TextFieldBuilder.create().promptText("Enter Coefficient A").build();

    TextField root_result_1 = new TextField(null);
    TextField root_result_2 = new TextField(null);

    Button submit = new Button("Submit");
    
    Button generate = new Button("Make");


    static double root1=0;
    static double root2=0;
    static double discriminant=0;

    static double op1 =0;
    static double op2 =0;
    static double op3 =0;
    
    static double a=0;
    static double b=0;
    static double c=0;
    static double x=0;
    static double vertex_y=0;
    static double y_int=0;
    
    static double a2=0;
    static double b2=0;
    static double c2=0;
    static double x2=0;
    static double vertex_y2=0;
    static double y_int2=0;
    
    static double a3=0;
    static double b3=0;
    static double c3=0;
    static double x3=0;
    static double vertex_y3=0;
    static double y_int3=0;


    Double extractDouble(final String possibleNumber)
    {
        Double extractedNumber;
        try
        {
            extractedNumber = new Double(possibleNumber);
        }
        catch (NumberFormatException nfe)
        {
            extractedNumber = null;
        }
        return extractedNumber;
    }

    //@Override
    public Number fromString(String text) {
        return Double.valueOf(text);
    }

    public static void quadraticEquationRoots(Double a, Double b, Double c){

        discriminant = Math.pow(b, 2) - (4 * a * c);
        root1 = ((-1 * b) + Math.sqrt(discriminant)) / (2 * a);
        root2 = ((-1 * b) - Math.sqrt(discriminant)) / (2 * a);

        System.out.println ("Root #1: " + root1);
        System.out.println ("Root #2: " + root2);

    }

    public static double get_root1(){

        return root1;
    }

    public static double get_root2(){

        return root2;
    }
    
    public static void generate_num(){
   	   //populating the series with data
       //f(x) = ax^2 + bx + c
       int max=10;
       int min= 0;
       
       int max1=0;
       int min1= -10;
       
       Random random = new Random();
       a = random.nextInt(max - min + 1) + min;
       System.out.println("The value of a from method: "+  a); 

       b = random.nextInt(max - min + 1) + min;
       System.out.println("The value of b from method: "+  b); 

       c = random.nextInt(max1 - min1 + 1) + min1;
       System.out.println("The value of c from method: "+  c); 

       x = (-(b/(2*a)));
       
       System.out.println("The value of x: "+  x); 
       
       vertex_y =((a*Math.pow(x,2))+(b*x)+c);
       
       System.out.println("VERTEX "+vertex_y);
        y_int = (a*0)+(b*0)+c;
       System.out.println("y_int: "+y_int+"\n");
   }
    
    public static void generate_num2(){
    	   //populating the series with data
        //f(x) = ax^2 + bx + c
        int max=10;
        int min= 0;
        
        int max1=0;
        int min1= -10;
        
        Random random = new Random();
        a2 = random.nextInt(max - min + 1) + min;
        System.out.println("The value of a from method: "+  a2); 

        b2 = random.nextInt(max - min + 1) + min;
        System.out.println("The value of b from method: "+  b2); 

        c2 = random.nextInt(max1 - min1 + 1) + min1;
        System.out.println("The value of c from method: "+  c2); 

        x2 = (-(b2/(2*a2)));
        
        System.out.println("The value of x: "+  x2); 
        
        vertex_y2 =((a2*Math.pow(x2,2))+(b*x2)+c2);
        
        System.out.println("VERTEX "+vertex_y2);
         y_int = (a2*0)+(b2*0)+c;
        System.out.println("y_int: "+y_int2+"\n");
    }
    
    public static void generate_num3(){
    	   //populating the series with data
        //f(x) = ax^2 + bx + c
        int max=10;
        int min= 0;
        
        int max1=0;
        int min1= -10;
        
        Random random = new Random();
        a3 = random.nextInt(max - min + 1) + min;
        System.out.println("The value of a from method: "+  a3); 

        b3 = random.nextInt(max - min + 1) + min;
        System.out.println("The value of b from method: "+  b3); 

        c3 = random.nextInt(max1 - min1 + 1) + min1;
        System.out.println("The value of c from method: "+  c3); 

        x3 = (-(b3/(2*a3)));
        
        System.out.println("The value of x: "+  x3); 
        
        vertex_y3 =((a3*Math.pow(x3,2))+(b3*x3)+c3);
        
        System.out.println("VERTEX "+vertex_y3);
         y_int3 = (a3*0)+(b3*0)+c3;
        System.out.println("y_int: "+y_int3+"\n");
    	
    }

    public QuadraticScreen(){
        super();
           
        final NumberAxis xAxis1 = new NumberAxis();
        final NumberAxis yAxis1= new NumberAxis();
        
        final NumberAxis xAxis2 = new NumberAxis();
        final NumberAxis yAxis2 = new NumberAxis();
        
        final NumberAxis xAxis3 = new NumberAxis();
        final NumberAxis yAxis3 = new NumberAxis();
        
        xAxis1.setLabel("X-axis");
        yAxis1.setLabel("Y-axis");
        
        xAxis2.setLabel("X-axis");
        yAxis2.setLabel("Y-axis");
        
        xAxis3.setLabel("X-axis");
        yAxis3.setLabel("Y-axis");
        
          //creating the chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis1,yAxis1);//1
 
        final LineChart<Number,Number> lineChart2 = new LineChart<Number,Number>(xAxis2,yAxis2);//2
        
        final LineChart<Number,Number> lineChart3 = new LineChart<Number,Number>(xAxis3,yAxis3);//3
 
        lineChart.setPrefHeight(400);
        lineChart.setPrefWidth(400);
       
        lineChart2.setPrefHeight(400);
        lineChart2.setPrefWidth(400);
        
        lineChart3.setPrefHeight(400);
        lineChart3.setPrefWidth(400);
        
       // lineChart.setTitle("Quadratic Plot 1");
       // lineChart2.setTitle("Quadratic Plot 2");

        //defining a series
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();

        series.setName("A");
        series2.setName("B");
        series3.setName("C");

        generate_num();
        System.out.println("The value of a: "+  a); 
        System.out.println("The value of b: "+  b); 
        System.out.println("The value of c: "+  c); 
        System.out.println("The value of x: "+  x); 
        System.out.println("The value of vertex_y: "+  vertex_y+"\n"); 
        
		series.getData().add(new XYChart.Data(x, vertex_y));
        series.getData().add(new XYChart.Data(c, 0)); 
        series.getData().add(new XYChart.Data(a, 0)); 

        generate_num2();
        System.out.println("The value of a: "+  a2); 
        System.out.println("The value of b: "+  b2); 
        System.out.println("The value of c: "+  c2); 
        System.out.println("The value of x: "+  x2); 
        System.out.println("The value of vertex_y: "+  vertex_y2); 

        series2.getData().add(new XYChart.Data(x2, vertex_y2));
        series2.getData().add(new XYChart.Data(c2, 0)); 
        series2.getData().add(new XYChart.Data(a2, 0)); 

        generate_num3();
        System.out.println("The value of a: "+  a3); 
        System.out.println("The value of b: "+  b3); 
        System.out.println("The value of c: "+  c3); 
        System.out.println("The value of x: "+  x3); 
        System.out.println("The value of vertex_y: "+  vertex_y3); 

        series3.getData().add(new XYChart.Data(x3, vertex_y3));
        series3.getData().add(new XYChart.Data(c3, 0)); 
        series3.getData().add(new XYChart.Data(a3, 0)); 
        
        lineChart.getData().add(series);
        lineChart2.getData().add(series2);  
        lineChart3.getData().add(series3);        

        getChildren().addAll(lineChart);
        getChildren().addAll(lineChart2); 
        getChildren().addAll(lineChart3);  
        
        GridPane plot_grid = new GridPane();
        
        plot_grid.setVgap(30);
        plot_grid.setHgap(30);

        plot_grid.setLayoutX(3);
        plot_grid.setLayoutY(20);
        
        plot_grid.setConstraints(lineChart, 0, 0);
        plot_grid.setConstraints(lineChart2, 1, 0);
        plot_grid.setConstraints(lineChart3, 2, 0);
        
        getChildren().add(plot_grid);

        plot_grid.getChildren().addAll(lineChart,lineChart2,lineChart3);
       
        //String answer = quadraticEquationRoot1(operand1.getCharacters(), operand2.getCharacters(), operand3.getCharacters());

        //submit.onMouseClickedProperty(root_result_1.setText());

        submit.setStyle(Configurations.buttonStyle);

        submit.setPrefSize(200,100);
        
        generate.setStyle(Configurations.buttonStyle);
        generate.setPrefSize(200,100);

        GridPane.setConstraints(operand1,0,0);

        GridPane.setConstraints(operand2,1,0);

        GridPane.setConstraints(operand3,0,1);

        GridPane.setConstraints(submit, 1,1);

        GridPane.setConstraints(root_result_1, 0,0);

        GridPane.setConstraints(root_result_2, 0,1);
        
        GridPane.setConstraints(generate, 1,1);

/*
        double operand1_buff = double.parseInt(operand1.getCharacters().toString());
        int number = Integer.parseInt(cs.toString());

        double operand2_buff =
        double operand2_buff = submit.onActionProperty(quadraticEquationRoots(operand1,operand2,operand3));
*/
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                // label.setText("Accepted");
                op1 = Double.parseDouble(operand1.getText());
                System.out.println("value of op1 "+ op1);
                op2 = Double.parseDouble(operand2.getText());
                op3 = Double.parseDouble(operand3.getText());
                quadraticEquationRoots(op1, op2, op3);
                System.out.print(get_root1()+" "+get_root2());
                root_result_1.setText(String.valueOf(get_root1()));
                root_result_2.setText(String.valueOf(get_root2()));
                
            	//System.out.println("get root1 "+ get_root1() +"get_root2() "+ get_root2() + "c "+ c +"a "+a);               
                if(get_root1()==c&&get_root2()==a){
                	//System.out.println("get root1 "+ get_root1() +"get_root2() "+ get_root2() + "c "+ c +"a "+a);
                	System.out.println("CORRECT FOR GRAPH 1");
                }
                
                if(get_root1()==c2&&get_root2()==a2){
                	//System.out.println("get root1 "+ get_root1() +"get_root2() "+ get_root2() + "c "+ c +"a "+a);
                	System.out.println("CORRECT FOR GRAPH 2");
                }
                
                if(get_root1()==c3&&get_root2()==a3){
                	//System.out.println("get root1 "+ get_root1() +"get_root2() "+ get_root2() + "c "+ c +"a "+a);
                	System.out.println("CORRECT FOR GRAPH 3");
                }       
/*
                System.out.println("Series 1 print " + series.getData().get(1));//first part of graph a on y plane
                System.out.println("Series 1 print " + series.getData().get(2));//first part of graph a on y plane
               
                System.out.println("Series 2 print " + series2.getData().get(1));//first part of graph b on y plane
                System.out.println("Series 2 print " + series2.getData().get(2));//first part of graph b on y plane

                System.out.println("Series  3 print " + series3.getData().get(1));//first part of graph c on y plane
                System.out.println("Series  3 print " + series3.getData().get(2));//second part of graph c on y plane
*/              
            }
        });
        
        generate.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

            	  generate_num();
                  System.out.println("The value of a: "+  a); 
                  System.out.println("The value of b: "+  b); 
                  System.out.println("The value of c: "+  c); 
                  System.out.println("The value of x: "+  x); 
                  System.out.println("The value of vertex_y: "+  vertex_y+"\n"); 
                  
          		series.getData().add(new XYChart.Data(x, vertex_y));
                  series.getData().add(new XYChart.Data(c, 0)); 
                  series.getData().add(new XYChart.Data(a, 0)); 

                  generate_num2();
                  System.out.println("The value of a: "+  a2); 
                  System.out.println("The value of b: "+  b2); 
                  System.out.println("The value of c: "+  c2); 
                  System.out.println("The value of x: "+  x2); 
                  System.out.println("The value of vertex_y: "+  vertex_y2); 

                  series2.getData().add(new XYChart.Data(x2, vertex_y2));
                  series2.getData().add(new XYChart.Data(c2, 0)); 
                  series2.getData().add(new XYChart.Data(a2, 0)); 

                  generate_num3();
                  System.out.println("The value of a: "+  a3); 
                  System.out.println("The value of b: "+  b3); 
                  System.out.println("The value of c: "+  c3); 
                  System.out.println("The value of x: "+  x3); 
                  System.out.println("The value of vertex_y: "+  vertex_y3); 

                  series3.getData().add(new XYChart.Data(x3, vertex_y3));
                  series3.getData().add(new XYChart.Data(c3, 0)); 
                  series3.getData().add(new XYChart.Data(a3, 0)); 
                  
                  lineChart.getData().add(series);
                  lineChart2.getData().add(series2);  
                  lineChart3.getData().add(series3);   
            	
            }
        });
        
/*
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println(textField.getText());

            }
        });
*/

        //  GridPane.setConstraints(operand4,1,1);

//        GridPane.setConstraints(label1,0,1,3,1);

        GridPane grid = new GridPane();
        GridPane result_grid = new GridPane();

        result_grid.setVgap(30);
        result_grid.setHgap(50);

        grid.setVgap(30);
        grid.setHgap(30);

        result_grid.setLayoutX(750);
        result_grid.setLayoutY(450);

        grid.setLayoutX(250);
        grid.setLayoutY(450);

        getChildren().add(grid);
        getChildren().add(result_grid);

        grid.getChildren().addAll(operand1, operand2, operand3, submit);
        result_grid.getChildren().addAll(root_result_1, root_result_2,generate);

    }
	
}
