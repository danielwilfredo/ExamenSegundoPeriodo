<%-- 
    Document   : bodega
    Created on : 04-08-2017, 10:49:46 AM
    Author     : DanielWilfredo
--%>

<%@page import="com.sv.udb.modelo.Proveedores"%>
<%@page import="com.sv.udb.modelo.Piezas"%>
<%@page import="com.sv.udb.controlador.BodegaCtrl"%>
<%@page import="com.sv.udb.modelo.Bodega"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/materialize/0.97.3/dist/css/materialize.min.css'>
            <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
            <script type="text/javascript" src="webjars/materialize/0.97.3/dist/js/materialize.min.js"></script>
        <title>Vista Bodegas</title>
    </head>
    <body>
    <div class="container">
      <div class="row">
        <div class="col l12 s12 m12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Seleccione mantenimiento:</span>
                 <ul>
                     <li><h2><a href="index.jsp"><h4>Mantenimiento Pieza</h4></a></h2></li>
                   <li><h2><a href="prove.jsp"><h4>Mantenimiento Proveedores</h4></a></h2></li>
                   <li><h2><a href="bodega.jsp"><h4>Ver Bodega</h4></a></h2></li>
                </ul>
            </div>
          </div>
        </div>
      </div>
        
        
       <form method="POST" action="BodegaServ" name="Demo"> 
           <div class="row">
        <div class="col l12 s12 m12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Vista Bodega</span>
              <h1>${mensAler}</h1>
             
                  <!--Importante agregarle el enctype"multipart/form-data"-->
            <input hidden type="text" name="codi2" id="codi2" value="${codi}"/><br/>
                <h5>Codigo Pieza</h5>
            <input disabled class="white-text" type="text" name="codi" id="codi" value="${codi}"/><br/>
              
            <h5>Piezas</h5>
        <select id="cmbPieza" name="cmbPieza" >
      <option value="" disabled selected>Seleccione una Pieza</option>
       <%
                for(Piezas temp: new BodegaCtrl().consPieza())
               
                { 
                    int id=-1;
                   if (request.getAttribute("cmbPieza") != null)
                   {                       
                        id =(Integer)request.getAttribute("cmbPieza");
                   }                      
                   
                    if(temp.getCodiPiez() == id)
                    {
                 %>
                        <option value="<%=temp.getCodiPiez()%>" SELECTED><%=temp.getNombPiez()%></option>;
                
               
                <%}
                    else
                    {
                 %>
                        <option value="<%=temp.getCodiPiez()%>" ><%=temp.getNombPiez()%></option>;
                
               
                <%}
                }
                %>
     
    </select>
                <h5>Proveedores</h5>
        <select id="cmbProve" name="cmbProve" >
      <option value="" disabled selected>Seleccione un Proveedor</option>
       <%
                for(Proveedores temp: new BodegaCtrl().consProve())
               
                { 
                    int id=-1;
                   if (request.getAttribute("cmbProve") != null)
                   {                       
                        id =(Integer)request.getAttribute("cmbProve");
                   }                      
                   
                    if(temp.getCodiProv() == id)
                    {
                 %>
                        <option value="<%=temp.getCodiProv()%>" SELECTED><%=temp.getNombProv()%></option>;
                
               
                <%}
                    else
                    {
                 %>
                        <option value="<%=temp.getCodiProv()%>" ><%=temp.getNombProv()%></option>;
                
               
                <%}
                }
                %>
     
    </select>
                <h5>Cantidad</h5>
            <input type="text" name="cant" id="cant" value="${cant}"/><br/><br/>              
                <h5>Fecha</h5>
            <input type="text" name="fech" id="fech" value="${fech}"/><br/><br/>              
          </div>
            <div class="card-action">
               
             <input class="btn waves-effect waves-light" type="submit" name="btnJuga" value="Guardar"/>
             
               
            </div>
          </div>
        </div>
      </div>   
           
       </form>

           <form method="POST" action="BodegaServ" name="Tabla"> 
                      <div class="row">
        <div class="col l12 s12 m12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <span class="card-title"><center>Bodega</center></span>
              <table border="1">
                <tr>
                    <th>Cons</th>
                    <th>Pieza</th>
                    <th>Proveedor</th>
                     <th>Cantidad</th>
                    <th>Fecha</th>
                   
                </tr>
                <%
                 for(Bodega temp : new BodegaCtrl().consTodo())
                 {
                     
            %>
                   
                <tr>
                    <td><input id="<%=temp.getCodiBode()%>" name="codiEquiRadi" type="radio" value="<%=temp.getCodiBode()%>"/>
                     <label for="<%=temp.getCodiBode()%>"></label></td>
                    <td><%=temp.getNombPiez()%></td>
                    <td><%=temp.getNombProv()%></td>
                    <td><%=temp.getCant()%></td>
                    <td><%=temp.getFech()%></td>
                    
                    
            </tr>
            <%
                }
            %>
               
            </table>
            </div>
            <div class="card-action">
            </div>
          </div>
        </div>
      </div>
    </form>

    </div>
         

    </body>
        <script>
       $(document).ready(function() {
    $('select').material_select();
  }); 
    </script>
    
</html>

