/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboardznpcp5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author zacharypierucci
 */
public class CheckerBoardFXMLController implements Initializable, Startable {
    
    private Stage stage;
    
    private int numRows = 8;
    private int numColumns = 8;
    private double boardWidth;
    private double boardHeight;
    private Color light = Color.RED;
    private Color dark = Color.BLACK;
    
    private CheckerBoard checkerBoard;
    
    @FXML
    private VBox vbox;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private void handleSize1(ActionEvent event) {
        checkerBoard.clear();
        numRows = 16;
        numColumns = 16;
        
        boardRefresh();
        refresh();
    }
    
    @FXML
    private void handleSize2(ActionEvent event) {
        checkerBoard.clear();
        numRows = 10;
        numColumns = 10;
        
        boardRefresh();
        refresh();
    }
    
    @FXML
    private void handleSize3(ActionEvent event) {
        checkerBoard.clear();
        numRows = 8;
        numColumns = 8;
        
        boardRefresh();
        refresh();
    }
    
    @FXML
    private void handleSize4(ActionEvent event) {
        checkerBoard.clear();
        numRows = 3;
        numColumns = 3;
        
        boardRefresh();
        refresh();
    }
    
    @FXML
    private void handleColor1(ActionEvent event) {
        checkerBoard.clear();
        light = Color.RED;
        dark = Color.BLACK;
        

        boardRefresh();
        refresh();
    }
    
    @FXML
    private void handleColor2(ActionEvent event) {
        checkerBoard.clear();
        light = Color.SKYBLUE;
        dark = Color.DARKBLUE;
        
        
        boardRefresh();
        refresh();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        boardWidth = anchorPane.getWidth();
        boardHeight = anchorPane.getHeight();
        
        checkerBoard = new CheckerBoard(numRows, numColumns, boardWidth, boardHeight);
        checkerBoard.setAnchorPane(anchorPane);
        //vbox.getChildren().add(checkerBoard.getBoard());
        
        this.anchorPane = this.checkerBoard.build();
        
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            checkerBoard.setBoardHeight(anchorPane.getHeight());
            checkerBoard.setBoardWidth(anchorPane.getWidth());
            this.anchorPane = checkerBoard.build();
            //refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        refresh();
        
    }
    
    private void boardRefresh() {
        checkerBoard = new CheckerBoard(numRows, numColumns, boardWidth, boardHeight, light, dark);
        vbox.getChildren().add(checkerBoard.getBoard());
    }
    
    private void refresh() {
        //checkerBoard.build(stage.getWidth(), stage.getHeight());
        checkerBoard.build();
    }    
    
}
