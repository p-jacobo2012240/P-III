<%-- 
    Document   : factura-edit
    Created on : 14/04/2020, 02:37:09 AM
    Author     : Ronald Galicia
--%>

<%@page import="org.models.Factura"%>
<%@page import="org.dao.FacturaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Edit Factura</title>
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
                <form method="post" action="FacturaController" >
                    <%
                        FacturaDao fDao = new FacturaDao();
                        int idFactura = Integer.parseInt((String) request.getAttribute("idFactura"));
                        Factura f = new Factura();
                        f = fDao.unaFactura(idFactura);
                    %>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Serie</label>
                      <input  name="serie" value="<%= f.getSerie() %>"  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Fecha</label>
                      <input name="fecha" value="<%= f.getFecha() %>"   type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Id_Cliente</label>
                      <input name="idCliente" value="<%= f.getIdCliente() %>"  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Total</label>
                      <input name="total" value="<%= f.getTotal() %>"  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Id_Usuario</label>
                      <input name="idUsuario" value="<%= f.getIdUsuario() %>"  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                    </div>
                    <input  name="accion" type="hidden" value="update">
                    <input  name="idExit" type="hidden" value="<%= f.getIdFactura() %>">    
                    <button type="submit" class="btn btn-success btn-lg btn-block">Editar</button><br>
                    <a href="facturas-list.jsp" type="button" class="btn btn-warning" style="width:100%">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>