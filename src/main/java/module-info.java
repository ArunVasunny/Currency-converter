module org.example.currencyconverter {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.currencyconverter to javafx.fxml;
    exports org.example.currencyconverter;
}