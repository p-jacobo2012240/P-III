<%-- 
    Document   : tipoproducto-list
    Created on : 13/04/2020, 11:22:17 PM
    Author     : josea
--%>

<%@page import="java.util.Iterator"%>
<%@page import="org.models.TipoProducto"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.TipoProductoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Tipo Producto CRUD</title>
        <style>
            #max-space-dsh{
                margin-top: 2%;
            }
        </style>
    </head>
    <body>
        <div id="max-space-dsh" class ="container">
            <a href="tipoproducto-add.jsp" type="button" class =" btn btn-success"> Agregar </a> 
            <a href="home.jsp" type="button" class="btn btn-outline-warning">Regresar</a>
            <br>
            <table class="table">
                <thead>
                    <tr> 
                        <th scope="col"> ID_TIPO_PRODUCTO </th>
                        <th scope="col"> DESCRIPCION </th>
                        <th scope="col"> ESTADO </th>
                        <th scope="col"> OPCIONES </th>
                    </tr>    
                </thead>
                <tbody>
                    <% 
                        TipoProductoDao tpDao = new TipoProductoDao();
                        List <TipoProducto> listaProductoDB = tpDao.listarTipoProducto();
                        Iterator <TipoProducto> iteradorProductos = listaProductoDB.iterator();
                        TipoProducto tp = new TipoProducto ();
                        while (iteradorProductos.hasNext()){
                            tp = iteradorProductos.next();
                    %>
                    <tr>
                        <td scope ="row"> <%= tp.getIdTipoProducto()   %> </td>
                        <td> <%= tp.getDescripcion()  %> </td>
                        <td> <%= tp.getEstado()  %> </td>
                        
                        <td>
                            <a 
                                type ="button"
                                class ="btn btn-warning"
                                href="TipoProductoController?accion=edit&idTipoProducto=<%= tp.getIdTipoProducto()  %>"
                                >
                                                 Editar
                            </a>    
                            <a 
                                type="button" 
                                class="btn btn-danger"
                                href="TipoProductoController?accion=delete&idTipoProducto=<%= tp.getIdTipoProducto()  %>"
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
