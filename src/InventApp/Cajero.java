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
public class Cajero {
    private String nombreCajero;
    private String userCajero;

    public Cajero(String nombreCajero, String userCajero) {
        this.nombreCajero = nombreCajero;
        this.userCajero = userCajero;
    }

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }

    public String getUserCajero() {
        return userCajero;
    }

    public void setUserCajero(String userCajero) {
        this.userCajero = userCajero;
    }
}
