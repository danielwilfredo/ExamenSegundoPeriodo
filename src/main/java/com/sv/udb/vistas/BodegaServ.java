/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.controlador.BodegaCtrl;
import com.sv.udb.modelo.Bodega;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author DanielWilfredo
 */
@WebServlet(name = "BodegaServ", urlPatterns = {"/BodegaServ"})
public class BodegaServ extends HttpServlet {

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
         boolean esValido = request.getMethod().equals("POST");
        String mens = "";
        if(!esValido){
            response.sendRedirect(request.getContextPath() + "/bodega.jsp");
        }
        else{
            String CRUD = request.getParameter("btnJuga");
            if(CRUD.equals("Guardar"))
            {
                Bodega obje = new Bodega();
                obje.setCodiPiez(Integer.parseInt(request.getParameter("cmbPieza")));
                obje.setCodiProv(Integer.parseInt(request.getParameter("cmbProve")));
                obje.setCant(Integer.parseInt((request.getParameter("cant"))));
                obje.setFech((request.getParameter("fech")));

                if(new BodegaCtrl().guar(obje))
                {
                    mens="Datos Guardados";
                }
                else
                {
                    mens="Error al guardar";
                }
                    
            }
             request.setAttribute("mensAler",mens);
            request.getRequestDispatcher("/bodega.jsp").forward(request, response);
            
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
