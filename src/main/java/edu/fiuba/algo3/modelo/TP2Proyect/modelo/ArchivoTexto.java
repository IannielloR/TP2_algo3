package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArchivoTexto {
    File archivo;

    public ArchivoTexto(File archivo){
        this.archivo = archivo;
    }

    public void escribirArchivo(HashMap<String, Integer> ranking){
        try{
            FileWriter escritura = new FileWriter(archivo);

            Set<String> nombres = ranking.keySet();
            for(String nombre:nombres){
                int movimiento = ranking.get(nombre);
                escritura.write(nombre + " " + Integer.toString(movimiento));
                escritura.write("\n");
            }

//            for (int i=0; i< ranking.size(); i++){
//                escritura.write(Integer.toString(ranking.get(i)));
//                escritura.write("\n");
//            }
            escritura.close();
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
    }

    public HashMap leerArchivo(){
        String contenido;
        HashMap<String, Integer> ranking = new HashMap<String, Integer>();
        try{
            FileReader lector = new FileReader(archivo);
            BufferedReader lectura = new BufferedReader(lector);

            contenido = lectura.readLine();
            while (contenido != null){
                String[] split = contenido.split(" ");
                String nombre = split[0];
                int movimiento = Integer.parseInt(split[1]);
                ranking.put(nombre,movimiento);
                contenido = lectura.readLine();
            }
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
        return ranking;
    }
}
