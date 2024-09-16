module es.juliogtrenard.juego_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.juliogtrenard.juego_javafx to javafx.fxml;
    exports es.juliogtrenard.juego_javafx;
}