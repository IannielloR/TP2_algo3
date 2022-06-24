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
        boolean vehiculoAvanza = false;
        for(int i = 0; i < this.interferencias.size(); i++){
            vehiculoAvanza = interferencias.get(i).analizarVehiculo(this.vehiculo,posVehiculoX, posVehiculoY, posX, posY);
        }

<<<<<<< HEAD
        for(int i = 0; i < this.sorpresas.size(); i++){
            movimientos += sorpresas.get(i).analizarVehiculo(this.vehiculo,posX, posY, movimientosTotales);

        }
        return movimientos;
    }
    private void crearInterferencias(){
        Interferencia obstaculo1 = new Pozo(2,1);
        Interferencia obstaculo2 = new Pozo(2,2);
        Interferencia obstaculo3 = new Pozo(3,2);
        Interferencia obstaculo4 = new Piquete(4,2);
        Interferencia obstaculo5 = new ControlPolicial(4,1);

        Interferencia obstaculo6 = new SorpresaDesfavorable(4,5);
        Interferencia obstaculo7 = new SorpresaFavorable(3,3);
        Interferencia obstaculo8 = new SorpesaCambioVehiculo(6,5);

        Interferencia obstaculo9 = new Piquete(7,4);
=======
        return vehiculoAvanza;
    }
>>>>>>> develop


    public void agregarInterferenciaAMapa(int posicion, Interferencia interferencia){
        this.interferencias.add(posicion,interferencia);
    }
}

