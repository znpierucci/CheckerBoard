/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboardznpcp5;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author zacharypierucci
 */
public class CheckerBoard {
    
    private double width;
    private double height;
    private int rows;
    private int columns;
    private double rectangleWidth;
    private double rectangleHeight;
    private Color light = Color.RED;
    private Color dark = Color.BLACK;
    private Color[] colors = {light, dark};
    private AnchorPane anchorPane;
    

    public CheckerBoard(int rows, int columns, double width, double height) {
        this.rows = rows;
        this.columns = columns;
        this.width = width;
        this.height = height;
        this.light = light;
        this.dark = dark;
        
        colors[0] = light;
        colors[1] = dark;
        
        anchorPane = new AnchorPane();
    }

    public CheckerBoard(int rows, int columns, double width, double height, Color light, Color dark) {
        this(rows, columns, width, height);
        
        this.light = light;
        this.dark = dark;   
    }
    
    /*
    public GridPane build(double width, double height) {
        clear();
        this.width = width;
        this.height = height;
        rectangleWidth = Math.ceil(width / (double)columns);
        rectangleHeight = Math.ceil(height / (double)rows);
        gridPane.setPrefWidth(width);
        gridPane.setPrefHeight(height);
        
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <columns; col++) {
                Color color = colors[(col + row)%2];
                Rectangle rect = new Rectangle(rectangleWidth, rectangleHeight, color);
                
                gridPane.add(rect, row, col);
            }

            
        }
        
        
        return gridPane;
    }
    */
    
    
    public AnchorPane build() {
        clear();
        
        //rectangleWidth = Math.ceil(width / (double)columns);
        //rectangleHeight = Math.ceil(height / (double)rows);
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <columns; col++) {
                
                //Rectangle rectangle = new Rectangle();
                Rectangle rectangle = new Rectangle(getRectangleWidth(), getRectangleHeight());
                
                this.anchorPane.getChildren().add(rectangle);
                
                rectangle.setTranslateX(getRectangleWidth() * row);
                rectangle.setTranslateY(getRectangleHeight() * col);
                        
//                rectangle.setHeight(rectangleHeight);
//                rectangle.setWidth(rectangleWidth);
//                rectangle.setX(rectangleWidth * col);
//                rectangle.setY(rectangleHeight * row);
                
                if ((row + col) % 2 == 0) {
                    rectangle.setFill(light);
                    //rectangle = new Rectangle(rectangleWidth, rectangleHeight, this.light);
                } else {
                    rectangle.setFill(dark);
                    //rectangle = new Rectangle(rectangleWidth, rectangleHeight, this.dark);
                }
                
                //anchorPane.getChildren().add(rectangle);
                
                //rectangle.setTranslateX(rectangleWidth * row);
                //rectangle.setTranslateY(rectangleHeight * col);
            }
        
            
        }
        
        return anchorPane;
    }
    
    /*
    public void clear() {
        if (gridPane != null) {
            gridPane.getChildren().clear();
        }
    }
    */
    
    public void clear() {
        if (anchorPane != null) {
            anchorPane.getChildren().clear();
        }
    }
    
    /*
    public GridPane getBoard() {
        return gridPane;
    }
    */
    
    public AnchorPane getBoard() {
        if (this.anchorPane != null) {
            return anchorPane;
        } else {
            return null;
        }

    }
    
    public void setAnchorPane(AnchorPane anchorPane){
        this.anchorPane = anchorPane;
    }
    
    public int getNumRows() {
        return rows;
    }
    
    public int getNumColumns() {
        return columns;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public Color getLightColor() {
        return light;
    }
    
    public Color getDarkColor() {
        return dark;
    }
    
    public double getRectangleWidth() {
        this.width = this.anchorPane.getWidth();
        return Math.ceil(this.width / this.columns);
        //return rectangleWidth;
    }
    
    public double getRectangleHeight() {
        this.height = this.anchorPane.getHeight();
        return Math.ceil(this.height / this.rows);
        //return rectangleHeight;
    }
    
    public void setBoardHeight(double height) {
        this.height = height;
    }
    
    public void setBoardWidth(double width) {
        this.width = width;
    }
    
    public void setBoard(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }
    
    public void setNumColumns(int columns) {
        this.columns = columns;
    }
    
    public void setNumRows(int rows) {
        this.rows = rows;
    }
    
    public void setLightColor(Color light) {
        this.light = light;
    }
    
    public void setDarkColor(Color dark) {
        this.dark = dark;
    }
    
}
