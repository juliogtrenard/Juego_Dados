package es.juliogtrenard.juego_javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;

public class HelloApplication extends Application {
    /**
     *
     */
    private int cantVidaPjPrincipal = 5;
    private int cantVidaPjEnemigo = 5;

    /**
     *
     * @param stage
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Juego en JavaFX");

        VBox contenedorV = new VBox();

        Label lblNombre = new Label("Ingresa tu nombre:");
        TextField txtNombre = new TextField();

        Label lblPjPrincipal = new Label("Jugador");
        Label lblPjEnemigo = new Label("Enemigo");

        Label lblVidaPjPrincipal = new Label("Vida: " + cantVidaPjPrincipal);
        Label lblVidaPjEnemigo = new Label("vida: " + cantVidaPjEnemigo);

        Label puntos1 = new Label("Puntuación: ");
        Label puntos2 = new Label("Puntuación: ");

        Button btnJugar = new Button("Jugar");

        Label lblGanador = new Label("");

        txtNombre.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent e) {
                lblPjPrincipal.setText(txtNombre.getText());
            }
        });

        btnJugar.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent e) {
                Random r = new Random();
                int puntaje1 = r.nextInt(6) + 1;
                int puntaje2 = r.nextInt(6) + 1;

                puntos1.setText("Puntuación: " + puntaje1);
                puntos2.setText("Puntuación: " + puntaje2);

                if(puntaje1 > puntaje2) {
                    cantVidaPjEnemigo--;
                    lblVidaPjEnemigo.setText("Vida: " + cantVidaPjEnemigo);
                    lblVidaPjEnemigo.setTextFill(Color.RED);

                    if(cantVidaPjEnemigo == 0) {
                        lblGanador.setText("Ganaste");
                    }
                } else {
                    cantVidaPjPrincipal--;
                    lblVidaPjPrincipal.setText("Vida: " + cantVidaPjPrincipal);
                    lblVidaPjPrincipal.setTextFill(Color.RED);

                    if(cantVidaPjPrincipal == 0) {
                        lblGanador.setText("Perdiste");
                    }
                }
            }
        });

        contenedorV.getChildren().addAll(lblNombre, txtNombre, lblPjPrincipal, lblVidaPjPrincipal, puntos1, lblPjEnemigo,
                lblVidaPjEnemigo, puntos2, btnJugar, lblGanador);

        Scene escena = new Scene(contenedorV, 300, 300);

        stage.setScene(escena);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}