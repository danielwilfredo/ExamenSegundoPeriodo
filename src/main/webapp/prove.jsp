<%-- 
    Document   : prove
    Created on : 04-08-2017, 10:07:54 AM
    Author     : DanielWilfredo
--%>

<%@page import="com.sv.udb.controlador.ProveedoresCtrl"%>
<%@page import="com.sv.udb.modelo.Proveedores"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/materialize/0.97.3/dist/css/materialize.min.css'>
            <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
            <script type="text/javascript" src="webjars/materialize/0.97.3/dist/js/materialize.min.js"></script>
        <title>Mantenimiento Equipos</title>
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
        
        
       <form method="POST" action="ProveedorServ" name="Demo"> 
           <div class="row">
        <div class="col l12 s12 m12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Ingresar Proveedor</span>
              <h1>${mensAler}</h1>
             
                  <!--Importante agregarle el enctype"multipart/form-data"-->
            <input hidden type="text" name="codi2" id="codi2" value="${codi}"/><br/>
                <h5>Codigo Pieza</h5>
            <input disabled class="white-text" type="text" name="codi" id="codi" value="${codi}"/><br/>
                <h5>Nombre Proveedor</h5>
            <input type="text" name="nomb" id="nomb" value="${nomb}"/><br/>
                <h5>Direccion</h5>
            <input type="text" name="dire" id="dire" value="${dire}"/><br/><br/>              
                <h5>Telefono</h5>
            <input type="text" name="tele" id="tele" value="${tele}"/><br/><br/>              
          </div>
            <div class="card-action">
               
             <input class="btn waves-effect waves-light" type="submit" name="btnEqui" value="Guardar"/>
             <input class="btn waves-effect waves-light" type="submit" name="btnEqui" value="Modificar"/>
               
            </div>
          </div>
        </div>
      </div>   
           
       </form>

    
         <form method="POST" action="ProveedorServ" name="Tabla">                                                                                  
       <div class="row">
        <div class="col l12 s12 m12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <span class="card-title"><center>Proveedores</center></span>
              <table border="1">
                <tr>
                    <th>Cons</th>
                    <th>Nombre</th>
                    <th>Direccion</th>
                     <th>Telefono</th>
                </tr>
                <%
                 for(Proveedores temp : new ProveedoresCtrl().consTodo())
                 {
                     
            %>
                   
                <tr>
                    <td><input id="<%=temp.getCodiProv()%>" name="codiEquiRadi" type="radio" value="<%=temp.getCodiProv()%>"/>
                     <label for="<%=temp.getCodiProv()%>"></label></td>
                    <td><%=temp.getNombProv()%></td>
                    <td><%=temp.getDireProv()%></td>
                    <td><%=temp.getTeleProv()%></td>
                    
            </tr>
            <%
                }
            %>
               
            </table>
            </div>
            <div class="card-action">
            <input class="btn waves-effect waves-light" type="submit" name="btnEqui" value="Consultar"/>
            <input class="btn waves-effect waves-light" type="submit" name="btnEqui" value="Eliminar"/>
            </div>
          </div>
        </div>
      </div>
         </form>
    </div>
    </body>
    
</html>

