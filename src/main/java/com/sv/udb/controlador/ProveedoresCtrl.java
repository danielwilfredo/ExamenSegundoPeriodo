/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;


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
public class ProveedoresCtrl {
  public List<Proveedores> consTodo()
    {
       List<Proveedores> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select * from proveedores");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Proveedores(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)));
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
    
         public Proveedores consTodo2(int id)
    {
      Proveedores resp = null;
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select * from proveedores where codi_prov=?");
            cmd.setString(1, String.valueOf(id));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = (new Proveedores(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
         
         public boolean guar(Proveedores obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("insert into proveedores values(null, ?, ?, ?);");

            cmd.setString(1, obje.getNombProv());
            cmd.setString(2, obje.getDireProv());
            cmd.setString(3, obje.getTeleProv());
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
         
         public boolean elim(Proveedores obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("delete from proveedores where codi_prov=?");
            cmd.setString(1, String.valueOf(obje.getCodiProv()));
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al Eliminar el Proveedores " + ex.getMessage());
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
         
          public boolean modi(Proveedores obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("update proveedores set nomb_prov=?, dire_prov=?, tele_prov=? where codi_prov=?");
            cmd.setString(1, String.valueOf(obje.getNombProv())); 
            cmd.setString(2, String.valueOf(obje.getDireProv()));
            cmd.setString(3, String.valueOf(obje.getTeleProv()));
            cmd.setString(4, String.valueOf(obje.getCodiProv()));
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
