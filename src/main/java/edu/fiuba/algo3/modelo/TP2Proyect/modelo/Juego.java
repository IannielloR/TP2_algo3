package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Juego {
    private int movimientos;
    private Mapa mapa;
    private boolean llegada;
    private Random random;
    private int maxMapaX;
    private int maxMapaY;
    private String jugador;



    public Juego(TipoVehiculo vehiculo){
        this.random = new Random();
        this.maxMapaX = this.random.generarInt(15);
        this.maxMapaY = this.random.generarInt(15);
        this.random = new Random(this.maxMapaX, this.maxMapaY);
        this.mapa = new Mapa(vehiculo,this.maxMapaX,this.maxMapaY);
        this.movimientos = 0;
    }
    public Juego(TipoVehiculo vehiculo,int maxPosX, int maxPosY){
        this.random = new Random();
        this.mapa = new Mapa(vehiculo,maxPosX,maxPosY);
        this.movimientos = 0;
    }
    public void agregarInterferencia(int posicion, Interferencia interferencia){
        this.mapa.agregarInterferenciaAMapa(posicion,interferencia);
    }
    public void crearMeta(){
        this.mapa.crearMeta(this.random);
    }
    public void agregarMeta(int y){
        this.mapa.agregarMeta(y);

    }
    public void crearInterferencias() {
        int cantTotalInterfencias = random.generarInt(10);

        for (int i = 0; i < cantTotalInterfencias; i++) {
            agregarInterferencia(i, random.crearInterferencias());
        }
    }


    public int[] obtenerTamanioMapa(){
        return this.mapa.obtenerTamanioMapa();
    }
    public int[] obtenerCoordenadaVehiculo(){
        return this.mapa.obtenerCoordenadaVehiculo();
    }
    public int[] obtenerCoordenadaMeta(){return this.mapa.obtenerCoordenadaMeta();}
    public List<Interferencia> obtenerInterferencias(){
        return this.mapa.obtenerInterferencias();
    }

    public Vehiculo obtenerVehiculo(){
        return this.mapa.obtenerVehiculo();
    }
    public void moverVehiculoArriba(){
        mapa.moverVehiculoArriba();
        verificarMeta();
    }

    public void moverVehiculoAbajo(){
        mapa.moverVehiculoAbajo();
        verificarMeta();
    }

    public void moverVehiculoIzquierda(){
        mapa.moverVehiculoIzquierda();
        verificarMeta();
    }

    public void moverVehiculoDerecha(){
        mapa.moverVehiculoDerecha();
        verificarMeta();
    }

    public void verificarMeta(){
        llegada = mapa.verificarMeta();
        if(llegada){
            modificarRanking(getMovimientos());
        }
    }

    public boolean getLlegada() {
        return llegada;
    }

    public int getMovimientos(){
        int movimientosTotales = this.mapa.devolverMovimientos();
        return movimientosTotales;
    }

    public void modificarRanking(int puntaje) {
        File archivo = new File("ranking.txt");
        if(!archivo.exists()){
            try {
                archivo.createNewFile();
            }catch (IOException e){
                e.printStackTrace(System.out);
            }
        }
        ArchivoTexto archivoRanking = new ArchivoTexto(archivo);
        ArrayList<String[]> ranking = archivoRanking.leerArchivo();

        String[] jugadorNuevo = new String[2];
        jugadorNuevo[0] = this.jugador;
        jugadorNuevo[1] = Integer.toString(puntaje);
        ranking.add(jugadorNuevo);

        for (int i = 0; i < (ranking.size()); i++) {
            for (int j = 0; j < (ranking.size() -1); j++) {
                String[] jugador1 = ranking.get(j);
                String[] jugador2 = ranking.get(j+1);
                String auxNombre = jugador2[0];
                String auxPuntaje = jugador2[1];
                if (Integer.parseInt(jugador2[1]) < Integer.parseInt(jugador1[1])){
                    jugador2[0] = jugador1[0];
                    jugador2[1] = jugador1[1];

                    jugador1[0] = auxNombre;
                    jugador1[1] = auxPuntaje;
                }
            }
        }
        archivoRanking.escribirArchivo(ranking);
    }

    public void agregarJugador(String jugador){
        this.jugador =  jugador;
    }
}