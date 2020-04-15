<%-- 
    Document   : home
    Created on : 07-abr-2020, 10:37:04
    Author     : Pablo Jacobo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            #margin-sts{
                margin-top: 2%;
            }
        </style>
    </head>
    <body style="background-image: url('https://c.wallhere.com/photos/74/bb/1920x1200_px_angle_minimalism_Optical_Illusion-1332977.jpg!d');">
        <nav class="navbar navbar-dark bg-dark justify-content-between">
        <a class="navbar-brand"> bienvenido : <% request.getSession().getAttribute("user"); %>   </a>
            <form class="form-inline">
                <button class="btn btn-success my-2 my-sm-0" type="submit">Salir</button>
            </form>
        </nav><br><br>
        <div class="container" >
            <div class="row" id="margin-sts"   >
            <div class="col-sm-4">
              <img class="card-img-top" src="https://lh6.googleusercontent.com/prnHxZ-kLGTC292CX8BfnGUyaMNC0SazoJ2YTHChGolkCvhgUgCrJxNW9ljl1q68QZpm8Q" style="width:85%">
                <div class="card" style="width:85%">  
                  <a href="facturas-list.jsp" class="btn btn-success btn-lg btn-block">FACTURA</a>
                </div>
            </div>
            <div class="col-sm-4">
              <img class="card-img-top" src="https://cdn.icon-icons.com/icons2/20/PNG/256/business_man_usersearch_thesearch_theclient_2356.png" style="width:85%">
                <div class="card" style="width:85%">
                  <a href="clientes-list.jsp" class="btn btn-success btn-lg btn-block">CLIENTE</a>
                </div>
              </div>
            <div class="col-sm-4">
              <img class="card-img-top" src="https://cdn.icon-icons.com/icons2/209/PNG/128/maintenance256_24835.png" style="width:85%">
                <div class="card" style="width:85%">
                  <a href="usuarios-list.jsp" class="btn btn-success btn-lg btn-block">MANTENIMIENTO</a>
                </div>
              </div>
            </div>
        </div>
    </body>
</html>
