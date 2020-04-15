<%-- 
    Document   : factura-add
    Created on : 14/04/2020, 02:33:21 AM
    Author     : Ronald Galicia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Add Factura</title>
        <style>
            #max-space-add{
                width: 40%;
                margin: auto;
                margin-top: 2%;
            }
        </style>
    </head>
    <body style="background-image: url('https://c.wallhere.com/photos/74/bb/1920x1200_px_angle_minimalism_Optical_Illusion-1332977.jpg!d');" >
         <div id="max-space-add" class="card">
            <div class="card-body">
                <form method="post" action="FacturaController" >
                    <div class="form-group">
                      <label for="exampleInputEmail1">Serie</label>
                      <input  name="serie" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Fecha</label>
                      <input name="fecha" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">idCliente</label>
                      <input name="idCliente" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Total</label>
                      <input name="total" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">idUsuario</label>
                      <input name="idUsuario" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <input  name="accion" type="hidden" value="add">    
                    <button type="submit" class="btn btn-success btn-lg btn-block">Agregar</button><br>
                    <a href="facturas-list.jsp" type="button" class="btn btn-warning" style="width:100%">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>