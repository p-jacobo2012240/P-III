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
import org.interfaces.TipoProductoInterface;
import org.models.TipoProducto;
import org.utils.Conexion;

/**
 *
 * @author josea
 */
public class TipoProductoDao implements TipoProductoInterface{
    private boolean resultadoDB = false;
    private String querySql = "";
    private ResultSet resultSet = null;
    private Conexion cnn = new Conexion ();

    
    
    @Override
    public boolean agregarTipoProducto(TipoProducto tipoProducto) {
          
        this.querySql = "INSERT INTO TIPO_PRODUCTO (DESCRIPCION, ESTADO) VALUES('"+tipoProducto.getDescripcion()+"', "+tipoProducto.getEstado()+")";
        
        
        
        try {
            this.cnn.open();
            this.resultadoDB = this.cnn.executeSql(this.querySql);
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE,null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE,null, ex);
        }
        return this.resultadoDB;
    
          
    }

    
    
    @Override
    public List<TipoProducto> listarTipoProducto() {
        List<TipoProducto> listarTipoProducto = new ArrayList ();
       
                this.querySql = "SELECT * FROM TIPO_PRODUCTO";
                    
      
        
        try {
            
            this.cnn.open();
            this.resultSet = this.cnn.executeQuery(this.querySql);
            
            while (this.resultSet.next()){
                TipoProducto tp = new TipoProducto ();
                tp.setIdTipoProducto(this.resultSet.getInt("ID_TIPO_PRODUCTO"));
                tp.setDescripcion(this.resultSet.getString("DESCRIPCION"));
                tp.setEstado(this.resultSet.getInt("ESTADO"));
                listarTipoProducto.add(tp);
            }
          
            this.resultSet.close();
            this.cnn.close();
        }catch (ClassNotFoundException ex) {
          Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE,null, ex);
         
        } catch (Exception ex) {
         
          Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        return listarTipoProducto;
        
     }

    @Override
    public boolean editarTipoProducto(TipoProducto tipoProducto) {
        System.out.println("Llega aquiiii");
        //this.querySql= "UPDATE TIPO_PRODUCTO SET DESCRIPCION ='"+tipoProducto.getDescripcion()+"', ESTADO = '"+tipoProducto.getEstado()+"', WHERE ID_TIPO_PRODUCTO = "+tipoProducto.getIdTipoProducto()+"";
        
        this.querySql="UPDATE TIPO_PRODUCTO SET DESCRIPCION = '"+tipoProducto.getDescripcion()+"',ESTADO = '"+tipoProducto.getEstado()+"', WHERE ID_TIPO_PRODUCTO = '"+tipoProducto.getIdTipoProducto()+"'";
        
        
         System.out.println("query es " + this.querySql  );
    try {
        this.cnn.open();
        System.out.println("entro al DB");
        this.resultadoDB = this.cnn.executeSql(this.querySql);
        this.cnn.close();
         }catch (ClassNotFoundException ex) {
            Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE,null, ex);
        } catch (Exception ex) {
           Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE,null, ex);
        }
        System.out.println("RETORNO DE DB" + this.resultadoDB);
        return this.resultadoDB;
        
    
    }
    

    @Override
    public boolean eliminarTipoProducto(int idTipoProducto) {
       this.querySql = "DELETE FROM TIPO_PRODUCTO WHERE  ID_TIPO_PRODUCTO = " + idTipoProducto + ""; 
       try{
           this.cnn.open();
           this.resultadoDB = this.cnn.executeSql(this.querySql);
           this.cnn.close();
       } catch (ClassNotFoundException ex) {
          Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE,null, ex);
        } catch (Exception ex) {
          Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE,null, ex);
        }
        return this.resultadoDB;
        
    }

    @Override
    public TipoProducto unTipoProducto(int idTipoProducto) {
       
        List<TipoProducto> oneUserList = new ArrayList();
        TipoProducto tpDB = new TipoProducto();
        this.querySql = "SELECT "
            + "* FROM TIPO_PRODUCTO WHERE ID_TIPO_PRODUCTO = "+ idTipoProducto +"";
        
        System.out.println(" query es " + this.querySql  );
        
        //SELECT * FROM TIPO_PRODUCTO WHERE ID_TIPO_PRODUCTO = 2
        
        try {
            this.cnn.open();
            this.resultSet = this.cnn.executeQuery(this.querySql );
            while( this.resultSet.next()){
                TipoProducto tp = new TipoProducto();
                tp.setIdTipoProducto(this.resultSet.getInt("ID_TIPO_PRODUCTO"));
                tp.setDescripcion(this.resultSet.getString("DESCRIPCION"));
                tp.setEstado(this.resultSet.getInt("ESTADO"));
            
                oneUserList.add(tp);
            }
            this.resultSet.close();
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        for(TipoProducto us : oneUserList ){
            tpDB = us;
        }
        
        return tpDB;
    }
        
        
    }



