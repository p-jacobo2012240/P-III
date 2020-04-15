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
import org.dao.FacturaDao;
import org.models.Factura;

/**
 *
 * @author Ronald Galicia
 */
@WebServlet(name = "FacturaController", urlPatterns = {"/FacturaController"})
public class FacturaController extends HttpServlet {
    
    private FacturaDao facturaDao = new FacturaDao();

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
            boolean resultadoOp = false;
            
            String idFactura = request.getParameter("idFactura");
            String serie = request.getParameter("serie");
            String fecha = request.getParameter("fecha");
            String idCliente = request.getParameter("idCliente");
            String total = request.getParameter("total");
            String idUsuario = request.getParameter("idUsuario");
            String idExit = request.getParameter("idExit");
            
            switch(action){
                case "add":
                    Factura fac = new Factura();
                    
                    fac.setSerie(serie);
                    fac.setFecha(fecha);
                    fac.setIdCliente(Integer.parseInt(idCliente));
                    fac.setTotal(Float.parseFloat(total));
                    fac.setIdUsuario(Integer.parseInt(idUsuario));
                    
                    resultadoOp = this.facturaDao.agregarFactura(fac);
                    
                    if(resultadoOp){
                        response.sendRedirect("facturas-list.jsp");
                    }else{
                        System.out.println("Error");
                        response.sendRedirect("fasturas-list.jsp");
                    }
                break;
                case "edit":
                    request.setAttribute("idFactura", request.getParameter("idFactura"));
                    RequestDispatcher rd= request.getRequestDispatcher("factura-edit.jsp");
                    rd.include(request, response);
                break;
                case "delete":
                    resultadoOp = this.facturaDao.eliminarFactura(Integer.parseInt(idFactura));
                    
                    if(resultadoOp){
                        response.sendRedirect("facturas-list.jsp");
                    }else{
                        System.out.println("Error");
                        response.sendRedirect("facturas-list.jsp");
                    }
                break;
                case "update":
                    
                    Factura f = new Factura();
                    
                    f.setSerie(serie);
                    f.setFecha(fecha);
                    System.out.println("idCliente es: "+idCliente);
                    f.setIdCliente(Integer.parseInt(idCliente));
                    f.setTotal(Float.parseFloat(total));
                    f.setIdUsuario(Integer.parseInt(idUsuario));
                    f.setIdFactura(Integer.parseInt(idExit));
                    
                    resultadoOp = this.facturaDao.editarFactura(f);
                    
                    if(resultadoOp){
                        response.sendRedirect("facturas-list.jsp");
                    }else{
                        System.out.println("Error");
                        response.sendRedirect("facturas-list.jsp");
                    }
                    
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
