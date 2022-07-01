package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class ArchivoTexto {
    File archivo;

    public ArchivoTexto(File archivo){
        this.archivo = archivo;
    }

    public void escribirArchivo(ArrayList<Integer > ranking){
        try{
            FileWriter escritura = new FileWriter(archivo);
            for (int i=0; i< ranking.size(); i++){
                escritura.write(Integer.toString(ranking.get(i)));
                escritura.write("\n");
            }
            escritura.close();
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
    }

    public ArrayList leerArchivo(){
        String contenido;
        ArrayList<Integer> movimientos = new ArrayList<Integer>();
        try{
            FileReader lector = new FileReader(archivo);
            BufferedReader lectura = new BufferedReader(lector);

            contenido = lectura.readLine();
            while (contenido != null){
                int movimiento = Integer.parseInt(contenido);
                movimientos.add(movimiento);
                contenido = lectura.readLine();
            }
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
        return movimientos;
    }
}
