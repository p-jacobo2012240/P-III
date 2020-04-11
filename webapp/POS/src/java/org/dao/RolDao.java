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
import org.interfaces.RolInterface;
import org.models.Rol;
import org.utils.Conexion;

/**
 *
 * @author Pablo Jacobo
 */
public class RolDao implements RolInterface {
    
    private boolean resultadoDB = false;
    private String querySql = "";
    private ResultSet resultSet = null;
    private Conexion cnn = new Conexion();

    @Override
    public boolean agregarRol(Rol rol) {
        
        this.querySql = "INSERT INTO SEG.ROL(ID_ROL, DESCRIPCION ) VALUES('7', '"+ rol.getDescripcion()  +" ');";
        
        try {
            this.cnn.open();
            this.resultadoDB = this.cnn.executeSql(this.querySql);
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  this.resultadoDB;
    }

    @Override
    public List<Rol> listarRol() {
        List<Rol> listaRolesDB = new ArrayList<Rol>();
        this.querySql = "SELECT * FROM ROL";
        
        try {
            this.cnn.open();
            this.resultSet = this.cnn.executeQuery(querySql);
            while( this.resultSet.next() ){
                Rol rol = new Rol();
                rol.setIdRol( this.resultSet.getInt("ID_ROL"));
                rol.setDescripcion( this.resultSet.getString("DESCRIPCION"));
                listaRolesDB.add(rol);
            }   
            this.resultSet.close();
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRolesDB;
    }

    @Override
    public boolean editarRol(Rol rol) {
        
        this.querySql = "UPDATE \n" +
            "	SEG.ROL \n" +
            "SET \n" +
            "	DESCRIPCION  = '" + rol.getDescripcion() +" ' \n" +
            "WHERE \n" +
            "	SEG.ROL.ID_ROL = " + rol.getIdRol() + " ";
        
        try {
            this.cnn.open();
            this.resultadoDB = this.cnn.executeSql( this.querySql );
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return this.resultadoDB;
    }

    @Override
    public boolean eliminarRol(int idRol) {
        
        this.querySql = "DELETE FROM \n" +
            "	SEG.ROL \n" +
            "WHERE \n" +
            "	SEG.ROL.ID_ROL = "+ idRol +" ";
        
        try {
            this.cnn.open();
            this.resultadoDB = this.cnn.executeSql(this.querySql);
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.resultadoDB;
    }

    @Override
    public Rol unRol( int idRol ) {
        List<Rol> listaDeUnRol = new ArrayList<Rol>();
        Rol rolDB = new Rol();
        this.querySql = "SELECT * FROM SEG.ROL WHERE ID_ROL = " + idRol  +"";
        
        try {
            this.cnn.open();
            this.resultSet = this.cnn.executeQuery(this.querySql);
            while( this.resultSet.next() ){
                Rol rol = new Rol();
                rol.setIdRol( this.resultSet.getInt("ID_ROL"));
                rol.setDescripcion( this.resultSet.getString("DESCRIPCION"));
                listaDeUnRol.add(rol);
            }
            this.cnn.close();
            this.resultSet.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        for( Rol rol : listaDeUnRol  ){
            rolDB = rol;
        }
        
        return rolDB;
    }
    
}
