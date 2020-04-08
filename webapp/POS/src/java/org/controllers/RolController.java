/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.RolDao;
import org.models.Rol;

/**
 *
 * @author Pablo Jacobo
 */
@WebServlet(name = "RolController", urlPatterns = {"/RolController"})
public class RolController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            /*  PARA LISTAR
            RolDao rolDao = new RolDao();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Datos Roles </title>");    
            for( Rol r : rolDao.listarRol()){
                out.println("<li> idRolxdxd " + r.getIdRol() + "</li><br>");
                 out.println("<li> descripcion " + r.getDescripcion() + "</li><br>");
            }
            out.println("<ul>");
            out.println("</ul>");
            out.println("</html>");*/
            
            /* PARA INGRESAR
            String desc = request.getParameter("descripcion");
            Rol rol = new Rol();
            rol.setDescripcion(desc);
            RolDao rolDao = new RolDao();
            
            boolean siInserto = rolDao.agregarRol(rol);
            out.println("<p>" + Boolean.toString(siInserto) +  "</p>");
            */
            
            /* PARA ELIMINAR
                String idRol = request.getParameter("idRol");
                //System.out.println(" el valor por url es " + idRol );
                RolDao rolDao = new RolDao();
                boolean siElimino = rolDao.eliminarRol( Integer.parseInt(idRol));
            
                if( siElimino == true ){
                    response.sendRedirect("index.jsp");
                }
            */
            
            String idRol = request.getParameter("idRol");
            RolDao rolDao = new RolDao();
            Rol rolDB = new Rol();
            rolDB = rolDao.unRol( Integer.parseInt(idRol) );
            System.out.println(" el valor del rol seleccionado es  ");
            System.out.println(" id :: " + rolDB.getIdRol() );
            System.out.println(" desc :: " + rolDB.getDescripcion() );
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
