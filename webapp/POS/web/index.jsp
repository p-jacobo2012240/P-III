<%-- 
    Document   : index
    Created on : 16-mar-2020, 22:30:16
    Author     : Pablo Jacobo
--%>

<%@page import="java.util.Iterator" %>  
<%@page import="java.util.List" %>
<%@page import="org.models.Rol" %>
<%@page import="org.dao.RolDao" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        table, th, td {
          border: 1px solid black;
        }
        </style>
    </head>
    <body>
        <!--form method="post" action="RolController" >
            <input name="descripcion" type="text" placeholder="ingrese desc..." />
            <button type="submit" > Guardar </button>
        </form-->
        <table style="width:100%">
        <tr>
          <th>idRol</th>
          <th>Descripcion</th> 
          <th>Editar</th>
          <th>Eliminar</th> 
        </tr>
       
          <%
              RolDao rolDao = new RolDao();
              List<Rol> listaRolesDB = rolDao.listarRol();
              Iterator<Rol> iteradorRol = listaRolesDB.iterator();
              Rol rol = new Rol();
              while( iteradorRol.hasNext() ){
                  rol = iteradorRol.next();
          %> 
          <tr>
          <td> <%= rol.getIdRol() %>  </td>
          <td>  <%= rol.getDescripcion() %> </td>
          <td> <a href="RolController?idRol=<%= rol.getIdRol()  %>" >Editar<a </td>
          <td> <a href="RolController?idRol=<%= rol.getIdRol()  %>" >Eliminar<a </td><br>  
          </tr>            
          <%
              }
          %>
        
      </table>
    </body>
</html>
