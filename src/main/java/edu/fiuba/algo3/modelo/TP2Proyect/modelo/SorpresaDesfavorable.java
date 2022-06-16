package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

public class SorpresaDesfavorable extends Obstaculo{
    public SorpresaDesfavorable(int id1, int id2) {
        this.posX = id1;
        this.posY = id2;
    }
    public int analizarVehiculo(Vehiculo vehiculo, int id1, int id2, int movimientos){
        if(this.posX == id1 && this.posY == id2 ){
            return vehiculo.devolverSorpresaDesfavorable(movimientos);
        }
        return 0;
    }
}
