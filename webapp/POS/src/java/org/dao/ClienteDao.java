/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.util.List;
import org.interfaces.ClienteInterface;
import org.models.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utils.Conexion;

/**
 *
 * @author Ronald Galicia
 */
public class ClienteDao implements ClienteInterface {

    private boolean resultadoDB = false;
    private String querySQL = "";
    private ResultSet resultSet = null;
    private Conexion cnn = new Conexion();
    
    @Override 
    public boolean agregarCliente(Cliente cliente) {
        this.querySQL = "INSERT INTO CLIENTE( \n" +
                "  NOMBRE, APELLIDO, \n" + 
                "  NIT, DIRECCION, TELEFONO \n" +
                "  ) \n" +
                "VALUES \n"+
                "  (\n"+
                "  '"+ cliente.getNombre() +"', '"+ cliente.getApellido() +"', \n" +
                "  '"+ cliente.getNit() +"', '"+ cliente.getDireccion() +"', '"+ cliente.getTelefono() +"'" +
                "  );";
        
        try{
            this.cnn.open();
            this.resultadoDB = this.cnn.executeSql(this.querySQL);
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.resultadoDB;
    }

    @Override 
    public List<Cliente> listarCliente() {
        List<Cliente> clienteDBList = new ArrayList();
        this.querySQL = "SELECT * FROM CLIENTE;";
        
        try{
            this.cnn.open();
            this.resultSet = this.cnn.executeQuery(querySQL);
            while(this.resultSet.next()){
                Cliente c = new Cliente();
                c.setIdCliente(this.resultSet.getInt("ID_CLIENTE"));
                c.setNombre(this.resultSet.getString("NOMBRE"));
                c.setApellido(this.resultSet.getString("APELLIDO"));
                c.setNit(this.resultSet.getString("NIT"));
                c.setDireccion(this.resultSet.getString("DIRECCION"));
                c.setTelefono(this.resultSet.getString("TELEFONO"));
                clienteDBList.add(c);
            }
            this.resultSet.close();
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clienteDBList;
    }

    @Override 
    public boolean editarCliente(Cliente cliente) {
        this.querySQL = "UPDATE\n" +
            "	CLIENTE\n" +
            "SET \n" +
            "	NOMBRE = '"+ cliente.getNombre() +"', APELLIDO = '"+ cliente.getApellido() +"',\n" +
            "	NIT = '"+ cliente.getNit() +"', DIRECCION = '"+ cliente.getDireccion() +"', \n" +
            "	TELEFONO = '"+ cliente.getTelefono() +"'\n" +
            "WHERE\n" +
            "	ID_CLIENTE = " + cliente.getIdCliente() + ";";
        
        try{
            this.cnn.open();
            this.resultadoDB = this.cnn.executeSql(this.querySQL);
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultadoDB;
    }

    @Override 
    public boolean eliminarCliente(int idCliente) {
        this.querySQL = "DELETE FROM CLIENTE WHERE ID_CLIENTE = "+ idCliente +";";
        try{
            this.cnn.open();
            this.resultadoDB = this.cnn.executeSql(this.querySQL);
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.resultadoDB;
    }

    @Override
    public Cliente unCliente(int idCliente) {
        List<Cliente> listaDeUnCliente = new ArrayList<Cliente>();
        Cliente clienteDB = new Cliente();
        this.querySQL = "SELECT * FROM CLIENTE WHERE ID_CLIENTE = "+ idCliente +";";
        
        try{
            this.cnn.open();
            this.resultSet = this.cnn.executeQuery(this.querySQL);
            while(this.resultSet.next()){
                Cliente c = new Cliente();
                c.setIdCliente(this.resultSet.getInt("ID_CLIENTE"));
                c.setNombre(this.resultSet.getString("NOMBRE"));
                c.setApellido(this.resultSet.getString("APELLIDO"));
                c.setNit(this.resultSet.getString("NIT"));
                c.setDireccion(this.resultSet.getString("DIRECCION"));
                c.setTelefono(this.resultSet.getString("TELEFONO"));
                listaDeUnCliente.add(c);
            }
            this.resultSet.close();
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Cliente cc : listaDeUnCliente){
            clienteDB = cc;
        }
        
        return clienteDB;
    }
}
