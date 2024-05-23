module org.example.currencyconverter {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires org.json;


    opens org.example.currencyconverter to javafx.fxml;
    exports org.example.currencyconverter;
}
