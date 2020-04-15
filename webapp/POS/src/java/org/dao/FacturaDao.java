/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.interfaces.FacturaInterface;
import org.models.Factura;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utils.Conexion;

/**
 *
 * @author Ronald Galicia
 */
public class FacturaDao implements FacturaInterface {
    private boolean resultadoDB = false;
    private String querySQL = "";
    private ResultSet resultSet = null;
    private Conexion cnn = new Conexion();

    @Override
    public boolean agregarFactura(Factura factura) {
        this.querySQL = "INSERT INTO FACTURA( \n "+
                    "   SERIE, FECHA, ID_CLIENTE, \n"+
                    "   TOTAL, ID_USUARIO)\n"+
                    "VALUES \n"+
                    "   (\n"+
                    "   '"+ factura.getSerie() +"', '"+ factura.getFecha() +"', \n" +
                    "   "+ factura.getIdCliente() +", "+ factura.getTotal() +", "+ factura.getIdUsuario() +"" +
                    "   );";
        try {
            this.cnn.open();
            this.resultadoDB = this.cnn.executeSql(this.querySQL);
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.resultadoDB;
    }

    @Override
    public List<Factura> listarFactura() {
        List<Factura> facturaDBList = new ArrayList();
        this.querySQL = "SELECT * FROM FACTURA";
        
        try {
            this.cnn.open();
            this.resultSet = this.cnn.executeQuery(querySQL);
            while(this.resultSet.next()){
                Factura f = new Factura();
                f.setIdFactura(this.resultSet.getInt("ID_FACTURA"));
                f.setSerie(this.resultSet.getString("SERIE"));
                f.setFecha(this.resultSet.getString("FECHA"));
                f.setIdCliente(this.resultSet.getInt("ID_CLIENTE"));
                f.setTotal(this.resultSet.getFloat("TOTAL"));
                f.setIdUsuario(this.resultSet.getInt("ID_USUARIO"));
                facturaDBList.add(f);
            }
            this.resultSet.close();
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return facturaDBList;
    }

    @Override
    public boolean editarFactura(Factura factura) {
        this.querySQL = "UPDATE\n" +
                    "	FACTURA\n" +
                    "SET\n" +
                    "	SERIE = '"+ factura.getSerie() +"', FECHA = '"+ factura.getFecha() +"',\n" +
                    "	ID_CLIENTE = "+ factura.getIdCliente()+", TOTAL = "+ factura.getTotal() +" , ID_USUARIO = " + factura.getIdUsuario() + "\n" +
                    "WHERE\n" +
                    "	ID_FACTURA = "+ factura.getIdFactura() +";";
        try {
            this.cnn.open();
            this.resultadoDB = this.cnn.executeSql(this.querySQL);
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.resultadoDB;
    }

    @Override
    public boolean eliminarFactura(int idFactura) {
        this.querySQL = "DELETE FROM\n" +
            "	FACTURA\n" +
            "WHERE\n" +
            "	ID_FACTURA = "+ idFactura +";";
            try {
                this.cnn.open();
                this.resultadoDB = this.cnn.executeSql(this.querySQL);
                this.cnn.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.resultadoDB;
    }

    @Override
    public Factura unaFactura(int idFactura) {
        List<Factura> listaUnaFactura =  new ArrayList<Factura>();
        Factura facturaDB = new Factura();
        this.querySQL = "SELECT * FROM FACTURA WHERE ID_FACTURA = "+ idFactura +";";
        
        try {
            this.cnn.open();
            this.resultSet = this.cnn.executeQuery(this.querySQL);
            while(this.resultSet.next()){
                Factura f = new Factura();
                f.setIdFactura(this.resultSet.getInt("ID_FACTURA"));
                f.setSerie(this.resultSet.getString("SERIE"));
                f.setFecha(this.resultSet.getString("FECHA"));
                f.setIdCliente(this.resultSet.getInt("ID_CLIENTE"));
                f.setTotal(this.resultSet.getFloat("TOTAL"));
                f.setIdUsuario(this.resultSet.getInt("ID_USUARIO"));
                listaUnaFactura.add(f);
            }
            this.resultSet.close();
            this.cnn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Factura fac : listaUnaFactura){
            facturaDB = fac;
        }
        return facturaDB;
    }
    
}
