package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

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

    public int[] obtenerCordenadaInterferencia(){
        int[] coordenada = new int[4];
        coordenada[0] = posXInicial;
        coordenada[1] = posYInicial;
        coordenada[2] = posXFinal;
        coordenada[3] = posYFinal;
        return coordenada;
    }
}
