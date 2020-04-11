<%-- 
    Document   : usuario-add
    Created on : 10-abr-2020, 11:38:10
    Author     : Pablo Jacobo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.Rol"%>
<%@page import="org.models.Usuario"%>
<%@page import="org.dao.RolDao"%>
<%@page import="org.dao.UsuarioDao"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Add User</title>
        <style>
            #max-space-add{
                width: 40%;
                margin: auto;
                margin-top: 2%;
            }
        </style>
    </head>
    <body>
        <div id="max-space-add" class="card">
            <div class="card-body">
                <form method="post" action="UsuarioController" >
                    <div class="form-group">
                      <label for="exampleInputEmail1">Nombre</label>
                      <input  name="nombre" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Apellido</label>
                      <input name="apellido" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Usuario</label>
                      <input name="usuario" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Clave</label>
                        <input 
                        type="password" 
                        class="form-control" 
                        name="clave"
                        required=""
                        id="exampleInputPassword1">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Elije un rol</label>
                        <select name="idRol" class="form-control">
                             <%
                                RolDao rDao = new RolDao();
                                List<Rol> rolList = rDao.listarRol();
                                Iterator<Rol> iteradorRol = rolList.iterator();
                                Rol rol = new Rol();
                                while( iteradorRol.hasNext() ){
                                    rol = iteradorRol.next();
                            %> 
                            <option value="<%= rol.getIdRol()  %>" ><%= rol.getDescripcion()  %> </option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Estado</label>
                        <select name="estado" class="form-control"  >
                            <option value="1" >Activo</option>
                            <option value="0" >Inactivo</option>
                        </select>
                    </div>
                    <input  name="accion" type="hidden" value="add">    
                    <button type="submit" class="btn btn-success btn-lg btn-block">Agregar</button>
                </form>
            </div>
        </div>
    </body>
</html>
