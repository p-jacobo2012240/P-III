/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;
import java.util.List;
import org.models.Rol;

/**
 *
 * @author Pablo Jacobo
 */
public interface RolInterface {
     //agregarProducto
    public boolean agregarRol(Rol rol);
    //listarProducto
    public List<Rol> listarRol();
    //editarProducto
    public boolean editarRol(Rol rol);
    
    //eliminarProducto
    public boolean eliminarRol(int idRol);
    
}
