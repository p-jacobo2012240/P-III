<%-- 
    Document   : cliente-edit
    Created on : 13/04/2020, 10:14:09 PM
    Author     : Ronald Galicia
--%>

<%@page import="org.dao.ClienteDao"%>
<%@page import="org.models.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Edit Client</title>
        <style>
            #max-space-edit{
                width: 40%;
                margin: auto;
                margin-top: 2%;
            }
        </style>
    </head>
    <body style="background-image: url('https://c.wallhere.com/photos/74/bb/1920x1200_px_angle_minimalism_Optical_Illusion-1332977.jpg!d');" >
        <div id="max-space-edit" class="card">
            <div class="card-body">
                <form method="post" action="ClienteController" >
                    <%
                        ClienteDao cDao = new ClienteDao();
                        int idCliente = Integer.parseInt((String) request.getAttribute("idCliente"));
                        Cliente c = new Cliente();
                        System.out.println("id cliente es: "+ Integer.toString(idCliente));
                        c = cDao.unCliente(idCliente);
                    %>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Nombre</label>
                      <input  name="nombre" value="<%= c.getNombre() %>"  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Apellido</label>
                      <input name="apellido" value="<%= c.getApellido() %>"   type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Nit</label>
                      <input name="nit" value="<%= c.getNit() %>"  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Direccion</label>
                      <input name="direccion" value="<%= c.getDireccion() %>"  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Telefono</label>
                      <input name="telefono" value="<%= c.getTelefono() %>"  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <input  name="accion" type="hidden" value="update">
                    <input  name="idExit" type="hidden" value="<%= c.getIdCliente() %>">    
                    <button type="submit" class="btn btn-success btn-lg btn-block">Editar</button><br>
                    <a href="clientes-list.jsp" type="button" class="btn btn-warning" style="width:100%">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>