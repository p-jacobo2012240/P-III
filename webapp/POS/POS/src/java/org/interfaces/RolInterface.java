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
    //agregarRol
    public boolean agregarRol( Rol rol );
    //listarRol
    public List<Rol> listarRol();
    //editarRol
    public boolean editarRol( Rol rol );
    //eliminarRo
    public boolean eliminarRol(int idRol );
}
