/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Piezas;
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
public class PiezasCtrl {
   public List<Piezas> consTodo()
    {
       List<Piezas> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select * from piezas");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Piezas(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)));
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
    
    
    //Codigo para consultar segun el id del registro
    
         public Piezas consTodo2(int id)
    {
      Piezas resp = null;
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select * from piezas where codi_piez =?");
            cmd.setString(1, String.valueOf(id));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = (new Piezas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
         
         
         //Codigo para guardar
         
         public boolean guar(Piezas obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("insert into piezas values(null, ?, ?, ?);");
            cmd.setString(1, obje.getNombPiez());
            cmd.setString(2, obje.getTipoPiez());
            cmd.setString(3, obje.getMarcPiez());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al guardar Miembros: " + ex.getMessage());
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
         
         public boolean elim(Piezas obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("delete from piezas where codi_piez=?");
            cmd.setString(1, String.valueOf(obje.getCodiPiez()));
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al Eliminar el Miembros " + ex.getMessage());
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
        
         //Codigo para modificar registros
         
          public boolean modi(Piezas obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("update piezas set nomb_piez=?, tipo_piez=?, marc_piez=? where codi_piez=?");
            cmd.setString(1, String.valueOf(obje.getNombPiez())); 
            cmd.setString(2, String.valueOf(obje.getTipoPiez()));
            cmd.setString(3, String.valueOf(obje.getMarcPiez()));
            cmd.setString(4, String.valueOf(obje.getCodiPiez()));
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al modificar el Jugador " + ex.getMessage());
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
