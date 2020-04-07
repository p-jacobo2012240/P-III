/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.Usuario;

/**
 *
 * @author Pablo Jacobo
 */
public interface UsuarioInterface {
    //agregarUsuario
    public boolean agregarUsuario( Usuario usuario );
    //listarUsuario
    public List<Usuario> listarUsuario();
    //editarUsuario
    public boolean editarUsuario( Usuario usuario );
    //eliminarUsuario
    public boolean eliminarUsuario(int idUsuario );
}
