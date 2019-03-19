/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventApp;

/**
 *
 * @author master
 */

//Objeto singleton
public class Configuracion {
    public static Configuracion config = new Configuracion();
    private Sesion sesionActual;
    public Configuracion(){}
    
    public Sesion getSesionActual() {
        return sesionActual;
    }

    public void setSesionActual(Sesion sesionActual) {
        this.sesionActual = sesionActual;
    }
}
