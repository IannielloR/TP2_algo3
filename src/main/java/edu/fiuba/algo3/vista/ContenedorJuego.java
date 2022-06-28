package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorJuego extends BorderPane {
    Stage stage;

    BarraDeMenu menuBar;
    VistaJuego vistaJuego;
    Canvas canvasCentral;
    VBox contenedorCentral;
    public ContenedorJuego(Stage stage, Juego juego, TipoVehiculo vehiculo){
        this.setMenu();
        this.setCentro(juego, vehiculo);
        this.setConsola();
        // Image imagen = new Image(path);
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.SPACE, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //this.setBackground(new Background(imagenDeFondo));
    }
    private void  setMenu(){
        this.menuBar = new BarraDeMenu(this.stage);
        this.setTop(menuBar);
    }

    private void setCentro(Juego juego, TipoVehiculo vehiculo){
        canvasCentral = new Canvas(800, 800);
        vistaJuego = new VistaJuego(juego, vehiculo, canvasCentral);
        vistaJuego.dibujar(800, 800);

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        etiqueta.setText("PROXIMAMENTE");
        etiqueta.setTextFill(Color.web("#000000"));


        contenedorCentral = new VBox(canvasCentral, etiqueta);
        contenedorCentral.setAlignment(Pos.CENTER);
        //contenedorCentral.setSpacing(20);
        //contenedorCentral.setPadding(new Insets(25));


       // Image imagen = new Image("file:src/vista/imagenes/fondo-verde.jpg");
       // BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, B);
        //contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }
    private void setConsola(){
        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("couier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");
        this.setBottom(contenedorConsola);
    }

    public BarraDeMenu getMenuBar() {
        return menuBar;
    }
}