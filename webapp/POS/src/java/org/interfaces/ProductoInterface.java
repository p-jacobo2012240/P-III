/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.Producto;

/**
 *
 * @author javie
 */
public interface ProductoInterface {
    
    //agregarProducto
    public boolean agregarProducto(Producto producto);
    //listarProducto
    public List<Producto> listarProducto();
    //editarProducto
    public boolean editarProducto(Producto producto);
    
    //eliminarProducto
    public boolean eliminarProducto(int idProducto);
    
    
        
    
    
}
