<%-- 
    Document   : producto
    Created on : 08-abr-2020, 11:09:34
    Author     : javie
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.Producto"%>
<%@page import="org.dao.ProductoDao"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRODUCTOS</title>
    </head>
    <body>
        <TABLE BORDER>
	<TR>
            <TH>ID_PRODUCTO</TH> <TH>ID_TIPO_PRODUCTO</TH> <TH>DESCRIPCION</TH> <TH> PRECIO   </TH><TH> EXISTENCIA   </TH><TH>ESTADO   </TH>
	</TR>
        
        <%
            ProductoDao productodao = new ProductoDao ();
            List<Producto> productosdb = productodao.listarProducto();
            Iterator<Producto> iteratorProducto = productosdb.iterator();
            Producto producto = new Producto();
            while(iteratorProducto.hasNext()){
            
            producto = iteratorProducto.next();
	%>
        
        
        <TR>
            <TD> <%= producto.getId_producto() %> </TD> <TD><%= producto.getId_Tipo_Producto() %></TD> <TD><%= producto.getDescripcion() %> </TD> <TD> <%= producto.getPrecio() %></TD> <TD><%= producto.getExistencia() %></TD> <TD><%= producto.getEstado() %></TD><br>
	</TR>
        <% 
        }
        %>
        
        
        
</TABLE>
    </body>
</html>
