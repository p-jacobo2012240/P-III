/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.interfaces.ProductoInterface;
import org.models.Producto;
import org.utils.Conexion;
/**
 *
 * @author javie
 */
public class ProductoDao implements ProductoInterface{
    
    private boolean resultadoDB = false;
    private String querySql ="";
    private ResultSet resulSet = null;
    private  Conexion conec = new Conexion();
    
    
    @Override
    public boolean agregarProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listarProducto() {
        List<Producto> listaProductos = new ArrayList();
        this.querySql = "SELECT * FROM POS.PRODUCTO";
        
        try {
            this.conec.open();
            this.resulSet = this.conec.executeQuery(querySql);
            this.conec.close();
            this.resulSet.close();
            
            while(this.resulSet.next()){
            Producto producto = new Producto();
            
            producto.setId_producto(this.resulSet.getInt("ID_PRODUCTO"));
            producto.setId_Tipo_Producto(this.resulSet.getInt("ID_TIPO_PRODUCTO"));
            producto.setDescripcion(this.resulSet.getString("DESCRIPCION"));
            producto.setPrecio(this.resulSet.getInt("PRECIO"));
            producto.setExistencia(this.resulSet.getInt("EXISTENCIA"));
            producto.setEstado(this.resulSet.getInt("ESTADO"));
            
            
            
            listaProductos.add(producto);
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return listaProductos;
        
         }

    @Override
    public boolean editarProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarProducto(int idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
