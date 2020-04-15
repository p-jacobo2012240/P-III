<%-- 
    Document   : cliente-add
    Created on : 12/04/2020, 08:57:44 PM
    Author     : Ronald Galicia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Add Client</title>
        <style>
            #max-space-add{
                width: 40%;
                margin: auto;
                margin-top: 2%;
            }
        </style>
    </head>
    <body style="background-image: url('https://c.wallhere.com/photos/74/bb/1920x1200_px_angle_minimalism_Optical_Illusion-1332977.jpg!d');">
         <div id="max-space-add" class="card">
            <div class="card-body">
                <form method="post" action="ClienteController" >
                    
                    <div class="form-group">
                      <label for="exampleInputEmail1">Nombre</label>
                      <input  name="nombre" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Apellido</label>
                      <input name="apellido" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Nit</label>
                      <input name="nit" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Direccion</label>
                      <input name="direccion" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Telefono</label>
                      <input name="telefono" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <input  name="accion" type="hidden" value="add">    
                    <button type="submit" class="btn btn-success btn-lg btn-block">Agregar</button><br>
                    <a href="clientes-list.jsp" type="button" class="btn btn-warning" style="width:100%">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
