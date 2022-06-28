package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.*;
import edu.fiuba.algo3.vista.eventos.BotonAutoEventHandle;
import edu.fiuba.algo3.vista.eventos.BotonCuatroXCuatroEventHandle;
import edu.fiuba.algo3.vista.eventos.BotonInicioEventHandle;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonMotoEventHandle;
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
    private TipoVehiculo vehiculo;
    public ContenedorJugador(Stage stage){
        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.vehiculo = new Moto();
        // Image imagen = new Image(path);
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.SPACE, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //this.setBackground(new Background(imagenDeFondo));

        Label tipoVehiculo = new Label();
        tipoVehiculo.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        tipoVehiculo.setTextFill(Color.web("#000000"));
        tipoVehiculo.setText("Moto");

        Button botonAuto = new Button();
        botonAuto.setText("Auto");
        BotonAutoEventHandle botonAutoEventHandle = new BotonAutoEventHandle(this.vehiculo, tipoVehiculo);
        botonAuto.setOnAction(botonAutoEventHandle);

        Button botonMoto = new Button();
        botonMoto.setText("Moto");
        BotonMotoEventHandle botonMotoEventHandle = new BotonMotoEventHandle(this.vehiculo, tipoVehiculo);
        botonMoto.setOnAction(botonMotoEventHandle);

        Button boton4x4 = new Button();
        boton4x4.setText("4x4");
        BotonCuatroXCuatroEventHandle botonCuatroXCuatroEventHandle = new BotonCuatroXCuatroEventHandle(this.vehiculo, tipoVehiculo);
        boton4x4.setOnAction(botonCuatroXCuatroEventHandle);

        Juego juego = crearModelo();


        ContenedorJuego contenedorJuego = new ContenedorJuego(stage, juego, this.vehiculo);
        Scene escenaJuego = new Scene(contenedorJuego, 800, 800);

        Button botonJugar = new Button();
        botonJugar.setText("Iniciar Partida");
        BotonInicioEventHandle botonJuegoHandler = new BotonInicioEventHandle(stage, escenaJuego);
        botonJugar.setOnAction(botonJuegoHandler);


        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        etiqueta.setText("Seleccione su vehiculo");
        etiqueta.setTextFill(Color.web("#000000"));

        this.getChildren().addAll(etiqueta,botonMoto, botonAuto, boton4x4, tipoVehiculo, botonJugar);
    }

    private Juego crearModelo(){
        return new Juego(this.vehiculo, 10, 10);
    }

}
