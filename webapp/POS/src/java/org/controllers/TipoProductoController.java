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
import org.dao.TipoProductoDao;
import org.models.TipoProducto;

/**
 *
 * @author josea
 */
@WebServlet(name = "TipoProductoController", urlPatterns = {"/TipoProductoController"})
public class TipoProductoController extends HttpServlet {

    private TipoProductoDao tipoProductoDao = new TipoProductoDao ();
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
            
            String idTipoProducto = request.getParameter("idTipoProducto");
            String descripcion = request.getParameter("descripcion");
            String estado = request.getParameter("estado");
            
            String idxEdit = request.getParameter("idxEdit");
            
         switch (action){
             case "add":
                // System.out.println("que llegue aqui");
                 TipoProducto pt = new TipoProducto();
                 pt.setDescripcion(descripcion);
                 pt.setEstado(Integer.parseInt(estado));
                 
                 //System.out.println("asasas");
                 resultOperation = this.tipoProductoDao.agregarTipoProducto(pt);
                 System.out.println("Es valor es " + resultOperation);
                 if (resultOperation){
                     response.sendRedirect("tipoproducto-list.jsp");
                 }else{
                     System.out.println("error");
                     response.sendRedirect("tipoproducto-list.jsp");
                 }
             break;
             case "edit":
                 request.setAttribute("idTipoProducto", request.getParameter("idTipoProducto"));
                 RequestDispatcher rd = request.getRequestDispatcher("tipoproducto-edit.jsp");
                 rd.include(request, response);
             break;
             case "delete" :
                 resultOperation = this.tipoProductoDao.eliminarTipoProducto(Integer.parseInt(idTipoProducto));
                 
                 if (resultOperation){
                     response.sendRedirect("tipoproducto-list.jsp");
                 }else{
                     System.out.println("error");
                     response.sendRedirect("tipoproducto-list.jsp");
                 }
             break;
             case "update":
                System.out.println("ingreso update" );
                 TipoProducto ti = new TipoProducto();
                   ti.setIdTipoProducto(Integer.parseInt(idTipoProducto));
                //  System.out.println("paso el id");
                  System.out.println("idtipo producto es: " + ti.getIdTipoProducto());
                 ti.setDescripcion(descripcion);
                 ti.setEstado(Integer.parseInt(estado));
                 
                
                
                 
                 ti.setDescripcion(descripcion);
                 ti.setEstado(Integer.parseInt(idxEdit));
                
                 resultOperation =  this.tipoProductoDao.editarTipoProducto(ti);
                 
                 
                 if (resultOperation){
                     response.sendRedirect("tipoproducto-list.jsp");
                 }else{
                     System.out.println("error");
                     response.sendRedirect("tipoproducto-list.jsp");
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
