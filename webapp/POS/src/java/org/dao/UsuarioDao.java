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
import org.interfaces.UsuarioInterface;
import org.models.Usuario;
import org.utils.Conexion;

/**
 *
 * @author Pablo Jacobo
 */
public class UsuarioDao implements UsuarioInterface {
    
    private boolean resultadoDB = false;
    private String querySql = "";
    private ResultSet resultSet = null;
    private Conexion cnn = new Conexion();

    @Override
    public boolean agregarUsuario(Usuario usuario) {
        this.querySql = "INSERT INTO USUARIO( \n" +
            "	NOMBRE, APELLIDO, \n" +
            "	USUARIO,CLAVE, ID_ROL, ESTADO \n" +
            "	) \n" +
            "VALUES\n" +
            "	(\n" +
            "	'" + usuario.getNombre() +"', '" + usuario.getApellido() + "', \n" +
            "	'"+ usuario.getUsuario() +"', CAST('" + usuario.getClave() +"' \n" +
            "	AS VARBINARY(MAX)), " + usuario.getIdRol() + ", "+ usuario.getEstado() +" \n" +
            "	);";
        
        try {
            this.cnn.open();
            this.resultadoDB = this.cnn.executeSql(this.querySql);
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.resultadoDB;
    }

    @Override
    public List<Usuario> listarUsuario() {
        List<Usuario> usersDBList = new ArrayList();
        this.querySql = "SELECT \n" +
            "	u.ID_USUARIO, u.NOMBRE, \n" +
            "	u.APELLIDO, u.USUARIO, \n" +
            "	u.CLAVE, r.DESCRIPCION AS 'ROL', \n" +
            "	u.ID_ROL,  u.ESTADO \n" +
            "FROM \n" +
            "	USUARIO u, ROL r\n" +
            "WHERE\n" +
            "	u.ID_ROL = r.ID_ROL;";
        
        try {
            this.cnn.open();
            this.resultSet = this.cnn.executeQuery(this.querySql);
            while( this.resultSet.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(this.resultSet.getInt("ID_USUARIO"));
                u.setNombre( this.resultSet.getString("NOMBRE"));
                u.setApellido( this.resultSet.getString("APELLIDO"));
                u.setUsuario( this.resultSet.getString("USUARIO"));
                u.setClave( this.resultSet.getString("CLAVE"));
                u.setRolName( this.resultSet.getString("ROL"));
                u.setIdRol(this.resultSet.getInt("ID_ROL"));
                u.setEstado( this.resultSet.getInt("ESTADO"));
                usersDBList.add(u);
            }
            this.resultSet.close();
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usersDBList;
    }

    @Override
    public boolean editarUsuario(Usuario usuario) {
        this.querySql = "UPDATE \n" +
            "	USUARIO \n" +
            "SET \n" +
            "	NOMBRE = '"+ usuario.getNombre() +"', APELLIDO = '" + usuario.getApellido() + "', \n" +
            "	USUARIO = '" + usuario.getUsuario() + "', CLAVE = CAST('" + usuario.getClave() + "' AS VARBINARY(MAX)), \n" +
            "	ID_ROL = " + usuario.getIdRol() + " , ESTADO = " + usuario.getEstado() + " \n" +
            "WHERE\n" +
            "	USUARIO.ID_USUARIO = " + usuario.getIdUsuario() + " ";
        
        try {
            this.cnn.open();
            this.resultadoDB = this.cnn.executeSql( this.querySql );
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.resultadoDB;
    }

    @Override
    public boolean eliminarUsuario(int idUsuario) {
        this.querySql = "DELETE FROM USUARIO WHERE ID_USUARIO = " + idUsuario +" ";
        try {
            this.cnn.open();
            this.resultadoDB = this.cnn.executeSql(this.querySql);
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.resultadoDB;
    }

    @Override
    public boolean login(String usuario, String clave) {
        List<Usuario> userFound = new ArrayList();
        this.querySql = "SELECT * FROM\n" +
            "	USUARIO\n" +
            "WHERE\n" +
            "	USUARIO = '" + usuario + "'\n" +
            "AND\n" +
            "	ESTADO = 1\n" +
            "AND\n" +
            "	CLAVE = CAST('" + clave + "' AS VARBINARY(MAX))";
        
        try {
            this.cnn.open();
            this.resultSet = this.cnn.executeQuery( this.querySql );
            while( this.resultSet.next() ){
                Usuario user = new Usuario();
                user.setUsuario( this.resultSet.getString("USUARIO"));
                userFound.add(user);
            }
            this.resultSet.close();
            this.cnn.close();
            if( userFound.size() > 0 ) 
                { this.resultadoDB = true; } 
            else { this.resultadoDB = false; } 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return this.resultadoDB;
    }

    @Override
    public Usuario unUsuario(int idUsuario) {
        List<Usuario> oneUserList = new ArrayList();
        Usuario usuarioDB = new Usuario();
        this.querySql = "SELECT "
            + "* FROM USUARIO WHERE ID_USUARIO = "+ idUsuario +"";
        
        System.out.println(" query es " + this.querySql  );
        
        try {
            this.cnn.open();
            this.resultSet = this.cnn.executeQuery(this.querySql );
            while( this.resultSet.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(this.resultSet.getInt("ID_USUARIO"));
                u.setNombre( this.resultSet.getString("NOMBRE"));
                u.setApellido( this.resultSet.getString("APELLIDO"));
                u.setUsuario( this.resultSet.getString("USUARIO"));
                u.setClave( this.resultSet.getString("CLAVE"));
                u.setIdRol(this.resultSet.getInt("ID_ROL"));
                u.setEstado( this.resultSet.getInt("ESTADO"));
                oneUserList.add(u);
            }
            this.resultSet.close();
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        for(Usuario us : oneUserList ){
            usuarioDB = us;
        }
        
        return usuarioDB;
    }
    
}
