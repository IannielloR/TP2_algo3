package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import java.util.Random;

public class Coordenada {
        private int posXInicial;
        private int posYInicial;
        private int posXFinal;
        private int posYFinal;
    public Coordenada() {
    }
    public void generarCoordenadas( int maxXMapa, int maxYMapa){
        Random random = new Random();
        int valor = 2;
        int empiezaConX = random.nextInt(valor);
        this.posXInicial = random.nextInt((maxXMapa+1));
        this.posYInicial = random.nextInt((maxYMapa+1));
        if(empiezaConX == 1){
            posXFinal = posXInicial;
            if(posYInicial == maxYMapa){
                posYFinal = (posYInicial-1);
            }else{
                posYFinal = (posYInicial+1);
            }
        }
        else{
            posYFinal = posYInicial;
            if(posXInicial == maxXMapa){
                posXFinal = (posXInicial-1);
            }else{
                posXFinal = (posXInicial +1);
            }
        }
    }
    public boolean hayColision(int vehiculoXInical, int vehiculoYInicial, int vehiculoXFinal, int vehiculoYFinal){
        if((vehiculoXInical == posXInicial) && (vehiculoYInicial == posYInicial) && (vehiculoXFinal == posXFinal) && (vehiculoYFinal == posYFinal)){
            return true;
        }
        if((vehiculoXInical == posXFinal) && (vehiculoYInicial == posYFinal) && (vehiculoXFinal == posXInicial) && (vehiculoYFinal == posYInicial)){
            return true;
        }
        return false;
    }

}
