package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;

import java.util.List;
import java.util.ArrayList;


public class Mapa {
    private int maximoX;
    private int maximoY;
    private Vehiculo vehiculo;
    private int posVehiculoX;
    private int posVehiculoY;
    private List<Interferencia> interferencias = new ArrayList<Interferencia>();

    private Random random;

    public Mapa(TipoVehiculo vehiculo){
        this.maximoX = 10;
        this.maximoY = 10;
        this.vehiculo = new Vehiculo(vehiculo);
        this.posVehiculoX = 1;
        this.posVehiculoY = 1;
        this.random = new Random(maximoX, maximoY);

    }


    public int devolverMovimientos(){
        return this.vehiculo.devolverMovimientos();
    }
    public void moverVehiculoAbajo(){
        if(posVehiculoY + 1 <= maximoY) {
            if (revisarObstaculos(posVehiculoX, (posVehiculoY + 1))) {
                posVehiculoY++;
            }
        }
    }
    public void moverVehiculoArriba(){
        if(posVehiculoY - 1 != 0) {
            if(revisarObstaculos(posVehiculoX, (posVehiculoY - 1))){
                posVehiculoY--;

            }
        }

    }
    public void moverVehiculoDerecha(){
        if(posVehiculoX + 1 <= maximoX) {
            if(revisarObstaculos((posVehiculoX + 1), posVehiculoY)){
                posVehiculoX++;
            }
        }
    }
    public void moverVehiculoIzquierda(){
        if(posVehiculoX - 1 != 0) {
            if(revisarObstaculos((posVehiculoX - 1), posVehiculoY)){
                posVehiculoX--;
            }
        }
    }
    private boolean revisarObstaculos(int posX, int posY){
        boolean vehiculoAvanza = true;
        for(int i = 0; i < this.interferencias.size(); i++){
            boolean permiso = interferencias.get(i).analizarVehiculo(this.vehiculo,posVehiculoX, posVehiculoY, posX, posY);
            if(!permiso) {
                vehiculoAvanza = false;
            }
        }
        this.vehiculo.sumarMovimiento();
        return vehiculoAvanza;
    }

    public void agregarInterferenciaAMapa(int posicion, Interferencia interferencia){
        this.interferencias.add(posicion,interferencia);

    }
}