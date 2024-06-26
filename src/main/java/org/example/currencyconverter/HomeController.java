package org.example.currencyconverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.List;
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
    private Button mini;

    @FXML
    private Button maxi;

    @FXML
    private Button exit;

    @FXML
    private ComboBox<String> box1;

    @FXML
    private ComboBox <String> box2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        setButtonImage(mini,"Minimize.png",20.0,20.0);
        setButtonImage(maxi,"Maximize.png",20.0,20.0);
        setButtonImage(exit,"Exit.png",20.0,20.0);
        populateBox();
        input.setFocusTraversable(false);
    }

    public void setButtonImage(Button btn, String imgPath, Double width, Double height)
    {
        ImageView imgView = new ImageView(new Image(getClass().getResourceAsStream(imgPath)));
        imgView.setFitHeight(height);
        imgView.setFitWidth(width);
        btn.setGraphic(imgView);
        btn.setStyle("-fx-background-color: transparent;");
    }

    @FXML
    private void miniBtnAction(ActionEvent event)
    {
        Stage stage = (Stage) BgAnchor.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void exitBtnAction(ActionEvent event)
    {
        Stage stage = (Stage) BgAnchor.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void resltBtn()
    {
        String from = box1.getValue();
        String to = box2.getValue();
        String inputField = input.getText();

        if (inputField == null || inputField.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Empty Field", "Enter a valid amount.");
            return;
        }

        double amount;
        try{
            amount = Double.parseDouble(inputField);
        }
        catch(Exception ex)
        {
            showAlert(Alert.AlertType.ERROR,"Invalid Input", "Amount must be a Number.");
            return;
        }

        if(from == null || to == null)
        {
            showAlert(Alert.AlertType.ERROR,"Invalid Selection!" ,"Please select Currency");
            return;
        }
        CurrencyApi cm = new CurrencyApi();
        String result = cm.getConversionRate(from, to, amount);
        if (result != null) {
            label5.setText(amount+" "+from+ " = "+result+" "+to);
        }
        else {
            showAlert(Alert.AlertType.ERROR, "Conversion Error", "Failed to convert the currency.");
        }

    }


    private void populateBox()
    {
        CurrencyApi cm = new CurrencyApi();
        FlagsApi fg = new FlagsApi();
        List<String> symbol = cm.fetchSymbols();

        box1.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                }
                else {
                    setText(item);
                    String countryCode = box1.getValue();
                    Image flagImage = FlagsApi.getFlagImg(countryCode);
                    ImageView imageView = new ImageView(flagImage);
                    imageView.setFitHeight(36);
                    imageView.setFitWidth(36);
                    setGraphic(imageView);
                }
            }
        });


        box2.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                }
                else {
                    setText(item);
                    String countryCode = box2.getValue();
                    Image flagImage = FlagsApi.getFlagImg(countryCode);
                    ImageView imageView = new ImageView(flagImage);
                    imageView.setFitHeight(36);
                    imageView.setFitWidth(36);
                    setGraphic(imageView);
                }
            }
        });

        box1.getItems().addAll(symbol);
        box2.getItems().addAll(symbol);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
