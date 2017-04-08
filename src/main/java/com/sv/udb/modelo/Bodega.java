/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author DanielWilfredo
 */
public class Bodega {
    
    private int codiBode;
    private int codiPiez;
    private int codiProv;
    private int cant;
    private String nombPiez;
    private String nombProv;
    private String fech;

    public int getCodiBode() {
        return codiBode;
    }

    public void setCodiBode(int codiBode) {
        this.codiBode = codiBode;
    }

    public int getCodiPiez() {
        return codiPiez;
    }

    public void setCodiPiez(int codiPiez) {
        this.codiPiez = codiPiez;
    }

    public int getCodiProv() {
        return codiProv;
    }

    public void setCodiProv(int codiProv) {
        this.codiProv = codiProv;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getNombPiez() {
        return nombPiez;
    }

    public void setNombPiez(String nombPiez) {
        this.nombPiez = nombPiez;
    }

    public String getNombProv() {
        return nombProv;
    }

    public void setNombProv(String nombProv) {
        this.nombProv = nombProv;
    }

    public String getFech() {
        return fech;
    }

    public void setFech(String fech) {
        this.fech = fech;
    }
    
    public Bodega()
    {
        
    }
//cuando se consulte la pieza
    public Bodega(int codiPiez, String nombPiez) {
        this.codiPiez = codiPiez;
        this.nombPiez = nombPiez;
    }
    
    
    public Bodega(int codiBode, int codiPiez, int codiProv, int cant, String nombPiez, String nombProv, String fech) {
        this.codiBode = codiBode;
        this.codiPiez = codiPiez;
        this.codiProv = codiProv;
        this.cant = cant;
        this.nombPiez = nombPiez;
        this.nombProv = nombProv;
        this.fech = fech;
    }
    
}
    
    
  