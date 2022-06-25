package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.manejadores.BotonEntrarEventHandle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorInicio extends VBox {
    Stage stage;
    //VBox contenedor;
    //static private String path;
    public ContenedorInicio(Stage stage, Scene escenaJuego, Scene escenaRanking){
        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        // Image imagen = new Image(path);
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.SPACE, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //this.setBackground(new Background(imagenDeFondo));

        Button botonJuego = new Button();
        botonJuego.setText("Jugar");

        Button botonRanking = new Button();
        botonRanking.setText("Ver Ranking");


        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        etiqueta.setText("GPS Challenge");
        etiqueta.setTextFill(Color.web("#000000"));

        Label etiqueta2 = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        etiqueta.setText("Rank?");
        etiqueta.setTextFill(Color.web("#000000"));

        BotonEntrarEventHandle botonJuegoHandler = new BotonEntrarEventHandle(stage, escenaJuego);
        botonJuego.setOnAction(botonJuegoHandler);
        this.getChildren().addAll(etiqueta, botonJuego);

        BotonEntrarEventHandle botonRankingHandler = new BotonEntrarEventHandle(stage, escenaRanking);
        botonRanking.setOnAction(botonRankingHandler);
        this.getChildren().addAll(etiqueta2, botonRanking);
    }
}
