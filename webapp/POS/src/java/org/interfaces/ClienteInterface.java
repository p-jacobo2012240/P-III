/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.Cliente;

/**
 *
 * @author Ronald Galicia
 */
public interface ClienteInterface {
    //agregarCliente
    public boolean agregarCliente(Cliente cliente);
    //listarCliente
    public List<Cliente> listarCliente();
    //editarCliente
    public boolean editarCliente (Cliente cliente);
    //eliminarCliente
    public boolean eliminarCliente(int idCliente);
}
