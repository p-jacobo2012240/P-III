/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Jacobo
 */
public class Conexion {
     private PreparedStatement preparar = null;    
    private  Connection coneccion=null;    
    private ResultSet resultado = null;
     //Cadena de Conexion
    
    String stringConnectionUrl = "jdbc:sqlserver://db-umg.cowbs9fgq896.us-east-1.rds.amazonaws.com:1433;databaseName=POS";
    //Driver o controlador JDBC
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    public Connection open() throws ClassNotFoundException{  
        System.out.println("Si conecto con la DB");
        try {  
                Class.forName(driver);
                coneccion = DriverManager.getConnection(stringConnectionUrl,"admin","developer2020");
                
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);            
            System.out.println("Excepción: " + e.getMessage());
        }
        return coneccion;
    }
    
    public void close() throws Exception{
        //Connection coneccion = null;
        try {
            if (coneccion != null){
                coneccion.clearWarnings();
                coneccion.close();                
            }
        } catch (SQLException e) {
            coneccion = null;
            throw new Exception(e.getMessage());
        }

    }
    
    public boolean executeSql (String cmd) throws Exception{
            if (cmd != null)
            try {
                    this.preparar = this.coneccion.prepareStatement(cmd);
                    this.preparar.executeUpdate();
            } catch (SQLException e) {
                    throw new Exception(e.getMessage());
            }
            else
                    throw new Exception("El comando a ejecutar es nulo!");
            return true;
    }
	
    public ResultSet executeQuery (String strSQL){
        
            if (strSQL != null)
            try {        
                    
                    preparar = coneccion.prepareStatement(strSQL);                    
                    resultado = preparar.executeQuery();	
            } catch (SQLException e) {                    
                System.out.println("Error al ejecutar el query en Clase: Conexion: " + e.toString());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
            //close();
            return resultado;
    }
}
