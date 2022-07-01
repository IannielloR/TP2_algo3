package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;

import java.util.List;

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
    public void agregarJugador(String jugador){
        this.jugador =  jugador;
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

    public void moverVehiculoArriba(){

        mapa.moverVehiculoArriba();
        llegada = mapa.verificarMeta();
    }

    public void moverVehiculoAbajo(){
        mapa.moverVehiculoAbajo();
        llegada = mapa.verificarMeta();
    }

    public void moverVehiculoIzquierda(){
        mapa.moverVehiculoIzquierda();
        llegada = mapa.verificarMeta();
    }

    public void moverVehiculoDerecha(){
        mapa.moverVehiculoDerecha();


        llegada = mapa.verificarMeta();

    }

    public boolean getLlegada() {
        return llegada;
    }

    public int getMovimientos(){
        return this.mapa.devolverMovimientos();
    }

}