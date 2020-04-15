<%-- 
    Document   : usuario
    Created on : 07-abr-2020, 22:07:21
    Author     : Pablo Jacobo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator" %>  
<%@page import="java.util.List" %>
<%@page import="org.models.Usuario" %>
<%@page import="org.dao.UsuarioDao" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Usuario CRUD</title>
         <style>
            #max-space-dsh{
                margin-top: 2%;
            }
        </style>
    </head>
    <body>
        <div id="max-space-dsh" class="container" >
            <a href="usuario-add.jsp" type="button" class="btn btn-success">Agregar</a>
         <br>
         <table class="table">
            <thead>
              <tr>
                <th scope="col">ID_USUARIO</th>
                <th scope="col">NOMBRE</th>
                <th scope="col">APELLIDO</th>
                <th scope="col">USUARIO</th>
                <th scope="col">ROL</th>
                <th scope="col">ESTADO</th>
                <th scope="col">OPCIONES</th>
              </tr>
            </thead>
            <tbody>
              
            <%
                UsuarioDao uDao = new UsuarioDao();
                List<Usuario> listaUsersDB = uDao.listarUsuario();
                Iterator<Usuario> iteradorUsuarios = listaUsersDB.iterator();
                Usuario us = new Usuario();
                while( iteradorUsuarios.hasNext() ){
                  us = iteradorUsuarios.next();
            %> 
              <tr>
                <td scope="row"><%= us.getIdUsuario() %></td>
                <td><%= us.getNombre() %></td>
                <td><%= us.getApellido() %></td>
                <td><%= us.getUsuario() %></td>
                <td><%= us.getRolName() %></td>
                <td><%= us.getEstado() %></td>
                <td>
                    <a 
                        type="button" 
                        class="btn btn-warning"
                        href="UsuarioController?accion=edit&idUsuario=<%= us.getIdUsuario()  %>"
                        >
                            Editar
                    </a>
                    <a 
                        type="button" 
                        class="btn btn-danger"
                        href="UsuarioController?accion=delete&idUsuario=<%= us.getIdUsuario()  %>"
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
