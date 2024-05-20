package org.example.currencyconverter;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable{
    @FXML
    private AnchorPane BgAnchor;

    @FXML
    private AnchorPane WhitePane;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private TextField input;

    @FXML
    private Button result;

    @FXML
    private AnchorPane barPane;

    @FXML
    private Label title;

    @FXML
    private Label img1;

    @FXML
    private Label img2;

    @FXML
    private Label img3;

    public void setLabelImage(Label label, String imgPath, Double width, Double height)
    {
        ImageView imgView = new ImageView(new Image(getClass().getResourceAsStream(imgPath)));
        imgView.setFitHeight(height);
        imgView.setFitWidth(width);
        label.setGraphic(imgView);
//        label.setStyle("-fx-background-color: transparent; -fx-border-width: 1.5px; -fx-border-radius: 80px; -fx-border-color: white; -fx-text-fill: white");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setLabelImage(img1,"Minimize.png",20.0,20.0);
        setLabelImage(img2,"Maximize.png",20.0,20.0);
        setLabelImage(img3,"Exit.png",20.0,20.0);


    }
}