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
public class VentaFacturada {
    String nombreProducto;
    String volumen;
    String colocacion;
    String satCodigo;

    public VentaFacturada(String nombreProducto, String volumen, String colocacion, String satCodigo) {
        this.nombreProducto = nombreProducto;
        this.volumen = volumen + " unidades";
        this.colocacion = "$" + colocacion;
        this.satCodigo = satCodigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getColocacion() {
        return colocacion;
    }

    public void setColocacion(String colocacion) {
        this.colocacion = colocacion;
    }

    public String getSatCodigo() {
        return satCodigo;
    }

    public void setSatCodigo(String satCodigo) {
        this.satCodigo = satCodigo;
    }

    @Override
    public String toString() {
        return this.nombreProducto + "," + this.volumen + "," + this.colocacion + "," + this.satCodigo;
    }
}

