package edu.fiuba.algo3.modelo.TP2Proyect.modelo.mapa;

public class Meta {
    private int posX;
    private int posY;

    Meta(int x, int y) {
        this.posX = x;
        if((posX == 1)&& (y == 1)){
            this.posY = 2;
        }else {
            this.posY = y;
        }
    }

    public boolean verificarMeta( int xVehiculo, int yVehiculo){
        if((this.posX == xVehiculo) && (this.posY == yVehiculo)){
            return true;
        }
        return false;
    }

    public int[] obtenerCoordenadasMeta(){
        int[] coordenada = new int[2];
        coordenada[0] = posX;
        coordenada[1] = posY;
        return coordenada;
    }
}
