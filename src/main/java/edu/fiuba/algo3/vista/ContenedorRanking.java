package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.ArchivoTexto;
import edu.fiuba.algo3.vista.eventos.BotonInicioEventHandle;
import edu.fiuba.algo3.vista.eventos.BotonVolverAtrasEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class ContenedorRanking extends VBox {
    Stage stage;
    //VBox contenedor;
    //static private String path;
    public ContenedorRanking(Stage stage, Scene escenaInicio){
        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        // Image imagen = new Image(path);
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.SPACE, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //this.setBackground(new Background(imagenDeFondo));


        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        etiqueta.setText("GPS Challenge");
        etiqueta.setTextFill(Color.web("#000000"));

        Button botonInicio = new Button();
        botonInicio.setText("Volver");
        BotonVolverAtrasEventHandler botonVolverHandler = new BotonVolverAtrasEventHandler(stage,escenaInicio);
        botonInicio.setOnAction(botonVolverHandler);

        File archivo = new File("ranking.txt");


        ArchivoTexto archivoRanking = new ArchivoTexto(archivo);
        ArrayList<String[]> ranking = archivoRanking.leerArchivo();

        TableView tableView = new TableView();
        TableColumn<String, String> column1 = new TableColumn<>("Jugador");
        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<String, String> column2 = new TableColumn<>("Puntuacion");
        column2.setCellValueFactory(new PropertyValueFactory<>("puntaje"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        for (int i = 0; i < ranking.size(); i++) {
            Jugador jugador = new Jugador(ranking.get(i)[0], Integer.parseInt(ranking.get(i)[1]));
            tableView.getItems().add(jugador);
        }

        this.getChildren().addAll(etiqueta,tableView,botonInicio);
    }


}
