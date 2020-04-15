<%-- 
    Document   : tipoproducto-add
    Created on : 14/04/2020, 12:28:56 AM
    Author     : josea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Añadir Tipo Productos</title>
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
           <a href="home.jsp" type="button" class="btn btn-outline-warning">Regresar</a>
            <div class="card-body">
                <form method="post" action="TipoProductoController" >
                    <div class="form-group">
                      <label for="exampleInputEmail1">Descripcion</label>
                      <input  name="descripcion" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
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
