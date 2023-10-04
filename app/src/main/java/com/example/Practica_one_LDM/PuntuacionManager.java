package com.example.Practica_one_LDM;

public class PuntuacionManager {
    private static PuntuacionManager instancia;
    private int puntos = 0;
    private String nombre = " ";

    private PuntuacionManager() {
        // Constructor privado para evitar instancias múltiples
    }

    public static PuntuacionManager getInstance() {
        if (instancia == null) {
            instancia = new PuntuacionManager();
        }
        return instancia;
    }

    public int getPuntos() {
        return puntos;
    }

    public void sumarPuntos(int puntosGanados) {
        puntos += puntosGanados;
    }

    public void restarPuntos(int puntosPerdidos) {
        puntos -= puntosPerdidos;
    }

    public void resetearPuntos() {
        puntos = 0;
    }

    public void setNombre(String name){
        nombre = name;
    }

    public String getNombre(){
        return nombre;
    }
}
