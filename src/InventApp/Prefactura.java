package InventApp;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author master
 */
public class Prefactura {
    private Date fechaInicio;
    private Date fechaFin;
    public ArrayList<VentaFacturada> listaProductosVendidos;
    private Connection connection = DB_INFO.getConnection();
    
    public Prefactura(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.listaProductosVendidos = new ArrayList<VentaFacturada>();
    }
    
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public void obtenerVentasPeriodo(){
        ArrayList<VentaFacturada> listaProductosVendidos = new ArrayList<VentaFacturada>();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String inicioFechaSQL = sdf.format(this.fechaInicio);
        String finalFechaSQL = sdf.format(this.fechaFin);
        connection = DB_INFO.getConnection();
        Statement st;
        ResultSet rs;
        PreparedStatement ps;
        String query = "SELECT product.name as `pname`, sum(order_detail.quantity) as `volumen`, \n" +
                        "sum(order_detail.quantity * product.price) as `revenue`, category.name as `sat` FROM `order_detail`\n" +
                        "\n" +
                        "JOIN `order_tbl` ON order_tbl.id = order_detail.order_id\n" +
                        "JOIN `product` ON order_detail.product_id = product.id\n" +
                        "JOIN `category` ON product.category_id = category.id\n" +
                        "\n" +
                        "WHERE order_tbl.order_date BETWEEN ? AND ?\n" +
                        "GROUP BY product.id";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, inicioFechaSQL);
            ps.setString(2, finalFechaSQL);
            rs = ps.executeQuery();
           
            VentaFacturada ventaTemp;
            while(rs.next()){
                ventaTemp = new VentaFacturada(rs.getString("pname"), rs.getString("volumen"), rs.getString("revenue"), rs.getString("sat"));
                listaProductosVendidos.add(ventaTemp);
            }
            this.listaProductosVendidos = listaProductosVendidos;
        
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
