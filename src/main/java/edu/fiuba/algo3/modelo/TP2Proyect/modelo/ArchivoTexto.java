package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

public class ArchivoTexto {
    File archivo;

    public ArchivoTexto(File archivo){
        this.archivo = archivo;
    }

    public void escribirArchivo(ArrayList<String[]> ranking){
        try{
            FileWriter escritura = new FileWriter(archivo);
            for (int i=0; i< ranking.size(); i++){
                String[] jugador = ranking.get(i);
                escritura.write(jugador[0] + " " + jugador[1]);
                escritura.write("\n");
            }

            escritura.close();
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
    }

    public ArrayList<String[]> leerArchivo(){
        String contenido;
        ArrayList<String[]> ranking = new ArrayList<String[]>();
        try{
            FileReader lector = new FileReader(archivo);
            BufferedReader lectura = new BufferedReader(lector);

            contenido = lectura.readLine();
            while (contenido != null){
                String[] split = contenido.split(" ");

                String[] jugador = new String[2];
                jugador[0] = split[0];
                jugador[1] = split[1];
                ranking.add(jugador);
                contenido = lectura.readLine();
            }
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
        return ranking;
    }
}
