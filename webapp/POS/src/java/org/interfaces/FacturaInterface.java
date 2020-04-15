/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.Factura;

/**
 *
 * @author Ronald Galicia
 */
public interface FacturaInterface {
    //agregarFactura
    public boolean agregarFactura(Factura factura);
    //listarFactura
    public List<Factura> listarFactura();
    //editarFactura
    public boolean editarFactura (Factura factura);
    //eliminarFactura
    public boolean eliminarFactura(int idFactura);
}
