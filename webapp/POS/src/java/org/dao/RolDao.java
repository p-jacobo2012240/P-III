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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rol> listarRol() {
        List<Rol> listaRolesDB = new ArrayList<Rol>();
        this.querySql = "SELECT * FROM SEG.ROL";
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRol(int idRol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
