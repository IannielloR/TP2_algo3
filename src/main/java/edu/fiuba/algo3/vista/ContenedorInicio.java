package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.eventos.BotonInicioEventHandle;
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

    public ContenedorInicio(Stage stage){
        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        // Image imagen = new Image(path);
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.SPACE, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //this.setBackground(new Background(imagenDeFondo));
        Image moto = new Image("file:src/vista/imagenes/moto.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(moto, BackgroundRepeat.SPACE, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonJuego = new Button();
        botonJuego.setText("Jugar");

        Button botonRanking = new Button();
        botonRanking.setText("Ver Ranking");

        ContenedorJugador contenedorJugador = new ContenedorJugador(stage);
        Scene escenaJugador = new Scene(contenedorJugador, 800, 800);

        ContenedorRanking contenedorRanking = new ContenedorRanking(stage );
        Scene escenaRanking = new Scene(contenedorRanking, 800, 800);

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        etiqueta.setText("GPS Challenge");
        etiqueta.setTextFill(Color.web("#000000"));

        BotonInicioEventHandle botonJuegoHandler = new BotonInicioEventHandle(stage, escenaJugador);
        botonJuego.setOnAction(botonJuegoHandler);


        BotonInicioEventHandle botonRankingHandler = new BotonInicioEventHandle(stage, escenaRanking);
        botonRanking.setOnAction(botonRankingHandler);

        this.getChildren().addAll(etiqueta, botonJuego, botonRanking);
    }
}
