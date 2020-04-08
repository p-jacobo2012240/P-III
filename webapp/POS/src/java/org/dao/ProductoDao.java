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
  private String querySql = "";
  private ResultSet resultset = null;
  private Conexion conexion = new Conexion ();
  
  
    
    @Override
    public boolean agregarProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listarProducto() {
    
        List<Producto> listarProductos = new ArrayList();
        this.querySql = "SELECT * FROM POS.PRODUCTO";
            
      try {
          this.conexion.open();
          this.resultset = conexion.executeQuery(querySql);
          this.conexion.close();
          this.resultset.close();
          
          while(this.resultset.next()){
          
              Producto producto = new Producto();
              
            producto.setId_producto(this.resultset.getInt("ID_PRODUCTO"));
            producto.setId_Tipo_Producto(this.resultset.getInt("ID_TIPO_PRODUCTO"));
            producto.setDescripcion(this.resultset.getString("DESCRIPCION"));
            producto.setPrecio(this.resultset.getInt("PRECIO"));
            producto.setExistencia(this.resultset.getInt("EXISTENCIA"));
            producto.setEstado(this.resultset.getInt("ESTADO"));
          
            listarProductos.add(producto);
          }

      } catch (ClassNotFoundException ex) {
          Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
      } catch (Exception ex) {
          Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
      }
        
     return listarProductos;
    
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
