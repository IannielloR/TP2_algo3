package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.manejadores.BotonAutoEventHandle;
import edu.fiuba.algo3.vista.manejadores.BotonCuatroXCuatroEventHandle;
import edu.fiuba.algo3.vista.manejadores.BotonInicioEventHandle;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.vista.manejadores.BotonMotoEventHandle;
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
        BotonAutoEventHandle botonAutoEventHandle = new BotonAutoEventHandle(stage);
        botonAuto.setOnAction(botonAutoEventHandle);

        Button botonMoto = new Button();
        botonMoto.setText("Moto");
        BotonMotoEventHandle botonMotoEventHandle = new BotonMotoEventHandle(stage);
        botonMoto.setOnAction(botonMotoEventHandle);

        Button boton4x4 = new Button();
        boton4x4.setText("4x4");
        BotonCuatroXCuatroEventHandle botonCuatroXCuatroEventHandle = new BotonCuatroXCuatroEventHandle(stage);
        boton4x4.setOnAction(botonCuatroXCuatroEventHandle);

        ContenedorJuego contenedorJuego = new ContenedorJuego(stage);
        Scene escenaJuego = new Scene(contenedorJuego, 640, 480);

        Button botonJugar = new Button();
        boton4x4.setText("Iniciar Partida");
        BotonInicioEventHandle botonJuegoHandler = new BotonInicioEventHandle(stage, escenaJuego);

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        etiqueta.setText("Seleccione su vehiculo");
        etiqueta.setTextFill(Color.web("#000000"));





        this.getChildren().addAll(etiqueta, botonAuto, botonMoto, boton4x4);
    }

}
