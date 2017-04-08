<%@page import="com.sv.udb.controlador.PiezasCtrl"%>
<%@page import="com.sv.udb.modelo.Piezas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/materialize/0.97.3/dist/css/materialize.min.css'>
            <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
            <script type="text/javascript" src="webjars/materialize/0.97.3/dist/js/materialize.min.js"></script>
        <title>Examen Segundo Periodo</title>
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
        
        
       <form method="POST" action="PiezaServ" name="Demo"> 
           <div class="row">
        <div class="col l12 s12 m12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Ingresar Piezas</span>
              <h1>${mensAler}</h1>
             
                  <!--Importante agregarle el enctype"multipart/form-data"-->
            <input hidden type="text" name="codi2" id="codi2" value="${codi}"/><br/>
                <h5>Codigo Pieza</h5>
            <input disabled class="white-text" type="text" name="codi" id="codi" value="${codi}"/><br/>
                <h5>Nombre Pieza</h5>
            <input type="text" name="nomb" id="nomb" value="${nomb}"/><br/>
                <h5>Tipo Pieza</h5>
            <input type="text" name="tipo" id="tipo" value="${tipo}"/><br/><br/>              
                <h5>Marca Pieza</h5>
            <input type="text" name="marc" id="marc" value="${marc}"/><br/><br/>              
          </div>
            <div class="card-action">
               
             <input class="btn waves-effect waves-light" type="submit" name="btnEqui" value="Guardar"/>
             <input class="btn waves-effect waves-light" type="submit" name="btnEqui" value="Modificar"/>
               
            </div>
          </div>
        </div>
      </div>   
           
       </form>

    
         <form method="POST" action="PiezaServ" name="Tabla">                                                                                  
       <div class="row">
        <div class="col l12 s12 m12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <span class="card-title"><center>Piezas</center></span>
              <table border="1">
                <tr>
                    <th>Cons</th>
                    <th>Nombre Pieza</th>
                    <th>Tipo Pieza</th>
                     <th>Marca Pieza</th>
                </tr>
                <%
                 for(Piezas temp : new PiezasCtrl().consTodo())
                 {
                     
            %>
                   
                <tr>
                    <td><input id="<%=temp.getCodiPiez()%>" name="codiEquiRadi" type="radio" value="<%=temp.getCodiPiez()%>"/>
                     <label for="<%=temp.getCodiPiez()%>"></label></td>
                    <td><%=temp.getNombPiez()%></td>
                    <td><%=temp.getTipoPiez()%></td>
                    <td><%=temp.getMarcPiez()%></td>
                    
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
