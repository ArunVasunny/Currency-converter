package org.example.currencyconverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("HomeUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 720);
        scene.getStylesheets().add(getClass().getResource("HomeUI.css").toExternalForm());
        stage.setTitle("Currency Converter");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}