package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

public class SorpresaDesfavorable extends Interferencia {
    public SorpresaDesfavorable(int id1, int id2) {
        this.posXInicial = id1;
        this.posYInicial = id2;
        this.posXFinal = (id1+1);
        this.posYFinal = (id2+1);
    }
    public int analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFianl, int yFinal, int movimientos){
        if((this.posXInicial == xInicial) && (this.posXFinal == xFianl) && (this.posYInicial == yInicial) && (this.posYFinal == yFinal) ){
            return vehiculo.devolverSorpresaDesfavorable(movimientos);
        }
        return 0;
    }
}
