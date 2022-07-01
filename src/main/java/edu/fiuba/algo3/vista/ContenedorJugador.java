package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.*;
import edu.fiuba.algo3.vista.eventos.*;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorJugador extends VBox {
    Stage stage;
    public TipoVehiculo vehiculo;
    private  Label tipoVehiculo;
    private Juego juego;
    private String jugador;
    TextField txtJugador;
    public ContenedorJugador(Stage stage, Scene escenaInicio){
        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.vehiculo = new Moto();

        // Image imagen = new Image(path);
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.SPACE, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //this.setBackground(new Background(imagenDeFondo));

        this.tipoVehiculo = new Label();
        this.tipoVehiculo.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        this.tipoVehiculo.setTextFill(Color.web("#000000"));
        this.tipoVehiculo.setText("Moto");

        Button botonAuto = new Button();
        botonAuto.setText("Auto");
        BotonAutoEventHandle botonAutoEventHandle = new BotonAutoEventHandle(this.vehiculo, this.tipoVehiculo);
        botonAuto.setOnAction(botonAutoEventHandle);

        Button botonMoto = new Button();
        botonMoto.setText("Moto");
        BotonMotoEventHandle botonMotoEventHandle = new BotonMotoEventHandle(this.vehiculo, this.tipoVehiculo);
        botonMoto.setOnAction(botonMotoEventHandle);


        Button boton4x4 = new Button();
        boton4x4.setText("4x4");
        BotonCuatroXCuatroEventHandle botonCuatroXCuatroEventHandle = new BotonCuatroXCuatroEventHandle(this.vehiculo, this.tipoVehiculo);
        boton4x4.setOnAction(botonCuatroXCuatroEventHandle);

        Button botonJugar = new Button();
        botonJugar.setText("Iniciar Partida");
        BotonJuegoEventHandle botonJuegoHandler = new BotonJuegoEventHandle(stage, this, escenaInicio);
        botonJugar.setOnAction(botonJuegoHandler);


        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        etiqueta.setText("Seleccione su vehiculo");
        etiqueta.setTextFill(Color.web("#000000"));

        Label lblJugador = new Label("Nombre:");
        this.txtJugador = new TextField ("S/N");
        HBox hb = new HBox();
        hb.getChildren().addAll(lblJugador, txtJugador);
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);

        this.getChildren().addAll(etiqueta,botonMoto, botonAuto, boton4x4, hb, this.tipoVehiculo, botonJugar);
    }

    public void crearModelo(){
        if(this.tipoVehiculo.getText() == "4x4"){
            this.vehiculo = new CuatroXCuatro();
        }
        if(this.tipoVehiculo.getText() == "Moto"){
            this.vehiculo = new Moto();
        }
        if(this.tipoVehiculo.getText() == "Auto"){
            this.vehiculo = new Auto();
        }
        this.juego = new Juego(this.vehiculo);
        juego.crearMeta();
        juego.crearInterferencias();
        juego.agregarJugador(this.txtJugador.getText());
    }

    public Juego obtenerJuego(){
        return this.juego;
    }
    public ContenedorJuego obtenerContenedorJuego(){
       return new ContenedorJuego(stage, this.juego, this.vehiculo);
    }

}
