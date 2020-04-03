/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.models;

/**
 *
 * @author javie
 */
public class Producto {
    
    private int Id_producto; 
    private int Id_Tipo_Producto;
    private String Descripcion;
    private double Precio;
    private int  Existencia;
    private int Estado;

    public int getId_producto() {
        return Id_producto;
    }

    public void setId_producto(int Id_producto) {
        this.Id_producto = Id_producto;
    }

    public int getId_Tipo_Producto() {
        return Id_Tipo_Producto;
    }

    public void setId_Tipo_Producto(int Id_Tipo_Producto) {
        this.Id_Tipo_Producto = Id_Tipo_Producto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
    
    
    
    
    
    
}
