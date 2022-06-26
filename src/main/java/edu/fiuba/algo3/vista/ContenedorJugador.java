package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.manejadores.BotonEntrarEventHandle;
import edu.fiuba.algo3.controlador.manejadores.BotonEntrarJuegoAutoEventHandle;
import edu.fiuba.algo3.controlador.manejadores.BotonEntrarJuegoCuatroXCuatroEventHandle;
import edu.fiuba.algo3.controlador.manejadores.BotonEntrarJuegoMotoEventHandle;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorJugador extends VBox {
    Stage stage;
    private TipoVehiculo tipoVehiculo;
    public ContenedorJugador(Stage stage){
        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        // Image imagen = new Image(path);
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.SPACE, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //this.setBackground(new Background(imagenDeFondo));

        Button botonAuto = new Button();
        botonAuto.setText("Auto");

        Button botonMoto = new Button();
        botonMoto.setText("Moto");

        Button boton4x4 = new Button();
        boton4x4.setText("4x4");


        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        etiqueta.setText("Seleccione su vehiculo");
        etiqueta.setTextFill(Color.web("#000000"));

        Juego juego = crearModelo();
        ContenedorJuego contenedorJuego = new ContenedorJuego(stage, juego);
        Scene escenaJuego = new Scene(contenedorJuego, 640, 480);

        BotonEntrarEventHandle botonJuegoHandler = new BotonEntrarEventHandle(stage, escenaJuego);

        BotonEntrarJuegoAutoEventHandle botonEntrarJuegoAutoEventHandle = new BotonEntrarJuegoAutoEventHandle(stage, tipoVehiculo);
        BotonEntrarJuegoMotoEventHandle botonEntrarJuegoMotoEventHandle = new BotonEntrarJuegoMotoEventHandle(stage, tipoVehiculo);
        BotonEntrarJuegoCuatroXCuatroEventHandle botonEntrarJuegoCuatroXCuatroEventHandle = new BotonEntrarJuegoCuatroXCuatroEventHandle(stage, tipoVehiculo);

        botonAuto.setOnAction(botonEntrarJuegoAutoEventHandle);
        botonMoto.setOnAction(botonEntrarJuegoMotoEventHandle);
        boton4x4.setOnAction(botonEntrarJuegoCuatroXCuatroEventHandle);


        this.getChildren().addAll(etiqueta, botonAuto, botonMoto, boton4x4);
    }

    private Juego crearModelo() {
        return new Juego(tipoVehiculo, 10, 10);
    }

}
