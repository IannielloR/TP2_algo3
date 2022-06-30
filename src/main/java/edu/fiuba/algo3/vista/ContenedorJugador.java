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
import javafx.scene.input.KeyEvent;
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
        BotonJuegoEventHandle botonJuegoHandler = new BotonJuegoEventHandle(stage, this);
        botonJugar.setOnAction(botonJuegoHandler);


        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        etiqueta.setText("Seleccione su vehiculo");
        etiqueta.setTextFill(Color.web("#000000"));

        this.getChildren().addAll(etiqueta,botonMoto, botonAuto, boton4x4, this.tipoVehiculo, botonJugar);
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
        Interferencia obstaculo1 = new Pozo(1,2,2,2);

        Interferencia obstaculo2 = new Pozo(2,2, 3,2);

        Interferencia obstaculo3 = new Pozo(5,2,5,3);

        Interferencia obstaculo4 = new Piquete(3,3,4,3);

        Interferencia obstaculo5 = new ControlPolicial(4,1,3,1, (float) 0.1);

        Interferencia obstaculo6 = new SorpresaFavorable(5,5,6,5);

        Interferencia obstaculo7 = new SorpresaDesfavorable(7,6,6,6);

        Interferencia obstaculo8 = new SorpresaCambioVehiculo(4,4,4,5);

        Interferencia obstaculo9 = new SorpresaFavorable(5,2,5,3);

        Interferencia obstaculo10 = new SorpresaDesfavorable(6,1,6,2);

        Interferencia obstaculo11 = new SorpresaCambioVehiculo(2,2,2,3);

        juego.agregarInterferencia(0,obstaculo1);
        juego.agregarInterferencia(1,obstaculo2);
        juego.agregarInterferencia(2,obstaculo3);
        juego.agregarInterferencia(3,obstaculo4);
        juego.agregarInterferencia(4,obstaculo5);
        juego.agregarInterferencia(5,obstaculo6);
        juego.agregarInterferencia(6,obstaculo7);
        juego.agregarInterferencia(7,obstaculo8);
        juego.agregarInterferencia(8,obstaculo9);
        juego.agregarInterferencia(9,obstaculo10);
        juego.agregarInterferencia(10,obstaculo11);
    }

    public Juego obtenerJuego(){
        return this.juego;
    }
    public ContenedorJuego obtenerContenedorJuego(){
       return new ContenedorJuego(stage, this.juego, this.vehiculo);
    }
    public Scene obtenerProximaEscena() {
        ContenedorJuego contenedorJuego = new ContenedorJuego(stage, this.juego, this.vehiculo);
        return new Scene(contenedorJuego, 800, 800);
    }

}
