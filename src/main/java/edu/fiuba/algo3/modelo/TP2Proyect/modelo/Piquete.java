package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

public class Piquete {
    private int posX;
    private int posY;
    public Piquete(int id1, int id2) {
        this.posX = id1;
        this.posY = id2;
    }
    public int analizarVehiculo(Vehiculo vehiculo, int id1, int id2){
        if(this.posX == id1 && this.posY == id2 ){
            return vehiculo.devolverPenalizacionPiquete();
        }
        return 0;
    }
}
