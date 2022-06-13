package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

public class Mapa {
    private int maximoX;
    private int maximoY;
    private Vehiculo vehiculo;
    private int posVehiculoX;
    private int posVehiculoY;
    private Pozo obstaculo1;
    private Pozo obstaculo2;
    private Pozo obstaculo3;

    private Piquete obstaculo4;

    public Mapa(Vehiculo vehiculo){
        this.maximoX = 5;
        this.maximoY = 5;
        this.vehiculo = vehiculo;
        this.posVehiculoX = 1;
        this.posVehiculoY = 1;
     //   this.obstaculo1 = new Pozo(2,1);
     //   this.obstaculo2 = new Pozo(2,2);
     //   this.obstaculo3 = new Pozo(3,2);
     //   this.obstaculo4 = new Piquete(4,2);
    }
    public int moverVehiculoAbajo(){
        if(posVehiculoY + 1 <= maximoY) {
            posVehiculoY++;

            return revisarObstaculos();
        }
        return 0;
    }
    public int moverVehiculoArriba(){
        if(posVehiculoY - 1 == 0) {
            posVehiculoY--;

            return revisarObstaculos();
        }
        return 0;
    }
    public int moverVehiculoDerecha(){
        if(posVehiculoX + 1 <= maximoX) {
            posVehiculoX++;

            return revisarObstaculos();
        }
        return 0;
    }
    public int moverVehiculoIzquierda(){
        if(posVehiculoX - 1 == 0) {
            posVehiculoX--;

            return revisarObstaculos();
        }
        return 0;
    }
    private int revisarObstaculos(){
        int movimientos = 1;
        movimientos += this.obstaculo1.analizarVehiculo(vehiculo,posVehiculoX,posVehiculoY);
        movimientos += this.obstaculo2.analizarVehiculo(vehiculo,posVehiculoX,posVehiculoY);
        movimientos += this.obstaculo3.analizarVehiculo(vehiculo,posVehiculoX,posVehiculoY);
        movimientos += this.obstaculo4.analizarVehiculo(vehiculo,posVehiculoX,posVehiculoY);
        return movimientos;
    }
}
