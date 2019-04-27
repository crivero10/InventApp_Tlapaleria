/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventApp;

import java.util.*;

/**
 *
 * @author master
 */
public class Sesion {
    private Date fechaInicializacion;
    private Date fechaFinalizacion;
    private Double cashInSession;
    private Cajero cajeroEnSesion;

    public Sesion(Date fechaInicializacion, Date fechaFinalizacion, Double cashInSession, Cajero cajeroEnSesion) {
        this.fechaInicializacion = fechaInicializacion;
        this.fechaFinalizacion = fechaFinalizacion;
        this.cashInSession = cashInSession;
        this.cajeroEnSesion = cajeroEnSesion;
    }
    
    public Date getFechaInicializacion() {
        return fechaInicializacion;
    }

    public void setFechaInicializacion(Date fechaInicializacion) {
        this.fechaInicializacion = fechaInicializacion;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Double getCashInSession() {
        return cashInSession;
    }

    public void setCashInSession(Double cashInSession) {
        this.cashInSession = cashInSession;
    }

    public Cajero getCajeroEnSesion() {
        return cajeroEnSesion;
    }

    public void setCajeroEnSesion(Cajero cajeroEnSesion) {
        this.cajeroEnSesion = cajeroEnSesion;
    }
    
    public void guardarSesionDB(){
        
    }
}
