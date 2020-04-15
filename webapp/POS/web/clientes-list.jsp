<%-- 
    Document   : clientes-list
    Created on : 13/04/2020, 07:07:34 PM
    Author     : Ronald Galicia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator" %>  
<%@page import="java.util.List" %>
<%@page import="org.models.Cliente" %>
<%@page import="org.dao.ClienteDao" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Cliente CRUD</title>
         <style>
            #max-space-dsh{
                margin-top: 2%;
            }
        </style>
    </head>
    <body style="background-image: url('https://c.wallhere.com/photos/74/bb/1920x1200_px_angle_minimalism_Optical_Illusion-1332977.jpg!d');" >
        <div id="max-space-dsh" class="container" >
        <a href="cliente-add.jsp" type="button" class="btn btn-success">Agregar</a>
        <a href="home.jsp" type="button" class="btn btn-warning">Regresar</a>
         <br>
         <table class="table">
            <thead>
              <tr>
                <th scope="col">ID_CLIENTE</th>
                <th scope="col">NOMBRE</th>
                <th scope="col">APELLIDO</th>
                <th scope="col">NIT</th>
                <th scope="col">DIRECCION</th>
                <th scope="col">TELEFONO</th>
                <th scope="col">OPCIONES</th>
              </tr>
            </thead>
            <tbody>
              
            <%
                ClienteDao cDao = new ClienteDao();
                List<Cliente> listaClienteDB = cDao.listarCliente();
                Iterator<Cliente> iteradorCliente = listaClienteDB.iterator();
                Cliente cc = new Cliente();
                while( iteradorCliente.hasNext()){
                    cc = iteradorCliente.next();
            %> 
              <tr>
                <td scope="row"><%= cc.getIdCliente() %></td>
                <td><%= cc.getNombre() %></td>
                <td><%= cc.getApellido() %></td>
                <td><%= cc.getNit() %></td>
                <td><%= cc.getDireccion() %></td>
                <td><%= cc.getTelefono() %></td>
                <td>
                    <a 
                        type="button" 
                        class="btn btn-warning"
                        href="ClienteController?accion=edit&idCliente=<%= cc.getIdCliente()  %>"
                        >
                            Editar
                    </a>
                    <a 
                        type="button" 
                        class="btn btn-danger"
                        href="ClienteController?accion=delete&idCliente=<%= cc.getIdCliente()  %>"
                        >
                            Eliminar
                    </a>
                </td>
              </tr>
            <%
                }
            %>
              
            </tbody>
          </table>
        </div>
    </body>
</html>
