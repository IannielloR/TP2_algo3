package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.manejadores.BotonEntrarEventHandle;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
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

public class ContenedorJuego extends VBox {
    Stage stage;
    //VBox contenedor;
    //static private String path;
    public ContenedorJuego(Stage stage, Juego juego){
        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        // Image imagen = new Image(path);
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.SPACE, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //this.setBackground(new Background(imagenDeFondo));

        Button botonInicio = new Button();
        botonInicio.setText("Salir");



        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        etiqueta.setText("GPS Challenge");
        etiqueta.setTextFill(Color.web("#000000"));

        BotonEntrarEventHandle botonSalirHandler = new BotonEntrarEventHandle(stage, escenaInicio);
        botonInicio.setOnAction(botonSalirHandler);


        this.getChildren().addAll(etiqueta, botonInicio);
    }
}