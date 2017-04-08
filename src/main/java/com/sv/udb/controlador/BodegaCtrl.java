/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Bodega;
import com.sv.udb.modelo.Piezas;
import com.sv.udb.modelo.Proveedores;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DanielWilfredo
 */
public class BodegaCtrl {
public List<Bodega> consTodo()
    {
       List<Bodega> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select b.codi_bode, p2.codi_piez, p1.codi_prov , b.cant, p2.nomb_piez, p1.nomb_prov, b.fech from bodega b, proveedores p1, piezas p2 where b.codi_piez=p2.codi_piez and b.codi_prov=p1.codi_prov;");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            { //int codiBode, int codiPiez, int codiProv, int cant, String nombPiez, String nombProv, String fech
                resp.add(new Bodega(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            //Se carga el 
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    } 
    
    //Buscar equipos
    public List<Piezas> consPieza()
    {
       List<Piezas> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select codi_piez, nomb_piez from piezas");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Piezas(rs.getInt(1), rs.getString(2)));
            }
            //Se carga el 
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    } 
    
    public List<Proveedores> consProve()
    {
       List<Proveedores> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select codi_prov, nomb_prov from proveedores;");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Proveedores(rs.getInt(1),rs.getString(2)));
            }
            //Se carga el 
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    } 
    
   // Para guardar
    
    public boolean guar(Bodega obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("insert into bodega values(null,?, ?, ?,?)");
            cmd.setInt(1, obje.getCodiPiez());
            cmd.setInt(2, obje.getCodiProv());
            cmd.setInt(3, obje.getCant());
            cmd.setString(4, obje.getFech());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al guardar Equipos: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
        
}
