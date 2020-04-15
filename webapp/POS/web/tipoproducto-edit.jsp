<%-- 
    Document   : tipoproducto-edit
    Created on : 14/04/2020, 12:38:43 AM
    Author     : josea
--%>

<%@page import="org.models.TipoProducto"%>
<%@page import="org.dao.TipoProductoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Editar Tipo Producto</title>
        <style>
            #max-space-edit{
                width: 40%;
                margin: auto;
                margin-top: 2%;
            }
        </style>
    </head>
    <body>
        <div id="max-space-edit" class="card">
            <div class="card-body">
                <form method="post" action="TipoProductoController" >
                    <%
                        TipoProductoDao tpDao = new TipoProductoDao();
                        int idTipoProducto = Integer.parseInt((String) request.getAttribute("idTipoProducto"));
                        TipoProducto tt = new TipoProducto();
                        System.out.println("id es" + Integer.toString(idTipoProducto) );
                        tt = tpDao.unTipoProducto(idTipoProducto);
                    %> 
                    <div class="form-group">
                      <label for="exampleInputEmail1">Descripcion</label>
                      <input  name="descripcion" value=" <%= tt.getDescripcion() %>"  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" > 
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Estado</label>
                        <select name="estado" class="form-control"  >
                            <option value="1" >Activo</option>
                            <option value="0" >Inactivo</option>
                        </select>
                    </div>
                    <input  name="accion" type="hidden" value="update">
                    <input  name="idxEdit" type="hidden" value="<%= tt.getIdTipoProducto() %>">    
                    <button type="submit" class="btn btn-success btn-lg btn-block">ACTUALIZAR</button>
                    <%
                     System.out.println("aqui vooooooy"); 
                    %>
                </form>
            </div>
        </div>
    </body>
</html>
