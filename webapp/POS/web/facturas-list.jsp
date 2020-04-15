<%--
    Document   : facturas-list
    Created on : 13/04/2020, 11:54:33 PM
    Author     : Ronald Galicia
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.models.Factura"%>
<%@page import="org.dao.FacturaDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Factura CRUD</title>
         <style>
            #max-space-dsh{
                margin-top: 2%;
            }
        </style>
    </head>
    <body style="background-image: url('https://c.wallhere.com/photos/74/bb/1920x1200_px_angle_minimalism_Optical_Illusion-1332977.jpg!d');" >
        <div id="max-space-dsh" class="container" >
            <a href="factura-add.jsp" type="button" class="btn btn-success">Agregar</a>
            <a href="home.jsp" type="button" class="btn btn-warning">Regresar</a>
         <table class="table">
            <thead>
              <tr>
                <th scope="col">ID_FACTURA</th>
                <th scope="col">SERIE</th>
                <th scope="col">FECHA</th>
                <th scope="col">ID_CLIENTE</th>
                <th scope="col">TOTAL</th>
                <th scope="col">ID_USUARIO</th>
                <th scope="col">OPCIONES</th>
              </tr>
            </thead>
            <tbody>
 
            <%
                FacturaDao fDao = new FacturaDao();
                List<Factura> listaFacturaDB = fDao.listarFactura();
                Iterator<Factura> iteradorFac = listaFacturaDB.iterator();
                Factura f = new Factura();
                while (iteradorFac.hasNext()){
                    f = iteradorFac.next();
            %> 
            <tr>
                <td scope="row"><%= f.getIdFactura() %></td>
                <td><%= f.getSerie() %></td>
                <td><%= f.getFecha() %></td>
                <td><%= f.getIdCliente() %></td>
                <td><%= f.getTotal() %></td>
                <td><%= f.getIdUsuario() %></td>
                <td>
                    <a 
                        type="button" 
                        class="btn btn-warning"
                        href="FacturaController?accion=edit&idFactura=<%= f.getIdFactura()  %>"
                        >
                            Editar
                    </a>
                    <a 
                        type="button" 
                        class="btn btn-danger"
                        href="FacturaController?accion=delete&idFactura=<%= f.getIdFactura()  %>"
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
