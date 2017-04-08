/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.controlador.PiezasCtrl;
import com.sv.udb.modelo.Piezas;
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
@WebServlet(name = "PiezaServ", urlPatterns = {"/PiezaServ"})
public class PiezaServ extends HttpServlet {

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
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        else{
            String CRUD = request.getParameter("btnEqui");
            if(CRUD.equals("Guardar"))
            {      
                  System.err.println("Esta en guardar");
                 System.err.println("valor de las variables " + request.getParameter("nomb"));
                System.err.println("valor de las variables " + request.getParameter("tipo"));
                System.err.println("valor de las variables " + request.getParameter("marc"));
                Piezas obje = new Piezas();
                obje.setNombPiez(request.getParameter("nomb"));
                obje.setTipoPiez(request.getParameter("tipo"));
                obje.setMarcPiez(request.getParameter("marc"));
                              
                if(new PiezasCtrl().guar(obje))
                {
                    mens = "Datos guardados";
                }
                else
                {
                    mens = "Error al guardar";
                } 
            }
            else if(CRUD.equals("Consultar"))
            {
                int codi = Integer.parseInt(request.getParameter("codiEquiRadi").isEmpty() ? "-1" : request.getParameter("codiEquiRadi"));
                Piezas obje = new PiezasCtrl().consTodo2(codi);
                if(obje != null)
                {
                    request.setAttribute("codi", obje.getCodiPiez());
                    request.setAttribute("nomb", obje.getNombPiez());
                    request.setAttribute("tipo", obje.getTipoPiez());
                    request.setAttribute("marc", obje.getMarcPiez());
                }
                else
                {
                    mens = "Error al consultar";
                }
            }
            else if(CRUD.equals("Eliminar"))
            {
                Piezas obje = new Piezas();
                int codi= Integer.parseInt(request.getParameter("codiEquiRadi").isEmpty() ? "-1" : request.getParameter("codiEquiRadi"));
                obje.setCodiPiez(codi);
                if(new PiezasCtrl().elim(obje))
                {
                    mens="Datos Eliminados";
                }
                else
                {
                    mens="Error al eliminar";
                }
            }
            else if(CRUD.equals("Modificar"))
            {
                Piezas obje = new Piezas();
           
                System.err.println("Esta en modificar");
                 System.err.println("valor de las variables " + request.getParameter("nomb"));
                System.err.println("valor de las variables " + request.getParameter("tipo"));
                System.err.println("valor de las variables " + request.getParameter("marc"));
                obje.setCodiPiez(Integer.parseInt(request.getParameter("codi2")));
                obje.setNombPiez(request.getParameter("nomb"));
                obje.setTipoPiez(request.getParameter("tipo"));
                obje.setMarcPiez(request.getParameter("marc"));
               
                if(new PiezasCtrl().modi(obje))
                {
                    mens="Datos Modificados";
                }
                else
                {
                    mens="Error al modificar";
                }
                
            }
            request.setAttribute("mensAler",mens);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
