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
    <body>
        <nav class="navbar navbar-light bg-light justify-content-between">
        <a class="navbar-brand"> bienvenido : <% request.getSession().getAttribute("user"); %>   </a>
            <form class="form-inline">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Salir</button>
            </form>
        </nav>
        <div class="container" >
            <div class="row" id="margin-sts" >
            <div class="col-sm-6">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Usuarios</h5>
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                  <a href="usuarios-list.jsp" class="btn btn-primary">Ir</a>
                </div>
              </div>
            </div>
            <div class="col-sm-6">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Productos</h5>
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                  <a href="#" class="btn btn-primary">Ir</a>
                </div>
              </div>
            </div>
            <br>
            <div class="col-sm-6">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Facturas</h5>
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                  <a href="#" class="btn btn-primary">Ir</a>
                </div>
              </div>
            </div>
            <br>
            <div class="col-sm-6">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Otros</h5>
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                  <a href="#" class="btn btn-primary">Ir</a>
                </div>
              </div>
            </div>
            <br>
            <br>
            <div class="col-sm-6">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Tipo Producto</h5>
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                  <a href="tipoproducto-list.jsp" class="btn btn-primary">Ir</a>
                </div>
              </div>
            </div>
            </div>
        </div>
    </body>
</html>
