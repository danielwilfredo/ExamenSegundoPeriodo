/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.controlador.ProveedoresCtrl;
import com.sv.udb.modelo.Proveedores;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DanielWilfredo
 */
@WebServlet(name = "ProveedorServ", urlPatterns = {"/ProveedorServ"})
public class ProveedorServ extends HttpServlet {

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
            response.sendRedirect(request.getContextPath() + "/prove.jsp");
        }
        else{
            String CRUD = request.getParameter("btnEqui");
            if(CRUD.equals("Guardar"))
            {      
                  System.err.println("Esta en guardar");
                 System.err.println("valor de las variables " + request.getParameter("nomb"));
                System.err.println("valor de las variables " + request.getParameter("dire"));
                System.err.println("valor de las variables " + request.getParameter("tele"));
                Proveedores obje = new Proveedores();
                obje.setNombProv(request.getParameter("nomb"));
                obje.setDireProv(request.getParameter("dire"));
                obje.setTeleProv(request.getParameter("tele"));
                              
                if(new ProveedoresCtrl().guar(obje))
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
                Proveedores obje = new ProveedoresCtrl().consTodo2(codi);
                if(obje != null)
                {
                    request.setAttribute("codi", obje.getCodiProv());
                    request.setAttribute("nomb", obje.getNombProv());
                    request.setAttribute("dire", obje.getDireProv());
                    request.setAttribute("tele", obje.getTeleProv());
                }
                else
                {
                    mens = "Error al consultar";
                }
            }
            else if(CRUD.equals("Eliminar"))
            {
                System.err.println("Esta en Eliminar");
                 System.err.println("valor de las variables " + request.getParameter("codiEquiRadi"));
                Proveedores obje = new Proveedores();
                int codi= Integer.parseInt(request.getParameter("codiEquiRadi").isEmpty() ? "-1" : request.getParameter("codiEquiRadi"));
                obje.setCodiProv(codi);
                if(new ProveedoresCtrl().elim(obje))
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
                Proveedores obje = new Proveedores();
           
                System.err.println("Esta en modificar");
                 System.err.println("valor de las variables " + request.getParameter("nomb"));
                System.err.println("valor de las variables " + request.getParameter("dire"));
                System.err.println("valor de las variables " + request.getParameter("tele"));
                obje.setCodiProv(Integer.parseInt(request.getParameter("codi2")));
                obje.setNombProv(request.getParameter("nomb"));
                obje.setDireProv(request.getParameter("dire"));
                obje.setTeleProv(request.getParameter("tele"));
               
                if(new ProveedoresCtrl().modi(obje))
                {
                    mens="Datos Modificados";
                }
                else
                {
                    mens="Error al modificar";
                }
                
            }
            request.setAttribute("mensAler",mens);
            request.getRequestDispatcher("/prove.jsp").forward(request, response);
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
