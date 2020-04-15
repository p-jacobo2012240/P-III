/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.TipoProducto;

/**
 *
 * @author josea
 */
public interface TipoProductoInterface {
    //agregarTipoProducto
    public boolean agregarTipoProducto (TipoProducto tipoProducto);
    //listarTipoProducto
    public List <TipoProducto> listarTipoProducto();
    //editarTipoProducto
    public boolean editarTipoProducto (TipoProducto tipoProducto);
    //eliminarTipoProducto
    public boolean eliminarTipoProducto (int idTipoProducto); 
    //
    public TipoProducto unTipoProducto (int idTipoProducto);
    
}
