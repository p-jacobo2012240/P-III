<%-- 
    Document   : index
    Created on : 16-mar-2020, 22:30:16
    Author     : Pablo Jacobo
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src='https://cdn.jsdelivr.net/npm/sweetalert2@9'></script>
        <script src='https://cdn.jsdelivr.net/npm/promise-polyfill'></script>
        <title>JSP Page</title>
        <style>
            #max-space-card{
                width: 40%;
                margin: auto;
                margin-top: 10%;
            }
        </style>
    </head>
    <body style="background-image: url('https://c.wallhere.com/photos/74/bb/1920x1200_px_angle_minimalism_Optical_Illusion-1332977.jpg!d');">
        
        <%
        String login_msg=(String)request.getAttribute("error");  
        if(login_msg!=null){
            out.println("<script src='https://cdn.jsdelivr.net/npm/promise-polyfill'></script>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@9'></script>");
            out.println("<script>");
            out.println(" setTimeout( function(){ Swal.fire('usuario/clave incorrect@', '', 'error' ) },200 )  ");
            out.println("</script>");
        }
        %>
        
        <div class="card" id="max-space-card" image: style="background-image: url('https://c.wallhere.com/photos/3e/19/nature_landscape_minimalism_water_mist_long_exposure_blurred_reflection-99954.jpg!d ');"  >
            <div class="card-body" >
                <form method="post" action="UsuarioController" >
                <div class="form-group"  >
                  <img class="card-img-top" src="https://icon-icons.com/icons2/11/PNG/32/customer_person_people_man_user_client_1629.png" style="width:5%">
                  <label for="exampleInputEmail1">Usuario</label>
                  <input 
                    type="text" 
                    class="form-control" 
                    id="exampleInputEmail1"
                    value="hackobo"
                    name="usuario"
                    aria-describedby="emailHelp">
                </div>
                <div class="form-group"  >
                  <img class="card-img-top" src="https://icon-icons.com/icons2/46/PNG/32/password_userpassword_9564.png" style="width:5%">  
                  <label for="exampleInputPassword1">Clave</label>
                  <input 
                    type="password" 
                    class="form-control" 
                    name="clave"
                    value="123abc"
                    id="exampleInputPassword1">
                </div>
                <input  name="accion" type="hidden" value="login">
                <button type="submit" class="btn btn-success btn-lg btn-block">Login</button>
              </form>
            </div>
        </div>
    </body>
    
    <!-- Footer -->
    <footer class="page-footer font-small blue">
      <!-- Copyright -->
      <div class="footer-copyright text-center py-3">© 2020 Estudiantes de Ingeniería en Sistemas:
          <br>
        <a href="https://umg.edu.gt/"> Universidad Mariano Galvéz de Guatemala</a>
      </div>
    </footer>
    <!-- Footer -->
</html>
