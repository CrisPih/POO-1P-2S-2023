/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.juego;

/**
 *
 * @author crisp
 */
public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;

    public Jugador(String nombre, ArrayList<Ficha> mano) {
        this.nombre = nombre;
        this.mano = mano;
    }

    public Ficha getFicha(int i) {
        if (i >= 0 && i < mano.size()) {
            return mano.get(i);
        }
        return null;
    }

    public ArrayList<Ficha> getMano() {
        return mano;
    }

    public void removerFicha(Ficha f) {
    mano.remove(f);
    }
        
    public String getNombre() {
        return nombre;
    }

    public void imprimirMano() {
        System.out.println(mano);
    }
    
}
