package edu.fiuba.algo3.vista;

public class Jugador {
    String nombre;
    int puntaje;
    public Jugador(String nombre, int puntaje){
              this.nombre = nombre;
              this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }
}
