package es.juliogtrenard.juego_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;

/**
 * Aplicación de JavaFX con dos personajes, el jugador y un enemigo, se tiran dos dados y el que tenga peor puntaje
 * pierde una vida. Si la vida llega a 0 se acaba el juego.
 */
public class HelloApplication extends Application {
    /**
     * Variable para almacenar la cantidad de vida del jugador
     */
    private int cantVidaPjPrincipal = 5;
    /**
     * Variable para almacenar la cantidad de vida del enemigo
     */
    private int cantVidaPjEnemigo = 5;

    /**
     * Método de inicio
     * @param stage Escenario principal de la ventana
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Juego en JavaFX");

        //Contenedor y elementos del juego
        VBox contenedorV = new VBox();

        Label lblNombre = new Label("Ingresa tu nombre:");
        TextField txtNombre = new TextField();

        Label lblPjPrincipal = new Label("Jugador");
        Label lblPjEnemigo = new Label("Enemigo");

        Label lblVidaPjPrincipal = new Label("Vida: " + cantVidaPjPrincipal);
        Label lblVidaPjEnemigo = new Label("Vida: " + cantVidaPjEnemigo);

        Label puntos1 = new Label("Puntuación: ");
        Label puntos2 = new Label("Puntuación: ");

        Button btnJugar = new Button("Jugar");

        Label lblGanador = new Label("");

        //Colocar el nombre al jugador cuando se presiona enter
        txtNombre.setOnAction(_ -> lblPjPrincipal.setText(txtNombre.getText()));

        //Tirar dados cuando se presiona el botón de jugar
        btnJugar.setOnAction(_ -> {
            Random r = new Random();
            int puntaje1 = r.nextInt(6) + 1;
            int puntaje2 = r.nextInt(6) + 1;

            while(puntaje1 == puntaje2) {
                puntaje1 = r.nextInt(6) + 1;
                puntaje2 = r.nextInt(6) + 1;
            }

            puntos1.setText("Puntuación: " + puntaje1);
            puntos2.setText("Puntuación: " + puntaje2);

            if(puntaje1 > puntaje2) {
                cantVidaPjEnemigo--;
                lblVidaPjEnemigo.setText("Vida: " + cantVidaPjEnemigo);
                lblVidaPjEnemigo.setTextFill(Color.RED);

                if(cantVidaPjEnemigo == 0) {
                    lblGanador.setText("GANASTE");
                    btnJugar.setDisable(true);
                }
            } else {
                cantVidaPjPrincipal--;
                lblVidaPjPrincipal.setText("Vida: " + cantVidaPjPrincipal);
                lblVidaPjPrincipal.setTextFill(Color.RED);

                if(cantVidaPjPrincipal == 0) {
                    lblGanador.setText("PERDISTE");
                    btnJugar.setDisable(true);
                }
            }
        });

        //Agrega los elementos al contenedor
        contenedorV.getChildren().addAll(lblNombre, txtNombre, lblPjPrincipal, lblVidaPjPrincipal, puntos1, lblPjEnemigo,
                lblVidaPjEnemigo, puntos2, btnJugar, lblGanador);

        //Establece la escena en el escenario y lo muestra
        Scene escena = new Scene(contenedorV, 300, 300);

        stage.setScene(escena);

        stage.show();
    }

    /**
     * Llamada al método launch para iniciar la aplicación
     * @param args Argumentos en la linea de comandos
     */
    public static void main(String[] args) {
        launch();
    }
}