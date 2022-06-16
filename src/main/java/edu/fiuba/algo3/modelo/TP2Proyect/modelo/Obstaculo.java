package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

public abstract class Obstaculo{
    protected int posX;
    protected int posY;

    public abstract int analizarVehiculo(Vehiculo vehiculo, int id1, int id2, int movimientos);
}
