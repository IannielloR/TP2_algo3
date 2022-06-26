package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;

public class Random {
    private java.util.Random random = new java.util.Random();
    private int maxXMapa;
    private int maxYMapa;

    public Random(){
    }
    public Random(int xMapa, int yMapa) {
        this.maxXMapa = xMapa;
        this.maxYMapa = yMapa;
    }
    public int generarXInicial(){
        return random.nextInt((this.maxXMapa+1));
    }
    public int generarYInicial(){
        return random.nextInt((this.maxYMapa+1));
    }

    public int generarXFinal(int xInicial){
        int valor = 2;
        int empiezaConX = random.nextInt(valor);
        int posXFinal = xInicial;
        if(empiezaConX == 0){
            if(xInicial == this.maxXMapa){
                posXFinal = (xInicial-1);
            }else{
                posXFinal = (xInicial +1);
            }
        }
        return posXFinal;
    }
    public int generarYFinal(int yInicial,int xInicial, int xFinal){
        int posYFinal = yInicial;
        if(xFinal == xInicial){
            if(yInicial == this.maxXMapa){
                posYFinal = (yInicial-1);
            }else{
                posYFinal = (yInicial +1);
            }
        }
        return posYFinal;
    }
    public int generarInt( int numMax){
        return random.nextInt(numMax);
    }
    public float generarFloat(){
        return random.nextFloat();
    }


}

