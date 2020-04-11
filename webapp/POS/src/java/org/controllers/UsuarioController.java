/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.dao.UsuarioDao;
import org.models.Usuario;
/**
 *
 * @author Pablo Jacobo
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {
    
    private String usuario = "";
    private String clave = "";
    private UsuarioDao usuarioDao = new UsuarioDao();
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
           
            String action = request.getParameter("accion");
                     
            boolean resultOperation = false;
            this.usuario = request.getParameter("usuario");
            this.clave = request.getParameter("clave");
            
            String idUsuario = request.getParameter("idUsuario");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            String idRol = request.getParameter("idRol");
            String estado = request.getParameter("estado");
            
            String idxEdit = request.getParameter("idxEdit");
            
            switch(action){
                case "login":
                    resultOperation = this.usuarioDao
                        .login(this.usuario, this.clave);
                    if( resultOperation ){
                        HttpSession userSession = request.getSession(true);
                        userSession.setAttribute("user", this.usuario);
                        response.sendRedirect("home.jsp");
                    }else{
                        request.setAttribute("error","Invalid Username or Password");
                        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");            
                        rd.include(request, response);
                    }
                break;
                case "add":
                    Usuario usu = new Usuario();
                    usu.setNombre(nombre);
                    usu.setApellido(apellido);
                    usu.setUsuario(usuario);
                    usu.setClave(clave);
                    usu.setIdRol( Integer.parseInt( idRol ));
                    usu.setEstado( Integer.parseInt(estado));
                    
                    resultOperation  = this.usuarioDao
                        .agregarUsuario(usu);
                    
                    if( resultOperation ){
                        response.sendRedirect("usuarios-list.jsp");
                    }else{
                        System.out.println("error");
                        response.sendRedirect("usuarios-list.jsp");
                    }
                break;
                case "edit":
                    request.setAttribute("idUsuario", request.getParameter("idUsuario"));
                    RequestDispatcher rd=request.getRequestDispatcher("usuario-edit.jsp");            
                    rd.include(request, response);
                break;
                case "delete":
                    resultOperation = this.usuarioDao
                        .eliminarUsuario( Integer.parseInt( idUsuario ));
                    
                    if( resultOperation ){
                        response.sendRedirect("usuarios-list.jsp");
                    }else{
                        System.out.println("error");
                        response.sendRedirect("usuarios-list.jsp");
                    }
                break;
                case "update":
                    Usuario us = new Usuario();
                    us.setNombre(nombre);
                    us.setApellido(apellido);
                    us.setUsuario(usuario);
                    us.setClave(clave);
                    us.setIdRol( Integer.parseInt( idRol ));
                    us.setEstado( Integer.parseInt(estado));
                    us.setIdUsuario( Integer.parseInt( idxEdit ));
                    
                    resultOperation = this.usuarioDao
                        .editarUsuario(us);
                    
                    if( resultOperation ){
                        response.sendRedirect("usuarios-list.jsp");
                    }else{
                        System.out.println("error");
                        response.sendRedirect("usuarios-list.jsp");
                    }
                    
                break;
            }
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
