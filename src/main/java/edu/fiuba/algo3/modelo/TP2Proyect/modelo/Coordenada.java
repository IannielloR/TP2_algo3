package edu.fiuba.algo3.modelo.TP2Proyect.modelo;


import java.util.Random;

public class Coordenada {
        private int posXInicial;
        private int posYInicial;
        private int posXFinal;
        private int posYFinal;

    public void asignarCoordenadas( int xInicial, int yInicial, int xFinal, int yFinal){
        this.posXInicial = xInicial;
        this.posYInicial = yInicial;
        this.posXFinal = xFinal;
        this.posYFinal = yFinal;
    }
    public boolean hayColision(int vehiculoXInical, int vehiculoYInicial, int vehiculoXFinal, int vehiculoYFinal) {
        if ((vehiculoXInical == posXInicial) && (vehiculoYInicial == posYInicial) && (vehiculoXFinal == posXFinal) && (vehiculoYFinal == posYFinal)) {
            return true;
        }
        if ((vehiculoXInical == posXFinal) && (vehiculoYInicial == posYFinal) && (vehiculoXFinal == posXInicial) && (vehiculoYFinal == posYInicial)) {
            return true;
        }
        return false;
    }
}
//    private int posX;
//    private int posY;
//    public Pozo(int id1, int id2) {
//        this.posX = id1;
//        this.posY = id2;
//    }
//    public int analizarVehiculo(TipoVehiculo vehiculo, int id1, int id2, int movimientos){
//        if(this.posX == id1 && this.posY == id2 ){
//            return (vehiculo.devolverVehiculo()).devolverPenalizacionPozo();
//        }
//        return 0;
//    }
//}
